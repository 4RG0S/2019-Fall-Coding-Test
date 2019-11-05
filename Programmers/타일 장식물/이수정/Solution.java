class Solution {
    public long solution(int N) {
        long answer = 0;
        long[] fibo = new long[N];
        fibo[0] = 1;
        fibo[1] = 1;
        
        for(int i = 2; i<N; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        
        answer = fibo[N-1]*2 + (fibo[N-1]+fibo[N-2])*2;
        return answer;
    }
}
