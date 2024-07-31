import java.util.Arrays;

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmployeeID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count == employees.length) {
            employees = Arrays.copyOf(employees, employees.length * 2);
        }
        employees[count++] = employee;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[--count];
                employees[count] = null;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(2);
        Employee e1 = new Employee(1, "Alice", "Manager", 75000);
        Employee e2 = new Employee(2, "Bob", "Developer", 60000);
        Employee e3 = new Employee(3, "Charlie", "Designer", 50000);

        ems.addEmployee(e1);
        ems.addEmployee(e2);
        ems.addEmployee(e3);

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("\nSearching for Employee with ID 2:");
        System.out.println(ems.searchEmployee(2));

        System.out.println("\nDeleting Employee with ID 1:");
        ems.deleteEmployee(1);
        ems.traverseEmployees();
    }
}
