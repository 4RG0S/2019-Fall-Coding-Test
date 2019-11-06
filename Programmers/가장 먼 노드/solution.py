def bfs(graph, dist_list, start):
    queue = [start]
    dist = 1

    while queue:
        for idx in range(0, len(queue)):
            n = queue.pop(0)

            if dist_list[n] == 0:
                dist_list[n] = dist

                for i in graph[n]:
                    # if i not in queue:
                    queue.append(i)
        dist += 1

    dic_max = max(dist_list.values())
    count = 0
    for key in dist_list:
        if dic_max == dist_list[key]:
            count += 1

    return count


from collections import defaultdict


def solution(n, edge):
    answer = 0
    dist_list = {i: 0 for i in range(1, len(edge))}
    graph = defaultdict(list)

    for u, v in edge:
        graph[u].append(v)
        graph[v].append(u)

    # graph : {3: [6, 4, 2, 1], 6: [3], 4: [3, 2], 2: [3, 1, 4, 5], 1: [3, 2], 5: [2]}
    # dist_list : {1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0}
    return bfs(graph, dist_list, 1)
