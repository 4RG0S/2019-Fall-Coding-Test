def solution(clothes):
    answer = 1
    kinds = {}
    for cloth in clothes:
        if cloth[1] not in kinds.keys():
            kinds[cloth[1]] = 1
        else:
            kinds[cloth[1]] += 1
    
    quantity = []
    
    for kind in kinds.values():
        quantity.append(kind)

    for idx in quantity:
        answer *= (idx + 1)
    
    return answer-1
