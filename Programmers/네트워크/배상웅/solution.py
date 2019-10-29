def solution(n, computers):
    pq = []
    check = set()
    answer = 0
    for idx in range(n):
        if not idx in check:
            answer += 1
            pq.append([idx, computers[idx]])
            check.add(idx)
            while pq:
                cur = pq.pop(0)
                for i in range(n):
                    if i == cur[0] or i in check:
                        continue
                    if cur[1][i] == 1:
                        pq.append([i, computers[i]])
                        check.add(i)
    return answer