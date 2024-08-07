DECLARE
  CURSOR loan_cursor IS
    SELECT loan_id, loan_amount, interest_rate
    FROM loans;

  v_loan_id NUMBER;
  v_loan_amount NUMBER;
  v_old_interest_rate NUMBER;
  v_new_interest_rate NUMBER := 0.05; -- Replace with new interest rate

BEGIN
  OPEN loan_cursor;
  LOOP
    FETCH loan_cursor INTO v_loan_id, v_loan_amount, v_old_interest_rate;
    EXIT WHEN loan_cursor%NOTFOUND;

    UPDATE loans
    SET interest_rate = v_new_interest_rate
    WHERE loan_id = v_loan_id;
  END LOOP;
  CLOSE loan_cursor;
END;
/
