// https://programmers.co.kr/learn/courses/30/lessons/42890
import java.util.*;
class Solution {

    Comparator<Integer> comp = new Comparator<Integer>() {
        int countBit(int n) {
            int result = 0;
            while(n != 0) {
                if((n & 1) != 0){
                    result++;
                }
                n = n >> 1;
            }    
            return result;
        }
        
        @Override
        public int compare(Integer a, Integer b) {
            int aBitCount = countBit(a);
            int bBitCount = countBit(b);
            
            if(aBitCount > bBitCount) {
                return 1;
            }else if(aBitCount == bBitCount) {
                return 0;
            }else {
                return -1;
            }
        }
    };
    
    
    public int solution(String[][] relation) {
        int rowSize =  relation.length;
        int columnSize = relation[0].length;
        List<Integer> superKeyList = new LinkedList<>();
        
        for(int i = 1; i < 1 << columnSize; i++) {
            if(isSuperKey(relation, rowSize, columnSize, i)) {
                superKeyList.add(i);
            }
        }
        
        Collections.sort(superKeyList, comp);
        int answer = 0;
        while(!superKeyList.isEmpty()) {
            int n = superKeyList.remove(0);
            answer++;
            
            for(Iterator<Integer> iter = superKeyList.iterator(); iter.hasNext(); ) {
                if((n & iter.next()) == n) {
                    iter.remove();
                }
            }
        }
        
        return answer;
    }
    
    private boolean isSuperKey(String[][] relation, int rowSize, int columnSize, int subset) {
        for(int a = 0; a < rowSize - 1; a++) {
            for(int b = a + 1; b < rowSize; b++) {
                boolean isSame = true;
                
                for(int k = 0; k < columnSize; k++) {
                    if((subset & 1 << k) == 0) {
                        continue;
                    }
                    
                    if(!relation[a][k].equals(relation[b][k])) {
                        isSame = false;
                        break;
                    }
                }
                
                if(isSame) {
                    return false;
                }
                
            }
        }
        
        return true;
    }
    
}
