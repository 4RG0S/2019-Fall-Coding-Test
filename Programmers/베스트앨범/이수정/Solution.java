import java.util.*;
class Solution {
    static class song {
        int play;
        int num;
        public song(int play, int num) {
            this.play = play;
            this.num = num;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Map<String, Integer> genre = new HashMap();
        Map<String, song> songs = new HashMap ();
        ArrayList<Integer> list = new ArrayList();
        
        for(int i = 0; i<genres.length; i++) {
            if(genre.containsKey(genres[i]))
                genre.put(genres[i], genre.get(genres[i])+plays[i]);
            else if(!genre.containsKey(genres[i]))
                genre.put(genres[i], plays[i]);
            
            if(songs.containsKey(genres[i]+"0")) {                              //1개라도 들어있을 시
                if(songs.containsKey(genres[i]+"1")) {
                    if(songs.get(genres[i]+"1").play < plays[i]) {
                        if(songs.get(genres[i]+"0").play <plays[i]){
                            song tmp = songs.get(genres[i]+"0");
                            songs.put(genres[i]+"0", new song(plays[i], i));
                            songs.put(genres[i]+"1", tmp);
                        }
                        else
                            songs.put(genres[i]+"1", new song(plays[i], i));
                    }
                }
                else {
                    if(songs.get(genres[i]+"0").play <plays[i]){
                        song tmp = songs.get(genres[i]+"0");
                        songs.put(genres[i]+"0", new song(plays[i], i));
                        songs.put(genres[i]+"1", tmp);
                    }
                    else {
                        songs.put(genres[i]+"1", new song(plays[i], i));
                    }     
                }
            }
            else {
                songs.put(genres[i]+"0", new song(plays[i], i));
            }
                      
        }
        
        Iterator it = sortByValue(genre).iterator();
        while(it.hasNext()) {
            String key = (String) it.next();
            
            if(songs.containsKey(key+"1")) {
                list.add(songs.get(key+"0").num);
                list.add(songs.get(key+"1").num);
            }
            else
                list.add(songs.get(key+"0").num);
        }
        
        answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
    
    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);

            }   
        });
        return list;

    }
}
