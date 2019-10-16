Problem : [저울](https://programmers.co.kr/learn/courses/30/lessons/42886) **탐욕법(Greedy) Level 3**

Flow :

1. 저울추가 담긴 배열 weight가 매개변수로 주어질 때, 이 추들로 측정할 수 없는 양의 정수 무게 중 최솟값을 return 하도록 solution 함수를 작성해주세요.


Solution :

1. 무게가 작은 순서대로 정렬한다.
2. 현재의 무게와 비교해서 추의 무게가 크면 현재의 무게를 반환해준다.