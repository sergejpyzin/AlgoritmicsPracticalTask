package LessonsThird;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.print();
        linkedList.reverse();
        linkedList.print();


    }


    public static class LinkedList {
        private static Node root;

        public void add(int value) {
            Node newNode = new Node(value, null);
            if (root == null) {
                root = newNode;
                return;
            }
            Node currentNode = root;
            while (currentNode.next != null)
                currentNode = currentNode.next;
            currentNode.next = newNode;
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

        public void reverse() {
            if (root != null && root.next != null) {
                Node previousNode = null;
                Node currentNode = root;
                while (currentNode != null) {
                    Node next = currentNode.next;
                    currentNode.next = previousNode;
                    previousNode = currentNode;
                    currentNode = next;
                }
                root = previousNode;
            }
        }


        private static class Node {
            public int value;
            public Node next;

            public Node(int _value, Node _next) {
                this.value = _value;
                this.next = _next;
            }
        }
    }

}