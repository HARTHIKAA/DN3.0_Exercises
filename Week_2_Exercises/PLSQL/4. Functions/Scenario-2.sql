CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  p_loan_amount NUMBER,
  p_interest_rate NUMBER,
  p_loan_duration_years NUMBER
)
RETURN NUMBER
IS
  v_monthly_interest_rate NUMBER;
  v_total_months NUMBER;
  v_emi NUMBER;
BEGIN
  -- Convert annual interest rate to monthly interest rate
  v_monthly_interest_rate := p_interest_rate / 12 / 100;

  -- Convert loan duration from years to months
  v_total_months := p_loan_duration_years * 12;

  -- Calculate EMI using the formula
  v_emi := (p_loan_amount * v_monthly_interest_rate * POWER(1 + v_monthly_interest_rate, v_total_months)) /
          (POWER(1 + v_monthly_interest_rate, v_total_months) - 1);

  RETURN v_emi;
EXCEPTION
  WHEN OTHERS THEN
    RETURN -1; -- Indicate error
END;
/
