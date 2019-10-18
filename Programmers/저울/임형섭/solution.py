
# coding: utf-8

# In[13]:


def solution(weight):
    answer = 0
    weight = sorted(weight)
    answer= weight[0]
    sol_list = list()
    for i in range(len(weight)):
        if answer < weight[i]:
            return answer
        else:
            answer+= weight[i]
    return answer

solution([3, 1, 6, 2, 7, 30, 1])

