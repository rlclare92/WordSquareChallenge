package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordSquareSetup {
    HashMap<String, List<String>> map = new HashMap<>();

    public List<List<String>> wordSquareSetup(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        createPrefixMap(words);
        for(int i = 0; i < words.size(); i++) {
            LinkedList<String> list = new LinkedList<>();
            list.add(words.get(i));
            backTrack(1, list, result, words.get(i).length());
        }
        System.out.println(result);
        return result;
    }

    public void backTrack(int step, LinkedList<String> list, List<List<String>> result, int n) {
        if(list.size() == n){
            result.add(new ArrayList<>(list));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(String word : list) {
            sb.append(word.charAt(step));
        }
        String prefix = sb.toString();
        List<String> wordList = map.getOrDefault(prefix, new ArrayList<>());
        for(String word : wordList) {
            list.add(word);
            backTrack(step + 1, list, result, n);
            list.removeLast();
        }
    }

    private void createPrefixMap(List<String> words) {
        for(String word : words){
            for(int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                map.putIfAbsent(prefix, new ArrayList<>());
                List<String> list = map.get(prefix);
                list.add(word);
            }
        }
    };
}
