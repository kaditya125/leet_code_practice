SELECT
    employee_id,
    CASE
        WHEN COUNT(DISTINCT department_id) = 1 THEN MAX(department_id)
        ELSE MAX(CASE WHEN primary_flag = 'Y' THEN department_id END)
    END AS department_id
FROM
    Employee
GROUP BY
    employee_id
    having department_id is not null;

