# Write your MySQL query statement below
SELECT
    teacher_id,
    COUNT(DISTINCT subject_id) AS cnt
FROM
    Teacher
GROUP BY
    teacher_id  
    order by teacher_id desc;
