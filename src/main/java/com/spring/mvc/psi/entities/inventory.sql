-- 庫存 
-- 建立一個View, 名稱 : Inventory
-- id, name, 買進數量, 買進總價, 賣出數量, 賣出總價
SELECT p.id, p.name, p.image,
       pu.q as pu_qty, pu.pq as pu_total,
       sa.q as sa_qty, sa.pq as sa_total
FROM Product p
LEFT JOIN (SELECT p.ID as pid, SUM(pu.QUANTITY) as q, SUM(pu.PRICE * pu.QUANTITY) as pq FROM PRODUCT p, PURCHASE pu WHERE p.ID = pu.PID GROUP BY p.ID) as pu
ON p.id = pu.pid
LEFT JOIN (SELECT p.ID as pid, SUM(sa.QUANTITY) as q, SUM(sa.PRICE * sa.QUANTITY) as pq FROM PRODUCT p, Sales sa WHERE p.ID = sa.PID GROUP BY p.ID) as sa
ON p.id = sa.pid;

-- 庫存 2
-- 建立一個View, 名稱 : Inventory2
SELECT i.id, 
       i."NAME", 
       i.image,
       i.PU_QTY-coalesce(i.SA_QTY, 0) qty, -- coalesce 合併(若 i.SA_QTY = null 則顯示 0)
       i.PU_TOTAL/i.PU_QTY as pu_cost , -- 進貨均價 
       i.SA_TOTAL/i.SA_QTY as sa_cost , -- 銷貨均價
       CAST(i.PU_TOTAL/i.PU_QTY/0.3 AS INTEGER) as price1 ,
       CAST(i.PU_TOTAL/i.PU_QTY/0.2 AS INTEGER) as price2 
FROM INVENTORY i