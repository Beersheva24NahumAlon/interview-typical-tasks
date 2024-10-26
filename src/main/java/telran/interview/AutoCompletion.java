package telran.interview;

import java.util.*;

public class AutoCompletion {
    private TreeMap<String, ArrayList<String>> map = new TreeMap<>();

    public boolean addWord(String word) {
        boolean res = false;
        String wordLowerCase = word.toLowerCase();
        ArrayList<String> list = map.getOrDefault(wordLowerCase, new ArrayList<>());
        if (!list.contains(word)) {
            res = true;
            list.add(word);
            map.put(wordLowerCase, list);
        }
        return res;
    }

    public String[] getVariants(String prefix) {
        String lowerCasePrexif = prefix.toLowerCase();
        return map.subMap(lowerCasePrexif, nextPrefix(lowerCasePrexif))
                .entrySet().stream().flatMap(e -> e.getValue().stream()).toArray(String[]::new);
    }

    private String nextPrefix(String prefix) {
        String res = "";
        if (prefix.length() > 0) {
            int lastChar = prefix.codePointAt(prefix.length() - 1);
            res = String.format("%s%c", prefix.substring(0, prefix.length() - 1), lastChar + 1);
        }
        return res;
    }

}
