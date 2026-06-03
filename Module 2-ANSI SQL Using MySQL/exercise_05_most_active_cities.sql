-- ============================================================
-- Exercise 5: Most Active Cities
-- Top 5 cities with the highest number of DISTINCT user
-- registrations.
-- ============================================================

SELECT
    u.city,
    COUNT(DISTINCT r.user_id) AS distinct_registrations
FROM Users u
JOIN Registrations r ON r.user_id = u.user_id
GROUP BY u.city
ORDER BY distinct_registrations DESC
LIMIT 5;
