CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  p_from_account_number NUMBER,
  p_to_account_number NUMBER,
  p_amount NUMBER
)
IS
  v_from_account_balance NUMBER;
  v_to_account_balance NUMBER;
BEGIN
  -- Check for insufficient funds
  SELECT balance INTO v_from_account_balance FROM accounts WHERE account_number = p_from_account_number;
  IF v_from_account_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in account ' || p_from_account_number);
  END IF;

  -- Begin transaction
  BEGIN
    UPDATE accounts SET balance = balance - p_amount WHERE account_number = p_from_account_number;
    UPDATE accounts SET balance = balance + p_amount WHERE account_number = p_to_account_number;
    COMMIT;
  EXCEPTION
    WHEN OTHERS THEN
      ROLLBACK;
      -- Log error (e.g., insert into an error log table)
      INSERT INTO error_log (error_code, error_message, transaction_time)
      VALUES (SQLCODE, SQLERRM, SYSDATE);
  END;
END;
/
