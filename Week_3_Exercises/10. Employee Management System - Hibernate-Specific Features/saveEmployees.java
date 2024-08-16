@Transactional
public void saveEmployees(List<Employee> employees) {
    for (Employee employee : employees) {
        employeeRepository.save(employee);
    }
}
