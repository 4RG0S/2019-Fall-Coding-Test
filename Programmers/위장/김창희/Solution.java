// https://programmers.co.kr/learn/courses/30/lessons/42578
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> clothListByTypeMap = new HashMap<>();
        
        // 가능한 모든 조합의 집합을 구할 필요가 없었음
        // Map<String, List<String>> clothListByTypeMap = new LinkedHashMap<>();
        // List<String> clothTypeList = new ArrayList<>();
        
        for(String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];
            
            List<String> clothList = clothListByTypeMap.get(type);
            if(clothList == null) {
                clothList = new LinkedList<>();
                clothListByTypeMap.put(type, clothList);
                
                // 가능한 모든 조합의 집합을 구할 필요가 없었음
                // clothTypeList.add(type);
            }
            clothList.add(name);
        }
        
        int clothesCombinationCount = 1;
        for(String clothType : clothListByTypeMap.keySet()) {
            // 1 더하는 이유 -> 해당 타입의 옷을 안입는 경우를 추가하기 위함
            clothesCombinationCount *= (clothListByTypeMap.get(clothType).size() + 1);
        }
        
        // 최소 한 개의 의상은 입으므로, 모든 타입의 옷을 안입는 경우의 수를 제거
        clothesCombinationCount -= 1;
        
//         // 가능한 모든 조합의 집합을 구할 필요가 없었음
//         // subset + cartesian product 논리로 해결 가능
//         List<Set<String>> clothTypeSubSetList = getClothTypeSubSetList(clothTypeList, clothListByTypeMap.size());
//         for(Set<String> clothTypeSubSet : clothTypeSubSetList) {
            
//             // 공집합
//             if(clothTypeSubSet.isEmpty()) {
//                 continue;
//             }
            
//             int temp = 1;
//             for(String clothType : clothTypeSubSet) {
//                 temp *= clothListByTypeMap.get(clothType).size();
//             }
            
//             clothesCombinationCount += temp;
//         }
        
        return clothesCombinationCount;
    }

//     // 가능한 모든 조합의 집합을 구할 필요가 없었음
//     private List<Set<String>> getClothTypeSubSetList(List<String> clothTypeList, int n) {
//         int numberOfCases = 1 << n;     // 부분집합은 2^n 개
//         List<Set<String>> ClothTypeSubSetList = new LinkedList<>();
        
//         for(int i = 0 ; i < numberOfCases ; i++){
//             Set<String> clothTypeSubSet = new HashSet<>();
//             for(int j = 0 ; j < n ; j++){
//                 if((i & (1 << j )) != 0) {
//                     clothTypeSubSet.add(clothTypeList.get(j));
//                 }
//             }
//             ClothTypeSubSetList.add(clothTypeSubSet);
//         }
        
//         return ClothTypeSubSetList;
//     }
}