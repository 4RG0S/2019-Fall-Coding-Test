
# coding: utf-8

# In[58]:



def solution(record):
    answer = []
    user_list = dict()
    log_list= list()
    answer1 =list()
    for line in record:
        split_line = line.split(" ")
        if split_line[0] == "Enter":
            user_list[split_line[1]]=split_line[2]
            log_list.append((split_line[0],split_line[1]))
        elif split_line[0] == "Leave":
            log_list.append((split_line[0],split_line[1]))
        else:
            user_list[split_line[1]]=split_line[2]
    
    print( user_list.items())
    for i in range(len(log_list)):
        if log_list[i][0]=="Enter":
            answer.append(user_list[log_list[i][1]]+"님이 들어왔습니다.")
        else:
            answer.append(user_list[log_list[i][1]]+"님이 나갔습니다.")
    return answer



solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"])

