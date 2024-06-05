# Write your MySQL query statement below
SELECT
    R.contest_id,
    ROUND(COUNT(DISTINCT R.user_id) * 100.0 / U.total_users, 2) AS percentage
FROM
    Register R
JOIN
    (SELECT COUNT(*) AS total_users FROM Users) U
GROUP BY
    R.contest_id
ORDER BY
    percentage DESC,
    R.contest_id ASC;


