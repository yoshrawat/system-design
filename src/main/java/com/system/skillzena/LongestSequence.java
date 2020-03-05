package com.system.skillzena;
import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class LongestSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            int len = sc.nextInt();
            String str = sc.next();
            //System.out.println(str);
           sequence(str, len);

        }
    }

    private static void sequence(String str, int n) {
        int count = 0;
        char res = str.charAt(0);
        int cur_count = 1;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {

            // If current character matches with next
            if (i < n - 1 && str.charAt(i) == str.charAt(i + 1))
                cur_count++;
            else
            {
                if (cur_count >= count)
                {
                    count = cur_count;
                    res = str.charAt(i);
                    map.put(res,cur_count);

                }
                cur_count = 1;
            }
        }
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        String str1="";
        List<Character> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : sorted.entrySet()) {
            if( max == Integer.MIN_VALUE){
                max = entry.getValue();
                //str1 = entry.getKey()+"";
                list.add(entry.getKey());
            }else if ( max == entry.getValue()){
                //str1 += entry.getKey()+"";
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        for( Character ch : list){
            str1 +=ch+"";
        }
        System.out.println(max+ " "+ str1);
    }
}
