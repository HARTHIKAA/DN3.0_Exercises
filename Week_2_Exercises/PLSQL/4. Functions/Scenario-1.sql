CREATE OR REPLACE FUNCTION CalculateAge(p_birthdate DATE)
RETURN NUMBER
IS
  v_age NUMBER;
BEGIN
  v_age := TRUNC(SYSDATE - p_birthdate) / 365.25;
  RETURN v_age;
EXCEPTION
  WHEN OTHERS THEN
    RETURN -1; -- Indicate error
END;
/
