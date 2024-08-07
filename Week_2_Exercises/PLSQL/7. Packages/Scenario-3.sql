CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(
    p_customer_id NUMBER,
    p_account_type VARCHAR2(50),
    p_initial_balance NUMBER
  );

  PROCEDURE CloseAccount(
    p_account_number NUMBER
  );

  FUNCTION GetTotalCustomerBalance(
    p_customer_id NUMBER
  ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(
    p_customer_id NUMBER,
    p_account_type VARCHAR2(50),
    p_initial_balance NUMBER
  )
  IS
  BEGIN
    -- Insert new account into Accounts table
  END OpenAccount;

  PROCEDURE CloseAccount(
    p_account_number NUMBER
  )
  IS
  BEGIN
    -- Update account status to closed in Accounts table
  END CloseAccount;

  FUNCTION GetTotalCustomerBalance(
    p_customer_id NUMBER
  ) RETURN NUMBER
  IS
    v_total_balance NUMBER := 0;
  BEGIN
    SELECT SUM(balance) INTO v_total_balance
    FROM accounts
    WHERE customer_id = p_customer_id;
    RETURN v_total_balance;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN 0; -- Customer has no accounts
  END;
END AccountOperations;
/
