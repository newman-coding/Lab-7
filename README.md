# Lab-7

Use the starter code provided to complete the following Java classes and their methods. 
**ALL** of the following methods should be **NON-DESTRUCTIVE** unless otherwise noted.

## Part One: ListMethods 
This class will contain a set of methods dealing with ArrayLists. 
Please write the following methods:

1. ArrayList<Integer> arrayToList(int[] arr): this method should take an array of integers and return
an ArrayList of the same integers.

2. ArrayList<String> arrayToList(String[] arr): this method should take an array of Strings and return
an ArrayList of the same Strings.

3. ArrayList<Integer> reverse(ArrayList<Integer> list): this method should take an ArrayList of Integers 
(ArrayList<Integer>) and return an ArrayList of Integers. The return value should be a copy of the original
list, with the elements in reverse order.
```java
ArrayList<Integer> values = new ArrayList<Integer>();
int[] nums = {1, 5, 7, -2};
for (int i = 0; i < nums.length; i++){
    values.add(nums[i]);
}
ArrayList<Integer> values_reversed = reverse(values);
System.out.println(values_reversed);
```
should print
```
-2, 7, 5, 1 
```

4. void printEvenIndex(ArrayList<String> list): this method should take an ArrayList of Strings and
print out the elements at even indices. (For this exercise, 0 is even).

5. void printEvenElements(ArrayList<Integer> list): this method should take an ArrayList of Integers and
print out the elements with even values.

6. int sumNegatives(ArrayList<Integer> list): this method should take an ArrayList of Integers and return 
the sum of all of the negative elements.

7. void shiftRightOne(ArrayList<Integer> list): this method should take an ArrayList of Integers and shift each element to the right by one index.

8. void shiftLeft(ArrayList<Integer> list, int distance): this method should take an ArrayList of integers and an int _distance_. It should shift each element in the array left by _distance_ indices.

## Part Two: SortMethods
This class will contain a set of methods that **sort** arrays and ArrayLists.

1. selection(int[] array)

2. insertion(int[] array)

3. alphabetize(ArrayList<String> words)

## Part Three: SearchMethods
This class will contain a set of methods that **search** arrays and ArrayLists

1. sequentialSearch(String[] array, String target)

2. sequentialSearch(ArrayList<Integer> list, int target)

3. binarySearch(int[] array, int target)
