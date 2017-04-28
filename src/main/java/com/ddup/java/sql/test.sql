-- dataname: db_sqltest

CREATE TABLE tb_test1
(
id int auto_increment,
name varchar(10),
PRIMARY KEY(id)
);

insert into tb_test1(id, name) values(2, '张三'),(4, '李四');

-- 创建存储过程
-- 1. 需要先把分隔符设置成另外一个，比如;;，用完之后再复原
-- 2. 设置参数时，参数类型的写法跟建表时一样。比如varchar不能直接写varchar必须带长度varchar(10)
DELIMITER ;;
create procedure proc_1(IN paraId int,OUT paraName varchar(10))
BEGIN
    select name INTO paraName from tb_test1 where id = paraId;
END
;;
DELIMITER ;
-- 调用方式如下：
-- CALL proc_1(2, @name);
-- SELECT @name;