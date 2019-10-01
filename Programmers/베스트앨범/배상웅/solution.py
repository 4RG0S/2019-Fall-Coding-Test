def solution(genres, plays):
    # 1 속한 노래가 많이 재생된 장르를 먼저  수록
    # 2 장르 내에서 가장 많이 재생된 노래를 먼저 수록
    # 3 같은 재생 횟수 일 때, 순서가 먼저인 것을 수록


    # Dictionary
    Category = {}
    for i in range(0, len(genres)):
        if genres[i] in Category:
            Category[genres[i]] += plays[i]
        else:
            Category[genres[i]] = plays[i]
    
    # 가장 많이 재생된 장르
    Sequence = []
    while True:
        if Category == {}:
            break
        key_max = max(Category.keys(), key=(lambda k: Category[k]))
        Sequence.append(key_max)
        del Category[key_max]


    a = []
    result = []
    for j in range(0, len(Sequence)):
        temp = []
        for i in range(0, len(genres)):
            if Sequence[j] in genres[i]:
                temp_list = []
                temp_list.append(genres[i])
                temp_list.append(plays[i])
                temp_list.append(i)
                temp.append(temp_list)
        b = sorted(temp, key=lambda x: (-x[1], x[2]))
        for i in range(0, len(b)):
            if i == 2:
                break
            result.append(b[i][2])

    print(result)

if __name__ == '__main__':
    genres = ["classic", "pop", "balad", "classic", "classic", "pop", "balad"]
    plays = [500, 600, 5000, 150, 800, 2500, 5000]
    solution(genres, plays)
