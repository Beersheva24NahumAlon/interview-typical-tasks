package telran.interview;

import java.util.*;

public class AutoCompletion {
    private TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean addWord(String word) {
        return set.add(word);
    }

    public String[] getVariants(String prefix) {
        String lowerCasePrexif = prefix.toLowerCase();
        return set.subSet(lowerCasePrexif, lowerCasePrexif + Character.MAX_VALUE).toArray(String[]::new);
    }
}
