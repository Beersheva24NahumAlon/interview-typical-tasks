package telran.interview;

import java.util.*;

public class AutoCompletion {
    private TreeMap<String, String> map = new TreeMap<>();
    // TODO

    public boolean addWord(String word) {
        // TODO
        // adds new word into auto-completion variants
        // returns true if added, false otherwise (if a given word already exists)
        map.put(word.toLowerCase(), word);
        return true;
    }

    public String[] getVariants(String prefix) {

        //String str1 = map.keySet().stream().filter(s -> s.startsWith(prefix)).;
        //String str2 = map.lowerKey(prefix);

        return null;
        //return map.headMap(prefix).values().stream().toArray(String[]::new);
        // TODO
        // returns all words beginning with a given prefix
        // Complexity of finding the variants is O[logN]
    }

    
}
