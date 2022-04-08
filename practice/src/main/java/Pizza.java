import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final List<Ingredient> ingredients = new ArrayList<>();

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient addIngredient(Ingredient ingredient){
        if(!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
            return ingredient;
        }
        return ingredients.stream().filter(i -> i.name.equals(ingredient.name)).toList().get(0);
    }
}
