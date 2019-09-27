import java.util.*;

class Solution {
    private static Map<String, Integer> map;
    public int solution(String[][] clothes) {
        int answer = 0;
        String[] key;
        map = new HashMap();
        
        //맵에 옷종류 넣기
        for(int i = 0; i<clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }
            else {
                map.put(clothes[i][1], 1);
            }
        }
        
        key = new String[map.keySet().size()];
        key = map.keySet().toArray(key);
        
        answer = recu(key, 0, 1);
        answer--;                   //아무것도 안입었을 경우를 빼줘야함
        
        return answer;
    }
    
    //재귀 index에 해당하는 옷종류를 입거나 / 안입거나
    public int recu(String[] key,int index, int count ) {
        if(index >= key.length)
            return count;
        
        int result = 0;
        result += recu(key, index+1, count*map.get(key[index]));     //포함
        result += recu(key, index+1, count);                         //포함x
        
        return result;
    }
}
