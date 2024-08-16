import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query methods can be defined here
}

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Custom query methods can be defined here
}
