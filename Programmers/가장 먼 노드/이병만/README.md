Problem : [가장 먼 노드](https://programmers.co.kr/learn/courses/30/lessons/49189) **그래프 Level 3**

Flow :

1. 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.


Solution :
1. BFS를 사용하였다.
2. 딕셔너리를 생성하여 각 노드에 연결된 노드를 넣어주었다.
3. 각 노드로부터 거리를 담고 있는 dist 딕셔너리도 생성해주었다. 리스트로 하려고 했지만 어떤 노드가 가장 먼 노드인지 나타내기 위해서 딕셔너리를 사용했다.
4. 먼저 첫번째 노드를 큐에 넣어주고, 거리 dict의 값이 0이면 거리를 추가해주고, 해당 노드랑 연결된 노드들을 다 큐에 넣어준다.
4.1 이 때 조건문을 사용해서 이미 큐에 노드가 있으면 넣어주지 않으려고 했는데 시간초과로 조건문을 제거했다. 아무래도 조건문의 시간이 많이 걸리는 것 같다,
5. 반복문을 완료하면 거리가 저장된 딕셔너리에서 최댓값을 찾고 해당 값과 같은 값과 일치하는 노드가 가장 먼 노드이므로 개수를 카운트하여 반환해준다. 

Problem : [타일 장식물](https://programmers.co.kr/learn/courses/30/lessons/43104) **동적계획법 Level 3**

Flow :

1. 타일의 개수 N이 주어질 때, N개의 타일로 구성된 직사각형의 둘레를 return 하도록 solution 함수를 작성하시오.


Solution :
1. 타일의 길이가 증가하는 방식이 n번째와 n+1번째의 값을 더한 값으로 증가한다.
2. N의 값이 1이면 바로 4를 반환해준다.
3. 그렇지 않으면 N만큼 반복문을 실행하여 타일의 길이를 세팅해준다.
4. 길이를 담고 있는 배열을 만든 후 맨 마지막에 있는 타일의 길이 두 개를 가져온다. 이 두개의 타일이 가로 세로를 의미한다.
5. 총 변의 길이가 4개이므로 각각 2씩 곱한 값을 더해주고 반환해준다.
