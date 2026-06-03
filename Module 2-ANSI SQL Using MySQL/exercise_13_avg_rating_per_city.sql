-- ============================================================
-- Exercise 13: Average Rating per City
-- Average feedback rating of events held in each city.
-- ============================================================

SELECT
    e.city,
    ROUND(AVG(f.rating), 2) AS avg_rating,
    COUNT(f.feedback_id)    AS total_feedback
FROM Events e
JOIN Feedback f ON f.event_id = e.event_id
GROUP BY e.city
ORDER BY avg_rating DESC;
