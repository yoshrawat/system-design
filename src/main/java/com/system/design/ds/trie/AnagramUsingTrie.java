package com.system.design.ds.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramUsingTrie {

    static class Trie {
        Trie[] childs = new Trie[257];
        boolean isEnd;
        List<Integer> index;

        public Trie() {
            this.isEnd = false;
            index = new ArrayList<>();
            for (int i = 0; i < 256; i++) {
                childs[i] = null;
            }
        }
    }

    static Trie root;

    public static boolean search(char[] str, int current, int index) {
        Trie temp = root;
        for (int i = 0; i < str.length; i++) {
            if (null != temp && temp.isEnd != true && temp.childs[str[i] - 97] == null) {
                return false;
            }
            temp = temp.childs[str[i] - 97];
        }
        if(temp.isEnd){
            temp.index.add(index);
        }
        return true;
    }

    public static void main(String[] args) {
        AnagramUsingTrie anagramUsingTrie = new AnagramUsingTrie();
        anagramUsingTrie.root = new Trie();
        String wordArr[] = {"cat", "dog", "tac", "god", "act"};
        int i = 0;
        for (String str : wordArr) {
            add(str, i);
            i++;
        }
        printAnagramsUtil(root,wordArr);
    }

    private static void add(String str, int i) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        if (!search(ch, 0, i)) {
            add(ch,0,i,root);
        }
    }

    private static void add(char[] str, int j, int index, Trie temp) {
        for (int i = 0; i < str.length; i++) {
            if(null != temp &&  temp.childs[str[i] - '0'] == null){
                Trie child = new Trie();
                temp.childs[str[i]-97] = child;
            }
            temp = temp.childs[str[i]-97];
        }
        temp.isEnd = true;
        temp.index.add(index);
    }
    static void printAnagramsUtil(Trie root,
                                  String wordArr[])
    {
        if (root == null)
            return;

        // If a lead node is reached, print all anagrams
        // using the indexes stored in index linked list
        if (root.isEnd)
        {
            // traverse the list
            for(Integer pCrawl: root.index){
                System.out.println(wordArr[pCrawl]);
            }

        }
        for (int i = 0; i < 256; ++i)
            printAnagramsUtil(root.childs[i], wordArr);
    }
}
