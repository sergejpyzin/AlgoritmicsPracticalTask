package LessonsThird;

public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
        ReverseDoublyLinkedList doublyLinkedList = new ReverseDoublyLinkedList();
        doublyLinkedList.addInFront(1);
        doublyLinkedList.addInFront(2);
        doublyLinkedList.addInFront(3);
        doublyLinkedList.addInFront(4);
        doublyLinkedList.addInFront(5);


    }
    private int size;
    private Node root;

//    public void DoublyLinkedList() {
//        Node root = null;
//        size = 0;
//    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void addInFront(int value){
        if (isEmpty()){
            root = new Node(value);
        } else {
            Node temp = root;
            root = new Node(null, value, temp);
            root.next.previous = root;
        }
        size++;
    }

    public void print(){

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
