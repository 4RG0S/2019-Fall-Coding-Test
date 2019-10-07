import java.util.*;

class Solution {
    static private Map<Integer, String> map;
    static private int flag = 0;
    static private String[] answer;
    
    static class ticket{
        int index;
        String airport;
        public ticket(int index, String airport) {
            this.index = index;
            this.airport = airport;
        }
    }
    public String[] solution(String[][] tickets) {
        map = new HashMap();
        dfs(tickets, "ICN", new ArrayList<ticket>());
        
        return answer;
    }
    
    public void dfs(String[][] tickets, String airport, ArrayList<ticket> route) {
        if(flag > 0)                                //이미 경로가 나온 경우
            return;
        
        if(map.size() == tickets.length){           //최초 경로 = 알파벳이 가장 빠른 경로
            answer = new String[route.size()+1];
            answer[0] = "ICN";
            for(int i = 0; i<route.size(); i++) {
                answer[i+1] = route.get(i).airport;
            }
            flag++;
            return ;
        }
        else {
            ArrayList<ticket> des = new ArrayList<>();                 //현재 티켓 출발공항의 도착지
            
            for(int i = 0; i<tickets.length; i++) {
                if(airport.equals(tickets[i][0])) {
                    if(!map.containsKey(i))
                        des.add(new ticket(i, tickets[i][1]));
                }
            }
            if(des.size() > 0){                                         //가능 경로가 있을 때 알파벳 순 정렬
                 Collections.sort(des, new Comparator<ticket>() {
                    @Override
                    public int compare(ticket t1, ticket t2) {
                        return t1.airport.compareTo(t2.airport);
                    }
                });


                for(int i = 0; i<des.size(); i++){
                    ArrayList<ticket> list = new ArrayList<>();
                    list.addAll(route);
                    list.add(des.get(i));
                    
                    map.put(des.get(i).index, "");
                    dfs(tickets, des.get(i).airport, list); 
                    map.remove(des.get(i).index);                   //다른 경로 선택을 위한 삭제
                    
                        
                }              
            }
            else {
                return ;
            }
        }
    }
}
