package Assignment2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TreeEx3 {

    static void printNumLevels(OrganizationStructure org) {
        Queue<Employee> queue = new ArrayDeque<>();
        queue.add(org.ceo);

        int countLevels = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            countLevels++;
            for (int i = 0; i < size; i++) {
                Employee currentEmployee = queue.poll();
                if (currentEmployee.directReports == null) continue;
                queue.addAll(currentEmployee.directReports);
            }
        }

        System.out.println(countLevels);
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

        printNumLevels(structure);
    }

}
