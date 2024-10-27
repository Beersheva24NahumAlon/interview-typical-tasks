package telran.interview;

import java.util.*;

public class AutoCompletion {
    // We use data structure TreeSet because complexity of adding and getting of it is O(logN)
    // We use constructor with comparator to switch off case sensitive in string comparing
    private TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean addWord(String word) {
        // adds new word into auto-completion variants
		// returns true if added, false otherwise (if a given word already exists)
        return set.add(word);
    }

    public String[] getVariants(String prefix) {
        // returns all words beginning with a given prefix
		// complexity of finding the variants is O[logN]
        String lowerCasePrexif = prefix.toLowerCase();
        return set.subSet(lowerCasePrexif, nextPrefix(lowerCasePrexif)).toArray(String[]::new);
    }

    private String nextPrefix(String prefix) {
        // Method return string with last character greater than given by 1 (in Unicode table)
        String res = "";
        if (prefix.length() > 0) {
            int lastChar = prefix.codePointAt(prefix.length() - 1);
            res = String.format("%s%c", prefix.substring(0, prefix.length() - 1), lastChar + 1);
        }
        return res;
    }

}
