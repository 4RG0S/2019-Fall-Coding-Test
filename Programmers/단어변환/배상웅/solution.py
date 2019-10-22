def func(before, after):
    diff = 0
    if len(before) != len(after):
        return 0
    else:
        for i in range(len(before)):
            if before[i] != after[i]:
                diff += 1
    if diff == 1:
        return 1
    else:
        return 0

def find(before, target, count, wordlist, distlist):
    if before == target:
        return
    else:
        for i in range(len(wordlist)):
            if (func(before, wordlist[i]) == 1 and
                (count + 1 < distlist[i] or distlist[i] == -1)):
                distlist[i] = count + 1
                find(wordlist[i], target, count+1, wordlist, distlist)

def solution(begin, target, words):

    distance = [-1] * len(words)
    goal = -1

    for i in range(len(words)):
        if words[i] == target:
            goal = i
            break

    if goal == -1:
        return 0

    else:
        find(begin, target, 0, words, distance)
        answer = distance[goal]
        if answer == -1:
            answer = 0
        return answer
