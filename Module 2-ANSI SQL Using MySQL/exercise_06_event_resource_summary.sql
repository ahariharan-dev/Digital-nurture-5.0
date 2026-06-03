-- ============================================================
-- Exercise 6: Event Resource Summary
-- Number of PDFs, images, and links uploaded for each event.
-- ============================================================

SELECT
    e.event_id,
    e.title,
    COUNT(r.resource_id)                                              AS total_resources,
    SUM(CASE WHEN r.resource_type = 'pdf'   THEN 1 ELSE 0 END)      AS pdfs,
    SUM(CASE WHEN r.resource_type = 'image' THEN 1 ELSE 0 END)      AS images,
    SUM(CASE WHEN r.resource_type = 'link'  THEN 1 ELSE 0 END)      AS links
FROM Events e
LEFT JOIN Resources r ON r.event_id = e.event_id
GROUP BY e.event_id, e.title
ORDER BY e.event_id;
