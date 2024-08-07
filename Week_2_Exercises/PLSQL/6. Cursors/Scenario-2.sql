DECLARE
  CURSOR account_cursor IS
    SELECT account_id, balance
    FROM accounts;

  v_account_id NUMBER;
  v_balance NUMBER;
  v_annual_fee CONSTANT NUMBER := 100; -- Replace with actual fee amount
BEGIN
  OPEN account_cursor;
  LOOP
    FETCH account_cursor INTO v_account_id, v_balance;
    EXIT WHEN account_cursor%NOTFOUND;

    IF v_balance >= v_annual_fee THEN
      UPDATE accounts
      SET balance = balance - v_annual_fee
      WHERE account_id = v_account_id;
    ELSE
      -- Handle insufficient balance (e.g., log an error, send a notification)
    END IF;
  END LOOP;
  CLOSE account_cursor;
END;
/
