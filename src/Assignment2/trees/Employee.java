package Assignment2.trees;

import java.util.List;

public class Employee {
    public String name;
    public String title;
    public List<Employee> directReports;

    Employee(String name, String title) {
        this.name = name;
        this.title = title;
    }
}