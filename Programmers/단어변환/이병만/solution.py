def solution(begin, target, words):
    # 변환할 수 없는 경우 0 return
    if target not in words:
        return 0

    answer = 0
    a_list = [begin]

    # words가 다 비워질 때까지
    while len(words) != 0:
        for i in a_list:
            tmp = []

            # 배열에서 문자를 하나 꺼낸다.
            for word in words:
                count = 0
                for j in range(len(i)):
                    # 비교를 했을 때 문자가 다르면 count 1 증가
                    if i[j] != word[j]:
                        count += 1
                    if count == 2:
                        break
                if count == 1:
                    tmp.append(word)
                    words.remove(word)

        answer += 1
        # print(answer, words)
        if target in tmp:
            return answer
        else:
            a_list = tmp

    return 0
