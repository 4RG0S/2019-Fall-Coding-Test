def solution(weight):
    weight.sort()
    ans = 1
    for e in weight:
        if ans < e:
            break
        ans += e

    return ans