package telran.interview;

import static telran.interview.InterviewTasks.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InterviewTasksTest {

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
}
