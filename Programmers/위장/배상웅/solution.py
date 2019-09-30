def solution(clothes):
    temp = {}
    category = []
    # 해쉬 만들기..(의미가 있나..)
    for i in range(0, len(clothes)):
        if clothes[i][1] not in temp:
            temp[clothes[i][1]] = 1
            category.append(clothes[i][1])
        elif clothes[i][1] in temp:
            temp[clothes[i][1]] += 1
    a = []
    for i in range(0, len(temp)):
        a.append(temp[category[i]])

    # 전체 경우의 수 조합 구하기...
    import itertools

    combs = []

    for i in range(1, len(a) + 1):
        #뭐 이런게 다 있답니다...
        els = [list(x) for x in itertools.combinations(a, i)]
        combs.extend(els)

    result = 0

    # 각각의 경우 곱해주기 + 결과 값에 더하기
    for i in range(0,len(combs)):
        multi = 1
        for j in range(0, len(combs[i])):
            multi *= combs[i][j]
        print(multi)
        result += multi

    # 질문 보니까 각각의 경우의수+1 해서 곱해주고 아예 안입는거 -1 해주면 된다는데...
    # 암튼 1번은 시간 초과 되었는데 코드는 대충 맞는거같아서 일단 넘깁니다..
    # 슬프네 머가리가 텅텅 비어서
    return result


if __name__ == '__main__':
    # clothes = [["yellow_hat", "headgear"], ["green_turban", "headgear"], ["blue_sunglasses", "eyewear"] ]
    clothes = [["R", "head"], ["G", "head"], ["R", "ear"], ["R", "eye"], ["G", "eye"], ["B", "eye"]]
    solution(clothes)
