-- Write your query below
SELECT 
    employee_id, 
    salary * (employee_id % 2) * CAST(SUBSTR(name, 1, 1) != 'M' AS INTEGER) as bonus
FROM employees
ORDER BY employee_id;