# 프로그래머스 '위장' 문제
# 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/42578

# 정확성 : 71.4

from itertools import combinations

# 조합,순열과 해쉬를 사용하는 문제입니다.
def solution(clothes):

    answer = 0

    clothesCategory = {}
    clothesName = []

    keyNum = 0
    valueNum = 0
    divideHash = {}

    # 각 옷의 종류를 key로 옷의 이름을 value로 해서 clothesCategory 해쉬에 저장해 놓습니다.
    # 모든 옷들을 clothesName 리스트에 저장해 놓습니다.
    for i in clothes:

        clothesName.append(i[0])

        if i[1] in clothesCategory:
            clothesCategory[i[1]].append(i[0])
        else:
            clothesCategory[i[1]] = []
            clothesCategory[i[1]].append(i[0])

    listKeys = list(clothesCategory.keys())

    # 총 옷의 종류를 keyNum에 저장해 놓습니다.
    for z in listKeys:
        keyNum = keyNum + 1

    # 총 옷의 개수입니다.
    valueNum = len(clothesName)

    # 옷을 1개씩 낱개로 고를 때를 answer에 더해줍니다.
    answer = answer + valueNum


    for o in listKeys:
        divideHash[o] = 0

    # 옷을 2개 이상씩 조합을 할 때의 경우입니다.
    # 모든 조합을 구한후에 같은 종류의 옷을 2개 이상 포함 할수 있으니 그 경우는 빼줍니다.
    for w in range(2, keyNum+1):
        listCombi = (list(combinations(clothesName, w)))
        answer = answer + len(listCombi)
        for u in listCombi:
            for e in u:
                for r in listKeys:
                    if e in clothesCategory[r]:
                        divideHash[r] = divideHash[r] + 1


            for p in listKeys:
                if divideHash[p] >= 2:
                    answer = answer - 1
                    break

            for t in listKeys:
                divideHash[t] = 0


    # 답을 return 해줍니다.
    return answer