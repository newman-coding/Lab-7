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
public class ListMethodsTest {
  private int[] testNil = {0, 0, 0};
  private int[] testOne = {5};

  @Test
  @Order(0)
  @DisplayName("Test intArrayToList correctness") 
  public void testIntArrayToList(){
    int[] t1 = {5, 2, 1, 7, 9};
    int[] t2 = {7, 6, -5, 4, -8, 2};
    int[] t3 = {3, 33, 333};
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
    String[] t1 = {"Come on", "Eileen", "Poor old", "Johnny Ray"};
    String[] t2 = {"Well", "you can tell", "by the way", "I use", "my walk"};
    String[] t3 = {"And if I only could", "I'd make a deal with God"};
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
  public void testReverse(){
    int[] t1 = {0, 1, 1, 2, 3, 5, 8};
    int[] r1 = {8, 5, 3, 2, 1, 1, 0};
    int[] t2 = {3, 6, 9, 12};
    int[] r2 = {12, 9, 6, 3};
    int[] t3 = {5};
    int[] r3 = {5};

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
  public void testPrintEvenIndex(){
    String[] t1 = {"To be", "or not", "to be", "that is", "the question", "Whether", "tis nobler", "in the mind"};
    String[] t2 = {"to suffer", "the slings", "and arrows", "of outrageous fortune"};
    String[] t3 = {"Or to take arms", "against", "a sea", "of troubles"};
    String[] t4 = {"And by opposing end them"};
    String r1 = "To be\nto be\nthe question\ntis nobler";
    String r2 = "to suffer\nand arrows";
    String r3 = "Or to take arms\na sea";
    String r4 = "And by opposing end them";

    // OUTPUT BINDING
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // action
    ArrayList<String> list1 = ListMethods.arrayToList(t1);
    ListMethods.printEvenIndex(list1);
    // get print, newline agnostic
    String result = bos.toString().replaceAll("\r\n|\r","\n");
    // assertion
    assertThat(result).isEqualTo(r1);
    // clear output stream
    bos.reset();

    // action
    ArrayList<String> list2 = ListMethods.arrayToList(t2);
    ListMethods.printEvenIndex(list2);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r","\n");
    // assertion
    assertThat(result).isEqualTo(r2);
    // clear output stream
    bos.reset();

    // action
    ArrayList<String> list3 = ListMethods.arrayToList(t3);
    ListMethods.printEvenIndex(list3);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r","\n");
    // assertion
    assertThat(result).isEqualTo(r3);
    // clear output stream
    bos.reset();

    // action
    ArrayList<String> list4 = ListMethods.arrayToList(t4);
    ListMethods.printEvenIndex(list4);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r","\n");
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
  public void testPrintEvenElements(){
    int[] t1 = {-1, 1, 0, 2, 4, 7, 8};
    String r1 = "0\n2\n4\n8\n";
    int[] t2 = {6, 21};
    String r2 = "6\n";
    int[] t3 = {2, -2, 2};
    String r3 = "2\n-2\n2\n";
    int[] t4 = {1, 3, 5, 7, 9};

    // OUTPUT BINDING
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // test one
    ArrayList<Integer> list1 = ListMethods.arrayToList(t1);
    ListMethods.printEvenElements(list1);
    // get print, newline agnostic
    String result = bos.toString().replaceAll("\r\n|\r","\n");
    // assertion
    assertThat(result).isEqualTo(r1);
    // clear output stream
    bos.reset();

    // test two
    ArrayList<Integer> list2 = ListMethods.arrayToList(t2);
    ListMethods.printEvenElements(list2);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r","\n");
    // assertion
    assertThat(result).isEqualTo(r2);
    // clear output stream
    bos.reset();

    // test three
    ArrayList<Integer> list3 = ListMethods.arrayToList(t3);
    ListMethods.printEvenElements(list3);
    // get print, newline agnostic
    result = bos.toString().replaceAll("\r\n|\r","\n");
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
  @DisplayName("Test sumNegatives correctness") 
   public void testSumNegatives()
   {
    int[] t1 = {-1, 1, 0, 2, -4, 6, -8};
    int r1 = -13;
    int[] t2 = {6, -21};
    int r2 = -21;
    int[] t3 = {-2, -2, -2};
    int r3 = -6;
    int[] t4 = {-1, 3, -5, -7, -9};
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
  @Order(6)
  @DisplayName("Test shiftRightOne correctness") 
  public void testShiftRightOne(){
    int[] t1 = {1, 2, 3, 4, 5};
    int[] r1 = {5, 1, 2, 3, 4};
    int[] t2 = {2, 4, 6, 8};
    int[] r2 = {8, 2, 4, 6};
    int[] t3 = {-1, 0, 1}; 
    int[] r3 = {1, -1, 0};
    int[] t4 = {9, 8};
    int[] r4 = {8, 9};

    // test 1
    ArrayList<Integer> list1 = ListMethods.arrayToList(t1);
    int test = ListMethods.sumNegatives(list1);
    // assertion
    assertThat(test == r1).isTrue();

    // action
    test = NumArray.maxArray(t2);
    // assertion
    assertThat(test == 6).isTrue();

    // action
    test = NumArray.maxArray(t3);
    // assertion
    assertThat(test == 2).isTrue();

    // action
    test = NumArray.maxArray(t4);
    // assertion
    assertThat(test == 1).isTrue();

    // action
    test = NumArray.maxArray(testOne);
    // assertion
    assertThat(test == 5).isTrue();

    // action
    test = NumArray.maxArray(testNil);
    // assertion
    assertThat(test == 0).isTrue();
  }
   
  @Test
  @Order(7)
  @DisplayName("Test randomEntry correctness") 
  public void testRandomEntry(){

  }

  @Test
  @Order(8)
  @DisplayName("Test subArray correctness") 
  public void testSubArray(){
    int[] t1 = {2, 3, 5, 7, 9};
    int[] t2 = {0, 1, 1, 2, 3, 5, 8};

    // action
    int[] test = NumArray.subArray(t1, 0, 3);
    int[] r1 = {2, 3, 5};
    // assertion
    assertThat(check(r1, test)).isTrue();

    // action
    test = NumArray.subArray(t2, 2, t2.length);
    int[] r2 = {1, 2, 3, 5, 8};
    // assertion
    assertThat(check(r2, test)).isTrue();

    // action
    test = NumArray.subArray(t2, 2, 5);
    int[] r3 = {1, 2, 3};
    // assertion
    assertThat(check(r3, test)).isTrue();

    // action
    test = NumArray.subArray(t1, 0, 1);
    int[] r4 = {2};
    // assertion
    assertThat(check(r4, test)).isTrue();

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
