import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);  
        List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());
        
        boolean flag = false;
        
        while(list.size() > 0) {
            if (list.size() > 2 && list.get(0)+list.get(1) > limit){                //가장 작은 몸무게 2개가 합해서 limit을 넘어갈 때 
                answer += list.size();
                break;
            }
            
            flag = false;
            int count = 0;
            
            for(int j = list.size()-1; j>0; j--) {                      //가장 작은 몸무게와 가장 큰 몸무게를 합치는게 효율적
                if(list.get(0)+list.get(j) <= limit) {
                    list.remove(j); list.remove(0);                    
                    answer++;
                    flag = true;
                    break;
                }
                count++;
            }
            if(flag == false) {                 //보트에 1명씩 밖에 못타는 경우
                answer+= list.size();
                break;
            }

            if(count > 0) {                     //가장 작은 값과 더해도 limit보다 큰 몸무게를 가진 사람들
               for(int i = 0; i<count; i++) {
                   list.remove(list.size()-1);
                   answer++;
               }
            }
        }
               
        return answer;
    }
}
