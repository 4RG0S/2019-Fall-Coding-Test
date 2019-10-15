// https://programmers.co.kr/learn/courses/30/lessons/43163
import java.util.*;

class Solution {
    private List<Integer> countList = new LinkedList<>();
    
    public int solution(String begin, String target, String[] words) {
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(begin);
        dfs(words, visitedSet, begin, target, 0);
        
        if(countList.isEmpty()) {
            return 0;
        }
        
        return Collections.min(countList);
    }
    
    private void dfs(String[] words, Set<String> visitedSet, String now, String target, int count) {
        if(now.equals(target)) {
            countList.add(count);
           return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(isConvertible(now, words[i], visitedSet)) {
                Set<String> newVisitedSet = new HashSet<>();
                newVisitedSet.addAll(visitedSet);
                newVisitedSet.add(words[i]);
                dfs(words, newVisitedSet, words[i], target, count + 1);
            }
        }
    }
    
    private boolean isConvertible(String src, String dst, Set<String> visitedSet) {
        if(visitedSet.contains(dst)) {
            return false;
        }
        
        int notEqualCount = 0;
        for(int i = 0; i < src.length(); i++) {
            if(src.charAt(i) != dst.charAt(i)) {
                notEqualCount++;
            }
        }
        
        if(notEqualCount == 1) {
            return true;
        }
        
        return false;
    }
    
}