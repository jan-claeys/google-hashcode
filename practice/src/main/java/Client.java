import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Client {
    private final List<Ingredient> likes = new ArrayList<>();
    private final List<Ingredient> dislikes = new ArrayList<>();

    public void addPreferences(Queue<String> lines) {
        this.addLikes(lines);
        this.addDislikes(lines);
    }

    public List<Ingredient> getLikes() {
        return List.copyOf(likes);
    }

    public List<Ingredient> getDislikes() {
        return List.copyOf(dislikes);
    }

    private void addLikes(Queue<String> lines) {
        int likesCount = Integer.parseInt(Objects.requireNonNull(lines.poll()));
        for (int j = 0; j < likesCount; j++) {
            Ingredient ingredient = new Ingredient(lines.poll());
            this.likes.add(ingredient);
        }
    }

    private void addDislikes(Queue<String> lines) {
        int dislikeCount = Integer.parseInt(Objects.requireNonNull(lines.poll()));
        for (int j = 0; j < dislikeCount; j++) {
            Ingredient ingredient = new Ingredient(lines.poll());
            this.dislikes.add(ingredient);
        }
    }

    @Override
    public String toString() {
        return "Client{" + "likes=" + likes + ", dislikes=" + dislikes + '}';
    }
}
