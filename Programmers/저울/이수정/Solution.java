import java.util.*;

class Solution {
    public int solution(int[] weight) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(weight);
        
        sum = 1;
        
        for(int i = 0; i<weight.length; i++) {
            if(sum < weight[i]) {
                break;
            }
            sum +=weight[i];
        }
        answer = sum;
        
        return answer;
    }
}
