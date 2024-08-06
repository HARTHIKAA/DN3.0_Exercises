DECLARE
  CURSOR customer_cursor IS
    SELECT customer_id, age, loan_interest_rate
    FROM customers;
  
  v_customer_id NUMBER;
  v_age NUMBER;
  v_loan_interest_rate NUMBER;
  v_discount_rate CONSTANT NUMBER := 0.01;
BEGIN
  OPEN customer_cursor;
  LOOP
    FETCH customer_cursor INTO v_customer_id, v_age, v_loan_interest_rate;
    EXIT WHEN customer_cursor%NOTFOUND;
    
    IF v_age > 60 THEN
      UPDATE loans
      SET interest_rate = interest_rate - (interest_rate * v_discount_rate)
      WHERE customer_id = v_customer_id;
    END IF;
  END LOOP;
  CLOSE customer_cursor;
END;
/
