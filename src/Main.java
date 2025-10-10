import java.util.Scanner;

interface Food {
    String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Fast Food";
    }
}

class Cake implements Food {
    public String getType() {
        return "Dessert";
    }
}

class FoodFactory {
    public Food getFood(String order) {

        if(order.equalsIgnoreCase("cake")) {
            return new Cake();
        } else if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        }


        return null;

    }
}

public class Main {
    public static void main(String args[]) {

        System.out.println("---------------------------------");
        System.out.println("Bem-vindo à Fábrica de Comida!");
        System.out.println("Digite 'pizza' ou 'cake' e pressione ENTER:");
        System.out.println("---------------------------------");

        Scanner sc = new Scanner(System.in);
        String order = sc.nextLine();
        sc.close();

        FoodFactory myFactory = new FoodFactory();

        Food food = myFactory.getFood(order);

        if (food != null) {
            System.out.println("\n--- Processando Pedido ---");
            System.out.println("The factory returned class " + food.getClass().getSimpleName());
            System.out.println("Someone ordered " + food.getType() + "!");
        } else {
            System.out.println("\nPedido não reconhecido.");
        }
    }
}