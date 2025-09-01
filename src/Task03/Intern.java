package Task03;

/*
2. Create an Intern class that extends from Employee. All the Interns have a salary limit of 20000 (constant). You must validate if an intern is created (or salary updated) with a bigger salary than the max. The max value is set.
 */

public class Intern extends Employee {
    private static final double salaryLimit = 20000;

    /**
     * Caps the salary to salaryLimit if a higher value is provided.
     */
    @Override
    public void setSalary(double salary) {
        if (salary > salaryLimit) {
            salary = salaryLimit;
        }

        super.setSalary(salary);
    }

    /**
     * Ignores the provided designation and forces it to "Intern".
     */
    @Override
    public void setDesignation(String designation) {
        super.setDesignation("Intern");
    }
}
