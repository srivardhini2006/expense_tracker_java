 import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total Spent");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    showTotal();
                    break;
                case 4:
                    System.out.println("Exiting... Bye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    static void addExpense() {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter category (Food/Travel/etc): ");
        String category = sc.nextLine();

        System.out.print("Enter note: ");
        String note = sc.nextLine();

        expenses.add(new Expense(amount, category, note));
        System.out.println("Expense added successfully!");
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        System.out.println("\n--- Expense List ---");
        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);
            System.out.println((i + 1) + ". Amount: " + e.amount +
                               ", Category: " + e.category +
                               ", Note: " + e.note);
        }
    }

    static void showTotal() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }

        System.out.println("Total spent: ₹" + total);
    }
}