SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO a
WHERE FAVORITES = (SELECT MAX(FAVORITES) FROM REST_INFO WHERE FOOD_TYPE = a.FOOD_TYPE GROUP BY FOOD_TYPE)
ORDER BY FOOD_TYPE DESC
