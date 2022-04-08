import java.util.*;

public class Company {
    private final int contributorsCount;
    private final int projectCount;
    public List<Contributor> contributors = new ArrayList<>();
    public List<Project> projects = new ArrayList<>();

    public Company(Queue<String> lines){
        this.contributorsCount = Integer.parseInt(Objects.requireNonNull(lines.poll()));
        this.projectCount = Integer.parseInt(Objects.requireNonNull(lines.poll()));
        fillContributors(lines);
        fillProjects(lines);
    }

    private void fillProjects(Queue<String> lines) {
        for (int i = 0; i < projectCount; i++) {
            Project project = new Project(lines.poll(), Integer.parseInt(Objects.requireNonNull(lines.poll())), Integer.parseInt(Objects.requireNonNull(lines.poll())), Integer.parseInt(Objects.requireNonNull(lines.poll())), this.contributors);
            project.addRole(lines);
            this.projects.add(project);
        }
    }

    private void fillContributors(Queue<String> lines) {
        for (int i = 0; i < contributorsCount; i++) {
            Contributor contributor = new Contributor(lines.poll());
            contributor.addSkills(lines);
            this.contributors.add(contributor);
        }
    }

    public void fillRolesOfProjects(){
        projects.forEach(Project::fillRoles);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(String.valueOf(projectCount));
        for (Project project:projects
             ) {
            res.append(project);
        }
        return res.toString();
    }
}
