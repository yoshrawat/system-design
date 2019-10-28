package com.system.design.ds.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrintAnagramTogether {
    public static void main(String[] args) {
        String wordArr[] = { "cat", "dog", "tac", "god", "act" };
        int size = wordArr.length;
        printAnagramsTogether(wordArr, size);
    }

    private static void printAnagramsTogether(String[] wordArr, int size) {
        int[] indexArray = new int[size];
        HashMap<String,List<String>> hashMap = new HashMap<>();
        String[] tempArray = new String[size];
        for( int i=0;i<size;i++){
            char[] ch = wordArr[i].toCharArray();
            Arrays.sort(ch);
            List<String> arrayList;
            if(hashMap.containsKey(String.valueOf(ch))){
                arrayList = hashMap.get(String.valueOf(ch));
                arrayList.add(wordArr[i]);
                hashMap.put(String.valueOf(ch),arrayList);
            }else{
                arrayList = new ArrayList<>();
                arrayList.add(wordArr[i]);
                hashMap.put(String.valueOf(ch),arrayList);
            }
        }
        hashMap.entrySet().stream().forEach(s -> System.out.println(s.getValue()));
    }
}
