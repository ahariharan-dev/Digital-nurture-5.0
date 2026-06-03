-- ============================================================
-- Exercise 15: Event Session Time Conflict
-- Sessions within the same event whose time windows overlap.
-- ============================================================

SELECT
    s1.event_id,
    e.title           AS event_title,
    s1.session_id     AS session_a_id,
    s1.title          AS session_a_title,
    s1.start_time     AS a_start,
    s1.end_time       AS a_end,
    s2.session_id     AS session_b_id,
    s2.title          AS session_b_title,
    s2.start_time     AS b_start,
    s2.end_time       AS b_end
FROM Sessions s1
JOIN Sessions s2
     ON  s1.event_id   = s2.event_id
     AND s1.session_id < s2.session_id
     AND s1.start_time < s2.end_time
     AND s1.end_time   > s2.start_time
JOIN Events e ON e.event_id = s1.event_id
ORDER BY s1.event_id, s1.session_id;
