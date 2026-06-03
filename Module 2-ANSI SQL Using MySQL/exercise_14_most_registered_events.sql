-- ============================================================
-- Exercise 14: Most Registered Events
-- Top 3 events by total number of user registrations.
-- ============================================================

SELECT
    e.event_id,
    e.title,
    e.city,
    e.status,
    COUNT(r.registration_id) AS total_registrations
FROM Events e
JOIN Registrations r ON r.event_id = e.event_id
GROUP BY e.event_id, e.title, e.city, e.status
ORDER BY total_registrations DESC
LIMIT 3;
