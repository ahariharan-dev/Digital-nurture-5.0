-- ============================================================
-- Exercise 12: Event with Maximum Sessions
-- Event(s) that have the highest number of sessions.
-- ============================================================

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS session_count
FROM Events e
JOIN Sessions s ON s.event_id = e.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(s.session_id) = (
    SELECT MAX(cnt) FROM (
        SELECT COUNT(session_id) AS cnt
        FROM Sessions
        GROUP BY event_id
    ) sub
)
ORDER BY e.event_id;
