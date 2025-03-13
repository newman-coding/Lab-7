import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.*;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SortMethodsTest {

    @Test
    @Order(0)
    @DisplayName("Test selection sort correctness") 
    public void testSelection(){
        int[] t1 = {5, 2, 1, 7, 9};
        int[] r1 = {1, 2, 5, 7, 9};
        int[] t2 = {7, 6, -5, 4, -8, 2};
        int[] r2 = {-8, -5, 2, 4, 6, 7};
        int[] t3 = {3, 33, 333};
        int[] r3 = {3, 33, 333};
        int[] t4 = {8, 7, 6, 5};
        int[] r4 = {5, 6, 7, 8};
        int[] testOne = {5};
        int[] rOne = {5};

        // action
        SortMethods.selection(t1);
        // assertion
        assertThat(check(r1, t1)).isTrue();

        // action
        SortMethods.selection(t2);
        // assertion
        assertThat(check(r2, t2)).isTrue();

        // action
        SortMethods.selection(t3);
        // assertion
        assertThat(check(r3, t3)).isTrue();

        // action
        SortMethods.selection(t4);
        // assertion
        assertThat(check(r4, t4)).isTrue();

        // action
        SortMethods.selection(testOne);
        // assertion
        assertThat(check(rOne, testOne)).isTrue();

    }
    
    @Test
    @Order(1)
    @DisplayName("Test insertion sort correctness") 
    public void testInsertion(){
        int[] t1 = {5, 2, 1, 7, 9};
        int[] r1 = {1, 2, 5, 7, 9};
        int[] t2 = {7, 6, -5, 4, -8, 2};
        int[] r2 = {-8, -5, 2, 4, 6, 7};
        int[] t3 = {3, 33, 333};
        int[] r3 = {3, 33, 333};
        int[] t4 = {8, 7, 6, 5};
        int[] r4 = {5, 6, 7, 8};
        int[] testOne = {5};
        int[] rOne = {5};
        
        // action
        SortMethods.insertion(t1);
        // assertion
        assertThat(check(r1, t1)).isTrue();

        // action
        SortMethods.insertion(t2);
        // assertion
        assertThat(check(r2, t2)).isTrue();

        // action
        SortMethods.insertion(t3);
        // assertion
        assertThat(check(r3, t3)).isTrue();

        // action
        SortMethods.insertion(t4);
        // assertion
        assertThat(check(r4, t4)).isTrue();

        // action
        SortMethods.insertion(testOne);
        // assertion
        assertThat(check(rOne, testOne)).isTrue();

    }

    @Test
    @Order(1)
    @DisplayName("Test alphabetize correctness") 
    public void testAlphabetize(){
        String[] t1 = {"four", "score", "and", "seven", "years", "ago"};
        String[] r1 = {"ago", "and", "four", "score", "seven", "years"};
        String[] t2 = {"aligators", "bears", "zebras", "cats"};
        String[] r2 = {"aligators", "bears", "cats", "zebras"};
        String[] t3 = {"c", "b", "a"};
        String[] r3 = {"a", "b", "c"};
        String[] t4 = {"hello", "hello"};
        String[] r4 =  {"hello", "hello"};
        String[] testOne = {"goodbye"};
        String[] rOne = {"goodbye"};
        
        // action
        ArrayList<String> test = ListMethods.arrayToList(t1);
        SortMethods.alphabetize(test);
        // assertion
        assertThat(check(r1, test)).isTrue();

        // action
        test = ListMethods.arrayToList(t2);
        SortMethods.alphabetize(test);
        // assertion
        assertThat(check(r2, test)).isTrue();

        // action
        test = ListMethods.arrayToList(t3);
        SortMethods.alphabetize(test);
        // assertion
        assertThat(check(r3, test)).isTrue();

        // action
        test = ListMethods.arrayToList(t4);
        SortMethods.alphabetize(test);
        // assertion
        assertThat(check(r4, test)).isTrue();

        // action
        test = ListMethods.arrayToList(testOne);
        SortMethods.alphabetize(test);
        // assertion
        assertThat(check(rOne, test)).isTrue();

    }
    
    public static boolean check(int[] expected, int[] actual) {
    if(actual == null) {
      System.out.format("Your \"actual\" array is null. Have you implemented the method you are testing?\n\n");
      return false;
    }
    if (expected.length != actual.length) {
      System.out.format("Array length did not match expected length:\n"
                + "      Expected: %d\n"
                + "      Got: %d\n",
              expected.length, actual.length);
      return false;
    }
    for (int k = 0; k < expected.length; k++) {
      if (expected[k] != actual[k]) {
        System.out.format("Array contents different at index %d:\n"
                    + "    Expected: %d\n"
                    + "    Got: %d\n",
                    k, expected[k], actual[k]);
        return false;
      }
    }
    return true;
  }

  public static boolean check(String[] expected, String[] actual) {
    if(actual == null) {
      System.out.format("Your \"actual\" array is null. Have you implemented the method you are testing?\n\n");
      return false;
    }
    if (expected.length != actual.length) {
      System.out.format("Array size did not match expected length:\n"
                + "      Expected: %d\n"
                + "      Got: %d\n",
                expected.length, actual.length);
      return false;
    }
    for (int k = 0; k < expected.length; k++) {
      if (!expected[k].equals(actual[k])) {
        System.out.format("Array contents different at index %d:\n"
                    + "    Expected: " + expected[k] + "\n"
                    + "    Got: " + actual[k] + "\n",
                    k);
        return false;
      }
    }
    return true;
  }

  public static boolean check(String[] expected, ArrayList<String> actual) {
    if(actual == null) {
      System.out.format("Your \"actual\" list is null. Have you implemented the method you are testing?\n\n");
      return false;
    }
    if (expected.length != actual.size()) {
      System.out.format("List size did not match expected length:\n"
                + "      Expected: %d\n"
                + "      Got: %d\n",
                expected.length, actual.size());
      return false;
    }
    for (int k = 0; k < expected.length; k++) {
      if (!expected[k].equals(actual.get(k))) {
        System.out.format("List contents different at index %d:\n"
                    + "    Expected: " + expected[k] + "\n"
                    + "    Got: " + actual.get(k) + "\n",
                    k);
        return false;
      }
    }
    return true;
  }

  public static boolean check(int[] expected, ArrayList<Integer> actual) {
    if(actual == null) {
      System.out.format("Your \"actual\" list is null. Have you implemented the method you are testing?\n\n");
      return false;
    }
    if (expected.length != actual.size()) {
      System.out.format("List size did not match expected length:\n"
                + "      Expected: %d\n"
                + "      Got: %d\n",
                expected.length, actual.size());
      return false;
    }
    for (int k = 0; k < expected.length; k++) {
      if (expected[k] != actual.get(k)) {
        System.out.format("List contents different at index %d:\n"
                    + "    Expected: %d\n"
                    + "    Got: %d\n",
                    k, expected[k], actual.get(k));
        return false;
      }
    }
    return true;
  }
}
