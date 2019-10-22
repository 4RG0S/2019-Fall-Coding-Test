
# coding: utf-8

# In[22]:


def solution(begin, target, words):
    answer = 0
    tar=list()
    start =list()
    word=list()
    index=0
    if target not in words:
        return 0
    else:
        for count in range(len(target)):
            tar.append(target[count])
            start.append(begin[count])
        while(len(words)!=0):
            word_list = words[index]
            for sp in range(len(word_list)):
                word.append(word_list[sp])
            tmp = start[:]
            count = 0
            for idx in range(len(target)):
                if start[idx]!= word[idx] and word[idx] != tar[idx] and abs(ord(tar[idx])-ord(start[idx]))>abs(ord(tar[idx])-ord(word[idx])):
                    count+=1
                elif start[idx] == tar[idx]:
                    continue
                elif word[idx] == tar[idx]:
                    start[idx]=word[idx]
                    break
                elif start[idx] == word[idx]:
                    continue
            if count == 1:
                start = word[:]
            if count == 2:
                break
            word =list()
            index+=1
            if index == len(words):
                index=0
            if start != tmp:
                answer +=1
            if start == tar:
                break
        return answer
   
    
print(solution("hit","cog",["hot", "dot", "dog", "lot", "log", "cog"]))
print(solution("hit","cog",["hot", "dot", "dog", "lot", "log"]))
print(solution("hit","hhh",["hhh", "hht"]))

