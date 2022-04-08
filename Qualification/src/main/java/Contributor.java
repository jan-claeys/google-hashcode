import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Contributor {
    public String name;
    public List<Skill> skills = new ArrayList<>();

    public void addSkills(Queue<String> lines) {
        int skillCount = Integer.parseInt(Objects.requireNonNull(lines.poll()));

        for (int j = 0; j <skillCount; j++) {
            Skill skill = new Skill(lines.poll(), Integer.parseInt(Objects.requireNonNull(lines.poll())));
            this.skills.add(skill);
        }
    }

    public Contributor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "name='" + name + '\'' +
                ", skills=" + skills +
                '}';
    }
}
