public class MVCPatternDemo {
    public static void main(String[] args) {
        // Create a student record
        Student model = new Student("1", "John Doe", "A");
        
        // Create a view to display student details
        StudentView view = new StudentView();
        
        // Create a controller
        StudentController controller = new StudentController(model, view);
        
        // Display initial student details
        controller.updateView();
        
        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("A+");
        
        // Display updated student details
        controller.updateView();
    }
}
