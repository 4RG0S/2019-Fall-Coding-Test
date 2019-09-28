from collections import Counter


def solution(clothes):
    answer = 1
    categories = []

    for cloth in clothes:
        category = cloth[1]
        categories.append(category)

    counter = Counter(categories)
    counts = list(counter.values())

    for idx in counts:
        print(idx)
        answer *= (idx + 1)

    return answer - 1
