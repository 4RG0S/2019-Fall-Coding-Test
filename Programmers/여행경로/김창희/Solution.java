// https://programmers.co.kr/learn/courses/30/lessons/43164
import java.util.*;

class Solution {
    private int numberOfTicket;
    private Map<String, List<Ticket>> ticketListMap;            // 출발지별 티켓 리스트에 대한 맵
    private boolean find = false;
    private String[] result;
    
    
    public String[] solution(String[][] tickets) {
        numberOfTicket = tickets.length;
        ticketListMap = new HashMap<>();
        
        for(String ticket[] : tickets) {
            String departure = ticket[0];
            String destination = ticket[1];
            
            List<Ticket> ticketList = ticketListMap.get(departure);
            if(ticketList == null) {
                ticketList = new LinkedList<>();
                ticketListMap.put(departure, ticketList);
            }
            ticketList.add(new Ticket(departure, destination));
        }
        
        for(List<Ticket> ticketList : ticketListMap.values()) {
            Collections.sort(ticketList, new Comparator<Ticket>() {
                @Override
                public int compare(Ticket ticket1, Ticket ticket2) {
                    return ticket1.destination.compareTo(ticket2.destination);
                }
            });
            
        }
        
        dfs("ICN", new LinkedHashSet<Ticket>());
        return result;
    }
    
    private void dfs(String nowAirport, LinkedHashSet<Ticket> usedTicketSet) {
        if(find) {
            return;
        }
        
        if(usedTicketSet.size() == numberOfTicket) {
            result = new String[usedTicketSet.size() + 1];
            int i = 0;
            for(Ticket ticket : usedTicketSet) {
                result[i] = ticket.departure;
                i++;
            }
            result[usedTicketSet.size()] = nowAirport;
            find = true;
            return;
        }
        
        List<Ticket> ticketList = ticketListMap.get(nowAirport);
        if(ticketList == null) {
            return;
        }
        
        for(Ticket ticket : ticketList) {
            if(!usedTicketSet.contains(ticket)) {
                usedTicketSet.add(ticket);
                dfs(ticket.destination, usedTicketSet);
                usedTicketSet.remove(ticket);
            }
        }
        
    }
    
    private static class Ticket{
        String departure;
        String destination;
        
        Ticket(String departure, String destination) {
            this.departure = departure;
            this.destination = destination;
        }
    }
    
}