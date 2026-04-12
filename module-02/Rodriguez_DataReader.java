//Carolina Rodriguez
//CSD 420 -Module 02
//This program reads the data from the file (Rodriguez_datafile.dat) created by Rodriguez_DataWriter and displays it on the terminal.

//Resources used: 
//GeeksforGeeks. (2025, October 3). Java BufferedOutputStream class.https://www.geeksforgeeks.org/java/java-io-bufferedoutputstream-class-java/
//OpenAI. (2026). ChatGPT (April 5 version) [Large language model]. https://chat.openai.com/



import java.io.*;

public class Rodriguez_DataReader {
    public static void main(String[] args) {
        String fileName = "Rodriguez_datafile.dat"; 

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { //try-with-resources to ensure the file is closed after reading
            String line;
            while ((line = br.readLine()) != null) {//read each line until the end of the file
                System.out.println(line);
            }
            System.out.println("Data successfully read from " + fileName);
        } catch (IOException e) { //catch block to handle potential IOExceptions during file reading
            e.printStackTrace();
    
}
    }
}
