public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentName(String departmentName);
    List<Employee> findByFirstNameIgnoreCase(String firstName);
}
