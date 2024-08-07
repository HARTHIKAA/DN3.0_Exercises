CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(
    p_customer_id NUMBER,
    p_customer_name VARCHAR2(100),
    p_address VARCHAR2(200)
  );

  PROCEDURE UpdateCustomer(
    p_customer_id NUMBER,
    p_customer_name VARCHAR2(100),
    p_address VARCHAR2(200)
  );

  FUNCTION GetCustomerBalance(
    p_customer_id NUMBER
  ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
  PROCEDURE AddCustomer(
    p_customer_id NUMBER,
    p_customer_name VARCHAR2(100),
    p_address VARCHAR2(200)
  )
  IS
  BEGIN
    -- Insert customer into Customers table
  END AddCustomer;

  PROCEDURE UpdateCustomer(
    p_customer_id NUMBER,
    p_customer_name VARCHAR2(100),
    p_address VARCHAR2(200)
  )
  IS
  BEGIN
    -- Update customer details in Customers table
  END UpdateCustomer;

  FUNCTION GetCustomerBalance(
    p_customer_id NUMBER
  ) RETURN NUMBER
  IS
    v_balance NUMBER;
  BEGIN
    SELECT balance INTO v_balance FROM accounts WHERE customer_id = p_customer_id;
    RETURN v_balance;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN -1; -- Indicate error
  END;
END CustomerManagement;
/
