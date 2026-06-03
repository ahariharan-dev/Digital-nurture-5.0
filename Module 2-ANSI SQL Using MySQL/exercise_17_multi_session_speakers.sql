-- ============================================================
-- Exercise 17: Multi-Session Speakers
-- Speakers handling more than one session across all events.
-- ============================================================

SELECT
    speaker_name,
    COUNT(session_id)               AS total_sessions,
    GROUP_CONCAT(title ORDER BY start_time SEPARATOR ' | ') AS sessions
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(session_id) > 1
ORDER BY total_sessions DESC;
