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
        // returns maximal positive value for which exists negative one with the same abs value
        // if no pair of positive and negative values with the same abs value the method returns -1
        // complexity O[N] only one pass over the elements

        // We define vaiable for return with value -1, if algorithm doesn't find any suitable value 
        // the method will return this value
        int res = -1;
        // We define variable for absolute value of element of array
        int elementAbs = -1;
        // I use data structure HashSet, because it has complexity O(1) for adding and getting data 
        HashSet<Integer> set = new HashSet<>();
        // We pass over all elements of array (that's why I use loop "for")
        for (int element : array) {
            elementAbs = Math.abs(element);
            // We check if in HashSet we have element with same absolute value, 
            // but with another sign
            if (set.contains(-element)) {
                // We find maximum of suitable elements
                res = elementAbs > res ? elementAbs : res;
            } else {
                set.add(element);
            }
        }
        return res;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {
        // rolesHistory is the list containg dates and roles assigned to the employees at the appropriate dates
        // for example, date => 2019-01-01, role => Developer means that some employee (no matter who) was taken
        // role Developer at 2019-01-01
        // create List<DateRole> with roles matching with the given dates and use most effective data structure

        // I use data structure TreeMap in this solution because we have to use some sorted data structure with 
        // effective searching (complexity O(logN))
        TreeMap<LocalDate, String> map = new TreeMap<>();
        // To return result I use ArrayList (I think for our task it's not metter wich list we use)
        List<DateRole> res = new ArrayList<DateRole>();
        // We fill our map
        rolesHistory.stream().forEach(dr -> map.put(dr.date(), dr.role()));
        // For every date in list we are finding floorKey in map (first key less then date in list) 
        // and get value (role) by key (date)
        dates.stream().forEach(d -> res.add(new DateRole(d, map.floorKey(d) != null ? map.get(map.floorKey(d)) : null)));
        return res;
    }

    public static boolean isAnagram(String word, String anagram) {
        // returns true if "anagram" string contains all
	    // letters from "word" in another order (case sensitive)
	    // O[N] (sorting is disallowed

        // We define vaiable for return with value "false"
        boolean res = false;
        // We check if word and anagram have different lenght or they are the same words
        // only if this contition is met we will continue 
        if (word.length() == anagram.length() && !word.equals(anagram)) {
            // I use data structure Map to link letter (key) and count of letters in the word (value)
            // We are filling our map using method collect  
            Map<Integer, Long> map = word.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            // For each letter in anagram we check if it's in our map using method merge of map
            // This method addes element(key, value) in map, and if key is exist in map apply finction 
            // (lambda expession) in third patameter 
            res = anagram.chars().allMatch(c -> map.merge(c, -1l, (o, n) -> o - 1) > -1);
        } 
        return res;
    }
}
