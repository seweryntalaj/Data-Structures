@SuppressWarnings("unchecked")
public class GenericDoublyLinkedList<T> {

    class Node <T>{
        private T content;
        private Node previous;
        private Node next;

        Node(T content) { this.content = content; }

        public Node previous() { return this.previous; }

        public Node next() { return this.next; }

        public T getContent() { return this.content; }

        public void setPrevious(Node previous) { this.previous = previous; }

        public void setNext(Node next) { this.next = next; }

        @Override
        public String toString() { return content.toString(); }

    }

    private Node head;
    private Node tail;
    private int size = 0;

    public Object head() { return this.head.getContent(); }

    public Object tail() { return this.tail.getContent() }


    public void add(T element) {
        Node newNode = new Node(element);

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrevious(this.tail);
            this.tail = newNode;
        }
        this.size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Index cannot be lower than 0 or higher than size of list!");
        }
    }

}
