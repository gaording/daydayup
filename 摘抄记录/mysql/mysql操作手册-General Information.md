mysql操作手册地址：[https://dev.mysql.com/doc/](https://dev.mysql.com/doc/?fileGuid=PpPwYkgqp66vKkJJ)

## 1.1About This Manual（关于手册）

这是关于mysql数据库系统8.0版本的使用指南，用的是8.027稳定版。本文档以发行号（8.0.x）为参考，指出了MySQL8.0的次要版本之间的差异。对于license信息，可查看法律通知（不用看，不关注）。

这个手册不是为更老的版本准备的，因为8.0版本和之前版本有许多不同。如果你正在用之前的版本，可查看对应版本的手册，例如5.7。

因为这个手册只是作为一个指南，它不提供SQL具体的操作说明或者相关的数据库概念。它也不教你如何用操作系统和命令行。

mysql软件一直在开发中，所以手册也在不断更新。可以通过手册查找最新的操作指南。当然你也可以直接下载对应的html和pdf。

mysql的源码中也包含用Doxygen写成的内部文档。生成的Dxygen内容是可用的。

如果有关于mysql的问题，加入[https://mysqlcommunity.slack.com/](https://mysqlcommunity.slack.com/?fileGuid=PpPwYkgqp66vKkJJ)，或者在我们的论坛中询问，看[https://dev.mysql.com/doc/refman/8.0/en/information-sources.html#forums](https://dev.mysql.com/doc/refman/8.0/en/information-sources.html#forums?fileGuid=PpPwYkgqp66vKkJJ)。如果有关于手册本身的问题，请发送它们到[http://www.mysql.com/company/contact/](http://www.mysql.com/company/contact/?fileGuid=PpPwYkgqp66vKkJJ).。

### Typographical and Syntax Conventions（印刷和语法规定）

这个手册用了一些印刷语法：说的是各种表现形式的文字代表那些指令，不写了，跳过

## 1.2 Overview of the MySQL Database Management System

### 1.2.1 What is MySQL?

mysql，最受欢迎的开源sql数据库管理系统，由oracle团队开发、贡献和支持。mysql站点[http://www.mysql.com/](http://www.mysql.com/?fileGuid=PpPwYkgqp66vKkJJ)提供关于mysql软件的最新信息。

* ***MySQL is a database management system.***
***一个数据库是数据的结构化集合。它可能任何一个东西，一个简单的购物清单、一个照片艺术或者公司网上的巨量信息。为了添加、获取和使用存在电脑数据库中的信息，你需要一个数据库管理系统，就比如mysql。计算机擅长处理大量信息，那数据库管理系统自然就扮演了一个计算中的中心角色，它可以单独使用，也可以作为其它应用的一部分。***
* ***MySQL databases are relational.***
一个关系型的数据库存储数据在单独的表中而不是将其放在一个大的仓库中。数据库结构被组织成针对速度进行了优化的物理文件。逻辑上，objects作为databases、tables、views、rows和columns，提供一个可变通的程序环境。你在这些不同的数据fields之间设立规则，例如一对一、一对多、唯一性、强制要求、可选性和不同表之间的“pointers”。数据库强制实施这些规则，所以一个良好设计的数据库，你的应用不应该看到反常的、重复的、孤立的、过时的或者缺失的数据。
“MySQL”的“SQL”意思是“Structured Query Language”。SQL访问数据库的标准语言。根据你的环境，你可以直接用SQL（比如生成报告时），用另一种语言书写的内嵌sql，或者用一个隐藏了sql语法的专用语言。
SQL由ANSI/ISO 标准定义。SQL标准从1986年开始一直演化并且存在了几个版本。在手册中，“SQL-92”指的是1992年发布的标准版本，“SQL：1999”指的是1999年发布的版本，“SQL：2003”指的是标准的当前版本。手册用“SQL版本”时指的就是当前版本。
* ***MySQL software is Open Source.***
开源意味着任何人都可以使用并且修改软件。任何人可以从网络下载mysql，无需付费。如果你需要，你可以学习并且修改源码以适应你的需求。mysql软件用GPL，[http://www.fsf.org/licenses/](http://www.fsf.org/licenses/?fileGuid=PpPwYkgqp66vKkJJ), 定义你不同情况下能用这个软件做的事和不能做的事。如果你不满足GPL或者想要商用mysql，可以购买。
* ***The MySQL Database Server is very fast, reliable, scalable, and easy to use.***
如果你需要这些，你可以进行尝试。mysql服务可以很方便的用在台式机和笔记本上，和你的其它应用、web服务等等，基本不需要额外注意。如果你配置了一个mysql的专用服务器，你可以调整设置项利用好所有的内存、CPU和可用的I/O空间。mysql还可以扩展到联网的机器集群。
mysql最初是为处理大型数据而研发的，比当时存在的解决方案快很多，并且已经在苛刻的生产环境中用了很多年了。在平时的研发中，mysql服务今天提供了一个丰富有用的函数集合。它的连续性、速度和安全性让mysql很适用于访问internet上的数据库
* ***MySQL Server works in client/server or embedded systems.***
mysql数据库软件是一个C/S系统，包括支持不同后台任务的多线程SQL服务，几个不同的客户端程序和函数库，以及广泛的APIs。
我们也提供MySQL server作为一个内嵌的多线程函数库，你可以对接你的应用程序获得一个更小、更快、更容易管理的标准产品。
* ***A large amount of contributed MySQL software is available.***
开源社区很活跃，用户提供了很多新特性。
### 1.2.2 The Main Features of MySQL

本节描述了mysql的一些重要特性。多数情况下这个路线图所有版本都适用。一些mysql分版本的特色信息，可以参考相应手册的总括部分。

* mysql8.0:[ Section 1.3, “What Is New in MySQL 8.0”](https://dev.mysql.com/doc/refman/8.0/en/mysql-nutshell.html?fileGuid=PpPwYkgqp66vKkJJ)
* mysql5.7：[What Is New in MySQL 5.7](https://dev.mysql.com/doc/refman/5.7/en/mysql-nutshell.html?fileGuid=PpPwYkgqp66vKkJJ)
* mysql5.6：[What Is New in MySQL 5.6](https://dev.mysql.com/doc/refman/5.6/en/mysql-nutshell.html?fileGuid=PpPwYkgqp66vKkJJ)
#### Internals and Portability

* 用C和C++写的
* 经过广泛的不同编译器测试
* 很多平台都在用
* 为了可移植性，使用CMake进行配置
* 经过Purify（一个商用内存泄露检测器）和Valgrind（一个GPL工具）的测试
* 使用具有独立模块的多层服务设计。
* 为了能利用多核CPU，设计成利用kernel threads（内核）的多线程
* 提供事务和非事务的存储引擎
* 使用索引压缩非常快的B树索引表
* 设计成容易添加其它的存储引擎。它是有用的，如果你想要为内部数据库提供一个SQL接口
* 使用非常快的基于线程分配的内存管理系统
* 使用优化的嵌套循环连接执行非常快速的join
* 实现内存中的哈希表，作为临时表
* 使用高度优化的尽可能快的类函数来实现SQL函数，通常查询初始化后没有内存分配（不懂啥意思）
* 提供server作为在C/S网络环境中使用的单独程序，也可以作为嵌入（链接）到独立应用程序中的库。这些应用可以在一个隔离的环境中使用，或者在网络不可用的环境中。
#### Data Types

* 许多数据类型：有符号/无符号整数1，2，3，4和8bytes，long、float、double、char、varchar、binary、varbinary、text、blob、date、time、datetime、timestamp、year、set、enum和openGIS空间类型
* 固定长度和可变长度字符串
#### Statements and Functions

* 完全支持select列表中的函数和where条件中的函数
* groupby和orderby语句中也完全支持。支持组函数（count(),avg(),std(),sum(),max(),min()个group_concat()）
* 支持left outer join和right outer join外联查询，通过标准的sql和odbc语法
* 支持标准sql要求的表和列别名
* 支持delete、insert、replace和update返回被修改的行数，或返回匹配的行数而不是通过设置连接到server时的flag
* 支持mysql特殊的show语句来展示关于数据库、存储引擎、表和索引的信息。支持根据标准sql实现的INFORMATION_SCHEMA数据库。
* 一个explain语句展示优化器如何解析一个query
* 函数名称与表或列名的独立性。例如，ABS是一个有效的列名，唯一的限制是，对于函数调用，函数名和其后的“(”)之间不允许有空格。
* 你可以在一条语句中涉及到多个数据库的表
#### Security

* 一个权利和安全的系统是非常灵活并且安全的，并且可以进行基于主机的验证
* 连接服务器时，通过对所有密码通信进行加密来实现密码安全
#### Scalability and Limits

* 支持大的数据库。我们用的mysql server超过了500万条记录。我们也知道用mysql超过200万张表和500亿行数据的用户
* 每张表支持最多64个索引。每个索引由1到16个列或者列的部分组成。innodb表最大的索引宽度为767字节或3072字节。可看[Section 15.22, “InnoDB Limits”](https://dev.mysql.com/doc/refman/8.0/en/innodb-limits.html?fileGuid=PpPwYkgqp66vKkJJ)。myisam表的最大索引宽度是1000字节。看[Section 16.2, “The MyISAM Storage Engine”](https://dev.mysql.com/doc/refman/8.0/en/myisam-storage-engine.html?fileGuid=PpPwYkgqp66vKkJJ)。一个索引可以用一个char、varchar、blob或者text类型列的前缀。
#### Connectivity

* 客户端可以用几个协议连接到mysql服务
    * 任何一个平台上客户端都可以用TCP/IP连接
    * windows系统，客户端可以通过named pipes连接，如果服务器是在启用named_pipe系统变量的情况下启动的话
    * 在unix系统，客户端可以用unix域套接字进行连接
* mysql客户端可以用很多语言去写。用C编写的客户端库可用于用C或C++编写的客户端，或提供C绑定的任何客户端。
* 为C、C++、Eiffel、Java、Python、Perl、PHP、Ruby和Tcl提供的APIs都是可用的，确保mysql客户端能用许多语言实现，可以看[Chapter 29, Connectors and APIs](https://dev.mysql.com/doc/refman/8.0/en/connectors-apis.html?fileGuid=PpPwYkgqp66vKkJJ)。
* 连接器ODBC（MyODBC）接口给使用ODBC的客户端程序提供支持。例如，你可以使用MS access连接到MySQL服务器。客户端可以在windows或unix上运行。connector/ODBC是可用的。支持ODBC2.5所有功能以及很多其它功能。看[MySQL Connector/ODBC Developer Guide](https://dev.mysql.com/doc/connector-odbc/en/?fileGuid=PpPwYkgqp66vKkJJ)
* connector/J接口给使用JDBC连接的java客户端程序提供支持。不管在windows还是unix，connector/J源是可用的。看[MySQL Connector/J 5.1 Developer Guide](https://dev.mysql.com/doc/connector-j/5.1/en/?fileGuid=PpPwYkgqp66vKkJJ)
* 还有.net连接支持，不说了，跳过
#### Localization

这里面可以配置貌似是各种编码？不重要，跳过，最后一个是时区本地化，这个开发中会用到

#### Clients and Tools

mysqldump、mysqladmin、mysql workbench这些是命令行可调用的实用工具

mysqlcheck分析工具、myisamchk分析myisam表操作的工具

## Tutorial

mysql返回的时间不是cpu或者机器时间，而是墙上时钟时间，还包含了服务器加载和网络延迟，并不精确，只能大概预估.

### [6.1.6 Security Considerations for LOAD DATA LOCAL

### 这里是从load data的命令跳入进去的，由于安全配置，mysql默认不开启load data，load data本质是mysql客户端发送了文件所在地址，然后mysql server自己去查找的，所以如果server不安全，它其实可以任意扫描client的文件。也可以开启一个参数load-data-local-dir限制访问路径。

还讲了mysql shell工具能做的一些事情，表导入导出、并行导入、实例备份、加载备份等能力，具体命令没说，要到mysql shell utilities那章节去看。

]

### 3.3.4 Retrieving Information from a Table

讲了基本的增删改查语句，以及排序、分组函数啥的。日期函数我之前用的不熟，这里讲到了，感觉都挺合适的。还有就是正则匹配接触到了新的形式：REGEXP_LIKE，感觉比like更强大了，但是不知道内部如何实现的，还有没有索引的问题。

分组时根据sql_mode可以决定是否进行count时select的所有列是否需要都在group by 语句中

mysql>SETsql_mode='ONLY_FULL_GROUP_BY';

Query OK, 0 rows affected (0.00 sec)

mysql>SELECTowner,COUNT(*)FROMpet;

ERROR 1140 (42000):In aggregated query without GROUP BY, expression

#1 of SELECT list contains nonaggregated column 'menagerie.pet.owner';

this is incompatible with sql_mode=only_full_group_by

select database();获取当前数据库

show tables;获取表

describe pet;描述表

show create table [tablename]；查看建表语句

用户定义变量：

mysql>SELECT@min_price:=MIN(price),@max_price:=MAX(price)FROMshop;

mysql>SELECT*FROMshopWHEREprice=@min_priceORprice=@max_price;

+---------+--------+-------+

|article|dealer|price|

+---------+--------+-------+

|0003|D|1.25|

|0004|D|19.95|

+---------+--------+-------+

获取自增主键：

SELECT@last:=LAST_INSERT_ID();

bit_count、bit_or很巧妙的用法

SELECTyear,month,BIT_COUNT(BIT_OR(1<<day))ASdaysFROMt1

GROUPBYyear,month;

myisam可以设置前置自增主键，如：

CREATETABLEanimals(

grpENUM('fish','mammal','bird')NOTNULL,

idMEDIUMINTNOTNULLAUTO_INCREMENT,

nameCHAR(30)NOTNULL,

PRIMARYKEY(grp,id)

)ENGINE=MyISAM;

INSERTINTOanimals(grp,name)VALUES

('mammal','dog'),('mammal','cat'),

('bird','penguin'),('fish','lax'),('mammal','whale'),

('bird','ostrich');

SELECT*FROManimalsORDERBYgrp,id;

+--------+----+---------+

| grp    | id | name    |

+--------+----+---------+

| fish   |  1 | lax     |

| mammal |  1 | dog     |

| mammal |  2 | cat     |

| mammal |  3 | whale   |

| bird   |  1 | penguin |

| bird   |  2 | ostrich |

+--------+----+---------+

这时候grp相同的自增键是递增的，不同的grp则是不同的序列

如果AUTO_INCREMENT列单独也是个索引，index(id)，那么自增序列就不考虑grep前缀的问题了。

## 4.2 Using MySQL Programs

### 4.2.2 Specifying Program Options

mysql提供了一些shell命令，这些shell命令可以指定各种启动参数，参数的加载顺序：1.读取环境变量 2.读取配置文件open file 3.读取命令行输入的参数 后面的会覆盖掉前面同类型的参数。

mysqld 的--user参数例外，优先读取文件中的，不优先采用命令行，处于安全考虑怕被改。还有一个例外是mysqld-auto.cnf文档，它被最后加载，所以它比命令行的优先级还高。

#### 4.2.2.1 Using Options on the Command Line

命令行使用参数时大多有长短两种形式，比如--help和--?是一致的，-h localhost和--h=localhost是一致的，有些参数和值分不分开也都可以，比如：

mysql-uroot

mysql-uroot

`--skip-grant-tables`和`--skip_grant_tables`也是等价的。但是运行时设置和查看系统变量必须用下划线。

SETGLOBALgeneral_log=ON;

SELECT@@GLOBAL.general_log;

服务开启时系统变量作为参数被设置时则可以不用下划线，例如`--general_log=ON`and`--general-log=ON`是等价的。

几个命令：

```plain
mysqladmin --count=1K --sleep=10 ping
```
```plain
shell> mysql -u root -p -e "SELECT VERSION();SELECT NOW()"
Enter password: ******
+------------+
| VERSION()  |
+------------+
| 8.0.19     |
+------------+
+---------------------+
| NOW()               |
+---------------------+
| 2019-09-03 10:36:48 |
+---------------------+
shell>
```
#### 4.2.2.2 Using Option Files

可以指定配置文件，配置参数什么的，还有个配置组的概念，不同命令读文件时会读取和命令名一样的配置组中的配置。大致跳过，不细写。一些命令：

shell>mysql--max_allowed_packet=16M

shell>mysql--max_allowed_packet=16*1024*1024

mysql>SETGLOBALmax_allowed_packet=16M;  这行不合法，set的时候不能用16M了

mysql>SETGLOBALmax_allowed_packet=16*1024*1024;

mysql -h localhost 会通过unix socket file去连接当前mysql server，命令行中-p是无效的，而mysql -h 127.0.0.1则会通过TCP/IP连接mysql server

本机测试中mysql -h localhost -u root -p -P 6666能连接成功，而mysql -h 127.0.0.1 -u root -p -P 6666连接失败

mysql的登录信息默认会读配置文件中client或者mysql组的配置信息。将用户名，密码，主机，端口都配置在配置文件中，执行mysql_config_editor set -u root -h localhost -p即可进行配置，下次连接时，直接输入mysql即可，或者指定读配置组--login-path=client

### 4.2.5 Connecting to the Server Using URI-Like Strings or Key-Value Pairs

mysql配置url连接的一些参数：

scheme、user、password（直接明文指定不安全）、host、port、socket、schema（默认连接的数据库），host中localhost的处理和上面的一样，由连接协议确定，如果为TCP/IP，则读取端口，若为unix socket file，则直接读取文件

额外的连接参数：

ssl-mode、ssl-ca、ssl-capath、ssl-cert、ssl-cipher、ssl-crl、ssl-crlpath、ssl-key这些都是安全相关的配置，没用过。

tls-version、tls-versions、tls-ciphersuites压缩相关的参数。

get-server-public-key从服务获取RSA密钥对的公钥，当mysql协议连接到服务并且ssl禁用时

server-public-key-path存储RSA密钥对中的公钥的文件

connect-timeout连接超时时间

compression、compression-algorithms、compression-level压缩配置

connection-attributes控制连接时应用程序传给服务的k-v键值对

mysqlx://user@host?connection-attributes

mysqlx://user@host?connection-attributes=true

mysqlx://user@host?connection-attributes=false

mysqlx://user@host?connection-attributes=[attr1=val1,attr2,attr3=]

mysqlx://user@host?connection-attributes=[]

### 4.2.7 Connection Transport Protocols

连接传输协议tcp默认是不安全的，但是可以进行加密。一般我们用的就是这个协议，因为要连接远端的mysql服务。

还有socket-file、named-pipe都是基于本地的。不做详述

### 4.2.8 Connection Compression Control

传输时进行数据压缩，可以让传输速度更快，但是客户端和服务端都需要就行压缩和解压缩操作，如果带宽有限的情况下，可以采用压缩保证传输速度。主从集群同步也会涉及到压缩。压缩能提高网络传输效率，但是加大了cpu的负荷。

8.0压缩参数是必填的，8.0以前不指定就会采用不压缩的方式传输。

--compress、 --compression-algorithms属于压缩相关参数，不指定--compression-algorithms时默认的压缩算法是zlid，指定之后，压缩算法为zlib和指定的算法的并集。

主从复制时，如果slave节点压缩算法开启，即slave_compressed_protocol启用时，它的优先级高于master_compression_algorithms，此时如果source和replica都支持zlib压缩算法，则会采用zlib算法。如果slave_compressed_protocol禁用时，则会采用master_compression_algorithms算法。

### 4.2.9 Setting Environment Variables

可以通过命令行设置环境变量，但只是一次性生效，若想下次启动时再次生效，可将相关参数配置到启动文件中。my.cnf或者之前的login.cnf

## 4.3 Server and Server-Startup Programs

### 4.3.1 mysqld — The MySQL Server

mysqld就是一个mysql server，管理着mysql数据目录。数据目录包含数据库和表，也包含类似log日志文件和status状态文件等其它信息。

mysql启动类的关系是mysql.server配置额外参数去启动mysql_safe，mysql_safe回去监控mysql进程并在挂掉时自动重启，最终启动命令是mysqld。mysql是mysql服务的客户端程序，是连接调用服务的。mysqld_multi管理多个mysql服务（是不是就算是集群了？）

## 4.4 Installation-Related Programs

一些相关的程序，插件之类的

comp_err查看错误日志的，mysql启动时会自动运行

mysql_secure_installation安全升级的，提高安全等级

mysql_ssl_rsa_setup生成ssl/rsa文件的，开启ssl验证时能用到

mysql_tzinfo_to_sql把服务器本地的时间加载到mysql时区表中

mysql_upgrade检查并更新表，8.0之后mysql server负责执行这个更新任务，mysql_upgrade就过期了。它更新表时候是会去锁表的，生产环境轻易不会用

## 4.5 Client Programs

mysql客户端可以调用各种命令，有对应的参数表，有问题可直接查询

然后mysql的输入内容都记录在.mysql_history（unix），/var/log/message（linux），可以看到输入的各种语句。可以选择忽略一些语句，如果命令行中的语句是多行输入的，mysql history会同时记录多行的输入和连成一行的输入。

可以不让这个文件记录，删除它，然后把它挂到/dev/null下，可以在配置文件中设置这个变量，也可以调用命令ln-s/dev/null $HOME/.mysql_history

mysql命令输入：

导入文件：

mysql*db_name*<*text_file*

mysql < text_file

mysql>source*file_name*

mysql>\.*file_name*

如果mysql客户端共享的话，可能我们不希望mysql的输入历史保留下来（为了安全考虑），可以禁用unix下面的mysql_history，同时mysql启动时加入参数--histignore=“*”来达到禁止上下翻查历史记录的目的。

mysql可以设置安全更改、删除模式，select的最大行限制，join表的最大行数限制

SETsql_safe_updates=1,sql_select_limit=1000,max_join_size=1000000;

设置了sql_sage_update的时候，update或者delete必须有where语句或者limit语句，且where语句中的条件要为key

sql_select_limit默认限制返回不会超过1000行，除非你sql自己加了limit参数，max_join_size判断join的表中有超过1000000行的，就会报错。

