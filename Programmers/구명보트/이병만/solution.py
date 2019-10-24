def solution(people, limit):
    # 최대 2명만 탈 수 있음.
    answer = 0
    people = list(sorted(people))
    left = 0
    right = len(people) - 1

    while left < right:
        # 보트를 태웠을 때 제한보다 작거나 같으면 배를 보낸다.
        if people[left] + people[right] <= limit:
            left += 1
            right -= 1
            answer += 1
        else:
            right -= 1

    print(len(people) - answer)
    return len(people) - answer