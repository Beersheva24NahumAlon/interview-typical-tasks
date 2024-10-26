package telran.interview;

import java.util.*;

public class AutoCompletion {
    private TreeSet<String> set = new TreeSet<>((s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase()));

    public boolean addWord(String word) {
        boolean res = false;
        if (!set.contains(word)) {
            res = true;
            set.add(word);
        }
        return res;
    }

    public String[] getVariants(String prefix) {
        String lowerCasePrexif = prefix.toLowerCase();
        return set.subSet(lowerCasePrexif, nextPrefix(lowerCasePrexif)).toArray(String[]::new);
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
