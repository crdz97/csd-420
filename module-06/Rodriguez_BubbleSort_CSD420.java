//Carolina Rodriguez
//CSD 420
//This program implements the Bubble Sort algorithm with comparable and comparator versions.
//It sorts an array of integers using the comparable version and an array of strings using the comparator version. 

//Resources used:
//GeeksforGeeks. (n.d.). Bubble sort algorithm. https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/
//GeeksforGeeks. (n.d.). Comparable vs Comparator in Java. https://www.geeksforgeeks.org/java/comparable-vs-comparator-in-java/
//Programiz. (n.d.). Java String compareToIgnoreCase(). https://www.programiz.com/java-programming/library/string/comparetoignorecase
//Stack Overflow. (n.d.). How to create Java List of type E extends Comparable<? super E>. https://stackoverflow.com/questions/26161381/how-to-create-java-list-of-type-e-extends-comparable-super-e
//W3Schools. (n.d.). Java advanced sorting (comparator and comparable). https://www.w3schools.com/java/java_advanced_sorting.asp

import java.util.Comparator;

public class Rodriguez_BubbleSort_CSD420 {

// ============================== Comparable version
    public static <E extends Comparable<E>> void bubbleSortComparable(E[] list) { //Using generic method to sort any type that implements Comparable interface
        boolean swapped; // flag to check if any swapping occurred

        for (int i = 0; i < list.length - 1; i++) {
            swapped = false; // reset flag for each pass

            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) { 
                    E temp = list[j]; //swap elements if they are in the wrong order
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break; // optimization
        }
    }

    // ============================== Comparator version
    public static <E> void bubbleSortComparator(E[] list, Comparator<E> comparator) { //Using generic method to sort any type with a provided Comparator
        boolean swapped;

        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < list.length - i - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break; // optimization
        }
    }

    public static void main(String[] args) { 

        
        Integer[] numbers1 = {5, 2, 9, 1, 3};
        bubbleSortComparable(numbers1); // sorting integers using the comparable version

        System.out.println("Sorted using Comparable:");
        for (int n : numbers1) {
            System.out.print(n + " ");
        }

        System.out.println("\n");


        String[] names = {"Carlos", "Ana", "Miguel", "Sofia"}; // sorting strings using the comparator version

        bubbleSortComparator(names, String::compareToIgnoreCase); // using method reference to compare strings ignoring case

        System.out.println("Sorted using Comparator:");
        for (String name : names) {
            System.out.print(name + " ");
        }
    }
}