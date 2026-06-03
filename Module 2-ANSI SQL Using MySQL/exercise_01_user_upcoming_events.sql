-- ============================================================
-- Exercise 1: User Upcoming Events
-- Show all upcoming events a user is registered for in their
-- city, sorted by start_date.
-- ============================================================

SELECT
    u.user_id,
    u.full_name,
    u.city,
    e.event_id,
    e.title          AS event_title,
    e.start_date,
    e.end_date
FROM Users u
JOIN Registrations r  ON r.user_id  = u.user_id
JOIN Events e         ON e.event_id = r.event_id
WHERE e.status = 'upcoming'
  AND e.city   = u.city
ORDER BY u.user_id, e.start_date;
