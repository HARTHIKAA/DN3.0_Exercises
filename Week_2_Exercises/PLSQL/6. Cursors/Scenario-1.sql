DECLARE
  CURSOR customer_cursor IS
    SELECT DISTINCT customer_id
    FROM transactions
    WHERE transaction_date >= TRUNC(SYSDATE, 'MM');

  v_customer_id NUMBER;
  v_transaction_cursor REF CURSOR;
  v_transaction_id NUMBER;
  v_transaction_date DATE;
  v_amount NUMBER;
  v_account_number NUMBER;
BEGIN
  OPEN customer_cursor;
  LOOP
    FETCH customer_cursor INTO v_customer_id;
    EXIT WHEN customer_cursor%NOTFOUND;

    OPEN v_transaction_cursor FOR
      SELECT transaction_id, transaction_date, amount, account_number
      FROM transactions
      WHERE customer_id = v_customer_id
        AND transaction_date >= TRUNC(SYSDATE, 'MM');

    DBMS_OUTPUT.PUT_LINE('Statement for Customer ID: ' || v_customer_id);
    LOOP
      FETCH v_transaction_cursor INTO v_transaction_id, v_transaction_date, v_amount, v_account_number;
      EXIT WHEN v_transaction_cursor%NOTFOUND;

      DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || v_transaction_id || ', Date: ' || v_transaction_date || ', Amount: ' || v_amount || ', Account: ' || v_account_number);
    END LOOP;
    CLOSE v_transaction_cursor;

    DBMS_OUTPUT.PUT_LINE('--------------------------------');
  END LOOP;
  CLOSE customer_cursor;
END;
/
