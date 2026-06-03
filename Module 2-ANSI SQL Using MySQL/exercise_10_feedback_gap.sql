-- ============================================================
-- Exercise 10: Feedback Gap
-- Events that had registrations but received NO feedback.
-- ============================================================

SELECT
    e.event_id,
    e.title,
    e.status,
    COUNT(r.registration_id) AS total_registrations
FROM Events e
JOIN Registrations r ON r.event_id = e.event_id
LEFT JOIN Feedback  f ON f.event_id = e.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.event_id, e.title, e.status
ORDER BY total_registrations DESC;
