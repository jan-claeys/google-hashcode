import java.util.*;

public class Start {
    public static void main(String[] args) {
        final String fileName = "e_elaborate.in.txt";
        Reader reader = new Reader();
        Queue<String> lines = reader.read(fileName);
        List<Client> clients = new ArrayList<>();
        int clientCount = Integer.parseInt(Objects.requireNonNull(lines.poll()));

        for (int i = 0; i < clientCount; i++) {
            Client client = new Client();
            client.addPreferences(lines);
            clients.add(client);
        }

        PizzaBaker pizzaBaker = new PizzaBaker(new Pizza());

        pizzaBaker.addIngredient(clients);

        List<Ingredient> ingredients = pizzaBaker.chooseIngredients();

        StringBuilder res = new StringBuilder(String.valueOf(ingredients.size())).append(" ");

        for (Ingredient ingredient : pizzaBaker.chooseIngredients()) {
            res.append(ingredient.toString()).append(" ");
        }

        System.out.println(res);
    }
}
