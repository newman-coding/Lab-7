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
public class SearchMethodsTest {

    @Test
    @Order(0)
    @DisplayName("Test String[] sequentialSearch correctness") 
    public void testStrArrSequentialSearch(){
        int[] t1 = {5, 2, 1, 7, 9};
        int[] t2 = {7, 6, -5, 4, -8, 2};
        int[] t3 = {3, 33, 333};
        int[] testOne = {5};
        // action
        ArrayList<Integer> test = ListMethods.arrayToList(t1);
        // assertion
        assertThat(check(t1, test)).isTrue();

        // action
        test = ListMethods.arrayToList(t2);
        // assertion
        assertThat(check(t2, test)).isTrue();

        // action
        test = ListMethods.arrayToList(t3);
        // assertion
        assertThat(check(t3, test)).isTrue();

        // action
        test = ListMethods.arrayToList(testOne);
        // assertion
        assertThat(check(testOne, test)).isTrue();

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
        System.out.format("Array contents different at index %d:\n"
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
        System.out.format("Array contents different at index %d:\n"
                    + "    Expected: %d\n"
                    + "    Got: %d\n",
                    k, expected[k], actual.get(k));
        return false;
      }
    }
    return true;
  }
}
