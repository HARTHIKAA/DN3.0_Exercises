CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
  IF :NEW.TransactionType = 'WITHDRAWAL' THEN
    IF :NEW.Amount > (SELECT balance FROM accounts WHERE account_id = :NEW.AccountFrom) THEN
      RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
    END IF;
  ELSIF :NEW.TransactionType = 'DEPOSIT' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive');
    END IF;
  END IF;
END;
/
