class HashTableBuilder {
    Element [] hashTable; // The hashtable
    int tableSize;

    HashTableBuilder(int numKeyWords) {
        tableSize = nextPrime(numKeyWords * 2); // Sets the size of the HashTable
        hashTable = new Element[tableSize]; // Instantiates the HashTable
    }

    private Element createNewElement(String keyword, Article articleToAdd) { // Creates a new Element to be added to the HashTable
        return new Element(keyword, articleToAdd);
    }

    void insert(String keyword, FileData fd) {
        Article articleToAdd = new Article(fd.id, fd.title, fd.author, null); // Creates a new Record object with the relevant information
        int index = find(keyword); // Finds the correct index for the Record using the find method
        if (index == -1)
            insert(keyword, articleToAdd); // Calls the insert method if there is a redundancy in the keyword
        else {
            articleToAdd.next = hashTable[index].head;
            hashTable[index].head = articleToAdd; // Adds Record to the HashMap if the keyword is unique
        }
    }

    private void insert(String keyword, Article articleToAdd) { // Used to handle redundancies
        int key = convertStringToInt(keyword);
        int index = key % tableSize; // Attempts to find available index by finding the remainder of key divided by the tableSize
        int  probe = 1;
        while (hashTable[index] != null) {
            System.out.printf("%s conflicts with %s at index: %d\n", keyword, hashTable[index].keyword, index);
            index = getNextQuadProbIndex(key, probe++); // If there is a conflict, use quadratic probing to find an available spot for the Element
        }
        hashTable[index] = createNewElement(keyword, articleToAdd); // Adds the element to the specified index
    }

    int find(String keyword) { // Used to find a value with a certain keyword
        int key = convertStringToInt(keyword); // Converts key to an integer value
        int index = key % tableSize; // Finds index using key
        int  probe = 1;
        while (hashTable[index] != null) {
            if (hashTable[index].keyword.compareTo(keyword) == 0)
                return index; // Returns index at which the key was found
            index = getNextQuadProbIndex(key, probe++);
        }
        return -1; // Returns -1 if key not found
    }

    private int getNextQuadProbIndex(int key, int probe) {
        return ((key % tableSize) + (int) Math.pow(probe, 2)) % tableSize; // Quadratic probing algorithm
    }

    private int convertStringToInt(String keyword) { // Converts a String to an integer value
        int sum = 0;
        for (int i=0; i < keyword.length(); i++)
            sum += (int) keyword.charAt(i); // Converts char to int and adds to sum
        return sum;
    }
    private int nextPrime(int num) { // Used to find the next prime number after the number given as a parameter
        num++; // Adds to num to ensure that num isn't returned if it's already a prime number
        for (int i = 2; i < num; i++) {
            if(num%i == 0) { // If a value is found that results in num / i having a remainder of 0, increments num and repeats loop
                num++;
                i=2;
            } else {
                continue;
            }
        }
        return num; // Returns next prime value
    }

    public void print() { // Used to print the contents of the HashMap
        int printWrap = 0;
        System.out.print("\n\n\n");
        for (int index=0; index<tableSize; index++) {
            if (hashTable[index] != null) {
                System.out.printf("index [%d]: %s (E ---> int): %d\n", index, hashTable[index].keyword, convertStringToInt(hashTable[index].keyword));
                // Used to format and print the keyword and hash value of the given index
                Article rec = hashTable[index].head;
                System.out.print("\t\t");
                while(rec != null) {
                    if (++printWrap%3 == 0) {
                        System.out.println();
                        System.out.print("\t\t");
                    }
                    System.out.printf("%d|%s|%s ---> ", rec.id, rec.author, rec.title); // Prints the id, author, and title of the text
                    rec = rec.next; // Goes to the next rec value
                }
                System.out.println("null\n");
                printWrap = 0;
            }
        }
    }
}