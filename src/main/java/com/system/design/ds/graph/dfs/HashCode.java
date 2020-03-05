package com.system.design.ds.graph.dfs;

import java.net.Inet4Address;
import java.util.*;

public class HashCode {
    public static void main(String[] args) {
        int max = 3;
        int pizza = 4;
        int[] slices = {2,5,6,8};
        System.out.println(minSlicesDP(slices,4,max));
    }
    static int minSlicesDP(int slices[], int m, int V)
    {
        int table[] = new int[V + 1];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        table[0] = 0;
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= V; i++)
        {
            System.out.println("test");
            for (int j = 0; j < m; j++){
                if (slices[j] <= i) {
                    int sub_res = table[i - slices[j]];
                    Set<Integer> child = map.get(i - slices[j]);
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 <= table[i]){
                        table[i] = sub_res + 1;
                        if( !map.containsKey(i)) {
                            map.put(i, new LinkedHashSet<>());
                        }
                        map.get(i).clear();
                        if( child != null ){
                            map.get(i).addAll(child);
                        }
                        map.get(i).add(j);
                    }
                }
            }
            System.out.println("table["+i+"]::"+ table[i]);
            System.out.println("table["+i+"] list::"+ map.get(i));

        }
        System.out.println(map.getOrDefault(V, new LinkedHashSet<>()).toString());
        return table[V];

    }
}
