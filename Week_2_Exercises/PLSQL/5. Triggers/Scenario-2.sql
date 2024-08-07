CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (TransactionID, TransactionDate, Amount, AccountFrom, AccountTo)
  VALUES (:NEW.TransactionID, :NEW.TransactionDate, :NEW.Amount, :NEW.AccountFrom, :NEW.AccountTo);
END;
/
