# 프로그래머스 '구명보트' 문제
# 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/42885

# 정확성 : 20.0
# 효율성 : 10.0


def solution(people, limit):

    answer = 0

    # 배열을 오름차순으로 정렬합니다.
    people.sort()

    startNum = 0
    sumNum = 0

    # 리스트를 앞에서부터 돌려서 limit를 넘지 않는 선까지 리스트를 순회합니다.
    # limit를 넘으면 보트개수를 1을 더하고 다시 sum을 초기화 시키고 다시 그 부분부터 리스트를 순회합니다.
    while(True):
        if startNum >= len(people):
            answer = answer + 1
            break

        sumNum = sumNum + people[startNum]

        if sumNum <= limit:
            startNum = startNum + 1

        else:
            answer = answer + 1
            sumNum = 0


    return answer





