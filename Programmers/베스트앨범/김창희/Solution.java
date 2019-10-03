// https://programmers.co.kr/learn/courses/30/lessons/42579
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> albumMusicList = new LinkedList<>();
        Map<String, List<Music>> musicListByGenreMap = new HashMap<>();
        int numberOfSongs = genres.length;
        
        for(int uniqueNumber = 0; uniqueNumber < numberOfSongs; uniqueNumber++) {
            List<Music> musicList = musicListByGenreMap.get(genres[uniqueNumber]);
            if(musicList == null) {
                musicList = new LinkedList<>();
                musicListByGenreMap.put(genres[uniqueNumber], musicList);
            }
            musicList.add(new Music(uniqueNumber, plays[uniqueNumber]));
        }
        

        List<Genre> sortedGenreList = getSortedGenreList(musicListByGenreMap);
        
        for(Genre genre : sortedGenreList) {
            String genreName = genre.getName();
            List<Music> musicList = musicListByGenreMap.get(genreName);
            Collections.sort(musicList, new Comparator<Music>() {
                @Override
                public int compare(Music music1, Music music2) {
                    int playTimeOfMusic1 = music1.getPlayTime();
                    int playTimeOfMusic2 = music2.getPlayTime();
                    
                    // if(playTimeOfMusic1 < playTimeOfMusic2) {
                    //     return 1;
                    // }else if(playTimeOfMusic1 == playTimeOfMusic2) {
                    //     if(music1.getUniqueNumber() <= music2.getUniqueNumber()) {
                    //         return -1;
                    //     }else {
                    //         return 1;
                    //     }
                    // }else {
                    //     return -1;
                    // }
                    
                    return Integer.compare(playTimeOfMusic2, playTimeOfMusic1);
                }
            });
            
            for(int count = 0; count < Integer.min(2, musicList.size()); count++) {
                albumMusicList.add(musicList.get(count).getUniqueNumber());
            }
        }
        

        return albumMusicList.stream().mapToInt(i -> i).toArray();
    }
    
    private List<Genre> getSortedGenreList(Map<String, List<Music>> musicListByGenreMap) {
        List<Genre> genreList = new LinkedList<>();
        
        for(Map.Entry<String, List<Music>> entry : musicListByGenreMap.entrySet()) {
            String genreName = entry.getKey();
            long totalPlayTime = 0;
            for(Music music : entry.getValue()) {
                totalPlayTime += music.getPlayTime();
            }
            
            genreList.add(new Genre(genreName, totalPlayTime));
        }
        
        Collections.sort(genreList, new Comparator<Genre>() {
            @Override
            public int compare(Genre genre1, Genre genre2) {
                return Long.compare(genre2.getTotalPlayTime(), genre1.getTotalPlayTime());
            }
        });
        
        return genreList;
    }
    
    private class Genre {
        private String name;
        private long totalPlayTime;
        
        Genre(String name, long totalPlayTime) {
            this.name = name;
            this.totalPlayTime = totalPlayTime;
        }
        
        String getName() {
            return name;
        }
        
        long getTotalPlayTime() {
            return totalPlayTime;
        }
    }
    
    private class Music {
        private int uniqueNumber;
        private int playTime;
        
        Music(int uniqueNumber, int playTime) {
            this.uniqueNumber = uniqueNumber;
            this.playTime = playTime;
        }
        
        int getUniqueNumber() {
            return uniqueNumber;
        }
        
        int getPlayTime() {
            return playTime;
        }
    }
    
}