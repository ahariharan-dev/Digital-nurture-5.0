-- ============================================================
-- Exercise 3: Inactive Users
-- Users who have NOT registered for any event in the last
-- 90 days.
-- ============================================================

SELECT
    u.user_id,
    u.full_name,
    u.email,
    u.city,
    MAX(r.registration_date) AS last_registration
FROM Users u
LEFT JOIN Registrations r ON r.user_id = u.user_id
GROUP BY u.user_id, u.full_name, u.email, u.city
HAVING MAX(r.registration_date) < CURDATE() - INTERVAL 90 DAY
    OR MAX(r.registration_date) IS NULL
ORDER BY last_registration;
