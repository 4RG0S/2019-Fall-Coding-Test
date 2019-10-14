import java.util.*;

class Solution {
    static int min;
    public int solution(String begin, String target, String[] words) {
        min = words.length+1;
        dfs(begin, words, new int[words.length], target, 0);
        int answer = min;
        
        if(min > words.length)
            answer = 0;
        return answer;
    }
    public void dfs(String begin, String[] words, int[] visited, String target, int count) {
        if(count > words.length)
            return;
        if(begin.equals(target)) {
            if(min > count)
                min = count;
            return ;
        }
        
        else {
            for(int i = 0; i<words.length; i++) {
                int flag = 0;
                if(visited[i] == 0) {                                    //Not visited
                    String[] arr = begin.split("");                     //begin
                    String[] arr2 = words[i].split("");                 //비교할 단어
                    for(int j = 0; j<words[i].length(); j++) {
                        if(!arr[j].equals(arr2[j]))
                            flag++;
                        
                        if(flag > 1)
                            break;
                    }
                    if(flag == 1){
                        int[] visit = new int[visited.length];
                        System.arraycopy(visited, 0, visit, 0, visited.length);
                        visit[i] = 1;
                        dfs(words[i], words, visit, target, count+1);
                    }
                       
                }   
            }
        }
    }
   
}
