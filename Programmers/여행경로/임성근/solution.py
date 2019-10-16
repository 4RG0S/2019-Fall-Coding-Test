def solution(tickets):
    answer = []
    answer.append('ICN')
    tickets.sort(key=takeSecond)
    bfs(tickets, answer)
    return answer
    
def takeSecond(elem):
    return elem[1]

def bfs(tickets, answer):
    now = answer[-1]
    index = 0
    if len(tickets) == 0:
        return answer
    else:
        for i in range(0, len(tickets)):
            if now == tickets[i][0]:
                now = tickets[i][1]
                index = i
                answer.append(now)
                break
        tickets.pop(index)
        bfs(tickets, answer)
        


