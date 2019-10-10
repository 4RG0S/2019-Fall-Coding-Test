# 프로그래머스 '디스크 컨트롤러' 문제
# 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/42627

# 정확성 : 10.0

import heapq

heap = []

# 힙을 이용하는 문제입니다.
def solution(jobs):

    answer = 0

    jobNum = len(jobs)

    first = []
    minimumFirst = jobs[0][0]


    # 처음 시작할 때 첫 요청시간이 같은 작업이 여러개 있을 수 있으니 그 작업들을 모두 골라줍니다.
    for q in jobs:
        if q[0] <= minimumFirst:
            minimumFirst = q[0]


    for y in range(len(jobs)):
        if jobs[y][0] == minimumFirst:
            first.append(y)

    # 그 작업으로부터 시작하는 recursive를 돌려줍니다.
    for e in first:
        alreadyRecursive = []
        alreadyRecursive.append(e)
        recursive(jobs, e, alreadyRecursive, jobs[e][0] + jobs[e][1], jobs[e][1] - jobs[e][0])


    # 최소힙에을 이용하여 최소 누적값을 알아내고 작업의 갯수만큼 나눠서 answer를 도출해냅니다.
    answer = (int)(heap[0] / jobNum)

    # 답을 return 해줍니다.
    return answer



# 모든 작업의 case를 돌렸을 때 가장 적은 평균값을 구하기 위해서 누적값을 구하는 recursive 입니다.
def recursive(jobs, numRecursive, alreadyRecursive, nowWhere, nowUntilLength):

    innerHave = 0

    # 모든 작업을 수행하고 나면 누적값들을 heap에 저장한 후 함수를 마무리 짓습니다.
    if len(alreadyRecursive) == len(jobs):
        heapq.heappush(heap, nowUntilLength)

    # 현재 시점보다 더 전에 요청 들어온 작업이 있는 경우에 돌아가는 for문 입니다.
    # 현재 시점보다 더 전에 요청 들어온 작업이 여러개 있을 수 있으니 그 경우를 위해
    # 각 경우별로 recursive를 여러 case를 돌립니다.
    for i in range(len(jobs)):
        if jobs[i][0] <= nowWhere and (i not in alreadyRecursive):
            innerHave = 1
            alreadyRecursive2 = []
            for w in alreadyRecursive:
                alreadyRecursive2.append(w)
            alreadyRecursive2.append(i)
            recursive(jobs, i, alreadyRecursive2, nowWhere + jobs[i][1], nowUntilLength + ((nowWhere-jobs[i][0])+jobs[i][1]))

    # innerHave가 0일 경우를 위해서 있는 for문입니다.
    # 현재 시점보다 더 전에 들어온 작업이 없을 때의 경우를 만족할 때 recursive를 돌립니다.
    for j in range(len(jobs)):
        if nowWhere < jobs[j][0] and (innerHave == 0) and (j not in alreadyRecursive):
            alreadyRecursive2 = []
            for s in alreadyRecursive:
                alreadyRecursive2.append(s)
            alreadyRecursive2.append(j)
            recursive(jobs, j, alreadyRecursive2, nowWhere + jobs[j][1] + (jobs[i][0] - nowWhere), nowUntilLength + jobs[j][1])

            break







