Problem : [오픈채팅방](https://programmers.co.kr/learn/courses/30/lessons/42888) **2019 KAKAO BLIND RECRUITMENT**

Flow :

1. 모든 유저는 [유저 아이디]로 구분한다.
2. [유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - Enter [유저 아이디] [닉네임] (ex. Enter uid1234 Muzi)
3. [유저 아이디] 사용자가 채팅방에서 퇴장 - Leave [유저 아이디] (ex. Leave uid1234)
4. [유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - Change [유저 아이디] [닉네임] (ex. Change uid1234 Muzi)
5. 첫 단어는 Enter, Leave, Change 중 하나이다.
6. 각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.
7. 유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.
8. 유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.
9. 채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.


Solution :

1. 먼저, record를 ' ' 기준으로 자른다.
2. 명령어, 유저 아이디, 닉네임을 저장한다.
3. temp 배열에 유저 아이디와 각 상황에 맞게 출력문을 넣어준다.
4. record를 다 읽은 후에 temp 배열에서 유저 아이디를 꺼내서 dict에 있는 닉네임을 가져와서 answer 배열에 넣어준다.