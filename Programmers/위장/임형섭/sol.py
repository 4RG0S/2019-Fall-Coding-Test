
# coding: utf-8

def solution(clothes):
    
    cloth=dict()
    answer = 1
    for spec in clothes:
        if spec[1] not in cloth:
            cloth[spec[1]]=list()
            cloth[spec[1]].append(spec[0])
        else:
            cloth[spec[1]].append(spec[0])
            
            
    for i in cloth.keys():
        print(cloth[i])
        print(len(cloth[i]))
        answer *= len(cloth[i])+1
    return answer-1

    

solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]])
solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]])
