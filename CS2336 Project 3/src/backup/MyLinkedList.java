public class MyLinkedList<E> {
    private Node<E> head, tail;
    public MyLinkedList() { }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        //size++;

        if (tail == null)
            tail = head;
    }
}