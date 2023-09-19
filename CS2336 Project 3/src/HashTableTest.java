
import java.util.*;
import java.io.*;

public class HashTableTest {
    BufferedReader reader;
    HashTableBuilder table;
    int tableSize;

    public static void main(String[] args){
        HashTableTest test = new HashTableTest("datafile.txt"); // Reads the txt file
        test.table.print(); // Prints the HashTable
    }

    HashTableTest(String filename){
        try {
            reader = new BufferedReader(new FileReader(filename)); // need to look at BufferedReader
            ArrayList<String> tempArray = new ArrayList<String>(); // Creates a temporary array to hold keywords
            FileData fd;
            while ((fd = this.readNextRecord()) != null) {
                for (int i=0; i<fd.keywords.length; i++) { // Used to find the appropriate tableSize depending on the data
                    if (!tempArray.contains(fd.keywords[i])) {
                        tempArray.add(fd.keywords[i]);
                        tableSize++;
                    }
                }
            }
            table = new HashTableBuilder(tableSize); // Creates a new HashTable of size tableSize

            reader = new BufferedReader(new FileReader(filename));
            while ((fd = readNextRecord()) != null){ // Reads the file into data-structure
                for (int i=0; i<fd.keywords.length; i++){
                    table.insert(fd.keywords[i], fd);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader!=null) reader.close(); // Closes the reader
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public FileData readNextRecord(){
        if(reader == null){
            System.out.println("Error: You must open the file first."); // Prints an error message if the file isn't open
            return null;
        }
        else{
            FileData readData;
            try{
                String data=reader.readLine();
                if(data==null) return null;
                readData= new FileData(Integer.parseInt(data), reader.readLine(), reader.readLine(), Integer.parseInt(reader.readLine()));
                // Creates a new FileData object using contents of the text file

                for (int i=0; i<readData.keywords.length; i++) {
                    readData.keywords[i] = reader.readLine(); // Reads the keyword for each book
                }
                String space=reader.readLine(); // Accounts for space between books
                if((space!=null) && (!space.trim().equals(""))){
                    System.out.println("Error in file format");
                    return null;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Error Number Expected! ");
                return null;
            }
            catch(Exception e){
                System.out.println("Fatal Error: "+e);
                return null;
            }
            return readData;
        }
    }
}