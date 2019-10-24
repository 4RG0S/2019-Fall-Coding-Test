Problem : [구명보트](https://programmers.co.kr/learn/courses/30/lessons/42885) **탐욕법(Greedy) Level 2**

Flow :

1. 사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.


Solution :
1. 처음에 차례대로 태우려고 했지만, 최대 2명만 탑승이 가능하기 때문에 방법을 바꿨다.
2. 양쪽 끝에서 부터 사람을 태운다. 2명을 태웠을 때 무게가 초과하지 않으면 OK.
3. 크면 다음 큰 사람을 태운다.
4. 전체 인원 수에서 두 명이 탑승한 배의 개수를 빼준다.