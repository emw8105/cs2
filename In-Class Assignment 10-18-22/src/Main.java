public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

    }
}


// MyList Interface has 12 methods, but 0 are defined
// MyAbstractClass has 6 total defined methods, 4 of which are overwritten from MyList, 2 are constructors
// MyAbstractList is in a roundabout way a child of the MyList Interface, but it does not use extend
// method call on line 10, method call on line 13, total 5 calls because remove has an inside call
    // some method calls belong to MyList, some belong to MyAbstractList