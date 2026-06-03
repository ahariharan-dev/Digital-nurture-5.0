-- ============================================================
-- Exercise 16: Unregistered Active Users
-- Users who created an account in the last 30 days but
-- haven't registered for any events.
-- ============================================================

SELECT
    u.user_id,
    u.full_name,
    u.email,
    u.city,
    u.registration_date
FROM Users u
LEFT JOIN Registrations r ON r.user_id = u.user_id
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
  AND r.registration_id IS NULL
ORDER BY u.registration_date DESC;
