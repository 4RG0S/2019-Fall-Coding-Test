
# coding: utf-8

def solution(genres, plays):
    answer = []
    playlist = {}
    count = 0
    for spec in zip(genres,plays):
        genre = spec[0]
        score=(spec[1],count)
        if genre not in playlist:
            playlist[genre]=list()
            playlist[genre].append(score)
        else:
            playlist[genre].append(score)
        count += 1
    temp = 0
    temp2 = ()
    for i in playlist.keys():
        print(playlist[i])
        playlist[i] = sorted(playlist[i], key=lambda play: play[0], reverse=True)
        
    ran=list()
    total=0
    for i in playlist.items():
        rank= list(i)
        for i in rank[1]:
            total += i[0]
        ran.append((total,rank[0]))
        total=0
    aa = list(reversed(sorted(ran)))
    selected=0
    for i in aa:
        for select in playlist[i[1]]:
            answer.append(select[1])
            if len(playlist[i[1]])==1:
                break
            else:
                selected +=1
                if selected ==2:
                    selected=0
                    break
    return answer

solution(["classic", "pop", "classic", "classic", "pop","pop"],[500, 600, 500, 900,800, 2500])

