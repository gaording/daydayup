存储过程和游标、触发器都涉及到业务逻辑，这个功能中看不中用，因为如果业务逻辑放在mysql层，就会导致扩展麻烦，不好做。

存储过程：

CREATE PROCEDUREordertotal(

IN onumber INT,

OUT ototal DECIMMAL(8,2)

)

BEGIN

SELECT Sum(item_price*quantity)

FROM orderitems

WHERE order_num=onumber

INTO ototal;

END;

DEOP PROCEDURE ordertotal;

SHOW CREATE PROCEDURE ordertotal;


游标：

DECLARE ordernumbers CURSOR;

OPEN ordernumbers;

CLOSE ordernumbers;

--Declare continue handler

DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done=1;

--Create a table to store the results

CREATE TABLE IF NOT EXISTS ordertotals(order_num INT,total DECIMAL(8,2))

--Open the cursor

OPEN ordernumbers;

--Loop through all rows

REPEAT

--Get order number

FETCH ordernumbers INTO o;

--Get the total for this order

CALL ordertotal(o,1,t);

--Insert order and total into ordertotals

INSERT INTO ordertotals(order_num,total)

VALUES(o,t);

--End of loop

UNTTIL done END REPEAT;

--Close the cursor

CLOSE ordernumbers;

END;

触发器“

CREATE TRIGGER newproduct AFTER INSERT ON products FOR EACH ROW SELECT 'Product added';


mysqldump可以备份数据

从表中删除大量数据时可采用optimize table来收回所用的空间，优化表的性能。

