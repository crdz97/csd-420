//Carolina Rodriguez
//CSD 420 -Module 02
//This program writes random integers and doubles creates a file and appends to it. 

//Resources used:
//GeeksforGeeks. (2025, July 23). Java.util.Random class in Java.https://www.geeksforgeeks.org/java/java-util-random-class-java/
//GeeksforGeeks. (2025, November 4). Java FileWriter class.https://www.geeksforgeeks.org/java/filewriter-class-in-java/
//Stack Overflow. (2010, April 1). What is the use of printStackTrace() method in Java?. https://stackoverflow.com/questions/2560368/what-is-the-use-of-printstacktrace-method-in-java
//OpenAI. (2026). ChatGPT (April 5 version) [Large language model]. https://chat.openai.com/

import java.io.*; //importing classes from java.io package for file handling
import java.util.Random; //random number generator class from java.util package

public class Rodriguez_DataWriter { //main class
    public static void main(String[] args) {
        String fileName = "Rodriguez_datafile.dat"; //name of the file to write to
        Random rand = new Random(); //random number generator object
        
        int[] intArr = new int[5]; //array to hold 5 random integers
        double[] doubleArr = new double[5];//array to hold 5 random doubles

        for (int i = 0; i < 5; i++) {
            intArr[i] = rand.nextInt(100); // Random integer between 0 and 99
            doubleArr[i] = rand.nextDouble() * 100; // Random double between 0.0 and 100.0
        }

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) { // 'true' for appending
            for (int i = 0; i < 5; i++) pw.print(intArr[i] + " ");
            pw.println(); //

            for (int i = 0; i < 5; i++) pw.print(doubleArr[i] + " ");
            pw.println("\n--- End of Entry ---");
            System.out.println("Data successfully written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

