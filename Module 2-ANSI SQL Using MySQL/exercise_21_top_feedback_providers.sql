-- ============================================================
-- Exercise 21: Top Feedback Providers
-- Top 5 users who submitted the most feedback entries.
-- ============================================================

SELECT
    u.user_id,
    u.full_name,
    u.email,
    COUNT(f.feedback_id) AS total_feedback_submitted
FROM Users u
JOIN Feedback f ON f.user_id = u.user_id
GROUP BY u.user_id, u.full_name, u.email
ORDER BY total_feedback_submitted DESC
LIMIT 5;
