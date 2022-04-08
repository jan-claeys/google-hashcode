import java.util.List;

public record PizzaBaker(Pizza pizza) {

    public List<Ingredient> chooseIngredients() {
        return pizza.getIngredients().stream().filter(ingredient -> ingredient.score > 0).toList();
    }

    public void addIngredient(List<Client> clients) {
        for (Client client : clients) {

            for (Ingredient ingredient : client.getLikes()) {
                this.pizza.addIngredient(ingredient).score += 1;
            }

            for (Ingredient ingredient : client.getDislikes()) {
                this.pizza.addIngredient(ingredient).score -= 1;
            }

        }
    }
}
