package Application;

import Entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        List <Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("Emplyoee #" + (i + 1) + ": ");
            System.out.print("Id: ");
            int id = sc.nextInt();
            while (hasId(list, id)){
                System.out.println("Id Alredy Taken! ");
                System.out.print("try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            list.add(new Employee(id, name, salary));
            System.out.println();

        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (emp == null){
            System.out.println("This id does not exist!");
        }
        else {

            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);

        }


        System.out.println();
        System.out.println("List of employees: ");
        for (Employee j : list){
            System.out.println(j);
        }

        sc.close();
    }

    public static boolean hasId(List <Employee> list, int id){
        Employee employee = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return employee != null;
    }

}
