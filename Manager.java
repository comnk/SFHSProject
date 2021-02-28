import java.util.*;

class Manager {
    static Map<String, Double> pricing = new HashMap<>();
    static Map<String, Integer> inventory_map = new HashMap<>();

    private static String checkDatabase() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Which database you want to look at?");
        String input = obj.nextLine();

        if (input.toUpperCase().equals("PRICING")) {
            return "Pricing Database: " + pricing;
        }

        else if (input.toUpperCase().equals("INVENTORY")) {
            return "Inventory Database: " + inventory_map;
        }

        else {
            return "Pricing Database: " + pricing + "\n" + "Inventory Database: " + inventory_map;
        }
    }

    private static String modifyItemPrice(String item, double price) {
        if (price <= 0.00){
            System.out.println("Invalid price");
        }

        else {
            Scanner obj = new Scanner(System.in);
            System.out.println("Do you wish to add or change price");
            String input = obj.nextLine();

            if (input.toUpperCase().equals("ADD")) {
                pricing.put(item,
                        pricing.getOrDefault(pricing.get(item), 0.00) + price);

            } else if (input.toUpperCase().equals("CHANGE")) pricing.put(item, price);
        }

        return "New Pricing Database: " + pricing;
    }

    private static String removeFromDatabase(String item) {
        pricing.remove(item);
        inventory_map.remove(item);
        return "Updated databases: \n" + "Inventory database: " + inventory_map + "\n" + "Pricing database: "
                 + pricing;
    }

    private static String modifyInventory(String item, int inventory) {
        if (inventory <= 0) {
            return "Invalid inventory value";
        }

        else inventory_map.put(item,
                inventory_map.getOrDefault(inventory_map.get(item), 0) + inventory);

        return "New inventory: " + inventory_map;
    }

    public static void main(String[] args) {

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
                case "CHANGE PRICING" -> {
                    input = new Scanner(System.in);
                    System.out.println("Which item and price (separate by space)?");

                    String[] array = input.nextLine().split(" ");
                    System.out.println(modifyItemPrice(array[0], Double.parseDouble(array[1])));

                }
                case "CHECK DATABASES" -> {
                    System.out.println(checkDatabase());

                }
                case "MODIFY INVENTORY" -> {
                    input = new Scanner(System.in);
                    System.out.println("Item and how many of them (separate by space)?");

                    String[] array = input.nextLine().split(" ");
                    System.out.println(modifyInventory(array[0], Integer.parseInt(array[1])));

                }
                case "REMOVE ITEM" -> {
                    input = new Scanner(System.in);
                    System.out.println("Which item to remove");

                    System.out.println(removeFromDatabase(input.nextLine()));

                }
            }
        }

    }
}
