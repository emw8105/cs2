public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    /** Create a default list */
    public MyLinkedList() {
    }

    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        // Implemented in Section 24.4.3.1, so omitted here
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        // Implemented in Section 24.4.3.2, so omitted here
    }

    @Override /** Add a new element at the specified index
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
        // Implemented in Section 24.4.3.3, so omitted here
    }

    /** Remove the head node and
     * return the object that is contained in the removed node. */
    //public E removeFirst() {
        // Implemented in Section 24.4.3.4, so omitted here
    //}

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    //public E removeLast() {
        // Implemented in Section 24.4.3.5, so omitted here
    //}

    /** Remove the element at the specified position in this
     * list. Return the element that was removed from the list. */
    //public E remove(int index) {
        // Implemented earlier in Section 24.4.3.6, so omitted here
    //}

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            }
            else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    @Override /** Clear the list */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override /** Return true if this list contains the element e */
    public boolean contains(E e) {
        //System.out.println("Implementation left as an exercise");
        boolean hasElement = false;
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e == current.element) {
                hasElement = true;
            }
            current = current.next;
        }
        return hasElement;
    }

    @Override /** Return the element at the specified index */
    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override /** Return the index of the head matching element
     * in this list. Return -1 if no match. */
    public int indexOf(E e) {
        //System.out.println("Implementation left as an exercise");
        Node<E> current = head;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (e == current) {
                index = i;
                break;
            }
            current = current.next;
        }
        return index;
    }

    @Override /** Return the index of the last matching element
     * in this list. Return -1 if no match. */
    public int lastIndexOf(E e) {
        //System.out.println("Implementation left as an exercise");

        Node<E> current = head;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (e == current) {
                index = i;
            }
            current = current.next;
        }
        return index;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override /** Replace the element at the specified position
     * in this list with the specified element. */
    public E set(int index, E e) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override /** Override iterator() defined in Iterable */
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator
            implements java.util.Iterator<E> {
        private Node<E> current = head; // Current index

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            System.out.println("Implementation left as an exercise");
        }
    }

    // This class is only used in LinkedList, so it is private.
    // This class does not need to access any
    // instance members of LinkedList, so it is defined static.
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}