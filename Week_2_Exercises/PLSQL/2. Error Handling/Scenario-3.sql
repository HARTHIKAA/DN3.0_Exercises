CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_customer_id NUMBER,
  p_customer_name VARCHAR2(100),
  p_address VARCHAR2(200)
)
IS
BEGIN
  INSERT INTO customers (customer_id, customer_name, address)
  VALUES (p_customer_id, p_customer_name, p_address);

  COMMIT;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    -- Handle duplicate customer ID
    DBMS_OUTPUT.PUT_LINE('Customer with ID ' || p_customer_id || ' already exists.');
    -- Log error (e.g., insert into an error log table)
    ROLLBACK;
  WHEN OTHERS THEN
    -- Handle other exceptions
    DBMS_OUTPUT.PUT_LINE('Error adding new customer.');
    -- Log error (e.g., insert into an error log table)
    ROLLBACK;
END;
/
