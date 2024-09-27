package telran.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class InterviewTasks {
    static public boolean hasSumTwo(int[] array, int sum) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(array).forEach(i -> set.add(i));
        Iterator<Integer> it = set.iterator();
        Integer cur = it.next();
        while (it.hasNext() && !isSum(set, cur, sum)) {
            cur = it.next();
        }
        return it.hasNext();
    }

    private static boolean isSum(HashSet<Integer> set, Integer cur, Integer sum) {
        return set.contains(sum - cur) && cur != sum - cur;
    }   
}
