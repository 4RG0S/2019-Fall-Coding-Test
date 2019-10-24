# 프로그래머스 '네트워크' 문제
# 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/43162

# 정확성 : A. 100.0   B. 30.8


# A 코드
alreadyNode = []
answer = 0

def solution(n, computers):

    global answer

    # 모든 경우를 돌아야 하므로 range(n) 을 for문으로 돌려줍니다.
    for i in range(n):
        recursive(n,i, computers)

    # 모든 recursive를 돌았을 때 돌지 않은 컴퓨터의 경우를 추가해줍니다.
    for h in range(n):
        if h not in alreadyNode:
            answer = answer + 1

    return answer



def recursive(n, i, computers):

    global answer

    computersArray = computers[i]

    # i 컴퓨터와 j 컴퓨터의 연결 상태를 보고 연결되었고 아직 돌지 않은 컴퓨터를 확인하면 alreadyNode에 추가해줍니다.
    # 추가해준 후, 추가해 준 j 번 컴퓨터를 또 recursive를 돌려줍니다.
    for j in range(n):
        # i와 j가 연결되어 있는 경우입니다. i와 j 모두 alreadyNode에 들어가 있지 않은 경우는 네트워크가 다른 컴퓨터와 형성되어 있지 않은 경우입니다.
        # answer를 1을 추가해 네트워크 갯수를 추가해줍니다.
        if (computersArray[j]) == 1 and ((i not in alreadyNode) and (j not in alreadyNode)) and  (i != j):
            alreadyNode.append(i)
            alreadyNode.append(j)
            answer = answer + 1
            recursive(n, j, computers)
        # i와 j가 연결되어 있는 경우입니다. 이 때는 j번 컴퓨터를 alreadyNode에 추가해주지만 answer는 변화가 없습니다.
        elif (computersArray[j]) == 1 and (j not in alreadyNode) and  (i != j):
            alreadyNode.append(j)
            recursive(n, j, computers)




# B 코드
'''
def solution(n, computers):

    alreadyNode = []
    answer = 0

    for i in range(n):
        for a in alreadyNode:
            if ((computers[i][a] == 1) and (i != a) and (i not in alreadyNode)):
                alreadyNode.append(i)

        for j in range(n):
            if(computers[i][j] == 1) and (i != j) and (i not in alreadyNode) and (j not in alreadyNode):
                alreadyNode.append(i)
                alreadyNode.append(j)
                answer = answer + 1
            elif (computers[i][j] == 1) and (i != j) and (j not in alreadyNode):
                alreadyNode.append(j)

    for w in range(n):
        if w not in alreadyNode:
            answer = answer + 1


    return answer
'''
