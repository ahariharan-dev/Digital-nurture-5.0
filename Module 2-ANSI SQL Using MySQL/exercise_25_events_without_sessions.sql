-- ============================================================
-- Exercise 25: Events Without Sessions
-- All events that currently have no sessions scheduled.
-- ============================================================

SELECT
    e.event_id,
    e.title,
    e.city,
    e.status,
    e.start_date
FROM Events e
LEFT JOIN Sessions s ON s.event_id = e.event_id
WHERE s.session_id IS NULL
ORDER BY e.start_date;
