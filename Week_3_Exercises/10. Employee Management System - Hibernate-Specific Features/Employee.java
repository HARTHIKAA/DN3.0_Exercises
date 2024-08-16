import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    private String id;

    // ... other fields
}
