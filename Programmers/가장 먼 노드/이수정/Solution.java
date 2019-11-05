import java.util.*;

class Solution {
    static class vertex {
        ArrayList<Integer> list;
        public vertex() {
            list = new ArrayList<>();
        }
        public void add(int n){
            this.list.add(n);
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dist = new int[n];
        Map<Integer, Integer> non_visited = new HashMap();
        vertex[] v = new vertex[n];
        
        dist[0] = 0;
        v[0] = new vertex();
        for(int i = 1; i<n; i++){
            dist[i] = 999999;
            non_visited.put(i, i);
            v[i] = new vertex();
        }
        
        for(int i = 0; i<edge.length; i++) {
            int v1 = edge[i][0]-1;
            int v2 = edge[i][1]-1;

            v[v1].add(v2);
            v[v2].add(v1);
            
            if(v1 == 0)
                dist[v2] = 1;
            
            if(v2 == 0)
                dist[v1] = 1;
        }
        
        int next = 0;
        for(int i = 0; i<n; i++) {
            Iterator<Integer> keys = non_visited.keySet().iterator(); 
            int min = 999999;
            while( keys.hasNext() ){ 
                int key = keys.next(); 
                if(min > dist[key]){
                    min = dist[key];
                    next = key;
                }
            }
            non_visited.remove(next);
            
            for(int k = 0; k<v[next].list.size(); k++) {
                int temp = v[next].list.get(k);
                if(non_visited.containsKey(temp)) {
                    if(dist[temp]> min+1) {
                        dist[temp] = min+1;
                    }
                }
            }
        }
        
        
        Arrays.sort(dist);
        int max = 0;
       
        for(int i = n-1; i>-1; i--) {
            if(dist[i] != 999999) {
                if(max == 0) {
                    max = dist[i];
                    answer = 1;
                }
                else {
                    if(max == dist[i])
                        answer++;
                    else
                        break;
                }
            }
        }
        
        return answer;
    }
   
}
