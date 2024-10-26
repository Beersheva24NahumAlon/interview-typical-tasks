package telran.interview;

import static telran.interview.InterviewTasks.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

public class InterviewTasksTest {
    private static final LocalDate DATE1 = LocalDate.of(2019, 12, 31);
	private static final LocalDate DATE2 = LocalDate.of(2021, 10, 30);
	private static final LocalDate DATE3 = LocalDate.of(2021, 12, 31);
	private static final LocalDate DATE4 = LocalDate.of(2024, 1, 1);
	private static final String ROLE1 = "Developer";
	private static final String ROLE2 = "Senior Developer";
	private static final String ROLE3 = "Manager";

    @Test
    void hasSumTwoTest() {
        int sum = 8;
        int[] arrToTrue = { 2, 1, 3, 4, 7 };
        int[] arrToTrue2 = { 1, 2, 4, 4, 10 };
        int[] arrToFalse = { 1, 2, 3, 4, 10 };
        assertTrue(hasSumTwo(arrToTrue, sum));
        assertTrue(hasSumTwo(arrToTrue2, sum));
        assertFalse(hasSumTwo(arrToFalse, sum));
    }

    @Test
    void getMaxWithNegativePresentationTest() {
        int[] array1 = { 200, 10, -10, 1, 2, 3, -3, -200 };
        int[] array2 = { -200, -200, 100, 10, 10 };
        int[] array3 = { -200, 10, -10, 1, 2, 3, -3, 200 };
        assertEquals(200, getMaxWithNegativePresentation(array1));
        assertEquals(-1, getMaxWithNegativePresentation(array2));
        assertEquals(200, getMaxWithNegativePresentation(array3));
    }

    @Test
    void assignRoleDatesTest() {
        List<DateRole> history = List.of(
                new DateRole(LocalDate.of(2020, 1, 1), ROLE1),
                new DateRole(LocalDate.of(2021, 1, 1), ROLE2),
                new DateRole(LocalDate.of(2022, 1, 1), ROLE3)
        );
        List<LocalDate> dates = List.of(
                DATE1,
                DATE2, 
                DATE3,
                DATE4
        );
        List<DateRole> expected = List.of(
                new DateRole(DATE1, null),
                new DateRole(DATE2, ROLE2),
                new DateRole(DATE3, ROLE2),
                new DateRole(DATE4, ROLE3)
        );
        assertIterableEquals(expected, assignRoleDates(history, dates));
    }

    @Test
    void isAnagrmaTest() {
        String word = "hello";
        assertTrue(isAnagram(word, "olleh"));
        assertTrue(isAnagram(word, "elloh"));
        assertTrue(isAnagram(word, "hleol"));
        assertFalse(isAnagram(word, word));
        assertFalse(isAnagram("electricity", new String("electricity")));
        assertFalse(isAnagram(word, "olle"));
        assertFalse(isAnagram(word, "ollhh"));
        assertFalse(isAnagram(word, "olehd"));
    }
}
