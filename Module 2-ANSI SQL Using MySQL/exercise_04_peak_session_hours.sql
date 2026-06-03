-- ============================================================
-- Exercise 4: Peak Session Hours
-- Count sessions scheduled between 10:00 AM and 12:00 PM
-- for each event.
-- ============================================================

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS sessions_10am_to_12pm
FROM Events e
LEFT JOIN Sessions s
       ON s.event_id = e.event_id
      AND TIME(s.start_time) >= '10:00:00'
      AND TIME(s.start_time) <  '12:00:00'
GROUP BY e.event_id, e.title
ORDER BY sessions_10am_to_12pm DESC;
