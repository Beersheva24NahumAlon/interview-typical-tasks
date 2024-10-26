package telran.interview;

import java.util.*;
import java.util.function.Function;
import java.time.LocalDate;
import java.util.stream.*;

record DateRole(LocalDate date,String role) {
}

public class InterviewTasks {
    static public boolean hasSumTwo(int[] array, int sum) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while (i < array.length && !set.contains(sum - array[i])) {
            set.add(array[i++]);
        }
        return i != array.length;
    }

    public static int getMaxWithNegativePresentation(int[] array) {
        int res = -1;
        int elementAbs = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int element : array) {
            elementAbs = Math.abs(element);
            if (set.contains(-element)) {
                res = elementAbs > res ? elementAbs : res;
            } else {
                set.add(element);
            }
        }
        return res;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {
        TreeMap<LocalDate, String> map = new TreeMap<>();
        List<DateRole> res = new ArrayList<DateRole>();
        rolesHistory.stream().forEach(dr -> map.put(dr.date(), dr.role()));
        dates.stream().forEach(d -> res.add(new DateRole(d, map.floorKey(d) != null ? map.get(map.floorKey(d)) : null)));
        return res;
    }

    public static boolean isAnagram(String word, String anagram) {
        boolean res = false;
        if (word.length() == anagram.length() && !word.equals(anagram)) {
            Map<Integer, Long> map = word.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            res = anagram.chars().allMatch(c -> map.merge(c, -1l, (o, n) -> o - 1) > -1);
        } 
        return res;
    }
}
