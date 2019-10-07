// https://programmers.co.kr/learn/courses/30/lessons/42627
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int numberOfJob = jobs.length;
        List<Job> jobList = new ArrayList<>(numberOfJob);
        Map<Job, Integer> timeFromRequestToEndOfJobMap = new HashMap<>();
        
        for(int i = 0; i < numberOfJob; i++) {
            Job job = new Job(jobs[i][0], jobs[i][1]);
            jobList.add(job);
        }
        
        // 작업 요청 시점에 대하여 오름차순 sorting
        Collections.sort(jobList, new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return Integer.compare(job1.getRequestedTime(), job2.getRequestedTime());
            }
        });
        
        Job nowJob = null;
        int time = 0;
        int jobIndex = 0;
        PriorityQueue<Job> jobPriorityQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                if(job1.getRemainedTime() > job2.getRemainedTime()) {                               // 남은 시간에 대한 MinHeap으로
                    return 1;
                }else if(job1.getRemainedTime() == job2.getRemainedTime()) {
                    return Integer.compare(job1.getRequestedTime(), job2.getRequestedTime());       // 요청 시간에 대한 MinHeap으로
                }else {
                    return -1;
                }

            }
        });
        
        while(timeFromRequestToEndOfJobMap.size() < numberOfJob) {
            while(jobIndex < numberOfJob && jobList.get(jobIndex).getRequestedTime() == time) {
                jobPriorityQueue.offer(jobList.get(jobIndex));
                jobIndex++;
            }
            
            if(!jobPriorityQueue.isEmpty()) {
                if(nowJob == null) {
                    nowJob = jobPriorityQueue.poll();
                }
                // SRF가 아닌 SJF..
                // }else if(nowJob.getRemainedTime() > jobPriorityQueue.peek().getRemainedTime()) {
                //     Job temp = nowJob;
                //     nowJob = jobPriorityQueue.poll();
                //     jobPriorityQueue.offer(temp);
                // }
            }
    
            time++;
            if(nowJob != null) {
                nowJob.minusRemainedTime(1);
                if(nowJob.getRemainedTime() == 0) {
                    timeFromRequestToEndOfJobMap.put(nowJob, time - nowJob.getRequestedTime());
                    nowJob = null;
                }
            }
        }
          
        return timeFromRequestToEndOfJobMap.values().stream().mapToInt(i->i).sum() / numberOfJob;
    }
    
    private static class Job {
        private int requestedTime;
        private int remainedTime;
        
        Job(int requestedTime, int remainedTime) {
            this.requestedTime = requestedTime;
            this.remainedTime = remainedTime;
        }
        
        int getRequestedTime() {
            return requestedTime;
        }
        
        int getRemainedTime() {
            return remainedTime;
        }
        
        void setRemainedTime(int remainedTime) {
            this.remainedTime = remainedTime;
        }
        
        void minusRemainedTime(int minusTime) {
            this.remainedTime -= minusTime;
        }    
    }
    
    
}