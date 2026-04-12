//Carolina Rodriguez
//CSD 420
//This program tests LinkedList performance using an iterator and get(index) method for 50,000 and 500,000 elements.

//Resources:
//GeeksforGeeks. (2025, November 22). Iterators in Java.https://www.geeksforgeeks.org/java/iterators-in-java/
//GeeksforGeeks. (2024, April 30). How to measure time taken by a function in Java.https://www.geeksforgeeks.org/java/measure-time-taken-function-java/
//OpenAI. (2026). ChatGPT (Apr 9 version) [Large language model]. https://chat.openai.com/
//Stack Overflow. (2016). Iterators on LinkedList time traversing. https://stackoverflow.com/questions/36093652/iterators-on-linkedlist-time-traversing

import java.util.Iterator;
import java.util.LinkedList;

public class Rodriguez_LinkedList_CSD420 {

    public static void main(String[] args) {

        testList(50_000); //testing with 50,000 elements then with 500,000 elements
        testList(500_000); 
    }

    public static void testList(int size) {

        LinkedList<Integer> list = new LinkedList<>(); //creating list with Integer type

        for (int i = 0; i < size; i++) { 
            list.add(i);//adding elements to the list from 0
        }

        System.out.println("\nTesting size: " + size);

        // Iterator test--------------
        long start1 = System.currentTimeMillis(); //start time for iterator test

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) { //iterator loop to traverse the list
            it.next();
        }

        long end1 = System.currentTimeMillis(); //end time for iterator test
        System.out.println("Iterator time: " + (end1 - start1) + " ms"); //time taken in milliseconds

        // get(index) test--------------
        long start2 = System.currentTimeMillis(); //start time for get(index) test

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long end2 = System.currentTimeMillis(); //end time for get(index) test
        System.out.println("get(index) time: " + (end2 - start2) + " ms"); //time taken in milliseconds
    }
}