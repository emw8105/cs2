import java.io.*;
public class Project2Test {
    BufferedReader fileReader;
    BST<String> bst;
    public static void main(String[] args) {
        Project2Test test = new Project2Test("datafile.txt");
        test.bst.inorder();
    }

    public Project2Test(String filename) {
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            bst = new BST<String>();
            while (readNextRecord()) {
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean readNextRecord() {
        if (fileReader == null) {
            System.out.println("Error: You must open the file first");
            return false;
        } else {
            try {
                String data = fileReader.readLine();
                if (data == null) return false;

                // System.out.println(data); // testing
                int titleId = Integer.parseInt(data);
                String title = fileReader.readLine();
                String author = fileReader.readLine();
                int numKeys = Integer.parseInt(fileReader.readLine());
                Article article = new Article(titleId, title, author);
                //System.out.println(article); // testing
                String keyword;
                for (int i = 0; i < numKeys; i++) {
                    keyword = fileReader.readLine();
                    bst.insert(keyword, article);
                }
                fileReader.readLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: Number expected!");
                return false;
            } catch (Exception e) {
                System.out.println("Fatal Error: " + e);
                return false;
            }
        }

        return true;
    }

}