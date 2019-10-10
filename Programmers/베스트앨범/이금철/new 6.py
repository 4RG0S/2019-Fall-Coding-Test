def solution(genres, plays):
    best_dict = {}
    for genre, play in zip(genres, plays):
        if best_dict.get(genre):
            best_dict[genre] += play
        else:
            best_dict[genre] = play
        rank = [genre for genre, play in sorted(best_dict.items(), key=itemgetter(1), reverse=True)]

    dict = {}
    for i in range(len(plays)):
        if dict.get(genres[i]) == None:
            dict[genres[i]] = [(plays[i], i)]
        else:
            dict[genres[i]].append((plays[i], i))

    answer = []
    for genre in rank:
        album = sorted(dict[genre], key=itemgetter(0), reverse=True)
        if len(one_genre_list) > 1:
            answer.append(album[0][1])
            answer.append(album[1][1])
        else:
            answer.append(album[0][1])

    return print(answer)

