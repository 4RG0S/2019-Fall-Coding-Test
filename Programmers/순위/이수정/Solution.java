class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int MAX = 99999;
        int[][] matrix = new int[n][n];
        int[] rank = new int[n];    
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                matrix[i][j] = i==j?0:MAX;
            }
        }
        
        for(int i = 0; i<results.length; i++) {
            int a = results[i][0]-1;
            int b = results[i][1]-1;
            matrix[a][b] = 1;            
        }
        
        //워샬 알고리즘
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                for(int k = 0; k<n; k++) {
                    if(matrix[j][i] != MAX && matrix[i][k] != MAX)
                        matrix[j][k] = min(matrix[j][i] + matrix[i][k], matrix[j][k]);
                }
            }
        }
        
        //연결 유무
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (matrix[i][j] == MAX) {
                    if (matrix[j][i] == MAX){
                        rank[i] = 1;
                        break;
                    }
                }
            }
        }
        
        for(int i = 0 ;i<n; i++) {
            if(rank[i] == 0)
                answer++;
        }
        return answer;
    }
    public static int min(int a, int b) {
        if(a > b)
            return b;
        return a;
    }
}
