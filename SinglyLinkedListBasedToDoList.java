import java.util.Scanner;
 import java.io.*;

 // A to-do list implementation that uses a singly linked list for storing tasks.
 public class SinglyLinkedListBasedToDoList {
   private static class Node {
      String text;     // task text
      Node next;       // pointer to next node
      Node(String t) { this.text = t; }
   }
   // instance variables
   private Node head;   // start of the list
   private Node tail;   // end of the list (new: for O(1) append)
   private int count;   // number of tasks
   // no-arg constructor
   public SinglyLinkedListBasedToDoList() {
      head = null;
      tail = null;
      count = 0;
   }
   public void addTask(String task) {
      Node n = new Node(task);
      if (head == null) {
         head = n;
         tail = n;
      } else {
         tail.next = n;
         tail = n;
      }
      count++;
      System.out.println("Task added: " + task);
   }
   public void removeTask(int position) {
      int idx = position - 1;
      if (idx < 0 || idx >= count || head == null) {
         System.out.println("Invalid task number: " + idx);
         return;
      }
      if (idx == 0) {
         String removed = head.text;
         head = head.next;
         if (head == null) tail = null;
         count--;
         System.out.println("Task removed: " + removed);
         return;
      }
      Node prev = head;
      for (int i = 0; i < idx - 1; i++) {
         prev = prev.next;
      }
      Node toDelete = prev.next;
      String removed = toDelete.text;
      prev.next = toDelete.next;
      if (toDelete == tail) tail = prev;
      count--;
      System.out.println("Task removed: " + removed);
   }
   public void displayTasks() {
      if (count == 0) {
         System.out.println("To-do list is empty!");
         return;
      }
      System.out.println("To-do list:");
      Node cur = head;
      int i = 1;
      while (cur != null) {
         System.out.println(i + ". " + cur.text + "\n");
         cur = cur.next;
         i++;
      }
      System.out.println("Total tasks: " + count);
   }
   // A method for saving all the tasks to a file
   public void saveTasks(String filename) {
      // inform the user if the to-do list is empty
      if (count == 0) {
         System.out.println("To-do list is empty! No tasks to save.");
         return; // end the void saveTasks method
      }
      // using a try-catch block to handle possible exceptions
      try {
         File file = new File(filename);
         PrintWriter output = new PrintWriter(file);
         // write all the tasks to the given file
         Node current = head; // starting from the head
         while (current != null) { // until reaching the end of the list
            output.println(current.text);
            current = current.next; // traverse each element in the list
         }
         output.close(); // close the file
         // inform the user that the tasks have been saved to the given file
         System.out.println("Tasks saved to " + filename);
      } catch (Exception e) {
         // inform the user if an exception is thrown
         System.out.println("Error saving tasks to file: " + e.getMessage());
      }
   }
   // A method for loading the tasks from a file
   public void loadTasks(String filename) {
      // using a try-catch block to handle possible exceptions
      try {
         File file = new File(filename);
         Scanner input = new Scanner(file);
         // read each task from the file and add it to the linked list
         while (input.hasNextLine()) {
            String task = input.nextLine();
            addTask(task);
         }
         input.close(); // close the file
         // if some tasks have been added
         if (count != 0)
            // inform the user that the tasks have been loaded from the given file
            System.out.println("Tasks loaded from " + filename);
         // otherwise
         else
            // inform the user that the file is empty
            System.out.println("No tasks in file: " + filename);
      } catch (Exception e) {
         // inform the user if an exception is thrown
         System.out.println("Error loading tasks from file: " + e.getMessage());
      }
   }
   // The main method
   public static void main(String[] args) {
      // create a singly linked list based to-do list
      SinglyLinkedListBasedToDoList toDoList = new SinglyLinkedListBasedToDoList();
      // load the tasks from the file (if there is any)
      toDoList.loadTasks("tasks.txt");
      // a user menu implemented by using a switch statement in a do-while loop
      Scanner scanner = new Scanner(System.in);
      int choice;
      // loop until the user selects to exit the program
      do {
         // list the options to the user
         System.out.println("\nTo-Do List Menu:");
         System.out.println("1. Add task");
         System.out.println("2. Display tasks");
         System.out.println("3. Remove task");
         System.out.println("4. Exit");
         System.out.print("Choose an option: ");
         // read the user-selected option
         choice = scanner.nextInt();
         scanner.nextLine(); // consume the newline
         // perform based on the user-selected option
         System.out.println(); // add a newline for readability
         switch (choice) {
            case 1: // adding a new task to the end of the list
               System.out.print("Enter the task description: ");
               String task = scanner.nextLine();
               toDoList.addTask(task);
               break;
            case 2: // displaying all the tasks
               toDoList.displayTasks();
break;
 case 3: // removing a task by its position
 System.out.print("Enter the task number to remove: ");
 int taskNumber = scanner.nextInt();
               toDoList.removeTask(taskNumber);
 break;
 case 4: // saving the tasks to the file and exiting the program
               toDoList.saveTasks("tasks.txt");
 System.out.println("Exiting...");
 break;
 default: // an invalid number is given by the user
 System.out.println("Invalid option. Please try again.");
         }
      } 
while (choice != 4); // loop continuation condition
 // close the scanner input
      scanner.close();
   }
 }