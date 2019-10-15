## 스케줄이 비어있을때, 들어와야할 스케줄 확인
## 밀려있을 때는 일이 짧은 순서대로

seq = []
def first_disc(jobs,first):
    seq.append(first)
    # print("seq : "+str(seq))
    next = []
    temp = []
    jobs.remove(first)
    if len(jobs) == 0:
        solution(seq)
        return 0
    for i in range(0, len(jobs)):
        if int(first[1]) >= int(jobs[i][0]):
            next.append(jobs[i])
        else :
            temp.append(jobs[i])
    if len(next) != 0:
        min = next[0]
        for i in range(1, len(next)):
            if min[1] > next[i][1]:
                min = next[i]
            if min[1] == next[i][1]:
                if min[0] > next[i][0]:
                    min = next[i]
        print(min)
    else:
        min = temp[0]
        temp.remove(min)
        print(min)
    first_disc(jobs, min)

def solution(seq):
    addition = 0
    current = 0
    i = 0
    while True:
        if i == len(seq):
            break
        if i == 0:
            addition = seq[i][1]
            current = seq[i][1]
        elif current >= seq[i][0]:
            addition += current - seq[i][0] + seq[i][1]
            current += seq[i][1]
        elif current < seq[i][0]:
            addition += seq[i][1]
            current += seq[i][0] + seq[i][1]

        i += 1

    answer = int(addition / len(seq))
    print("answer : " +str(answer))



if __name__ == '__main__':
    jobs = [[0,3],[1,9],[2,6],[4,3],[500,2]]
    first = jobs[0]

    first_disc(jobs, first)
