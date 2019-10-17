def solution(weight):
    weight = sorted(weight)
    answer = 1

    for idx in range(len(weight)):
        if answer < weight[idx]:
            return answer
        else:
            answer += weight[idx]

    return answer