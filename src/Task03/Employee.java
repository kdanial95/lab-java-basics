package Task03;

/*
1. Create an Employee class to represent an employee of a company. Add all relevant properties and behaviors that you might need but you have to include a salary property. Don't forget to add getters and setters.
2. Create an Intern class that extends from Employee. All the Interns have a salary limit of 20000 (constant). You must validate if an intern is created (or salary updated) with a bigger salary than the max. The max value is set.
3. Write a program that creates 10 Employees and print it all the properties.
*/

import java.util.Scanner;
public class Employee {
    private int id;
    private String empName;
    private String designation;
    private double salary;
    private boolean isIntern = false;

    /**
     * Sets the unique identifier for the employee.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the employee's display name.
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * Sets the job title/role assigned to this employee.
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Sets the salary for this employee.
     * Note: Intern overrides this method to enforce a max salary.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Marks this employee as an intern or not. This flag is informational; actual
     * intern-specific constraints are implemented in Intern.
     */
    public void setIsIntern(boolean isIntern) {
        this.isIntern = isIntern;
    }

    /**
     * @return the unique identifier of the employee.
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return the employee's display name.
     */
    public String getEmpName() {
        return this.empName;
    }

    /**
     * @return the role/designation of the employee.
     */
    public String getDesignation() {
        return this.designation;
    }

    /**
     * @return the current salary of the employee.
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * @return true if this employee is flagged as an intern; false otherwise.
     */
    public boolean getIsIntern() {
        return this.isIntern;
    }
}
