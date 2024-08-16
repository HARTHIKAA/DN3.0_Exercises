public interface EmployeeSummaryProjection {
    Long getId();
    String getName();
    String getDepartmentName(); // Assuming Department has a name property
}

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeSummaryProjection> findByDepartmentName(String departmentName);
}
