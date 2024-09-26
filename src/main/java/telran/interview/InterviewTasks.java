package telran.interview;

import java.util.Arrays;
import java.util.HashMap;

public class InterviewTasks {
    static public boolean hasSumTwo(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(array).forEach(i -> map.put(i, sum - i));
        Integer[] keys = map.keySet().toArray(Integer[]::new);
        int i = 0;
        while (i < keys.length && !isSum(keys[i], map)) {
            i++;
        }
        return i != keys.length;
    }

    private static boolean isSum(Integer key, HashMap<Integer, Integer> map) {
        Integer value = map.get(key);
        return key == map.get(value) && value != key;
    }
}
