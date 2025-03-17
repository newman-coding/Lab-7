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
import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ListMethodsTest {

  @Test
  @Order(0)
  @DisplayName("Test intArrayToList correctness")
  public void testIntArrayToList() {
    int[] t1 = { 5, 2, 1, 7, 9 };
    int[] t2 = { 7, 6, -5, 4, -8, 2 };
    int[] t3 = { 3, 33, 333 };
    int[] testOne = { 5 };
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

  @Test
  @Order(1)
  @DisplayName("Test string arrayToList correctness")
  public void testStrArrayToList() {
    String[] t1 = { "Come on", "Eileen", "Poor old", "Johnny Ray" };
    String[] t2 = { "Well", "you can tell", "by the way", "I use", "my walk" };
    String[] t3 = { "And if I only could", "I'd make a deal with God" };
    // action
    ArrayList<String> test = ListMethods.arrayToList(t1);
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

  }

  @Test
  @Order(2)
  @DisplayName("Test reverse correctness")
  public void testReverse() {
    int[] t1 = { 0, 1, 1, 2, 3, 5, 8 };
    int[] r1 = { 8, 5, 3, 2, 1, 1, 0 };
    int[] t2 = { 3, 6, 9, 12 };
    int[] r2 = { 12, 9, 6, 3 };
    int[] t3 = { 5 };
    int[] r3 = { 5 };

    // action
    ArrayList<Integer> list1 = ListMethods.arrayToList(t1);
    ArrayList<Integer> test = ListMethods.reverse(list1);
    // assertion
    assertThat(check(r1, test)).isTrue();

    // action
    ArrayList<Integer> list2 = ListMethods.arrayToList(t2);
    test = ListMethods.reverse(list2);
    // assertion
    assertThat(check(r2, test)).isTrue();

    // action
    ArrayList<Integer> list3 = ListMethods.arrayToList(t3);
    test = ListMethods.reverse(list3);
    // assertion
    assertThat(check(r3, test)).isTrue();

  }

  @Test
  @Order(3)
  @DisplayName("Test printEvenIndex correctness")
  public void testPrintEvenIndex() {
    String[] t1 = { "To be", "or not", "to be", "that is", "the question", "Whether", "tis nobler", "in the mind" };
    String[] t2 = { "to suffer", "the slings", "and arrows", "of outrageous fortune" };
    String[] t3 = { "Or to take arms", "against", "a sea", "of troubles" };
    String[] t4 = { "And by opposing end them" };
    String r1 = "To be\nto be\nthe question\ntis nobler\n";
    String r2 = "to suffer\nand arrows\n";
    String r3 = "Or to take arms\na sea\n";
    String r4 = "And by opposing end them\n";

    // OUTPUT BINDING
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // action
    ArrayList<String> list1 = ListMethods.arrayToList(t1);
    ListMethods.printEvenIndex(list1);
    // get print, newline agnostic
    String result = bos.toString().replaceAll("\r\n|\r", "\n");
    // assertion
    assertThat(result).isEqualTo(r1);
    // clear output stream
    bos.reset();

    // action
    ArrayList<String> list2 = ListMethods.arrayToList(t2);
    ListMethods.printEvenIndex(list2);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r", "\n");
    // assertion
    assertThat(result).isEqualTo(r2);
    // clear output stream
    bos.reset();

    // action
    ArrayList<String> list3 = ListMethods.arrayToList(t3);
    ListMethods.printEvenIndex(list3);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r", "\n");
    // assertion
    assertThat(result).isEqualTo(r3);
    // clear output stream
    bos.reset();

    // action
    ArrayList<String> list4 = ListMethods.arrayToList(t4);
    ListMethods.printEvenIndex(list4);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r", "\n");
    // assertion
    assertThat(result).isEqualTo(r4);
    // clear output stream
    bos.reset();

    // UNDO output binding in System
    System.setOut(originalOut);

  }

  @Test
  @Order(4)
  @DisplayName("Test printEvenElements correctness")
  public void testPrintEvenElements() {
    int[] t1 = { -1, 1, 0, 2, 4, 7, 8 };
    String r1 = "0\n2\n4\n8\n";
    int[] t2 = { 6, 21 };
    String r2 = "6\n";
    int[] t3 = { 2, -2, 2 };
    String r3 = "2\n-2\n2\n";
    int[] t4 = { 1, 3, 5, 7, 9 };

    // OUTPUT BINDING
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // test one
    ArrayList<Integer> list1 = ListMethods.arrayToList(t1);
    ListMethods.printEvenElements(list1);
    // get print, newline agnostic
    String result = bos.toString().replaceAll("\r\n|\r", "\n");
    // assertion
    assertThat(result).isEqualTo(r1);
    // clear output stream
    bos.reset();

    // test two
    ArrayList<Integer> list2 = ListMethods.arrayToList(t2);
    ListMethods.printEvenElements(list2);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r", "\n");
    // assertion
    assertThat(result).isEqualTo(r2);
    // clear output stream
    bos.reset();

    // test three
    ArrayList<Integer> list3 = ListMethods.arrayToList(t3);
    ListMethods.printEvenElements(list3);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r", "\n");
    // assertion
    assertThat(result).isEqualTo(r3);
    // clear output stream
    bos.reset();

    // test four
    ArrayList<Integer> list4 = ListMethods.arrayToList(t4);
    ListMethods.printEvenElements(list4);
    // get print (should be empty)
    result = bos.toString();
    // assertion
    assertThat(result).isEmpty();
    // clear output stream
    bos.reset();

    // UNDO output binding in System
    System.setOut(originalOut);

  }

  @Test
  @Order(5)
  @DisplayName("Test standardDeviation correctness")
  public void testStandardDeviation() {
    double[] t1 = {-1, -0.5, 0, 0.5, 1};
    double r1 = Math.sqrt(0.5);
    double[] t2 = {6, 8};
    double r2 = 1.0;
    double[] t3 = {-2.2, -2.2, -2.2};
    double r3 = 0.0;
    double[] t4 = {1, 3, 5, 7, 9};
    double r4 = Math.sqrt(8);

    // test 1
    ArrayList<Double> list1 = new ArrayList<Double>();
    for (double d : t1)
      list1.add(d);
    double test = ListMethods.standardDeviation(list1);
    // assertion
    assertThat(test).isWithin(1.0e-10).of(r1);

    // test 2
    ArrayList<Double> list2 = new ArrayList<Double>();
    for (double d : t2)
      list2.add(d);
    test = ListMethods.standardDeviation(list2);
    // assertion
    assertThat(test).isWithin(1.0e-10).of(r2);

    // test 2
    ArrayList<Double> list3 = new ArrayList<Double>();
    for (double d : t3)
      list3.add(d);
    test = ListMethods.standardDeviation(list3);
    // assertion
    assertThat(test).isWithin(1.0e-10).of(r3);

    // test 2
    ArrayList<Double> list4 = new ArrayList<Double>();
    for (double d : t4)
      list4.add(d);
    test = ListMethods.standardDeviation(list4);
    // assertion
    assertThat(test).isWithin(1.0e-10).of(r4);

  }

  @Test
  @Order(6)
  @DisplayName("Test sumNegatives correctness")
  public void testSumNegatives() {
    int[] t1 = { -1, 1, 0, 2, -4, 6, -8 };
    int r1 = -13;
    int[] t2 = { 6, -21 };
    int r2 = -21;
    int[] t3 = { -2, -2, -2 };
    int r3 = -6;
    int[] t4 = { -1, 3, -5, -7, -9 };
    int r4 = -22;

    // test 1
    ArrayList<Integer> list1 = ListMethods.arrayToList(t1);
    int test = ListMethods.sumNegatives(list1);
    // assertion
    assertThat(test == r1).isTrue();

    // test 2
    ArrayList<Integer> list2 = ListMethods.arrayToList(t2);
    test = ListMethods.sumNegatives(list2);
    // assertion
    assertThat(test == r2).isTrue();

    // test 2
    ArrayList<Integer> list3 = ListMethods.arrayToList(t3);
    test = ListMethods.sumNegatives(list3);
    // assertion
    assertThat(test == r3).isTrue();

    // test 2
    ArrayList<Integer> list4 = ListMethods.arrayToList(t4);
    test = ListMethods.sumNegatives(list4);
    // assertion
    assertThat(test == r4).isTrue();

  }
  @Test
  @Order(7)
  @DisplayName("Test hasDuplicates correctness")
  public void testHasDuplicates() {
    String[] t1 = {"eggs", "onions", "garlic", "cheese", "peppers", "eggs", "tomatoes", "garlic"};
    String[] t2 = {"apples", "bananas", "kiwis", "plums"};
    String[] t3 = {"eggs", "butter", "butter", "milk", "bacon"};
    String[] t4 = {"brioche", "sourdough", "tortillas", "rye", "multigrain"};

    // action
    ArrayList<String> list = ListMethods.arrayToList(t1);
    boolean test = ListMethods.hasDuplicates(list);
    // assertion
    assertThat(test).isTrue();

    // action
    list = ListMethods.arrayToList(t2);
    test = ListMethods.hasDuplicates(list);
    // assertion
    assertThat(test).isFalse();

    // action
    list = ListMethods.arrayToList(t3);
    test = ListMethods.hasDuplicates(list);
    // assertion
    assertThat(test).isTrue();

    // action
    list = ListMethods.arrayToList(t4);
    test = ListMethods.hasDuplicates(list);
    // assertion
    assertThat(test).isFalse();
  }

  @Test
  @Order(7)
  @DisplayName("Test pairUp correctness")
  public void testPairUp() {
    String[] t1 = {"roses", "thorns", "apples", "pears", "snakes", "ladders"};
    String[] r1 = {"roses and thorns", "apples and pears", "snakes and ladders"};
    String[] t2 = {"one", "two", "three", "four", "five"};
    String[] r2 = {"one and two", "three and four", "five"};
    String[] t3 = {"ups", "downs"};
    String[] r3 = {"ups and downs"};
    String[] t4 = {"left", "left", "left", "left", "multigrain"};
    String[] r4 = {"left and left", "left and left", "multigrain"};

    // action
    ArrayList<String> list = ListMethods.arrayToList(t1);
    ArrayList<String> test = ListMethods.pairUp(list);
    // assertion
    assertThat(check(r1, test)).isTrue();

    // action
    list = ListMethods.arrayToList(t2);
    test = ListMethods.pairUp(list);
    // assertion
    assertThat(check(r2, test)).isTrue();

    // action
    list = ListMethods.arrayToList(t3);
    test = ListMethods.pairUp(list);
    // assertion
    assertThat(check(r3, test)).isTrue();

    // action
    list = ListMethods.arrayToList(t4);
    test = ListMethods.pairUp(list);
    // assertion
    assertThat(check(r4, test)).isTrue();
  }

  @Test
  @Order(8)
  @DisplayName("Test shiftRightOne correctness")
  public void testShiftRightOne() {
    int[] t1 = { 1, 2, 3, 4, 5 };
    int[] r1 = { 5, 1, 2, 3, 4 };
    int[] t2 = { 2, 4, 6, 8 };
    int[] r2 = { 8, 2, 4, 6 };
    int[] t3 = { -1, 0, 1 };
    int[] r3 = { 1, -1, 0 };
    int[] t4 = { 9, 8 };
    int[] r4 = { 8, 9 };

    // test 1
    ArrayList<Integer> list1 = ListMethods.arrayToList(t1);
    ListMethods.shiftRightOne(list1);
    // assertion
    assertThat(check(r1, list1)).isTrue();

    // test 2
    ArrayList<Integer> list2 = ListMethods.arrayToList(t2);
    ListMethods.shiftRightOne(list2);
    // assertion
    assertThat(check(r2, list2)).isTrue();

    // test 3
    ArrayList<Integer> list3 = ListMethods.arrayToList(t3);
    ListMethods.shiftRightOne(list3);
    // assertion
    assertThat(check(r3, list3)).isTrue();

    // test 4
    ArrayList<Integer> list4 = ListMethods.arrayToList(t4);
    ListMethods.shiftRightOne(list4);
    // assertion
    assertThat(check(r4, list4)).isTrue();
  }

  @Test
  @Order(9)
  @DisplayName("Test shiftLeft correctness")
  public void testShiftLeft() {
    int[] t1 = { 1, 2, 3, 4, 5 };
    int[] r1 = { 4, 5, 1, 2, 3 };
    int[] t2 = { 2, 4, 6, 8 };
    int[] r2 = { 4, 6, 8, 2 };
    int[] t3 = { -1, 0, 1 };
    int[] r3 = { 1, -1, 0 };
    int[] t4 = { 9, 8 };
    int[] r4 = { 8, 9 };

    // test 1
    ArrayList<Integer> list1 = ListMethods.arrayToList(t1);
    ListMethods.shiftLeft(list1, 3);
    // assertion
    assertThat(check(r1, list1)).isTrue();

    // test 2
    ArrayList<Integer> list2 = ListMethods.arrayToList(t2);
    ListMethods.shiftLeft(list2, 1);
    // assertion
    assertThat(check(r2, list2)).isTrue();

    // test 3
    ArrayList<Integer> list3 = ListMethods.arrayToList(t3);
    ListMethods.shiftLeft(list3, 2);
    // assertion
    assertThat(check(r3, list3)).isTrue();

    // test 4
    ArrayList<Integer> list4 = ListMethods.arrayToList(t4);
    ListMethods.shiftLeft(list4, 1);
    // assertion
    assertThat(check(r4, list4)).isTrue();
  }

  @Test
  @Order(10)
  @DisplayName("Test removeDuplicates correctness")
  public void testRemoveDuplicates() {
    String[] t1 = {"eggs", "onions", "garlic", "cheese", "peppers", "eggs", "tomatoes", "garlic"};
    String[] r1 = {"eggs", "onions", "garlic", "cheese", "peppers", "tomatoes"};
    String[] t2 = {"apples", "bananas", "kiwis", "plums"};
    String[] r2 = {"apples", "bananas", "kiwis", "plums"};
    String[] t3 = {"eggs", "butter", "butter", "milk", "bacon"};
    String[] r3 = {"eggs", "butter", "milk", "bacon"};
    String[] t4 = {"brioche", "sourdough", "tortillas", "rye", "sourdough", "rye", "tortillas", "multigrain"};
    String[] r4 = {"brioche", "sourdough", "tortillas", "rye", "multigrain"};

    // action
    ArrayList<String> test = ListMethods.arrayToList(t1);
    ListMethods.removeDuplicates(test);
    // assertion
    assertThat(test).containsExactlyElementsIn(r1);

    // action
    test = ListMethods.arrayToList(t2);
    ListMethods.removeDuplicates(test);
    // assertion
    assertThat(test).containsExactlyElementsIn(r2);

    // action
    test = ListMethods.arrayToList(t3);
    ListMethods.removeDuplicates(test);
    // assertion
    assertThat(test).containsExactlyElementsIn(r3);

    // action
    test = ListMethods.arrayToList(t4);
    ListMethods.removeDuplicates(test);
    // assertion
    assertThat(test).containsExactlyElementsIn(r4);
  }

  public static boolean check(String[] expected, ArrayList<String> actual) {
    if (actual == null) {
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
    if (actual == null) {
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
