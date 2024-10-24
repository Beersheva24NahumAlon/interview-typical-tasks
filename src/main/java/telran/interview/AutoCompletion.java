package telran.interview;

import java.util.*;

public class AutoCompletion {
    private ArrayList<String> array = new ArrayList<>();

    public boolean addWord(String word) {
        boolean res = false;
        int index = binarySearch(array, word);
        if (index < 0) {
            array.add(-index - 1, word);
            res = true;
        }
        return res;
    }

    private int binarySearch(ArrayList<String> array, String word) {
        int start = 0;
        int finish = array.size() - 1;
        int middle = (start + finish) / 2;
        while (start <= finish) {
            if (word.toLowerCase().compareTo(array.get(middle).toLowerCase()) > 0) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
            middle = (start + finish) / 2;
        }
        return start <= finish ? start : -start - 1;
    }

    private int getIndex(ArrayList<String> array, String prefix, boolean isFirst) {
        int start = 0;
        int finish = array.size() - 1;
        int middle = (start + finish) / 2;
        while (start <= finish) {
            int compareResult = prefix.toLowerCase()
                    .compareTo(array.get(middle).substring(0, prefix.length()).toLowerCase());
            if ((compareResult > 0 && isFirst) || (compareResult >= 0 && !isFirst)) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
            middle = (start + finish) / 2;
        }
        return isFirst ? start : middle;
    }

    public String[] getVariants(String prefix) {
        int firstIndex = getIndex(array, prefix, true);
        int lastIndex = getIndex(array, prefix, false);
        return array.subList(firstIndex, lastIndex + 1).toArray(String[]::new);
    }

}
