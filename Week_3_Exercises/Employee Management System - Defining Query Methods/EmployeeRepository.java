import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentName(String departmentName);
    List<Employee> findByFirstNameIgnoreCase(String firstName);
    List<Employee> findBySalaryGreaterThan(Double salary);
}
