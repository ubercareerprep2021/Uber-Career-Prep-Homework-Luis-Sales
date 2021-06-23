package Assignment2.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TreeEx2 {

    static void printOrganizationStructure(OrganizationStructure org) {
        Queue<Employee> queue = new ArrayDeque<>();
        queue.add(org.ceo);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Employee currentEmployee = queue.poll();
                System.out.println("Name: " + currentEmployee.name + ", Title: " + currentEmployee.title);
                if (currentEmployee.directReports == null) continue;
                queue.addAll(currentEmployee.directReports);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Employee ceo = new Employee("A", "CEO");
        OrganizationStructure structure = new OrganizationStructure(ceo);

        ceo.directReports = new ArrayList<>();

        Employee cfo = new Employee("B", "CFO");
        ceo.directReports.add(cfo);
        Employee cto = new Employee("C", "CTO");
        ceo.directReports.add(cto);

        cfo.directReports = new ArrayList<>();
        cfo.directReports.add(new Employee("I", "Director"));
        cfo.directReports.add(new Employee("D", "Manager"));

        cto.directReports = new ArrayList<>();
        cto.directReports.add(new Employee("E", "Manager"));

        printOrganizationStructure(structure);
    }


}
