SELECT A.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(S.SALES * B.PRICE) TOTAL_SALES
FROM BOOK B,
     AUTHOR A,
     BOOK_SALES S
WHERE B.AUTHOR_ID = A.AUTHOR_ID
  AND B.BOOK_ID = S.BOOK_ID
  AND DATE_FORMAT(S.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY B.AUTHOR_ID, B.CATEGORY
ORDER BY 1, 3 DESC