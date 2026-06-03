-- ============================================================
-- Exercise 2: Top Rated Events
-- Events with the highest average rating that have received
-- at least 10 feedback submissions.
-- ============================================================

SELECT
    e.event_id,
    e.title,
    COUNT(f.feedback_id)   AS total_feedback,
    AVG(f.rating)          AS avg_rating
FROM Events e
JOIN Feedback f ON f.event_id = e.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC;
