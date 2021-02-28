import java.util.*;

public class CheckUser {

    static String[] managers = new String[]{"jerome", "tyler", "noah", "sarah"};
    static String[] passwords = new String[]{"football72", "iris12!", "rad1648", "ponies&carrots69"};
    static String[] users = new String[]{"jade", "joshua", "brian", "sierra", "ariel", "matt", "victor"};
    static String[] ids = new String[]{"14932$", "94720!", "101467*", ""};
    static String[] employees = new String[]{"taylor", "richie", "hailey", "mark", "bill"};
    static String[] codewords = new String[]{"funny", "bread", "donuts", "basketball", "rich"};

    public static void main(String[] args) {

        Manager.pricing.put("cheeseburger", 2.25);
        Manager.pricing.put("fries", 1.20);
        Manager.pricing.put("nachos", 1.75);
        Manager.pricing.put("sandwich", 1.50);
        Manager.pricing.put("salad", 2.00);

        Scanner check = new Scanner(System.in);
        System.out.println("Are you a manager or a customer or an employee?");
        String checker = check.nextLine();

        if (checker.toUpperCase().equals("CUSTOMER")) {
            check = new Scanner(System.in);
            System.out.println("Name?");
            String name = check.nextLine();

            if (checkInArray(users, name)) {
                check = new Scanner(System.in);
                System.out.println("ID?");

                if (checkInArray(ids, check.nextLine())) {
                    System.out.println("Welcome back " + name.toUpperCase() + "!");
                    Customer.main(null);
                }

                else System.out.println("Invalid password!");
            }

            else System.out.println("You do not have an account");
        }

        if (checker.toUpperCase().equals("CUSTOMER")) {
            check = new Scanner(System.in);
            System.out.println("Name?");
            String name = check.nextLine();

            if (checkInArray(users, name)) {
                check = new Scanner(System.in);
                System.out.println("ID?");

                if (checkInArray(ids, check.nextLine())) {
                    System.out.println("Welcome back " + name.toUpperCase() + "!");
                    Customer.main(null);
                }

                else System.out.println("Invalid password!");
            }

            else System.out.println("You do not have an account");
        }

        if (checker.toUpperCase().equals("MANAGER")) {
            check = new Scanner(System.in);
            System.out.println("Name?");
            String name = check.nextLine();

            if (checkInArray(managers, name)) {
                check = new Scanner(System.in);
                System.out.println("Password?");

                if (checkInArray(passwords, check.nextLine())) {
                    System.out.println("Welcome back " + name.toUpperCase() + "!");
                    Manager.main(null);
                }

                else System.out.println("Invalid password!");
            }

            else System.out.println("You are not a manager!");
        }

        if (checker.toUpperCase().equals("EMPLOYEE")) {
            check = new Scanner(System.in);
            System.out.println("Name?");
            String name = check.nextLine();

            if (checkInArray(employees, name)) {
                check = new Scanner(System.in);
                System.out.println("Code Word?");

                if (checkInArray(codewords, check.nextLine())) {
                    System.out.println("Welcome back " + name.toUpperCase() + "!");
                    Employee.main(null);
                }

                else System.out.println("Invalid password!");
            }

            else System.out.println("You are not an employee!");
        }
    }

    private static boolean checkInArray(Object[] arr, String item) {
        for (Object thing: arr) {
            if (thing.equals(item.toLowerCase())) return true;
        }

        return false;
    }
}
