DECLARE
  CURSOR customer_cursor IS
    SELECT customer_id, balance
    FROM customers;
  
  v_customer_id NUMBER;
  v_balance NUMBER;
BEGIN
  OPEN customer_cursor;
  LOOP
    FETCH customer_cursor INTO v_customer_id, v_balance;
    EXIT WHEN customer_cursor%NOTFOUND;
    
    IF v_balance > 10000 THEN
      UPDATE customers
      SET is_vip = 'TRUE'
      WHERE customer_id = v_customer_id;
    END IF;
  END LOOP;
  CLOSE customer_cursor;
END;
/
