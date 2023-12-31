SELECT PRODUCT_CODE, 
SUM(SALES_AMOUNT)*PRICE SALES
FROM OFFLINE_SALE o
JOIN PRODUCT p
ON o.PRODUCT_ID = p.PRODUCT_ID
GROUP BY o.PRODUCT_ID
ORDER BY SALES DESC, PRODUCT_CODE
