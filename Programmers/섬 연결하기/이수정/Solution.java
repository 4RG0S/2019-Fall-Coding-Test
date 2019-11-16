import java.util.*;
class Solution {
    static int[] parent;
    static class Edge implements Comparable<Edge>{
        int x; int y;
        int weight;
        
        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e) {
            if(this.weight > e.weight)
                return 1;
            else
                return -1;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        parent = new int[n];
        for(int i = 0; i<costs.length; i++) {
           queue.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        for(int i = 0; i<n; i++) {
            parent[i] = i;
        }
        
        while(!queue.isEmpty()) {
            Edge e = queue.poll();
            int x = e.x;
            int y = e.y;
            
            int a = find(x);
            int b = find(y);
            
            if(a == b) continue;
            union(a, b);
            
           // System.out.println(e.weight);
            answer += e.weight;
        }
        
        
        return answer;
    }
    public static int find(int n) {
        if(n == parent[n]) return n;
        parent[n] = find(parent[n]);
        return parent[n];
    }
    
    public static void union(int a, int b) {
        int aR = find(a);
        int bR = find(b);
        if(aR != bR)
            parent[aR] = b;
    }
}
