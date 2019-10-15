result = []
start = []
check = []
def solution(tickets):
    tickets.sort()
    for i in range(0, len(tickets)):
        check.append(False)
    for i in range(0, len(tickets)):
        if tickets[i][0] == "ICN":
            start = tickets[i]
            check[i] = True
            break
    result.append(start[0])
    find_next(start)

def find_next(start):
    i = 0
    while True:
        if i >= len(tickets):
            result.append(start[1])
            print(result)
            return result
        if tickets[i][0] == start[1] and check[i] == False:

            start = tickets[i]
            check[i] = True
            result.append(start[0])
            break

        i += 1

    find_next(start)

if __name__ == "__main__":
    tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]
    # ICN, ATL, ICN, SFO, ATL, SFO
    solution(tickets)