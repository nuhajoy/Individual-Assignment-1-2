package Assignment1;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class to perform operations on the linked list
class LinkedList {
    Node head;

    // Method to insert a node at a specified position in the linked list
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    // Method to delete a node at a specified position in the linked list
    public void deleteAtPosition(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            }
        }
    }

    // Method to delete the node that occurs after a given node in the linked list
    public void deleteAfterNode(Node prevNode) {
        if (prevNode != null && prevNode.next != null) {
            prevNode.next = prevNode.next.next;
        }
    }

    // Method to search for a node with a specific value in the linked list
    public boolean searchNode(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

// Stack class to implement a stack using linked lists
class Stack {
    LinkedList list;

    public Stack() {
        list = new LinkedList();
    }

    // Method to push an element onto the stack
    public void push(int data) {
        list.insertAtPos(data, 1);
    }

    // Method to pop the top element from the stack
    public void pop() {
        list.deleteAtPosition(1);
    }

    // Method to peek at the top element of the stack
    public int peek() {
        if (list.head != null) {
            return list.head.data;
        } else {
            return -1; // Stack is empty
        }
    }
}

// Main class to demonstrate the usage of LinkedList and Stack classes
public class Main {
    public static void main(String[] args) {
        // Example usage of LinkedList operations
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtPos(45, 1);
        linkedList.insertAtPos(15, 2);
        linkedList.insertAtPos(35, 3);
        linkedList.deleteAtPosition(2);
        System.out.println(linkedList.searchNode(15)); // Output: false

        // Example usage of Stack operations
        Stack stack = new Stack();
        stack.push(5);
        stack.push(24);
        stack.push(15);
        System.out.println(stack.peek()); // Output: 15
        stack.pop();
        System.out.println(stack.peek()); // Output: 24
    }
}