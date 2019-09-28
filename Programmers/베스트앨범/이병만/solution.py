from operator import itemgetter


def classification(genres, plays):
    dic = {}

    for i in range(len(genres)):
        if not genres[i] in dic:
            dic[genres[i]] = []
            dic[genres[i]].append(0)

        dic[genres[i]].append((i, plays[i]))
        dic[genres[i]][0] += plays[i]

    album = list(dic.values())
    sort_list = sorted(album, key=itemgetter(0), reverse=True)

    return sort_list


def solution(genres, plays):
    answer = []
    sort_list = classification(genres, plays)

    while sort_list:
        sort_list[0].pop(0)
        sort_list[0].sort(key=itemgetter(1), reverse=True)
        # print(sort_list)
        # print(sort_list[0])

        for i in range(len(sort_list[0])):
            if i >= 2:
                break
            # print(sort_list[0])
            answer.append(sort_list[0][i][0])
        sort_list.pop(0)
    return answer
