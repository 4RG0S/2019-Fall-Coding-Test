import java.lang.Comparable;
import java.util.*;

class Solution {
    static class stage implements Comparable<stage>{
        int num;
        float fail;
        public stage(int num) {
            this.num = num;
            this.fail = 0;
        }
        public void setFail(float fail) {
            this.fail = fail;
        }
        @Override
        public int compareTo(stage t) {
            if(this.fail < t.fail)
                return 1;
            else if(this.fail == t.fail) {
                if(this.num > t.num)
                    return 1;
            }
            return -1;
        }
    }
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        stage[] s = new stage[N];
        int[] answer = new int[N];
        float count = 0;                              //머물러있는 사람
        int prev = stages[0];                       //이전 스테이지 체크용
        
        for(int i = 0; i<N; i++) {
            s[i] = new stage(i+1);
        }
        
        for(int i = 0; i<stages.length; i++) {
            if(prev == stages[i]){
                count++;
                if(prev <= N && i == stages.length-1){                          //마지막 index 스테이지 계산 
                    s[prev-1].setFail(count/(stages.length-i+count-1));
                }
            }
            
            else {
                s[prev-1].setFail(count/(stages.length-i+count));
                prev = stages[i];
                count = 1;
            }          
        }
        
        Arrays.sort(s);
        for(int i = 0; i<N; i++){
            answer[i] = s[i].num;
        }
        return answer;
    }
}
