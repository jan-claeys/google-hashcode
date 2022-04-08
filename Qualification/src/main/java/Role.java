public class Role {
    public Skill skill;
    public Contributor contributor;

    public Role(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return contributor.name + " ";
    }
}
