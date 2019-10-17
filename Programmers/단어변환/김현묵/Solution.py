# 프로그래머스 '단어 변환' 문제
# 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/43163

# 정확성 : 100.0


# 재귀를 돌리면서 words 리스트를 한개씩 검사 해보는 문제입니다.
def solution(begin, target, words):

    answer = 0
    step = 0
    wordsNum = len(words)

    answer = recur(begin, target, words, step, wordsNum+1)

    # target을 못 찾은 경우를 뜻합니다.
    if answer == (wordsNum+1):
        answer = 0

    # answer를 return 해줍니다.
    return answer


# 재귀를 돌리는 함수입니다.
def recur(begin, target, words, step,wordsNum):

    length = len(begin)

    answerCandidate = []
    answerCandidate.append(wordsNum)

    tempoBegin = ""

    # target을 찾은 경우입니다.
    if begin == target:
        return step

    # 모든 words 리스트를 돌았으나 찾지 못한 경우입니다.
    if len(words) == 0:
        return wordsNum

    # 단어 한개씩 검사합니다.
    for t in words:

        equalNum = []
        notEqualNum = []

        # 검사하는 단어로 변환이 가능하려면 한 글자 빼고 나머지는 같아야 합니다.
        for p in range(length):
            if begin[p] == t[p]:
                equalNum.append(p)
            else:
                lookNum = p

        if len(equalNum) != (length-1):
            continue

        # 검사하는 단어로 변환하고 다시 재귀를 돌립니다.
        # 이 때, 이미 검사한 단어는 words 리스트에서 지워줍니다.
        # step 도 1단계씩 늘어납니다.
        tempoBegin = begin[:lookNum] + t[lookNum] + begin[lookNum+1:]
        tempoWords = words[:]
        tempoWords.remove(t)
        answerCandidate.append(recur(tempoBegin, target, tempoWords, step+1, wordsNum))

    # 재귀 돌린 결과값들로부터 최솟값을 찾아내 return을 해줍니다.
    minimumAnswer = min(answerCandidate)


    return minimumAnswer










