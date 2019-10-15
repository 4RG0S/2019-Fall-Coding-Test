// https://programmers.co.kr/learn/courses/30/lessons/42889
import java.util.*;

class Solution {
    private Comparator<Stage> stageCompare = new Comparator<Stage>() {
        @Override
        public int compare(Stage stage1, Stage stage2) {
            if(stage1.failRate == stage2.failRate) {
                return stage1.number - stage2.number;
            }else if(stage1.failRate < stage2.failRate) {
                return 1;
            }else {
                return -1;
            }
        }
    };
    
    public int[] solution(int N, int[] stages) {
        List<Stage> stageList = new ArrayList<>(N);
        
        for(int i = 0; i < N; i++) {
            stageList.add(new Stage(i + 1));
        }
        
        for(int reachedStage : stages) {
            for(int i = 1 ; i < reachedStage; i++) {
                Stage stage = stageList.get(i - 1);
                stage.challenge++;
                stage.clear++;
            }
            
            if(reachedStage <= N) {
                Stage stage = stageList.get(reachedStage - 1);
                stage.challenge++;
            }
        }
        
        // 실패율 계산
        for(Stage stage : stageList) {
            if(stage.challenge != 0) {
                stage.failRate = (double) (stage.challenge - stage.clear) / stage.challenge;
            }
        }
        
        stageList.sort(stageCompare);
        int[] answer = new int[N];
        for(int i = 0 ; i < N; i++) {
            answer[i] = stageList.get(i).number;
        }
        
        return answer;
    }
    
    class Stage {
        int number;
        int challenge;
        int clear;
        double failRate;
        
        Stage(int number) {
            this.number = number;
            this.challenge = 0;
            this.clear = 0;
            failRate = 0;
        }
    }
}