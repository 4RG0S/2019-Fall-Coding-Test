def solution(N):
    tile = [0, 1]

    if N == 1:
        return 4
    else:
        for i in range(N):
            tile.append(tile[i] + tile[i + 1])

    return (tile[N] * 2) + (tile[N + 1] * 2)