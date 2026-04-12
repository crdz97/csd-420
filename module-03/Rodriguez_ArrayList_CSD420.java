//Carolina Rodriguez
//CSD 420
//This program generates a list of random integers, removes duplicates, and prints both the original and the modified lists.

//Resources: 
//GeeksforGeeks. (2018, Dec 11). How to remove duplicates from ArrayList in Java.https://www.geeksforgeeks.org/java/how-to-remove-duplicates-from-arraylist-in-java/
//GeeksforGeeks. (2026, March 26). LinkedHashSet in Java with examples.https://www.geeksforgeeks.org/java/linkedhashset-in-java-with-examples/
//GeeksforGeeks. (2025, April 24). Generating random numbers in Java.https://www.geeksforgeeks.org/java/generating-random-numbers-in-java/


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class Rodriguez_ArrayList_CSD420 {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) { // Generate random integers between 1 and 20 up to 50 times
            originalList.add(rand.nextInt(20) + 1);
        }

        System.out.println("Original List:");
        System.out.println(originalList);

        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);

        System.out.println("\nList Without Duplicates:");
        System.out.println(noDuplicates);
    }

    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return new ArrayList<>(new LinkedHashSet<>(list)); // Linked HashSet is used to maintain the order of elements while removing duplicates
    }
}
