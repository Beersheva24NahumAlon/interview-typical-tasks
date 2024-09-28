package telran.interview;

import java.util.*;

public class InterviewTasks {
    static public boolean hasSumTwo(int[] array, int sum) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while (i < array.length && !set.contains(sum - array[i])) {
            set.add(array[i++]);
        }
        return i != array.length;
    }  
}
