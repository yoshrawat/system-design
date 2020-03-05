package com.system.skillzena;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int[][] clips= {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        System.out.println(videoStitching(clips,10));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(allSubstrings("cab",new char[]{'a','c'}));
    }
    public static int allSubstrings(String s, char[] alphabets) {
        int total = alphabets.length;
        Map<Character,Integer> map = new HashMap<>();
        int res = 0, start = 0;
        for(char c : alphabets) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i = 0; i < s.length(); i++) {
            if( map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > 0 ){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                total--;
            }
            while(total == 0) {
                if( map.containsKey(s.charAt(start)))
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                if( map.containsKey(s.charAt(start)) && map.get(s.charAt(start)) > 0 )
                    total++;
                start++;
            }
            res += i-start+1;
        }
        return res;
    }
    public static int videoStitching(int[][] clips, int T) {

        Arrays.sort( clips, (a, b) -> a[0] - b[0]);

        int count = 0;
        int curend = 0;
        int laststart = -1;

        for(int i = 0; i < clips.length; ) {
            if(clips[i][0] > curend) {
                return -1;
            }
            int maxend = curend;
            while(i < clips.length && clips[i][0] <= curend) { // while one clip's start is before or equal to current end
                maxend = Math.max(maxend, clips[i][1]); // find out the one with the max possible end
                i++;
                System.out.println("maxend::"+ maxend);
            }
            count++;
            System.out.println("count::"+ count);
            curend = maxend;
            if(curend >= T) {
                return count;
            }
        }
        return -1;
    }
}
