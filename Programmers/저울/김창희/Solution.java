// https://programmers.co.kr/learn/courses/30/lessons/42886

import java.util.*;

class Solution {
    public int solution(int[] weight) {
        Arrays.sort(weight);
        
        int answer = 1;
        for(int i = 0; i< weight.length; i++) {
            if(answer < weight[i]) {
                return answer;
            }
            answer += weight[i];
        }

        return answer;
    }
}