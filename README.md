# Lab-7

Use the starter code provided to complete the following Java classes and their methods. 
**ALL** of the following methods should be **NON-DESTRUCTIVE** unless otherwise noted.

## Part One: ListMethods 
This class will contain a set of methods dealing with ArrayLists. 
Please write the following methods:

### 1. ArrayList<Integer> arrayToList(int[] arr)
   This method should take an array of integers and 
   return an ArrayList of the same integers.
```java
int[] nums = {1, 5, 7, -2};
ArrayList<Integer> list = arrayToList(nums);

// Should return:
// [1, 5, 7, -2]

```
### 2. ArrayList<String> arrayToList(String[] arr) 
  This method should take an array of Strings and return an ArrayList of the same Strings.

```java
String[] words = {"Greetings", "from Mars", "Earthlings!"};
ArrayList<String> list = arrayToList(words);

// Should return:
// [Greetings, from Mars, Earthlings!]
```

### 3. ArrayList<Integer> reverse(ArrayList<Integer> list)
  This method should take an ArrayList of Integers (ArrayList<Integer>) and return 
an ArrayList of Integers. The return value should be a copy of the original list, 
with the elements in reverse order.
```java
int[] nums = {1, 5, 7, -2};
ArrayList<Integer> values = arrayToList(nums);
ArrayList<Integer> values_reversed = reverse(values);

// Should return:
// [-2, 7, 5, 1]
```

### 4. void printEvenIndex(ArrayList<String> list)
This method should take an ArrayList of Strings and
print out the elements at even indices. (0 is even).
```java
String[] words = {"Greetings", "from Mars", "Earthlings!"};
ArrayList<String> values = arrayToList(words);
printEvenIndex(values);
```
  should print
```
Greetings
Earthlings!
```

### 5. void printEvenElements(ArrayList<Integer> list)
This method should take an ArrayList of Integers and print out the elements with even values.
```java
int[] nums = {-1, 5, 2, 7, 6, 0, 8};
ArrayList<Integers> values = arrayToList(nums);
printEvenElements(values);

```
  should print
```
2
6
0
8
```
### 6. int sumNegatives(ArrayList<Integer> list)
This method should take an ArrayList of Integers and return 
the sum of all of the negative elements.
```java
int[] nums = {1, -5, 4, -2};
ArrayList<Integer> values = arrayToList(nums);
int sum = sumNegatives(values);

// Should return:
// -7
```
### 7. void shiftRightOne(ArrayList<Integer> list)
This method should take an ArrayList of Integers and shift each element 
to the right by one index.  This is a **destructive** method, and should 
change the values of the original list.
```java
int[] nums = {0, 1, 2, 3, 4};
ArrayList<Integer> values = arrayToList(nums);
ArrayList<Integer> values_shifted = shiftRightOne(values);
System.out.println(values_shifted);

// Should return:
// [4, 0, 1, 2, 3]
```
### 8. void shiftLeft(ArrayList<Integer> list, int distance)
This method should take an ArrayList of integers and an int _distance_. 
It should shift each element in the array left by _distance_ indices. 
This is a **destructive** method, and should change the values of the original list.

```java
int[] nums = {0, 1, 2, 3, 4, 5};
ArrayList<Integer> values = arrayToList(nums);
shiftLeft(values, 1);
System.out.println(values);

int[] nums2 = {10, 9, 8, 7, 6};
ArrayList<Integer> values2 = arrayToList(nums2);
shiftLeft(values2, 2);
System.out.println(values);
```
  should print
```
[1, 2, 3, 4, 5, 0]
[8, 7, 6, 10, 9]
```

## Part Two: SortMethods
This class will contain a set of methods that **sort** arrays and ArrayLists.

### 1. selection(int[] array)

### 2. insertion(int[] array)

### 3. alphabetize(ArrayList<String> words)

## Part Three: SearchMethods
This class will contain a set of methods that **search** arrays and ArrayLists

### 1. sequentialSearch(String[] array, String target)

### 2. sequentialSearch(ArrayList<Integer> list, int target)

### 3. binarySearch(int[] array, int target)
