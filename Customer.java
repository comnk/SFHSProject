import java.util.*;

class Customer {
    static Map<String, Double> balances = new HashMap<>();

    private static String addBalance(String name, double deposit) {
        if (balances.containsKey(name)) {
            balances.put(name, balances.getOrDefault(name, balances.get(name)) + deposit);
        }

        return "New balance: " + balances.get(name);
    }

    private static String buyItems(String name, String[] array) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (array.length <= 0 || balances.get(name) < Manager.pricing.get(array[0])) break;
            balances.put(name, balances.get(name) - Manager.pricing.get(array[0]));
            sb.append(array[0]);
            sb.append(", ");
            array = Arrays.copyOfRange(array, 1, array.length);
        }

        if (array.length != 0) return "You have bought " + sb.toString() + ", and cannot buy ["
                + String.join(", ", array) + "]";

        return "You have successfully purchased " + sb.toString();
    }

    public static void main(String[] args) {

        for (String item: CheckUser.users) {
            balances.put(item, 0.00);
        }

        label: {
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.println("What operation?");

                String userTyped = input.nextLine();

                switch (userTyped.toUpperCase()) {
                    case "ALL DONE" -> {
                        System.out.println("Thank you for using this service!");
                        break label;
                    }

                    case "CHECK PRICING" -> {
                        System.out.println(Manager.pricing);
                    }

                    case "CHECK BALANCE" -> {
                        Scanner check = new Scanner(System.in);
                        System.out.println("Name?");

                        System.out.println("Your balance is: " + balances.get(check.nextLine()));
                    }

                    case "BUY ITEM" -> {
                        Scanner check = new Scanner(System.in);
                        System.out.println("Name?");
                        String name = check.nextLine();

                        if (balances.containsKey(name) && balances.get(name) > 0) {
                            check = new Scanner(System.in);
                            System.out.println("What items (separate each by spaces), lowest to highest price?");
                            String checking = check.nextLine();

                            if (checking.toUpperCase().equals("CHECK PRICING")) System.out.println(Manager.pricing);

                            else {
                                String[] array = checking.toLowerCase().split(" ");
                                System.out.println(buyItems(name, array));
                            }
                        }
                    }

                    case "DEPOSIT" -> {
                        Scanner check = new Scanner(System.in);
                        System.out.println("Name?");
                        String name = check.nextLine();

                        if (balances.containsKey(name)) {
                            check = new Scanner(System.in);
                            System.out.println("How much?");
                            Integer deposit = check.nextInt();

                            if (deposit > 0) {
                                System.out.println(addBalance(name, deposit));
                            }

                        }

                    }
                }
            }
        }
    }
}
