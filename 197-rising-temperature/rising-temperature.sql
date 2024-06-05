# Write your MySQL query statement below
SELECT t1.id as Id
FROM Weather t1
JOIN Weather t2 ON t1.recordDate- INTERVAL 1 DAY = t2.recordDate
WHERE t1.temperature > t2.temperature;

