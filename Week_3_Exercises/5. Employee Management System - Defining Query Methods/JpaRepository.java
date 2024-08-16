import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> getEmployeesByDepartmentName(@Param("departmentName") String departmentName);
}
