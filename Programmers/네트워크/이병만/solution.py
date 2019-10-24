def dfs(computers, visited, i):
    stack = [i]
    # print(stack)
    while len(stack) != 0:
        j = stack.pop()
        if not visited[j]:
            visited[j] = True

        for k in range(len(computers)):
            if computers[j][k] == 1 and not visited[k]:
                print(j, k)
                stack.append(k)
                print(stack)


def solution(n, computers):
    answer = 0
    visited = [False for i in range(n)]
    i = 0

    while False in visited:
        if not visited[i]:
            print(visited)
            dfs(computers, visited, i)
            answer += 1
        i += 1

    return answer