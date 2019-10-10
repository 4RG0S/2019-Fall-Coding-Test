# 프로그래머스 '여행경로' 문제
# 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/43164

# 정확성 : 75.0

# recursive 함수내에서 tripPoint 앞에 써주는거, for문에 써주는거 차이!
# 알파벳 순으로 정렬하기?
import heapq

candidateAnswer = []

# 힙과 재귀를 이용하는 문제입니다.
def solution(tickets):


    firstCandidate = []


    # 첫 시작인 "ICN" 을 모두 찾아줍니다.
    for i in range(len(tickets)):
        if tickets[i][0] == "ICN":
            firstCandidate.append(i)

    # "ICN" 을 찾아 모든 경우에서 recursive를 돌려줍니다.
    for j in firstCandidate:
        tripPoint = []
        tripPoint.append(tickets[j][0])
        tripPoint.append(tickets[j][1])
        for w in range(len(tickets)):
            if tickets[w][0] == tickets[j][1]:
                alreadyTripIndex = []
                alreadyTripIndex.append(j)
                alreadyTripIndex.append(w)
                recursive(tickets, w, alreadyTripIndex, tripPoint)


    answer = candidateAnswer[0]

    # 답을 return 해줍니다.
    return answer


# recursive 함수는 후보군들을 모두 recursive 로 돌려
# 항공권을 모두 사용하고 마지막 도착지에 도착할 때까지 경우를 candidateAnswer에 저장해줍니다.
def recursive(tickets, w, alreadyTripIndex , tripPoint):
    tripPoint.append(tickets[w][1])

    if len(alreadyTripIndex) == len(tickets):
        candidateAnswer.append(tripPoint)


    for e in range(len(tickets)):
        if (tickets[e][0] == tickets[w][1]) and (e not in alreadyTripIndex):
            alreadyTripIndex2 = []
            for t in alreadyTripIndex:
                alreadyTripIndex2.append(t)
            alreadyTripIndex2.append(e)
            '''tripPoint2 = []
            for s in tripPoint:
                tripPoint2.append(s)
            tripPoint2.append(tickets[e][1])'''
            recursive(tickets, e, alreadyTripIndex2, tripPoint)


