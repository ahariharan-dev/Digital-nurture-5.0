-- ============================================================
-- Exercise 22: Duplicate Registrations Check
-- Detect users registered more than once for the same event.
-- ============================================================

SELECT
    u.user_id,
    u.full_name,
    e.event_id,
    e.title               AS event_title,
    COUNT(r.registration_id) AS registration_count
FROM Registrations r
JOIN Users  u ON u.user_id  = r.user_id
JOIN Events e ON e.event_id = r.event_id
GROUP BY u.user_id, u.full_name, e.event_id, e.title
HAVING COUNT(r.registration_id) > 1
ORDER BY registration_count DESC;
