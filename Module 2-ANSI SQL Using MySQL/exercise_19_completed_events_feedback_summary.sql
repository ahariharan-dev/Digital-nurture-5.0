-- ============================================================
-- Exercise 19: Completed Events with Feedback Summary
-- For completed events: total registrations and average rating.
-- ============================================================

SELECT
    e.event_id,
    e.title,
    e.city,
    e.start_date,
    COUNT(DISTINCT r.registration_id) AS total_registrations,
    COUNT(DISTINCT f.feedback_id)     AS total_feedback,
    ROUND(AVG(f.rating), 2)           AS avg_rating
FROM Events e
LEFT JOIN Registrations r ON r.event_id = e.event_id
LEFT JOIN Feedback       f ON f.event_id = e.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title, e.city, e.start_date
ORDER BY avg_rating DESC;
