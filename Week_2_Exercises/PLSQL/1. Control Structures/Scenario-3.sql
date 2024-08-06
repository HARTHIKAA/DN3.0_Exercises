DECLARE
  CURSOR loan_cursor IS
    SELECT l.loan_id, c.customer_name, l.due_date
    FROM loans l
    JOIN customers c ON l.customer_id = c.customer_id
    WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
  
  v_loan_id NUMBER;
  v_customer_name VARCHAR2(100);
  v_due_date DATE;
BEGIN
  OPEN loan_cursor;
  LOOP
    FETCH loan_cursor INTO v_loan_id, v_customer_name, v_due_date;
    EXIT WHEN loan_cursor%NOTFOUND;
    
    DBMS_OUTPUT.PUT_LINE('Reminder for customer ' || v_customer_name || ': Loan ' || v_loan_id || ' is due on ' || v_due_date);
  END LOOP;
  CLOSE loan_cursor;
END;
/
