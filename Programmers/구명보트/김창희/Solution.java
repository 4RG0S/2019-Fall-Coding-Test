// https://programmers.co.kr/learn/courses/30/lessons/42885
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int answer = 0;
        
        while(left <= right) {
            int leftPeopleWeight = people[left];
            int rightPeopleWeight = people[right];
            if(leftPeopleWeight + rightPeopleWeight <= limit) {
                left++;
                right--;
            }else {
                right--;
            }
            answer++;
        }
        
        return answer;
    }
}