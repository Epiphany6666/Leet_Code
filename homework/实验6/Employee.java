package homework.实验6;

public class Employee {
    private int employeeID;
    private String name;
    private String gender;
    private int startYear;
    private String department;
    private String position;
    private String title;
    private double basicSalary;
    private double positionSalary;
    private double titleSalary;
    private double travelAllowance;
    private double mealAllowance;
    private double regionAllowance;
    private double rent;
    private double waterBill;
    private double electricityBill;
    private double tax;

    public Employee(int employeeID, String name, String gender, int startYear, String department, String position, String title) {
        this.employeeID = employeeID;
        this.name = name;
        this.gender = gender;
        this.startYear = startYear;
        this.department = department;
        this.position = position;
        this.title = title;
        calculateSalary();
    }

    public void calculateSalary() {
        if (title.equals("员级")) {
            titleSalary = 1200;
        } else if (title.equals("中级")) {
            titleSalary = 2100;
        } else if (title.equals("高级")) {
            titleSalary = 3500;
        }
        basicSalary = 3000; // assuming basic salary is 3000
        positionSalary = 0; // assuming no position salary for now

        // calculate total salary
        double totalSalary = basicSalary + positionSalary + titleSalary + travelAllowance + mealAllowance + regionAllowance;

        // calculate total deductions
        double totalDeductions = rent + waterBill + electricityBill;
        if (totalSalary > 3000 && totalSalary <= 8000) {
            tax = totalSalary * 0.08;
        } else if (totalSalary > 8000) {
            tax = totalSalary * 0.15;
        }

        // calculate net salary
        double netSalary = totalSalary - totalDeductions - tax;

        System.out.println("Employee: " + name);
        System.out.println("Total Salary: " + totalSalary);
        System.out.println("Total Deductions: " + totalDeductions);
        System.out.println("Net Salary: " + netSalary);
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "John", "Male", 2010, "IT", "Manager", "高级");
        Employee employee2 = new Employee(2, "Alice", "Female", 2012, "HR", "Supervisor", "中级");
        Employee employee3 = new Employee(3, "Bob", "Male", 2015, "Finance", "Accountant", "员级");
        Employee employee4 = new Employee(4, "Emily", "Female", 2017, "Marketing", "Coordinator", "员级");
        Employee employee5 = new Employee(5, "Mike", "Male", 2019, "Sales", "Representative", "中级");
    }
}
