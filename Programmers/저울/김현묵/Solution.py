# 프로그래머스 '저울' 문제
# 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/42886

# 정확성 : 5.0
# 효율성 : 0.0

# '탐욕법' 을 써야하지만 어렵다.
import itertools

def solution(weight):
    answer = 0
    combs = []
    nums = []
    startNum = 1

    for i in range(1, len(weight)+1):
        els = [list(x) for x in itertools.combinations(weight, i)]
        combs.extend(els)

    for a in combs:
        numSum = 0
        for b in a:
            numSum = numSum + b
        nums.append(numSum)

    while(True):
        if startNum in nums:
            startNum = startNum + 1
            continue
        else:
            answer = startNum
            break


    return answer
