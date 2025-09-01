package Task03;

/*
3. Write a program that creates 10 Employees and print it all the properties.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ListEmployees {
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void generateEmployeeData() {
        String[] Names = {"Danial Khan", "Quintin Wise", "Vivian Gonzalez","Marisa Fennell","Katie Morley","Broderick Shumate","Gunnar Alvarado","Anjali Rollins","Jimmy Ott","Brigid Martinez","Joe Wood"};
        String[] Designations = {"Chief","Central","District","Future","Chief","Human","Internal","Forward","International","Internal"};

        for (int i = 1; i <= 8 ; i++) {
            Employee emp = new Employee();
            emp.setId(i);
            emp.setEmpName(Names[(int) (Math.random()*10)]);
            emp.setDesignation(Designations[(int) (Math.random()*10)]);
            emp.setSalary(Math.random()*50000);

            employees.add(emp);
        }

        Intern internee = new Intern();
        internee.setId(9);
        internee.setEmpName("John Doe");
        internee.setDesignation("internee");
        internee.setSalary(50000);

        employees.add(internee);

        Intern internee2 = new Intern();
        internee2.setId(10);
        internee2.setEmpName("John Doe Jr");
        internee2.setDesignation("internee");
        internee2.setSalary(10000);

        employees.add(internee);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int choice;

        generateEmployeeData();

        // Main menu loop: read a choice and execute the corresponding action
        do {
            System.out.println("-------------MENU-------------");
            System.out.println("1 - Add an employee");
            System.out.println("2 - Update an employee");
            System.out.println("3 - Delete an employee");
            System.out.println("4 - Add an intern");
            System.out.println("------------------------------");
            System.out.println("5 - View all");
            System.out.println("0 - Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee(false);
                case 2 -> {
                    System.out.println("Enter employee id to update: ");
                    int empId = sc.nextInt();
                    updateEmployee(empId);
                }
                case 3 -> {
                    System.out.println("Enter employee id to delete: ");
                    int empId = sc.nextInt();
                    deleteEmployee(empId);
                }
                case 4 -> addEmployee(true);
                case 5 -> listAll();
                case 0 -> exit = true;
            }

        } while (!exit);

        sc.close();
    }

    /**
     * Prints a simple table with all employees currently stored in ArrayList.
     */
    static void listAll() {
        System.out.printf("| %-6s | %-15s | %-15s | %-10s%n", "ID", "Name", "Designation", "Salary");
        System.out.println("==========================================================");
        for (Employee e : employees) {
            System.out.printf("| %-6s | %-15s | %-15s | %-10s%n", e.getId(), e.getEmpName(), e.getDesignation(), Math.round(e.getSalary()));
        }
    }

    /**
     * Reads fields from the console and adds either a regular Employee or an Intern.
     *
     * @param isIntern if true, fills the shared Intern instance; otherwise the Employee instance.
     *                 We object via a ternary so we can call common setters
     *                 on the Employee reference.
     */
    static void addEmployee(boolean isIntern) {
        Scanner sc = new Scanner(System.in);

        // Choose the underlying object based on the flag; both are Employees so
        // we can call common getters/setters through the Employee reference.
        Employee obj = isIntern ? new Intern() : new Employee();

        System.out.println("Enter employee ID");
        obj.setId(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter employee name: ");
        obj.setEmpName(sc.nextLine());

        System.out.println("Enter employee designation: ");
        obj.setDesignation(sc.nextLine());

        System.out.println("Enter employee salary: ");
        obj.setSalary(sc.nextDouble());

        obj.setIsIntern(isIntern);

        System.out.println("Employee added Successfully");
        employees.add(obj);
    }


    /**
     * Updates an existing employee by id. If not found, it reports and returns.
     */
    static void updateEmployee(int id) {
        // Find employee by id and update its fields
        Employee _thisEmployee = null;
        for (Employee e : employees) {
            if (e.getId() == id) {
                _thisEmployee = e;
                break;
            }
        }

        if (_thisEmployee == null) {
            System.out.println("Employee with id " + id + " not found.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Updating employee with id: " + id + "");

        System.out.print("Name [" + _thisEmployee.getEmpName() + "]: ");
        _thisEmployee.setEmpName(sc.nextLine());

        System.out.print("Designation [" + _thisEmployee.getDesignation() + "]: ");
        _thisEmployee.setDesignation(sc.nextLine());

        System.out.print("Salary [" + _thisEmployee.getSalary() + "]: ");
        _thisEmployee.setSalary(sc.nextDouble());

        System.out.println("Employee: " + id + " updated successfully.");
    }


    /**
     * Deletes an employee with the given id from the Array list.
     */
    static void deleteEmployee(int id) {
        if (employees.isEmpty()) {
            System.out.println("Employee list is empty.");
            return;
        }
        boolean removed = employees.removeIf(e -> e.getId() == id);

        if (removed) {
            System.out.println("Employee with id " + id + " deleted successfully.");
        } else {
            System.out.println("Employee with id " + id + " not found.");
        }
    }
}
