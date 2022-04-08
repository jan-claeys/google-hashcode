import java.util.*;

public class Project {
    public String name;
    public int duration;
    public int score;
    public int bestBefore;
    public List<Contributor> contributors;
    public List<Role> roles = new ArrayList<>();

    public Project(String name, int duration, int score, int bestBefore, List<Contributor> contributors) {
        this.name = name;
        this.duration = duration;
        this.score = score;
        this.bestBefore = bestBefore;
        this.contributors = new LinkedList<>(contributors);
    }

    public void addRole(Queue<String> lines) {
        int rolesCount = Integer.parseInt(Objects.requireNonNull(lines.poll()));
        for (int i = 0; i < rolesCount; i++) {
            Skill skill = new Skill(lines.poll(), Integer.parseInt(Objects.requireNonNull(lines.poll())));
            this.roles.add(new Role(skill));
        }
    }

    public List<Contributor> searchContributor(Skill skill){
        return this.contributors.stream().filter(contributor -> contributor.skills.contains(skill)).toList();
    }

    public void fillRoles() {
        this.roles.forEach(role -> {
            Contributor contributor = this.searchContributor(role.skill).get(0);
            role.contributor = contributor;
            this.contributors.remove(contributor);
        });
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(System.lineSeparator() + name + System.lineSeparator());
        for (Role role: roles
             ) {
            res.append(role);
        }
        return res.toString();
    }
}
