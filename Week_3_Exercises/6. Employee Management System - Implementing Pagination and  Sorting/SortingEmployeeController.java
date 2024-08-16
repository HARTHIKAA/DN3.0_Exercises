import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Page<Employee> getEmployees(Pageable pageable, @RequestParam(required = false) String sort) {
        if (sort != null) {
            pageable = Pageable.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
        }
        return employeeService.getEmployees(pageable);
    }
}
