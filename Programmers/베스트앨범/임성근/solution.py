def solution(genres, plays):
    kinds = {}
    
    for i in range(0, len(genres)):
        if genres[i] not in kinds:
             kinds[genres[i]] = plays[i]
        else:
            kinds[genres[i]] += plays[i]
    #print(kinds)
    
    sorted_kinds = sorted(kinds.keys(), key=lambda kinds: kinds[1], reverse = True)

    index = {}
    for i in range(0, len(sorted_kinds)):
        kind = []
        for j in range(0, len(genres)):
            if genres[j] == sorted_kinds[i] and j not in kind:
                kind.append(j)
                index[genres[j]] = kind
    
    print(index)
    
    answer = []
    
    for idx in index.items():
        a = {}
        data = idx[1]
        
        if len(data) == 1:
            answer.append(data)
        for i in range(0, len(data)):
            a[data[i]] = plays[data[i]]
        sorted_a = sorted(a.items(), key=lambda a: a[1], reverse = True)
        
        answer.append(sorted_a[0][0])
        answer.append(sorted_a[1][0])
        
    return answer
