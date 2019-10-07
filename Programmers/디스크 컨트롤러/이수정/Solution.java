import java.util.*;
class Solution {
    static class job implements Comparable<job>{
        int start;
        int running;
        
        public job(int start, int running) {
            this.start = start;
            this.running = running;
        }
        @Override
        public int compareTo(job j) {
            if(this.running < j.running) {
                return -1;
            }
            else if(this.running == j.running) {
                if(this.start < j.start)
                    return -1;
                else
                    return 1;
            }
            else 
                return 1;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        PriorityQueue<job> pq = new PriorityQueue<>();
        ArrayList<job> list = new ArrayList<>();
        
        for(int i = 0; i<jobs.length; i++)
            pq.add(new job(jobs[i][0], jobs[i][1]));
        
        for(int i = 0; i<jobs.length; i++)
            list.add(pq.poll());
        
        while(list.size() > 0) {
            for(int i = 0; i<list.size(); i++) {
                if(time >= list.get(i).start) {
                    answer += time-list.get(i).start;
                    answer += list.get(i).running;
                    time += list.get(i).running;
                    
                    list.remove(i);
                    break;
                }
                else {
                    if(i == list.size()-1) time++;
                }
            }
        }
        answer /= jobs.length;
        
        return answer;
    }
}
