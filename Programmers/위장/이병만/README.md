Problem : [위장](https://programmers.co.kr/learn/courses/30/lessons/42578) **해시 Level 2**

Flow :

1. 스파이가 가진 의상들이 담긴 2차원 배열 clothes 가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.


Solution :

1. clothes 배열에서 옷의 종류를 저장한다.
2. 저장한 옷의 종류를 카운트한다.
2. 가지고 있는 옷의 종류로 만들 수 있는 조합의 갯수를 구한다.
3. 무조건 하나의 옷은 입기 때문에 안 입는 조건을 빼주고 반환해준다.