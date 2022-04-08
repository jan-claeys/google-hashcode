import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Queue<String> lines = reader.read("a_an_example.in.txt");

        Company company = new Company(lines);

        company.fillRolesOfProjects();

        System.out.println(company);
    }
}
