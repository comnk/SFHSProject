import java.util.*;

class Employee {
    static Double[] wages = new Double[]{10.25, 14.25, 16.55, 19.78, 25.14, 155.00};
    static String[] positions = new String[]{"janitor", "cashier", "junior cook", "senior cook", "manager", "franchise owner"};
    static Map<String, String> jobs = new HashMap<>();

    private static String checkWage(String name) {
        try {
            return "Your wage is $" + wages[findIndex(positions, jobs.get(name))];
        }

        catch (ArrayIndexOutOfBoundsException ie) {
            return "your name is not found";
        }
    }

    public static void main(String[] args) {
        jobs.put("richie", "janitor");
        jobs.put("taylor", "cashier");
        jobs.put("mark", "junior cook");
        jobs.put("hailey", "senior cook");
        jobs.put("bill", "franchise owner");

        for (int i = 0; i < CheckUser.managers.length; i++) {
            jobs.put(CheckUser.managers[i], "manager");
        }

        label:
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("What operation?");

            String userTyped = input.nextLine();

            switch (userTyped.toUpperCase()) {
                case "ALL DONE" -> {
                    System.out.println("Thank you for using this service!");
                    break label;
                }

                case "CHECK WAGE" -> {
                    input = new Scanner(System.in);
                    System.out.println("Name?");
                    String check = input.nextLine();

                    System.out.println(checkWage(check));
                }
            }
        }
    }

    public static int findIndex(String[] arr, String t)
    {
        int i = 0;
        for (String item: arr) {
            if (item.equals(t)) return i;

            i++;
        }

        return -1;
    }
}
