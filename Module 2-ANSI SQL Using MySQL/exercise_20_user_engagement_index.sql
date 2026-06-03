-- ============================================================
-- Exercise 20: User Engagement Index
-- For each user: events registered and feedbacks submitted.
-- ============================================================

SELECT
    u.user_id,
    u.full_name,
    u.city,
    COUNT(DISTINCT r.event_id)  AS events_registered,
    COUNT(DISTINCT f.event_id)  AS feedbacks_given
FROM Users u
LEFT JOIN Registrations r ON r.user_id = u.user_id
LEFT JOIN Feedback       f ON f.user_id = u.user_id
GROUP BY u.user_id, u.full_name, u.city
ORDER BY events_registered DESC, feedbacks_given DESC;
