import java.util.*;
class Solution {
    int[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        
        for(int i = 0; i<n; i++) {
            if(visited[i] == 0) {                   //i번째와 연결된 모든 정점을 탐색한 후, 미방문 정점이 있을 시 네트워크 +1
                answer++;
                dfs(i, computers, n);
            }
        }
        return answer;
    }
    
    public void dfs(int index, int[][] computers, int n) {
        visited[index] = 1;
        for(int i = 0; i<n; i++) {                                  //현재 정점과 연결된 Edge들 모두 방문
            if(visited[i] != 1 && computers[index][i] == 1) {
                dfs(i, computers, n);
            }
        }
    }
}
