-- ============================================================
-- Exercise 24: Average Session Duration per Event
-- Average session duration (in minutes) for each event.
-- ============================================================

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id)                                         AS total_sessions,
    ROUND(
        AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)), 2
    )                                                           AS avg_duration_minutes
FROM Events e
JOIN Sessions s ON s.event_id = e.event_id
GROUP BY e.event_id, e.title
ORDER BY avg_duration_minutes DESC;
