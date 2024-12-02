public class LinkedListDemo {

    // Define the Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Define the LinkedList class
    static class LinkedList {
        Node head;

        // Add a new node to the end of the list
        void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        // Display the linked list
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // Delete the last occurrence of a specified item
        void deleteLastOccurrence(int key) {
            Node temp = head, lastOccurrence = null, prevLastOccurrence = null;
            Node prev = null;

            while (temp != null) {
                if (temp.data == key) {
                    lastOccurrence = temp;
                    prevLastOccurrence = prev;
                }
                prev = temp;
                temp = temp.next;
            }

            if (lastOccurrence != null) {
                if (lastOccurrence == head) { // If the last occurrence is the head
                    head = head.next;
                } else {
                    prevLastOccurrence.next = lastOccurrence.next;
                }
            } else {
                System.out.println("Item not found in the list.");
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Add elements to the linked list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(40);
        list.add(20);

        System.out.println("Original List:");
        list.display();

        // Delete last occurrence of 20
        System.out.println("Deleting last occurrence of 20:");
        list.deleteLastOccurrence(20);
        list.display();

        // Delete last occurrence of 10
        System.out.println("Deleting last occurrence of 10:");
        list.deleteLastOccurrence(10);
        list.display();

        // Delete last occurrence of 50 (non-existent)
        System.out.println("Deleting last occurrence of 50:");
        list.deleteLastOccurrence(50);
        list.display();
    }
}
