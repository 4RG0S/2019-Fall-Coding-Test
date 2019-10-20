// https://programmers.co.kr/learn/courses/30/lessons/43162
import java.util.*;
class Solution {
    private Set<Integer> checkedNodeSet = new HashSet<>();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int start = 0; start < n; start++) {
            if(!checkedNodeSet.contains(start)) {
                answer++;
                bfs(computers, start);
            }
        }
        
        return answer;
    }
   
    private void bfs(int[][] computers, int start) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        checkedNodeSet.add(start);
        nodeQueue.add(start);
        
        while(!nodeQueue.isEmpty()) {
            int now = nodeQueue.poll();
            
            for(int next = 0; next < computers[now].length; next++) {
                if(!checkedNodeSet.contains(next) && computers[now][next] == 1) {
                    checkedNodeSet.add(next);
                    nodeQueue.add(next);
                }
            }
        }
    }
    
    
}