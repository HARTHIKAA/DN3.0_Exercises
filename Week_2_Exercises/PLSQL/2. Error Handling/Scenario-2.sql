CREATE OR REPLACE PROCEDURE UpdateSalary(
  p_employee_id NUMBER,
  p_percentage NUMBER
)
IS
  v_current_salary NUMBER;
BEGIN
  -- Get current salary
  SELECT salary INTO v_current_salary FROM employees WHERE employee_id = p_employee_id;

  -- Update salary
  UPDATE employees SET salary = salary * (1 + p_percentage / 100) WHERE employee_id = p_employee_id;

  COMMIT;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    -- Handle employee not found
    DBMS_OUTPUT.PUT_LINE('Employee with ID ' || p_employee_id || ' not found.');
    -- Log error (e.g., insert into an error log table)
  WHEN OTHERS THEN
    -- Handle other exceptions
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error updating salary for employee ' || p_employee_id);
    -- Log error (e.g., insert into an error log table)
END;
/
