# 프로그래머스 '베스트앨범' 문제
# 문제링크 : https://programmers.co.kr/learn/courses/30/lessons/42579

# 정확성 : 53.3

# 해쉬를 이용하는 문제입니다.
def solution(genres, plays):

    answer = []

    # dictionary인 playOfGenres에 각 장르의 총 플레이 횟수를 저장해 놓습니다.
    # dictionary인 rowOfGenres에 각 장르별 인덱스와 플레이 횟수를 리스트로 저장해 놓습니다.
    playOfGenres = {}
    rowOfGenres = {}

    for i in range(len(genres)):
        if genres[i] in playOfGenres:
            playOfGenres[genres[i]] = playOfGenres[genres[i]] + plays[i]
            rowOfGenres[genres[i]].append([i,plays[i]])
        else:
            playOfGenres[genres[i]] = 0
            playOfGenres[genres[i]] = playOfGenres[genres[i]] + plays[i]
            rowOfGenres[genres[i]] = []
            rowOfGenres[genres[i]].append([i, plays[i]])

    # 플레이 횟수가 많은 장르가 앞에 오도록 합니다.
    sPlayOfGenres = sorted(playOfGenres.items(), key = lambda x: x[1] , reverse=True)

    # 장르별 플레이 횟수가 많은 인덱스가 앞에 오도록 합니다.
    for j in sPlayOfGenres:
        rowOfGenres[j[0]].sort(key = lambda x:(-x[1], x[0]))

    # 플레이 횟수가 많은 장르부터 장르별 2개곡씩 인덱스를 앞에서부터 꺼내 줍니다.
    for w in sPlayOfGenres:
        answer.append(((rowOfGenres[w[0]])[0])[0])
        if len(rowOfGenres[w[0]]) >= 1:
            answer.append(((rowOfGenres[w[0]])[1])[0])

    # 답을 return 해줍니다.
    return answer
