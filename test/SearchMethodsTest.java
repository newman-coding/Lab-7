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
    int[] longone = {429,954,317,30,451,81,656,990,623,766,3,733,991,340,891,339,817,
      744,321,633,242,928,480,980,54,519,161,396,643,521,78,709,559,436,734,349,372,587,
      727,392,577,109,965,206,827,361,284,637,245,99,438,870,578,717,201,91,669,333,510,
      535,323,296,141,851,757,713,751,262,65,263,698,45,538,527,551,506,922,131,500,441,
      380,166,488,740,529,353,46,942,315,692,923,729,126,62,884,892,183,232,22,163};

    @Test
    @Order(0)
    @DisplayName("Test String[] sequentialSearch correctness") 
    public void testSequentialArray(){
        String[] t1 = {"behemoth", "harpy", "werewolf", "zombie", "yeti", "basilisk", "vampire"};
        String[] t2 = {"fairy", "nymph", "dryad", "heloi", "vila", "siren"};
        String[] t3 = {"fairy tale", "fairy tale"};
        // action
        int index = SearchMethods.sequentialSearch(t1, "harpy");
        // assertion
        assertThat(index == 1).isTrue();

        // action
        index = SearchMethods.sequentialSearch(t1, "zombie");
        // assertion
        assertThat(index == 3).isTrue();

        // action
        index = SearchMethods.sequentialSearch(t1, "spider");
        // assertion
        assertThat(index == -1).isTrue();

        // action
        index = SearchMethods.sequentialSearch(t2, "siren");
        // assertion
        assertThat(index == 5).isTrue();

        // action
        index = SearchMethods.sequentialSearch(t2, "fairy");
        // assertion
        assertThat(index == 0).isTrue();

        // action
        index = SearchMethods.sequentialSearch(t3, "fairy tale");
        // assertion
        assertThat(index == 0).isTrue();

    }
    @Test
    @Order(1)
    @DisplayName("Test ArrayList<Integer> sequentialSearch correctness") 
    public void testSequentialList(){
        int[] t1 = {5, 2, 1, 7, 9};
        int[] t2 = {7, 6, -5, 4, -8, 2, 6};
        int[] testOne = {5};
        // action
        ArrayList<Integer> test = ListMethods.arrayToList(t1);
        int index = SearchMethods.sequentialSearch(test, 1);
        // assertion
        assertThat(index == 2).isTrue();

        // action
        index = SearchMethods.sequentialSearch(test, 5);
        // assertion
        assertThat(index == 0).isTrue();

        // action
        index = SearchMethods.sequentialSearch(test, 3);
        // assertion
        assertThat(index == -1).isTrue();

        // action
        test = ListMethods.arrayToList(t2);
        index = SearchMethods.sequentialSearch(test, 1);
        // assertion
        assertThat(index == -1).isTrue();

        // action
        index = SearchMethods.sequentialSearch(test, 6);
        // assertion
        assertThat(index == 1).isTrue();

        // action
        index = SearchMethods.sequentialSearch(test, -5);
        // assertion
        assertThat(index == 2).isTrue();

        // action
        test = ListMethods.arrayToList(testOne);
        index = SearchMethods.sequentialSearch(test, 5);
        // assertion
        assertThat(index == 0).isTrue();

    }

    @Test
    @Order(2)
    @DisplayName("Test binary search correctness") 
    public void testBinary(){
        int[] t1 = {9,11,22,25,26,34,48,69,71,77,78,79,81,82,91};
        int[] t2 = {5,15,22,34,46,50,62,78,82,99};
        int[] testOne = {5};
        // action
        int index = SearchMethods.binarySearch(t1, 79);
        // assertion
        assertThat(index == 11).isTrue();

        // action
        index = SearchMethods.binarySearch(t1, 11);
        // assertion
        assertThat(index == 1).isTrue();

        // action
        index = SearchMethods.binarySearch(t1, 23);
        // assertion
        assertThat(index == -1).isTrue();

        // action
        index = SearchMethods.binarySearch(t1, 91);
        // assertion
        assertThat(index == 14).isTrue();

        // action
        index = SearchMethods.binarySearch(t2, 91);
        // assertion
        assertThat(index == -1).isTrue();

        // action
        index = SearchMethods.binarySearch(t2, 99);
        // assertion
        assertThat(index == 9).isTrue();

        // action
        index = SearchMethods.binarySearch(t2, 50);
        // assertion
        assertThat(index == 5).isTrue();

        // action
        index = SearchMethods.binarySearch(t2, 22);
        // assertion
        assertThat(index == 2).isTrue();

        // action
        index = SearchMethods.binarySearch(t2, 5);
        // assertion
        assertThat(index == 0).isTrue();

        // action
        index = SearchMethods.binarySearch(testOne, 5);
        // assertion
        assertThat(index == 0).isTrue();

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
