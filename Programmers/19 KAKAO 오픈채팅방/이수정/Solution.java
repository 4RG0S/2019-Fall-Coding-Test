import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public String[] solution(String[] record) {
        int n = record.length;
        int m = n;
        String[] answer = new String[n];
        String[] tmp = {};
        
        Map<String, String> user = new HashMap<String, String>();
        
        for(int i = 0; i<n; i++) {
            
            //String flag = record[i].substring(0,1);
            
            StringTokenizer t = new StringTokenizer(record[i], " ");
            
            String command = t.nextToken();
            String id = t.nextToken();
           
            String name = "";

            if(command.equals("Enter") || command.equals("Change")) {
                name = t.nextToken();
                user.put(id, name);
                if(command.equals("Change")) 
                    m--;
            }   
            
        }
        tmp = new String[m];
        int j = 0;
        for(int i = 0; i<n; i++) {
            StringTokenizer t = new StringTokenizer(record[i], " ");
            String command = t.nextToken();
            String id = t.nextToken();
            
            if(command.equals("Enter")) {
                tmp[j++] = user.get(id)+"님이 들어왔습니다.";
            }
            else if(command.equals("Leave")) {
                tmp[j++] = user.get(id)+"님이 나갔습니다.";
            }
        }
        
        
       
       
        return tmp;
    }
}
