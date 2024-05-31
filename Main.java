package DSA;
import java.util.Scanner;
class Task {
    private final String title;
    private final String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}

class Node {
    private final Task task;
    private Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    public Task getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addToDo(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        
        System.out.println("Task added to the to-do list.");
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.getTask().getTitle().equals(title)) {
                current.getTask().markCompleted();
                found = true;
                break;
            }
            current = current.getNext();
        }

        if (found) {
            System.out.println("Task marked as completed: " + title);
        } else {
            System.out.println("Task not found.");
        }
    }

    public void viewToDoList() {
        if (head == null) {
            System.out.println("To-do list is empty.");
        } else {
            Node current = head;
            System.out.println("To-do List:");

            while (current != null) {
                Task task = current.getTask();
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Completed: " + task.isCompleted());
                System.out.println("-----------------------");
                current = current.getNext();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Mark task as completed");
            System.out.println("3. View to-do list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    Task task = new Task(title, description);
                    toDoList.addToDo(task);
                }
                case 2 -> {
                    System.out.print("Enter task title to mark as completed: ");
                    String taskTitle = scanner.nextLine();
                    toDoList.markToDoAsCompleted(taskTitle);
                }
                    case 3 -> toDoList.viewToDoList();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    
     }
}
