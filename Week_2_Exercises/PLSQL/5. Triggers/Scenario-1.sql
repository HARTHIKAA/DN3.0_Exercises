CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
AFTER UPDATE ON Customers
FOR EACH ROW
BEGIN
  UPDATE Customers
  SET LastModified = SYSDATE
  WHERE CustomerID = :NEW.CustomerID;
END;
/
