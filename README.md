# Lab-7

Use the starter code provided to complete the following Java classes and their methods. 
**ALL** of the following methods should be **NON-DESTRUCTIVE** unless otherwise noted.

## Part One: ListMethods.java
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
### 6. double standardDeviation(ArrayList<Double> list)
This method should take an ArrayList of Doubles and return
their mathematical standard deviation. The standard deviation
is the square root of the variance. Variance is the sum of squared
differences from the mean divided by the number of samples.  
```java
double[] nums = {2.0, -4.5, 4.5, -1.0, 6, 8};
ArrayList<Double> values = arrayToList(nums);
double stddev = standardDeviation(values);

// stddev should be calculated as follows:
// mean = 2.5
// variance = ((2.0-2.5)^2 + (-4.5-2.5)^2 + (4.5-2.5)^2 + (-1.0-2.5)^2 + (6-2.5)^2 + (8-2.5)^2) / 6
//          = ((-0.5)^2 + (-7)^2 + (2)^2 + (-3.5)^2 + (3.5)^2 + (5.5)^2)) / 6
//          = 108 / 6
//          = 18
// stddev = sqrt(18)
//        = 4.2426407
```
### 7. int sumNegatives(ArrayList<Integer> list)
This method should take an ArrayList of Integers and return 
the sum of all of the negative elements.
```java
int[] nums = {1, -5, 4, -2};
ArrayList<Integer> values = arrayToList(nums);
int sum = sumNegatives(values);

// sum should be:
// -7
```

### 8. boolean hasDuplicates(ArrayList<String> list)
This method should take an ArrayList of Strings and return
True if there are any duplicate values in the list.
```java
String[] groceries = {"eggs", "onions", "garlic", "cheese", "peppers", "eggs"};
ArrayList<String> list = arrayToList(groceries);
hasDuplicates(list);

// should return:
// true
```

### 9. ArrayList<String> pairUp(ArrayList<String> list)
This method should take an ArrayList of Strings and return
a new ArrayList containing the concatenation of each consecutive
pair of Strings with "and" in between. Odd elements should be returned
intact.
```java
String[] words = {"peanut butter", "jelly", "apples", "oranges", "cookies"};
ArrayList<String> list = arrayToList(words);
ArrayList<String> pairs = pairUp(words);

// pairs should contain:
// {"peanut butter and jelly", "apples and oranges", "cookies"}
```

### 10. void shiftRightOne(ArrayList<Integer> list)
This method should take an ArrayList of Integers and shift each element 
to the right by one index.  This is a **destructive** method, and should 
change the values of the original list.
```java
int[] nums = {0, 1, 2, 3, 4};
ArrayList<Integer> values = arrayToList(nums);
shiftRightOne(values);
System.out.println(values);

// Should print:
// [4, 0, 1, 2, 3]
```
### 11. void shiftLeft(ArrayList<Integer> list, int distance)
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

### 12. void removeDuplicates(ArrayList<String> list)
This method should take an ArrayList of Strings and remove
all duplicate values from the list. This is a **destructive** 
method, and should  change the values of the original list.
```java
String[] groceries = {"eggs", "onions", "garlic", "cheese", "peppers", "eggs", "tomatoes", "garlic"};
ArrayList<String> list = arrayToList(groceries);
removeDuplicates(list);

// list should now contain:
// {"eggs", "onions", "garlic", "cheese", "peppers","tomatoes"}
```

## Part Two: SearchMethods.java
This class will contain a set of methods that **search** arrays and ArrayLists

### 1. sequentialSearch(String[] array, String target)
This method should take an array of Strings and a String holding a target word. It should return the index of the target word in the array if found, or -1 if the target word was not present in the array.

### 2. sequentialSearch(ArrayList<Integer> list, int target)
This method should take an ArrayList of Integers and an int holding a target value. It should return the index of the target value in the ArrayList if found, or -1 if the target value was not present in the ArrayList.

### 3. binarySearch(int[] array, int target)
This method should take an array of ints and an int holding a target value. It should use binary search to return the index of the target value if found, or -1 if the target value was not present in the array.

## Part Three: SortMethods.java
This class will contain a set of methods that **sort** arrays and ArrayLists. Note that all methods may be destructive, and should alter the order of the original array.

### 0. bubble(int[] array)
This method should take an array of ints and sort it using the naive "bubble sort" algorithm. Bubble sort works by repeatedly comparing each pair of elements in the array and swapping them if they are not in order.

### 1. selection(int[] array)
This method should take an array of ints and sort it using the selection sort algorithm. Selection sort repeatedly takes the smallest remaining value in the array and moves it to the end of the "sorted section" in the front of the array.

### 2. insertion(int[] array)
This method should take an array of ints and sort it using the insertion sort algorithm. Insertion sort looks at each value in the array and shifts it forward until it finds a smaller value, then "inserts" it into the array at the index before the smaller value.

### 3. alphabetize(ArrayList<String> words)
This method should take an ArrayList of Strings and use either Selection or Insertion sort to alphabetize it.

**Bonus extra credit**: Implement this method to sort uppercase words correctly, _without_ altering the case of the original words. Java will, by default, sort all uppercase letters as alphabetically before all lowercase letters using String comparison methods.
```java
String z = "Zoology";
String a = "aardvarks";
z.compareTo(a) // will return a value < 0
```
For extra credit, your alphabetize method will show the following behavior:
```java
String[] words = {"zephyr", "aardvarks", "zoology", "Zoology"};
alphabetize(words);
System.out.println(words);
```
 should print
```
[aardvarks zephyr Zoology zoology]
```