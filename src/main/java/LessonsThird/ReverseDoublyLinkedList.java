package LessonsThird;

public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
        ReverseDoublyLinkedList doublyLinkedList = new ReverseDoublyLinkedList();
        doublyLinkedList.addInTail(1);
        doublyLinkedList.addInTail(2);
        doublyLinkedList.addInTail(3);
        doublyLinkedList.addInTail(4);
        doublyLinkedList.addInTail(5);

        doublyLinkedList.print();


    }
    private int size;
    private Node root;
    private Node tail;


//    public void DoublyLinkedList() {
//        Node root = null;
//        size = 0;
//    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void addInTail(int value){
        if (isEmpty()){
            root = new Node(value);
        } else {
            Node temp = root;
            root = new Node(null, value, temp);
            root.next.previous = root;
        }
        size++;
    }

    public void print() {
        System.out.print("[ ");
        Node currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }
    static class Node {
        int value;
        Node next;
        Node previous;

        Node (int value) {
            this(null, value, null);
        }

        Node (Node previous, int value, Node next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
