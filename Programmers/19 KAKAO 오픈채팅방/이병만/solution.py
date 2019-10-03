# -*- coding: utf-8 -*-
def solution(record):
    answer = []
    temp = []
    dict = {}

    for i in range(len(record)):
        command = record[i].split(' ')[0]
        id = record[i].split(' ')[1]

        if command == 'Enter':
            name = record[i].split(' ')[2]
            dict[id] = name
            temp.append([id, '님이 들어왔습니다.'])

        elif command == 'Leave':
            temp.append([id, '님이 나갔습니다.'])

        else:  # command == 'Change'
            name = record[i].split(' ')[2]
            dict[id] = name

    for j in range(len(temp)):
        answer.append(str(dict.get(temp[j][0])) + temp[j][1])

    return answer
