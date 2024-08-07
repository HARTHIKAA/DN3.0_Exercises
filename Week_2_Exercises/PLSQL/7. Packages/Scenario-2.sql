CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(
    p_employee_id NUMBER,
    p_first_name VARCHAR2(50),
    p_last_name VARCHAR2(50),
    p_department_id NUMBER,
    p_salary NUMBER
  );

  PROCEDURE UpdateEmployee(
    p_employee_id NUMBER,
    p_first_name VARCHAR2(50),
    p_last_name VARCHAR2(50),
    p_department_id NUMBER,
    p_salary NUMBER
  );

  FUNCTION CalculateAnnualSalary(
    p_employee_id NUMBER
  ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(
    p_employee_id NUMBER,
    p_first_name VARCHAR2(50),
    p_last_name VARCHAR2(50),
    p_department_id NUMBER,
    p_salary NUMBER
  )
  IS
  BEGIN
    -- Insert employee into Employees table
  END HireEmployee;

  PROCEDURE UpdateEmployee(
    p_employee_id NUMBER,
    p_first_name VARCHAR2(50),
    p_last_name VARCHAR2(50),
    p_department_id NUMBER,
    p_salary NUMBER
  )
  IS
  BEGIN
    -- Update employee details in Employees table
  END UpdateEmployee;

  FUNCTION CalculateAnnualSalary(
    p_employee_id NUMBER
  ) RETURN NUMBER
  IS
    v_salary NUMBER;
  BEGIN
    SELECT salary INTO v_salary FROM employees WHERE employee_id = p_employee_id;
    RETURN v_salary * 12;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN -1; -- Indicate error
  END;
END EmployeeManagement;
/
