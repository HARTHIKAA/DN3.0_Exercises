CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department_id NUMBER,
  p_bonus_percentage NUMBER
)
IS
BEGIN
  UPDATE employees
  SET salary = salary * (1 + p_bonus_percentage / 100)
  WHERE department_id = p_department_id;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    -- Log error (e.g., insert into an error log table)
END;
/
