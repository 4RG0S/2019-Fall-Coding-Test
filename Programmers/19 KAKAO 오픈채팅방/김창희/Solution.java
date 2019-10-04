// https://programmers.co.kr/learn/courses/30/lessons/42888
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        Map<String, String> userNickNameTable = new HashMap<>();
        
        for(int i = 0; i < record.length; i++) {
            String[] splitResult = record[i].split(" ");
            String action = splitResult[0];
            String userId = splitResult[1];
            
            if(action.equals("Enter")) {
                String nickName = splitResult[2];
                
                result.add(new StringBuilder(32)
                                    .append(userId)
                                    .append("님이 들어왔습니다.")
                                    .toString());
                
                if(userNickNameTable.get(userId) == null) {
                    userNickNameTable.put(userId, nickName);
                }else{
                    userNickNameTable.replace(userId, nickName);
                }
                
            }else if(action.equals("Leave")){
                result.add(new StringBuilder(32)
                                    .append(userId)
                                    .append("님이 나갔습니다.")
                                    .toString());
            }else if(action.equals("Change")) {
                String nickName = splitResult[2];
                userNickNameTable.replace(userId, nickName);
            }
        }
        

        for(int i = 0; i < result.size(); i++) {
            String resultEntry = result.get(i);
            String userId = resultEntry.split("님이 ")[0];
            resultEntry = resultEntry.replace(userId, userNickNameTable.get(userId));
            result.set(i, resultEntry);
        }
        
        return result.toArray(new String[result.size()]);
    }
}