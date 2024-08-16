public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeProjection> findAll();
}
