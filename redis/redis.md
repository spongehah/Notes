# 	1、Redis安装、配置和启动

==阳哥邮箱：zzyybs@126.com==



在官网下载tar.gz包后，拷贝到/opt中，进行解压，然后进入解压出的redis文件中，执行命令make && make install,默认安装到/usr/local/bin目录下

在根目录下创建一个目录/myredis，并将/opt/redis-7.0.10/redis.conf文件复制到myredis目录下，保留原文件

配置文件的修改：

​	1.将daemonize no 改为 daemonize yes

​	2.protected-mode yes 改为protected-mode no

​	3.注释掉bind 127.0.0.1 -::1

​	4.requirepass设置密码

主从复制的配置：

![image-20230408143127271](image/redis.assets/image-20230408143127271.png)

redis可使用config get xxx 来查看对应的配置



redis卸载：rm -rf /usr/local/bin/redis-*

启动：

​	redis-server /myredis/redis7.conf

​	redis-cli -a 密码 [-p 6379] [--raw]

​			redis-cli  --> auth 密码

​	可使用ps -ef | grep redis | grep -v grep 查看进程

​	若输入ping，输出PONG，则启动成功

退出cli：quit

退出cli和server：

​	在redis命令行中：shutdown

​	不在redis命令行中（远程关闭）：单实例关闭：redis -cli -a 密码 shutdown

​																多实例关闭（分别指定端口号）：redis-cli -p 6379 shutdown

# 2、Redis十大数据类型

## 2.1 总体概述

<img src="image/redis.assets/image-20230403225207494.png" alt="image-20230403225207494" style="zoom:50%;" />

<img src="image/redis.assets/image-20230403225251521.png" alt="image-20230403225251521" style="zoom:50%;" />

![image-20230403225449055](image/redis.assets/image-20230403225449055.png)

![image-20230403225621007](image/redis.assets/image-20230403225621007.png)

![image-20230403225657133](image/redis.assets/image-20230403225657133.png)

![image-20230403225720684](image/redis.assets/image-20230403225720684.png)

![image-20230403225805567](image/redis.assets/image-20230403225805567.png)

![image-20230403231640906](image/redis.assets/image-20230403231640906.png)

![image-20230403231714477](image/redis.assets/image-20230403231714477.png)

![image-20230403231900839](image/redis.assets/image-20230403231900839.png)

![image-20230403231949615](image/redis.assets/image-20230403231949615.png)

![image-20230403232046006](image/redis.assets/image-20230403232046006.png)

## 2.2 获取redis常见数据类型操作命令

官网英文：[Commands | Redis](https://redis.io/commands/)

中文：[Redis命令中心（Redis commands） -- Redis中国用户组（CRUG）](http://redis.cn/commands.html)

## 2.3 key操作命令

![image-20230404144959263](image/redis.assets/image-20230404144959263.png)

![image-20230404145353394](image/redis.assets/image-20230404145353394.png)

**获取对应数据类型的命令：help @数据类型**

**redis可使用config get xxx 来查看对应的配置**

**命令不区分大小写，但是key使区分的**

## 2.4.1 String

![image-20230404164432416](image/redis.assets/image-20230404164432416.png)

![image-20230404150507417](image/redis.assets/image-20230404150507417.png)

![image-20230404151626311](image/redis.assets/image-20230404151626311.png)

**若msetnx k1 v1 k2 v2：k1已经存在，k4不存在，则不会执行成功，全部都失败**



![image-20230404151754634](image/redis.assets/image-20230404151754634.png)

<img src="image/redis.assets/image-20230404152137413.png" alt="image-20230404152137413" style="zoom:50%;" />

![image-20230404152335659](image/redis.assets/image-20230404152335659.png)

<img src="image/redis.assets/image-20230404152346946.png" alt="image-20230404152346946" style="zoom:50%;" />

<img src="image/redis.assets/image-20230404152551652.png" alt="image-20230404152551652" style="zoom: 67%;" />

![image-20230404152759900](image/redis.assets/image-20230404152759900.png)

<img src="image/redis.assets/image-20230404152901807.png" alt="image-20230404152901807" style="zoom:50%;" />

![image-20230404153014235](image/redis.assets/image-20230404153014235.png)

<img src="image/redis.assets/image-20230404153237570.png" alt="image-20230404153237570" style="zoom:33%;" />

**setnx == set nx的合并**

**setex == set + expire 的合并 == set ex**

![image-20230404153757944](image/redis.assets/image-20230404153757944.png)

<img src="image/redis.assets/image-20230404153827366.png" alt="image-20230404153827366" style="zoom:50%;" />

**getset k v == set k v get**





**string应用场景：点赞，访问次数**



## 2.4.2 List

![image-20230404155852728](image/redis.assets/image-20230404155852728.png)

![image-20230404155935050](image/redis.assets/image-20230404155935050.png)

![image-20230404160240517](image/redis.assets/image-20230404160240517.png)

<img src="image/redis.assets/image-20230404160220307.png" alt="image-20230404160220307" style="zoom:50%;" />

**lrange list1 0 -1 相当于遍历**

<img src="image/redis.assets/image-20230404160446068.png" alt="image-20230404160446068" style="zoom:50%;" />

![image-20230404160507965](image/redis.assets/image-20230404160507965.png)

<img src="image/redis.assets/image-20230404160754814.png" alt="image-20230404160754814" style="zoom:50%;" />

<img src="image/redis.assets/image-20230404160808059.png" alt="image-20230404160808059" style="zoom:50%;" />

![image-20230404160825227](image/redis.assets/image-20230404160825227.png)

<img src="image/redis.assets/image-20230404161120028.png" alt="image-20230404161120028" style="zoom: 50%;" />

<img src="image/redis.assets/image-20230404161301771.png" alt="image-20230404161301771" style="zoom:50%;" />

![image-20230404161627474](image/redis.assets/image-20230404161627474.png)

<img src="image/redis.assets/image-20230404161641455.png" alt="image-20230404161641455" style="zoom:33%;" />

<img src="image/redis.assets/image-20230404161732069.png" alt="image-20230404161732069" style="zoom:33%;" />

![image-20230404161745126](image/redis.assets/image-20230404161745126.png)

<img src="image/redis.assets/image-20230404161818052.png" alt="image-20230404161818052" style="zoom:50%;" />

<img src="image/redis.assets/image-20230404161917970.png" alt="image-20230404161917970" style="zoom:50%;" />

**应用场景：微信公众号多关注订阅的文章**



## 2.4.3 Hash

![image-20230404163215501](image/redis.assets/image-20230404163215501.png)

![image-20230404163255796](image/redis.assets/image-20230404163255796.png)

<img src="image/redis.assets/image-20230404163657688.png" alt="image-20230404163657688" style="zoom:50%;" />

**现版本hset == hmset，hmset已经被弃用**

<img src="image/redis.assets/image-20230404163752325.png" alt="image-20230404163752325" style="zoom:50%;" />

**hgetall相当于遍历**

![image-20230404164031407](image/redis.assets/image-20230404164031407.png)

<img src="image/redis.assets/image-20230404164110523.png" alt="image-20230404164110523" style="zoom:50%;" />

![image-20230404164122328](image/redis.assets/image-20230404164122328.png)

<img src="image/redis.assets/image-20230404164307732.png" alt="image-20230404164307732" style="zoom:50%;" />

![image-20230404164316473](image/redis.assets/image-20230404164316473.png)

<img src="image/redis.assets/image-20230404164500816.png" alt="image-20230404164500816" style="zoom:50%;" />

![image-20230404164513482](image/redis.assets/image-20230404164513482.png)

<img src="image/redis.assets/image-20230404164646512.png" alt="image-20230404164646512" style="zoom:50%;" />

<img src="image/redis.assets/image-20230404164705975.png" alt="image-20230404164705975" style="zoom:50%;" />

![image-20230404165057936](image/redis.assets/image-20230404165057936.png)

<img src="image/redis.assets/image-20230404165134941.png" alt="image-20230404165134941" style="zoom:50%;" />

![image-20230404170156044](image/redis.assets/image-20230404170156044.png)

<img src="image/redis.assets/image-20230404170224054.png" alt="image-20230404170224054" style="zoom: 33%;" />

<img src="image/redis.assets/image-20230404170246406.png" alt="image-20230404170246406" style="zoom:33%;" />

## 2.4.4 Set（无序且不重复）

**![](image/redis.assets/image-20230404171056476.png)*

![image-20230404171209171](image/redis.assets/image-20230404171209171.png)

<img src="image/redis.assets/image-20230404171217306.png" alt="image-20230404171217306" style="zoom:50%;" />

**smembers key 相当于遍历**

![image-20230404171306420](image/redis.assets/image-20230404171306420.png)

<img src="image/redis.assets/image-20230404171256573.png" alt="image-20230404171256573" style="zoom:50%;" />

![image-20230404171510161](image/redis.assets/image-20230404171510161.png)

<img src="image/redis.assets/image-20230404171736588.png" alt="image-20230404171736588" style="zoom:50%;" />

![image-20230404171844719](image/redis.assets/image-20230404171844719.png)

<img src="image/redis.assets/image-20230404171956252.png" alt="image-20230404171956252" style="zoom:33%;" />

<img src="image/redis.assets/image-20230404172014454.png" alt="image-20230404172014454" style="zoom:33%;" />

![image-20230404172023254](image/redis.assets/image-20230404172023254.png)

<img src="image/redis.assets/image-20230404172121348.png" alt="image-20230404172121348" style="zoom:50%;" />

**![image-20230404172246329](image/redis.assets/image-20230404172246329.png)*

![image-20230404172344442](image/redis.assets/image-20230404172344442.png)

<img src="image/redis.assets/image-20230404172351483.png" alt="image-20230404172351483" style="zoom: 50%;" />

![image-20230404172404918](image/redis.assets/image-20230404172404918.png)

<img src="image/redis.assets/image-20230404172417627.png" alt="image-20230404172417627" style="zoom:50%;" />

![image-20230404172428866](image/redis.assets/image-20230404172428866.png)

![image-20230404172620915](image/redis.assets/image-20230404172620915.png)

<img src="image/redis.assets/image-20230404172756269.png" alt="image-20230404172756269" style="zoom:50%;" />

![image-20230404173028170](image/redis.assets/image-20230404173028170.png)

<img src="image/redis.assets/image-20230404173040632.png" alt="image-20230404173040632" style="zoom: 25%;" />

<img src="image/redis.assets/image-20230404173548221.png" alt="image-20230404173548221" style="zoom:25%;" />

<img src="image/redis.assets/image-20230404173644203.png" alt="image-20230404173644203" style="zoom:33%;" />

## 2.4.5 Zset(sorted set)

![image-20230404174827874](image/redis.assets/image-20230404174827874.png)

![image-20230404182213058](image/redis.assets/image-20230404182213058.png)



![image-20230404175144751](image/redis.assets/image-20230404175144751.png)

<img src="image/redis.assets/image-20230404175009934.png" alt="image-20230404175009934" style="zoom: 33%;" />

<img src="image/redis.assets/image-20230404175122275.png" alt="image-20230404175122275" style="zoom: 50%;" />

![image-20230404175321184](image/redis.assets/image-20230404175321184.png)

<img src="image/redis.assets/image-20230404175334432.png" alt="image-20230404175334432" style="zoom:33%;" />

<img src="image/redis.assets/image-20230404175749802.png" alt="image-20230404175749802" style="zoom: 33%;" />

![image-20230404180040229](image/redis.assets/image-20230404180040229.png)

<img src="image/redis.assets/image-20230404180050914.png" alt="image-20230404180050914" style="zoom:50%;" />

![image-20230404180059802](image/redis.assets/image-20230404180059802.png)

<img src="image/redis.assets/image-20230404180154881.png" alt="image-20230404180154881" style="zoom:50%;" />

![image-20230404180204980](image/redis.assets/image-20230404180204980.png)

<img src="image/redis.assets/image-20230404180252285.png" alt="image-20230404180252285" style="zoom:50%;" />

![image-20230404180335624](image/redis.assets/image-20230404180335624.png)

<img src="image/redis.assets/image-20230404180441994.png" alt="image-20230404180441994" style="zoom:33%;" />

![image-20230404180530928](image/redis.assets/image-20230404180530928.png)

<img src="image/redis.assets/image-20230404180542323.png" alt="image-20230404180542323" style="zoom:50%;" />

![image-20230404180602183](image/redis.assets/image-20230404180602183.png)

<img src="image/redis.assets/image-20230404180840261.png" alt="image-20230404180840261" style="zoom:33%;" />

![image-20230404180917807](image/redis.assets/image-20230404180917807.png)

<img src="image/redis.assets/image-20230404181107403.png" alt="image-20230404181107403" style="zoom: 50%;" />

![image-20230404181333071](image/redis.assets/image-20230404181333071.png)

<img src="image/redis.assets/image-20230404181315571.png" alt="image-20230404181315571" style="zoom: 25%;" />

## 2.4.6 bitmap（位图）--string

![image-20230404193548268](image/redis.assets/image-20230404193548268.png)

**bitmap 相当于string的子类，type bit 的返回值为string**

<img src="image/redis.assets/image-20230404193729538.png" alt="image-20230404193729538" style="zoom:50%;" />

<img src="image/redis.assets/image-20230404193706412.png" alt="image-20230404193706412" style="zoom:50%;" />

![image-20230404193815527](image/redis.assets/image-20230404193815527.png)

<img src="image/redis.assets/image-20230404193918746.png" alt="image-20230404193918746" style="zoom: 33%;" />

![image-20230404194130392](image/redis.assets/image-20230404194130392.png)

<img src="image/redis.assets/image-20230404194243814.png" alt="image-20230404194243814" style="zoom:50%;" />

![image-20230404194221167](image/redis.assets/image-20230404194221167.png)

<img src="image/redis.assets/image-20230404194317163.png" alt="image-20230404194317163" style="zoom: 33%;" />

**每八位一组，一组是一个字节，strlen返回的是字节数**

![image-20230404194520508](image/redis.assets/image-20230404194520508.png)

<img src="image/redis.assets/image-20230404194542795.png" alt="image-20230404194542795" style="zoom: 50%;" />

<img src="image/redis.assets/image-20230404194808845.png" alt="image-20230404194808845" style="zoom: 80%;" />

![image-20230404195616077](image/redis.assets/image-20230404195616077.png)

![image-20230404195544962](image/redis.assets/image-20230404195544962.png)

<img src="image/redis.assets/image-20230404195416531.png" alt="image-20230404195416531" style="zoom: 33%;" />

![image-20230404195952350](image/redis.assets/image-20230404195952350.png)

**签到天数**

<img src="image/redis.assets/image-20230404200137404.png" alt="image-20230404200137404" style="zoom:33%;" />



## 2.4.7 HyperLogLog（基数统计）--string

<img src="image/redis.assets/image-20230404202309445.png" alt="image-20230404202309445" style="zoom: 50%;" />

<img src="image/redis.assets/image-20230404201722609.png" alt="image-20230404201722609" style="zoom:50%;" />

<img src="image/redis.assets/image-20230404201729369.png" alt="image-20230404201729369" style="zoom: 50%;" />

<img src="image/redis.assets/image-20230404202514808.png" alt="image-20230404202514808" style="zoom: 33%;" />

<img src="image/redis.assets/image-20230404202707642.png" alt="image-20230404202707642" style="zoom: 67%;" />

<img src="image/redis.assets/image-20230404202750880.png" alt="image-20230404202750880" style="zoom:50%;" />

![image-20230404202919105](image/redis.assets/image-20230404202919105.png)

## 2.4.8 GEO（地理空间）--zset

![image-20230404204809187](image/redis.assets/image-20230404204809187.png)

![image-20230404205224307](image/redis.assets/image-20230404205224307.png)

<img src="image/redis.assets/image-20230404205234321.png" alt="image-20230404205234321" style="zoom: 33%;" />

![image-20230404205529983](image/redis.assets/image-20230404205529983.png)

<img src="image/redis.assets/image-20230404205633619.png" alt="image-20230404205633619"  />

![image-20230404205732280](image/redis.assets/image-20230404205732280.png)

![image-20230404210047316](image/redis.assets/image-20230404210047316.png)

![image-20230404211347133](image/redis.assets/image-20230404211347133.png)

![image-20230404211518786](image/redis.assets/image-20230404211518786.png)

## 2.4.9 Stream（redis流）用于MQ

<img src="image/redis.assets/image-20230404213312159.png" alt="image-20230404213312159" style="zoom: 50%;" />

![image-20230404213756806](image/redis.assets/image-20230404213756806.png)

<img src="image/redis.assets/image-20230404213817188.png" alt="image-20230404213817188" style="zoom: 33%;" />

<img src="image/redis.assets/image-20230404213852193.png" alt="image-20230404213852193" style="zoom: 33%;" />

![image-20230404214147552](image/redis.assets/image-20230404214147552.png)

<img src="image/redis.assets/image-20230404214230187.png" alt="image-20230404214230187" style="zoom:50%;" />

<img src="image/redis.assets/image-20230404214641212.png" alt="image-20230404214641212" style="zoom:50%;" />

### 生产相关命令

<img src="image/redis.assets/image-20230404214802556.png" alt="image-20230404214802556" style="zoom:50%;" />

<img src="image/redis.assets/image-20230404221030749.png" alt="image-20230404221030749" style="zoom: 50%;" />

![image-20230405133621236](image/redis.assets/image-20230405133621236.png)

<img src="image/redis.assets/image-20230405133851521.png" alt="image-20230405133851521" style="zoom:50%;" />

<img src="image/redis.assets/image-20230405134309238.png" alt="image-20230405134309238" style="zoom:50%;" />

![image-20230405134411435](image/redis.assets/image-20230405134411435.png)

<img src="image/redis.assets/image-20230405134539497.png" alt="image-20230405134539497" style="zoom:33%;" />

![image-20230405134615310](image/redis.assets/image-20230405134615310.png)

<img src="image/redis.assets/image-20230405134629566.png" alt="image-20230405134629566" style="zoom:33%;" />

![image-20230405134736417](image/redis.assets/image-20230405134736417.png)

<img src="image/redis.assets/image-20230405134800206.png" alt="image-20230405134800206" style="zoom:50%;" />

<img src="image/redis.assets/image-20230405134813680.png" alt="image-20230405134813680" style="zoom: 80%;" />

![image-20230405134836892](image/redis.assets/image-20230405134836892.png)

<img src="image/redis.assets/image-20230405135127611.png" alt="image-20230405135127611" style="zoom: 33%;" />

<img src="image/redis.assets/image-20230405135019850.png" alt="image-20230405135019850" style="zoom: 33%;" />

![image-20230405135150439](image/redis.assets/image-20230405135150439.png)

<img src="image/redis.assets/image-20230405135516758.png" alt="image-20230405135516758" style="zoom: 33%;" />

<img src="image/redis.assets/image-20230405135613818.png" alt="image-20230405135613818" style="zoom:33%;" />

<img src="image/redis.assets/image-20230405135813755.png" alt="image-20230405135813755" style="zoom:33%;" />



### 消费相关命令

![image-20230405140112329](image/redis.assets/image-20230405140112329.png)

![image-20230405140209314](image/redis.assets/image-20230405140209314.png)

<img src="image/redis.assets/image-20230405140238202.png" alt="image-20230405140238202" style="zoom:33%;" />

![image-20230405140353249](image/redis.assets/image-20230405140353249.png)

<img src="image/redis.assets/image-20230405140736329.png" alt="image-20230405140736329" style="zoom:33%;" />

<img src="image/redis.assets/image-20230405140922357.png" alt="image-20230405140922357" style="zoom: 33%;" />

![image-20230405141112822](image/redis.assets/image-20230405141112822.png)

![image-20230405141506009](image/redis.assets/image-20230405141506009.png)

<img src="image/redis.assets/image-20230405141551701.png" alt="image-20230405141551701" style="zoom:50%;" />

<img src="image/redis.assets/image-20230405142023606.png" alt="image-20230405142023606" style="zoom:50%;" />

![image-20230405141818015](image/redis.assets/image-20230405141818015.png)

<img src="image/redis.assets/image-20230405142000116.png" alt="image-20230405142000116" style="zoom:50%;" />

![image-20230405142050646](image/redis.assets/image-20230405142050646.png)

<img src="image/redis.assets/image-20230405142109446.png" alt="image-20230405142109446" style="zoom:50%;" />

![image-20230405142211049](image/redis.assets/image-20230405142211049.png)



## 2.4.10 bitfield（位域）

<img src="image/redis.assets/image-20230405144707422.png" alt="image-20230405144707422" style="zoom:50%;" />

![image-20230405144851639](image/redis.assets/image-20230405144851639.png)

![image-20230405145226605](image/redis.assets/image-20230405145226605.png)

![image-20230405145236375](image/redis.assets/image-20230405145236375.png)

<img src="image/redis.assets/image-20230405145600229.png" alt="image-20230405145600229" style="zoom: 33%;" />

<img src="image/redis.assets/image-20230405153436277.png" alt="image-20230405153436277" style="zoom:50%;" />

<img src="image/redis.assets/image-20230405153853768.png" alt="image-20230405153853768" style="zoom:50%;" />

![image-20230405154832889](image/redis.assets/image-20230405154832889.png)

<img src="image/redis.assets/image-20230405155213731.png" alt="image-20230405155213731" style="zoom:50%;" />

<img src="image/redis.assets/image-20230405161058796.png" alt="image-20230405161058796" style="zoom:50%;" />

<img src="image/redis.assets/image-20230405161127243.png" alt="image-20230405161127243" style="zoom: 50%;" />



# 3、Redis持久化

![image-20230405161743958](image/redis.assets/image-20230405161743958.png)

![image-20230405161628794](image/redis.assets/image-20230405161628794.png)



## ==3.1 RDB（Redis Database）==

### 是什么（含6 7 自动触发区别）

![image-20230405161830350](image/redis.assets/image-20230405161830350.png)

<img src="image/redis.assets/image-20230405161835676.png" alt="image-20230405161835676" style="zoom:50%;" />

<img src="image/redis.assets/image-20230405162918429.png" alt="image-20230405162918429" style="zoom:50%;" />

<img src="image/redis.assets/image-20230405163104062.png" alt="image-20230405163104062" style="zoom:50%;" />

<img src="image/redis.assets/image-20230405163445841.png" alt="image-20230405163445841" style="zoom:50%;" />





### 自动触发

<img src="image/redis.assets/image-20230405163627189.png" alt="image-20230405163627189" style="zoom:50%;" />

**按上图修改配置**

save 5 2（现在已经设置为5秒两次）

dir /myredis/dumpfiles

dbfilename dump6379.rdb

![image-20230405195656003](image/redis.assets/image-20230405195656003.png)

![image-20230405195612851](image/redis.assets/image-20230405195612851.png)

**执行shutdown命令且没有开启AOF持久化也会生成dump文件**

![image-20230405195924064](image/redis.assets/image-20230405195924064.png)





### 手动触发（默认推荐使用DBSAVE，因为不会阻塞redis服务器）

![image-20230405201853548](image/redis.assets/image-20230405201853548.png)

**严禁使用save手动触发！！！**

![image-20230405202047053](image/redis.assets/image-20230405202047053.png)

![image-20230405202414292](image/redis.assets/image-20230405202414292.png)





### 优缺点

![image-20230405203410922](image/redis.assets/image-20230405203410922.png)

![image-20230405203520365](image/redis.assets/image-20230405203520365.png)

<img src="image/redis.assets/image-20230405203606972.png" alt="image-20230405203606972" style="zoom:50%;" />

![image-20230405203827514](image/redis.assets/image-20230405203827514.png)





### 修复RDB文件

使用在/usr/local/bin目录下的check-rdb，修复rdb文件

![image-20230405205319503](image/redis.assets/image-20230405205319503.png)





### RDB触发情况和快照禁用

![image-20230405205742570](image/redis.assets/image-20230405205742570.png)

![image-20230405210011878](image/redis.assets/image-20230405210011878.png)

<img src="image/redis.assets/image-20230405210056378.png" alt="image-20230405210056378" style="zoom: 50%;" />

**将save后写成空串，但还是可以手动触发生成rdb文件**





### redis数据库RDB和AOF配置，数据库备份的区别：

**一句话：AOF的优先级高于RDB**

**情况1：整个redis默认情况下，redis为不设置save参数且未开启了AOF持久化时，当shutdown时会生成一个有效dump文件，整个过程只能在shutdown时保存一个有效的dump文件，以至于下一次打开redis时可恢复数据**

**情况2：不设置save参数但是开启了AOF持久化时，以AOF为主，当shutdown时也会生成一个无效dump文件，备份数据库由AOF完成，若将AOF文件删除，数据库将无法完成备份**

**情况3：但是若将save 后写成空串，则是禁用所有dump文件的自动生成方式，shutdown时连空文件也不会生成，若开启了AOF，则可由AOF完成备份，若未开启AOF，则是纯缓存模式，则redis无法自动完成备份**

**情况4：设置了save参数以开启自动触发RDB，若未开启AOF，则由RDB独自完成备份，若开启了AOF且开启了混合模式，则由RDB和AOF混合完成备份，生成的AOF文件包括RDB头部和AOF混写，若未开启混合模式，则以AOF为主，AOF优先级高**





### 优化配置项（后四者都推荐默认）

![image-20230405210439775](image/redis.assets/image-20230405210439775.png)

<img src="image/redis.assets/image-20230405210531817.png" alt="image-20230405210531817" style="zoom:50%;" />

**若为yes，则数据一致性很高（建议默认yes）**



![image-20230405210654149](image/redis.assets/image-20230405210654149.png)

**推荐默认yes**



![image-20230405211009684](image/redis.assets/image-20230405211009684.png)

**推荐默认yes**



![image-20230405211123785](image/redis.assets/image-20230405211123785.png)

**推荐默认no**



### 小总结

<img src="image/redis.assets/image-20230405211326775.png" alt="image-20230405211326775" style="zoom:50%;" />





## ==3.2 AOF（Append Only File）==

### 是什么

![image-20230405211935077](image/redis.assets/image-20230405211935077.png)

![image-20230405213547778](image/redis.assets/image-20230405213547778.png)

**默认为关闭，可通过yes开启**





### AOF持久工作流程和三种写回策略（默认为everysec）

<img src="image/redis.assets/image-20230405212518162.png" alt="image-20230405212518162" style="zoom:50%;" />

**先保存在AOF缓存区，等达到一定数量后再写入AOF文件，减少IO次数**

![image-20230405213502389](image/redis.assets/image-20230405213502389.png)

![image-20230405213754559](image/redis.assets/image-20230405213754559.png)

![image-20230405213843436](image/redis.assets/image-20230405213843436.png)

![image-20230405213857279](image/redis.assets/image-20230405213857279.png)

<img src="image/redis.assets/image-20230405213638513.png" alt="image-20230405213638513" style="zoom:50%;" />

![image-20230405214050241](image/redis.assets/image-20230405214050241.png)





### 配置开启（含6 7aof保存路径、保存名称的区别）

![image-20230405215504057](image/redis.assets/image-20230405215504057.png)

![image-20230405215214769](image/redis.assets/image-20230405215214769.png)

![image-20230405215316036](image/redis.assets/image-20230405215316036.png)



++++





![image-20230405215521608](image/redis.assets/image-20230405215521608.png)



++++





![image-20230405215545871](image/redis.assets/image-20230405215545871.png)

![image-20230405215808682](image/redis.assets/image-20230405215808682.png)

![image-20230405220437485](image/redis.assets/image-20230405220437485.png)

**redis6：和RDB保存的位置相同**

**==redis7：会在RAB文件保存的位置上加上一个自己设定的appenddirname目录，保存在其中==**



++++



![image-20230405220449448](image/redis.assets/image-20230405220449448.png)

![image-20230405220900536](image/redis.assets/image-20230405220900536.png)

![image-20230405220601888](image/redis.assets/image-20230405220601888.png)

**redis6：只有一个aof文件**

**==redis7：aof文件被拆分为三个==**



<img src="image/redis.assets/image-20230405220920558.png" alt="image-20230405220920558" style="zoom:50%;" />





### 正常恢复

![image-20230405221343030](image/redis.assets/image-20230405221343030.png)

![image-20230406191559461](image/redis.assets/image-20230406191559461.png)

**不看rdb文件，把rdb文件全部删掉，可以证明只用aof文件也可以对redis数据库进行恢复**

**对于写操作，==是aof.incr在默默记录==，对于读操作，不会记录，大小不变**

<img src="image/redis.assets/image-20230406192008533.png" alt="image-20230406192008533"  />





### 异常恢复

![image-20230406192332377](image/redis.assets/image-20230406192332377.png)

![image-20230406194408184](image/redis.assets/image-20230406194408184.png)

**在aof.incr文件中故意写入乱码：**

**![image-20230406194651594](image/redis.assets/image-20230406194651594.png)**

**redis服务器启动不了**

**使用/usr/local/bin目录下的==redis-check-aof --fix==修复incr文件**

![image-20230406195245468](image/redis.assets/image-20230406195245468.png)





### 优缺点

![image-20230406195543939](image/redis.assets/image-20230406195543939.png)

![image-20230406200028100](image/redis.assets/image-20230406200028100.png)

![image-20230406195839056](image/redis.assets/image-20230406195839056.png)

![image-20230406195926135](image/redis.assets/image-20230406195926135.png)





### 重写机制

![image-20230406200319735](image/redis.assets/image-20230406200319735.png)

![image-20230406200337939](image/redis.assets/image-20230406200337939.png)

**当aof文件达到阈值时，自动触发**

**使用bgrewriteaof手动触发**



![image-20230406200549216](image/redis.assets/image-20230406200549216.png)

![image-20230406200450221](image/redis.assets/image-20230406200450221.png)





案例：

![image-20230406205204119](image/redis.assets/image-20230406205204119.png)

![image-20230406205256049](image/redis.assets/image-20230406205256049.png)

![image-20230406205311350](image/redis.assets/image-20230406205311350.png)

![image-20230406205340698](image/redis.assets/image-20230406205340698.png)





### 小总结

![image-20230406205535287](image/redis.assets/image-20230406205535287.png)

![image-20230406205656264](image/redis.assets/image-20230406205656264.png)





## 3.3 RDB-AOF混合持久化

![image-20230406210824682](image/redis.assets/image-20230406210824682.png)

![image-20230406210206899](image/redis.assets/image-20230406210206899.png)

![image-20230406210125216](image/redis.assets/image-20230406210125216.png)

**可以共存，但AOF优先级高于RDB**

![image-20230406210220048](image/redis.assets/image-20230406210220048.png)

![image-20230406210429725](image/redis.assets/image-20230406210429725.png)

![image-20230406210504894](image/redis.assets/image-20230406210504894.png)

![image-20230406210608955](image/redis.assets/image-20230406210608955.png)



![image-20230406210617243](image/redis.assets/image-20230406210617243.png)

![image-20230406210925750](image/redis.assets/image-20230406210925750.png)

![image-20230406210834433](image/redis.assets/image-20230406210834433.png)

### redis数据库RDB和AOF配置，数据库备份的区别：

==**一句话：AOF的优先级高于RDB==**

**情况1：整个redis默认情况下，redis为不设置save参数且未开启了AOF持久化时，当shutdown时会生成一个有效dump文件，整个过程只能在shutdown时保存一个有效的dump文件，以至于下一次打开redis时可恢复数据**

**情况2：不设置save参数但是开启了AOF持久化时，以AOF为主，当shutdown时也会生成一个无效dump文件，备份数据库由AOF完成，若将AOF文件删除，数据库将无法完成备份**

**情况3：但是若将save 后写成空串，则是禁用所有dump文件的自动生成方式，shutdown时连空文件也不会生成，若开启了AOF，则可由AOF完成备份，若未开启AOF，则是纯缓存模式，则redis无法自动完成备份**

**情况4：设置了save参数以开启自动触发RDB，若未开启AOF，则由RDB独自完成备份，若开启了AOF且开启了混合模式，则由RDB和AOF混合完成备份，生成的AOF文件包括RDB头部和AOF混写，若未开启混合模式，则以AOF为主，AOF优先级高**





## 3.4 纯缓存模式

![image-20230406211459344](image/redis.assets/image-20230406211459344.png)

![image-20230406211639486](image/redis.assets/image-20230406211639486.png)

**不影响手动备份！！！！！！！！！！！！！！！！**





# ==4、Redis事务==

![image-20230406213545815](image/redis.assets/image-20230406213545815.png)





## 4.1 Redis事务是什么，与数据库事务的对比

**==数据库事务：在一次跟数据库的连接会话当中，所有执行的SQL，要么一起成功，要么一起失败==**

**==原子性：一个事务中的所有操作要么全部成功，要么全部失败回滚，不能只执行其中的一部分操作==**

![image-20230406214148888](image/redis.assets/image-20230406214148888.png)

![image-20230406214330200](image/redis.assets/image-20230406214330200.png)

![image-20230406214351875](image/redis.assets/image-20230406214351875.png)

**Redis的事务只是能够==保证一组命令能够连续独占的执行，不会被其他命令插入，也不会被阻塞==，事务提交前任何命令都==不会被实际执行，即不涉及数据库事务的回滚操作，所以没有隔离级别，不保证原子性==(即不保证同时成功或同时失败，冤头债主)，只决定是否开始执行一组的全部指令**





## 4.2 怎么使用Redis事务

![image-20230406215728790](image/redis.assets/image-20230406215728790.png)





### 常用命令

![image-20230406215751030](image/redis.assets/image-20230406215751030.png)

### 正常执行

![image-20230406215854707](image/redis.assets/image-20230406215854707.png)

<img src="image/redis.assets/image-20230406220100279.png" alt="image-20230406220100279" style="zoom:50%;" />

### 放弃执行

![image-20230406220134672](image/redis.assets/image-20230406220134672.png)

<img src="image/redis.assets/image-20230406220206888.png" alt="image-20230406220206888" style="zoom:50%;" />

### 全体连坐（语法编译错误，该组命令全部被舍弃）

![image-20230406220552344](image/redis.assets/image-20230406220552344.png)

![image-20230406220526376](image/redis.assets/image-20230406220526376.png)

### 冤头债主（语法没错，编译时没检查出错误，对的命令执行，不对的不执行）

![image-20230406221001476](image/redis.assets/image-20230406221001476.png)

<img src="image/redis.assets/image-20230406220856366.png" alt="image-20230406220856366" style="zoom:50%;" />

<img src="image/redis.assets/image-20230406221021739.png" alt="image-20230406221021739" style="zoom:50%;" />

![image-20230406220829205](image/redis.assets/image-20230406220829205.png)

### watch监控（开启乐观锁）

![](image/redis.assets/image-20230406221419392.png)

![image-20230406221224677](image/redis.assets/image-20230406221224677.png)

![image-20230406221248353](image/redis.assets/image-20230406221248353.png)

**==Redis采用乐观锁，但必须要提交的版本大于当前版本才能执行==**

**watch key时，若其他客户端已对key进行修改，当前事务将会被打断，无效**

![image-20230406221547634](image/redis.assets/image-20230406221547634.png)

### unwatch

![image-20230406221911990](image/redis.assets/image-20230406221911990.png)





![image-20230406222014243](image/redis.assets/image-20230406222014243.png)

![image-20230406222325070](image/redis.assets/image-20230406222325070.png)



### 小总结

![image-20230406222053893](image/redis.assets/image-20230406222053893.png)





# 5、Redis管道

![image-20230408121329331](image/redis.assets/image-20230408121329331.png)

## 5.1 管道的由来，是什么

![image-20230408122015366](image/redis.assets/image-20230408122015366.png)

![image-20230408120938690](image/redis.assets/image-20230408120938690.png)

![image-20230408121039056](image/redis.assets/image-20230408121039056.png)

![image-20230408121112824](image/redis.assets/image-20230408121112824.png)





## ==5.2 管道的操作==

![image-20230408122353571](image/redis.assets/image-20230408122353571.png)

**在Linux窗口下，写好一个txt文件，用管道符执行该文件中的所有命令**



## 5.3 管道与原生批处理命令和事务的对比，使用注意事项

![image-20230408122448993](image/redis.assets/image-20230408122448993.png)

pipeline与原生批处理命令对比：

![image-20230408122740607](image/redis.assets/image-20230408122740607.png)

pipeline与事务对比：

![image-20230408122831546](image/redis.assets/image-20230408122831546.png)

使用pipeline注意事项：

![image-20230408123247953](image/redis.assets/image-20230408123247953.png)





# 6、Redis发布订阅（了解即可）

![image-20230408133106050](image/redis.assets/image-20230408133106050.png)

## 6.1 是什么

![image-20230408133137417](image/redis.assets/image-20230408133137417.png)

是stream的前身

## 6.2 能干嘛

![image-20230408133423825](image/redis.assets/image-20230408133423825.png)

![image-20230408133450828](image/redis.assets/image-20230408133450828.png)

## 6.3 常用命令

![image-20230408133534728](image/redis.assets/image-20230408133534728.png)

![image-20230408133710677](image/redis.assets/image-20230408133710677.png)

![image-20230408133853118](image/redis.assets/image-20230408133853118.png)

![image-20230408134016908](image/redis.assets/image-20230408134016908.png)

![image-20230408134039254](image/redis.assets/image-20230408134039254.png)

![image-20230408134105040](image/redis.assets/image-20230408134105040.png)

![image-20230408134158868](image/redis.assets/image-20230408134158868.png)

![image-20230408134400720](image/redis.assets/image-20230408134400720.png)



**演示：**

![image-20230408135504653](image/redis.assets/image-20230408135504653.png)

**psubscribe是订阅带有通配符*的频道**



**小总结：**

![image-20230408135955937](image/redis.assets/image-20230408135955937.png)





# 7、Redis主从复制

![image-20230408140117380](image/redis.assets/image-20230408140117380.png)

## 7.1 是什么、能干嘛

![image-20230408140207933](image/redis.assets/image-20230408140207933.png)

**==master以写为主，slave以读为主==**

![image-20230408140527803](image/redis.assets/image-20230408140527803.png)

<img src="image/redis.assets/image-20230408140537631.png" alt="image-20230408140537631" style="zoom:50%;" />





## 7.2 操作与操作命令

![image-20230408140713081](image/redis.assets/image-20230408140713081.png)

![image-20230408140751191](image/redis.assets/image-20230408140751191.png)



权限细节：

![image-20230408140848125](image/redis.assets/image-20230408140848125.png)

**==从机要设置masterauth来获得主机的许可==**



![image-20230408141303037](image/redis.assets/image-20230408141303037.png)

![image-20230408141419076](image/redis.assets/image-20230408141419076.png)

**手动给自己临时换一个主机**



![image-20230408141429591](image/redis.assets/image-20230408141429591.png)





## ==7.3 实操案例演示==

![image-20230408141558903](image/redis.assets/image-20230408141558903.png)

![image-20230408211647900](image/redis.assets/image-20230408211647900.png)



### 准备工作

<img src="image/redis.assets/image-20230408141742401.png" alt="image-20230408141742401" style="zoom:33%;" />

![image-20230408141618892](image/redis.assets/image-20230408141618892.png)

![image-20230408142229016](image/redis.assets/image-20230408142229016.png)







![image-20230408142241404](image/redis.assets/image-20230408142241404.png)

![image-20230408142459814](image/redis.assets/image-20230408142459814.png)

![image-20230408142533115](image/redis.assets/image-20230408142533115.png)

**==配主不配从==**



### 配置细节

![image-20230408143002113](image/redis.assets/image-20230408143002113.png)

![image-20230408143127271](image/redis.assets/image-20230408143127271.png)



**==主机只配前十步，从机需要配第十一步==**

从机配置replicaof和masterauth



dump文件名为dump6379.rdb

log文件名为6379.log





### ==一主二仆实现==

#### 配置文件写死情况

![image-20230408155758562](image/redis.assets/image-20230408155758562.png)

**==先开主机，再开从机==**

**==从机启动时，一定要指明端口，否则默认为6379==**

![image-20230410192559543](image/redis.assets/image-20230410192559543.png)



![image-20230408160528137](image/redis.assets/image-20230408160528137.png)

主机日志

![image-20230408160204938](image/redis.assets/image-20230408160204938.png)

备机日志

![image-20230408160401834](image/redis.assets/image-20230408160401834.png)



**使用info  replication命令查看主从关系**

<img src="image/redis.assets/image-20230408160618114.png" alt="image-20230408160618114" style="zoom:50%;" />



#### 主从问题演示（配置写死）

![image-20230408161138030](image/redis.assets/image-20230408161138030.png)

![image-20230408160949114](image/redis.assets/image-20230408160949114.png)

**==从机不可以执行写命令，读写分离==**



![image-20230408161017451](image/redis.assets/image-20230408161017451.png)

**==可以跟上，首次开机全部复制==**



![image-20230408161536521](image/redis.assets/image-20230408161536521.png)

**==主机shutdown过后，从机原地待命==**



![image-20230408161735149](image/redis.assets/image-20230408161735149.png)

**==关系依旧==**



![image-20230408161801434](image/redis.assets/image-20230408161801434.png)

**==和问题2一样，可以跟上==**



#### 命令操作手动指定情况

![image-20230408161947054](image/redis.assets/image-20230408161947054.png)

**==从机重启过后，关系不在了==**



![image-20230408162719965](image/redis.assets/image-20230408162719965.png)



### 薪火相传实现

**![image-20230408211712851](image/redis.assets/image-20230408211712851.png)*

<img src="image/redis.assets/image-20230408211751697.png" alt="image-20230408211751697" style="zoom: 33%;" />

**==slave6380还是不能写操作==**





### 反客为主实现

![image-20230408212547621](image/redis.assets/image-20230408212547621.png)





## ==7.4 复制原理和工作流程总结==

![image-20230408212807487](image/redis.assets/image-20230408212807487.png)

![image-20230408212925378](image/redis.assets/image-20230408212925378.png)

![image-20230408212951325](image/redis.assets/image-20230408212951325.png)



**首次连接，全量复制：**

![](image/redis.assets/image-20230408213021098.png)



![image-20230408213457007](image/redis.assets/image-20230408213457007.png)

![image-20230408213503623](image/redis.assets/image-20230408213503623.png)



![image-20230408213546586](image/redis.assets/image-20230408213546586.png)



![image-20230408213617020](image/redis.assets/image-20230408213617020.png)





## 7.5 主从复制缺点

![image-20230408214049921](image/redis.assets/image-20230408214049921.png)

![image-20230408214109882](image/redis.assets/image-20230408214109882.png)



![image-20230408214339860](image/redis.assets/image-20230408214339860.png)

![image-20230408214647487](image/redis.assets/image-20230408214647487.png)



引入哨兵和集群进行改进





# 8、Redis哨兵监控

![image-20230408214830459](image/redis.assets/image-20230408214830459.png)

## 8.1 是什么、能干嘛

![image-20230408215731885](image/redis.assets/image-20230408215731885.png)

![image-20230408215802828](image/redis.assets/image-20230408215802828.png)

![image-20230408220023357](image/redis.assets/image-20230408220023357.png)





## ==8.2 操作与案例==

![image-20230408220452407](image/redis.assets/image-20230408220452407.png)



### 准备工作

**Redis Sentinel架构，前提说明**

![image-20230408221206785](image/redis.assets/image-20230408221206785.png)

![image-20230408224401749](image/redis.assets/image-20230408224401749.png)

**至少需要三台哨兵，因为网络抖动等等原因，可能造成哨兵down机，并且需要多台哨兵进行投票选取新的master**



### 配置细节

![image-20230408224809355](image/redis.assets/image-20230408224809355.png)



<img src="image/redis.assets/image-20230408225425792.png" alt="image-20230408225425792" style="zoom: 25%;" />

黑字和之前的一样配置



![image-20230409153923243](image/redis.assets/image-20230409153923243.png)

**==quorum参数：法定票数==**

![image-20230408225558891](image/redis.assets/image-20230408225558891.png)

![image-20230409153549805](image/redis.assets/image-20230409153549805.png)

![image-20230409153638060](image/redis.assets/image-20230409153638060.png)

**==至少要有quorum个sentinel认为master有故障，才会进行下线和故障转移==**



**设置哨兵连接master的密码**

![image-20230409153950260](image/redis.assets/image-20230409153950260.png)



其他参数：（用默认即可）

![image-20230409154146355](image/redis.assets/image-20230409154146355.png)





### 本次案例sentinel 文件通用配置

![image-20230409154450472](image/redis.assets/image-20230409154450472.png)

![image-20230409154511552](image/redis.assets/image-20230409154511552.png)



**将三个sentinel端口.conf配置文件如下格式写好**

![image-20230409154740426](image/redis.assets/image-20230409154740426.png)

![image-20230409155150040](image/redis.assets/image-20230409155150040.png)

自己的：

![image-20230409160326358](image/redis.assets/image-20230409160326358.png)





### 哨兵集群启动

#### 一主二从启动

![image-20230409160502282](image/redis.assets/image-20230409160502282.png)

**==从机启动时，一定要指明端口，否则默认为6379==**

![image-20230410192559543](image/redis.assets/image-20230410192559543.png)

![image-20230409160517691](image/redis.assets/image-20230409160517691.png)

![image-20230409160537725](image/redis.assets/image-20230409160537725.png)

**==前面主从复制的时候，master的redis6379.conf不用设置masterauth，但是这里要设置新主机的密码，因为此时主机可能变从机，推荐所有密码都设为一致，避免报错==**

![image-20230409161059750](image/redis.assets/image-20230409161059750.png)

![image-20230409161732939](image/redis.assets/image-20230409161732939.png)



![image-20230409161948018](image/redis.assets/image-20230409161948018.png)



#### 哨兵启动

![image-20230409162303680](image/redis.assets/image-20230409162303680.png)

**==在同一个终端下启动三个哨兵（实际应用都是一台主机一个哨兵）==**

![image-20230409162317618](image/redis.assets/image-20230409162317618.png)

![image-20230409162408724](image/redis.assets/image-20230409162408724.png)

![image-20230409162915334](image/redis.assets/image-20230409162915334.png)





==sentinel日志文件：==

![image-20230410195557845](image/redis.assets/image-20230410195557845.png)

![image-20230410195522975](image/redis.assets/image-20230410195522975.png)





**==哨兵启动后，会在各自的sentinel.conf配置文件中自动追加重写一些信息，与其生成的log文件相对应==**

例如自己的id，监控的master是谁，slave有哪些，哨兵集群中其他的哨兵是谁

![image-20230410200005543](image/redis.assets/image-20230410200005543.png)





### master挂了，含问题思考

![image-20230409164303693](image/redis.assets/image-20230409164303693.png)

![image-20230409164637286](image/redis.assets/image-20230409164637286.png)

**==1、从机数据OK，只是要等sentinel进行投票选举，master刚挂时可能会提醒断开连接==**

**==2、会从剩下的两台机器上选出新的master==**

**==3、重启后，将会变成slave，6379下位后，会自动向其redis6379.conf最后追加重写一些内容==**

![image-20230409170647296](image/redis.assets/image-20230409170647296.png)

<img src="image/redis.assets/image-20230409170826523.png" alt="image-20230409170826523" style="zoom: 33%;" />

![image-20230409170655715](image/redis.assets/image-20230409170655715.png)

![image-20230409171113649](image/redis.assets/image-20230409171113649.png)



### ==master挂后配置文件的改变==

![image-20230409173948430](image/redis.assets/image-20230409173948430.png)

![image-20230409174348692](image/redis.assets/image-20230409174348692.png)

**==哨兵启动后，会在各自的sentinel.conf配置文件中自动追加重写一些信息，与其生成的log文件相对应==**

例如自己的id，监控的master是谁，slave有哪些，哨兵集群中其他的哨兵是谁

![image-20230410200005543](image/redis.assets/image-20230410200005543.png)



**==6379下位后开机，会自动向其redis6379.conf最后追加重写一些内容==**

![image-20230409171519355](image/redis.assets/image-20230409171519355.png)



**==主从切换后，之前哨兵启动时往sentinel追加的信息也会相应的发生该变，因为主从关系变了==**



![image-20230409205846099](image/redis.assets/image-20230409205846099.png)



## ==8.3 哨兵故障转移运行流程==

![image-20230409205940971](image/redis.assets/image-20230409205940971.png)

**==建议sentinel采取奇数台，防止某一台sentinel无法连接到master导致误切换==**

![image-20230409210441156](image/redis.assets/image-20230409210441156.png)

### Sdown主观下线

![image-20230409210637243](image/redis.assets/image-20230409210637243.png)

![image-20230409210809009](image/redis.assets/image-20230409210809009.png)

### Odown客观下线

![image-20230409211028803](image/redis.assets/image-20230409211028803.png)

![image-20230409211042076](image/redis.assets/image-20230409211042076.png)



### Raft算法选举出领导者哨兵（兵王）

![image-20230409212402031](image/redis.assets/image-20230409212402031.png)

![image-20230409213142631](image/redis.assets/image-20230409213142631.png)

**简单了解Raft算法**

![image-20230409220651126](image/redis.assets/image-20230409220651126.png)



### ==兵王选出新master（含选举算法）==

![image-20230409221052860](image/redis.assets/image-20230409221052860.png)

**新主登基**

![image-20230409221634107](image/redis.assets/image-20230409221634107.png)

![image-20230409221858246](image/redis.assets/image-20230409221858246.png)

<img src="image/redis.assets/image-20230409221927353.png" alt="image-20230409221927353" style="zoom:33%;" />

**==选举算发：优先级--> offset--> RunID==**

<img src="image/redis.assets/image-20230409221724624.png" alt="image-20230409221724624" style="zoom: 25%;" />



**群臣俯首**

![image-20230409222227063](image/redis.assets/image-20230409222227063.png)



**旧主拜服**

![image-20230409222345404](image/redis.assets/image-20230409222345404.png)

**小总结**

![image-20230409222418931](image/redis.assets/image-20230409222418931.png)

![image-20230409222446305](image/redis.assets/image-20230409222446305.png)



## 8.4 哨兵使用建议与缺点

![image-20230409222956031](image/redis.assets/image-20230409222956031.png)

**==建议sentinel采取奇数台，防止某一台sentinel无法连接到master导致误切换==**

**主从 + 哨兵也不能保证数据零丢失，所以引出集群**





# ==9、Redis集群分片==

![image-20230410212906598](image/redis.assets/image-20230410212906598.png)

![image-20230410212814102](image/redis.assets/image-20230410212814102.png)

## 9.1 是什么、能干嘛

![image-20230410213205105](image/redis.assets/image-20230410213205105.png)

![image-20230410213216449](image/redis.assets/image-20230410213216449.png)

![image-20230410213403087](image/redis.assets/image-20230410213403087.png)

**==不用再使用哨兵，只需链接任意一个集群中的可用2节点即可，master之间数据共享，但是不保证强一致性==**





## ==9.2 集群算法-分片-槽位slot==

![image-20230410214145186](image/redis.assets/image-20230410214145186.png)

![image-20230410214309164](image/redis.assets/image-20230410214309164.png)

**==被分为16384个槽，有效设置了16384个主节点的集群大小上限，但是建议最大节点大小约为1000个节点==**



### 槽位slot

![image-20230410214525181](image/redis.assets/image-20230410214525181.png)

### 分片和它的优势

![image-20230410214751714](image/redis.assets/image-20230410214751714.png)

![image-20230410215136036](image/redis.assets/image-20230410215136036.png)





### 槽位映射算法

![image-20230410215439039](image/redis.assets/image-20230410215439039.png)

#### 哈希取余分区

![image-20230410220439769](image/redis.assets/image-20230410220439769.png)

![image-20230410220754453](image/redis.assets/image-20230410220754453.png)

![image-20230410220747234](image/redis.assets/image-20230410220747234.png)



#### 一致性哈希算法分区

<img src="image/redis.assets/image-20230410220940292.png" alt="image-20230410220940292" style="zoom:33%;" />

![image-20230410220841456](image/redis.assets/image-20230410220841456.png)

![image-20230410220905305](image/redis.assets/image-20230410220905305.png)

![image-20230410220924182](image/redis.assets/image-20230410220924182.png)



**算法构建一致性哈希环**

![image-20230410221104902](image/redis.assets/image-20230410221104902.png)



**服务器IP节点映射**

节点：redis服务器

![image-20230410221419152](image/redis.assets/image-20230410221419152.png)



**key落到服务器的落键规则**

![image-20230410221816579](image/redis.assets/image-20230410221816579.png)

![image-20230410221710199](image/redis.assets/image-20230410221710199.png)



![image-20230410221938760](image/redis.assets/image-20230410221938760.png)

![image-20230410222014396](image/redis.assets/image-20230410222014396.png)

![image-20230410222039801](image/redis.assets/image-20230410222039801.png)

![image-20230410222146248](image/redis.assets/image-20230410222146248.png)





![image-20230410222213891](image/redis.assets/image-20230410222213891.png)

![image-20230410222156798](image/redis.assets/image-20230410222156798.png)

![image-20230410222256716](image/redis.assets/image-20230410222256716.png)





#### ==哈希槽分区==

![image-20230410222419545](image/redis.assets/image-20230410222419545.png)

![image-20230410222814597](image/redis.assets/image-20230410222814597.png)

![image-20230410222915337](image/redis.assets/image-20230410222915337.png)





### ==为什么最大槽数是16384==

![image-20230410223424858](image/redis.assets/image-20230410223424858.png)

![image-20230410223513872](image/redis.assets/image-20230410223513872.png)

![image-20230410223538678](image/redis.assets/image-20230410223538678.png)

![image-20230410223650056](image/redis.assets/image-20230410223650056.png)

**==（1）65536消息头太大==**

![image-20230410223821799](image/redis.assets/image-20230410223821799.png)

**==（2）1000以内节点16384个槽够用了，不易造成网络拥堵==**

![image-20230410223913265](image/redis.assets/image-20230410223913265.png)

**==（3）在节点少的情况下，即小型集群中，因为填充率为slots/N，若采用65536的话，填充率将会很高，压缩比将会很低，不容易传输，但是采用16384的话，填充率低一些，压缩比将会高很多，容易传输些==**





### 不保证强一致性

![image-20230410230449517](image/redis.assets/image-20230410230449517.png)





## ==9.3 三主三从集群搭建==

![image-20230411155840013](image/redis.assets/image-20230411155840013.png)

### ==3主3从redis集群配置==

![image-20230411160032970](image/redis.assets/image-20230411160032970.png)



#### 新建6台独立的redis实例服务

![image-20230411160402336](image/redis.assets/image-20230411160402336.png)

 

![image-20230411160420264](image/redis.assets/image-20230411160420264.png)



![image-20230411160526569](image/redis.assets/image-20230411160526569.png)

**==相比主从复制，只写了masterauth，没有写replicaof==**

bind 0.0.0.0
daemonize yes
protected-mode no
port 6381
logfile "/myredis/cluster/cluster6381.log"
pidfile /myredis/cluster6381.pid
dir /myredis/cluster
dbfilename dump6381.rdb
appendonly yes
appendfilename "appendonly6381.aof"
requirepass xxxxxxxxxxxxxx@
masterauth xxxxxxxxxxxxxx@
cluster-enabled yes
cluster-config-file nodes-6381.conf
cluster-node-timeout 5000

![image-20230411161810076](image/redis.assets/image-20230411161810076.png)

**==这里只需启动redis-server==**



####  redis-cli为6台机器构建集群关系

![image-20230411185514494](image/redis.assets/image-20230411185514494.png)

![image-20230411185526464](image/redis.assets/image-20230411185526464.png)

**==redis-cli语句如下==**，并没有打开客户端，只是构建了集群

```
redis-cli -a 111111 --cluster create --cluster-replicas 1 192.168.111.185:6381 192.168.111.185:6382 192.168.111.172:6383 192.168.111.172:6384 192.168.111.184:6385 192.168.111.184:6386
```

![image-20230411190221954](image/redis.assets/image-20230411190221954.png)

**==主从关系是随机分配的==**

![image-20230411190310678](image/redis.assets/image-20230411190310678.png)

**集群启动后会产生nodes开头的文件**

![image-20230411191114952](image/redis.assets/image-20230411191114952.png)



#### redis-cli打开6381客户端为切入点，查看并检验集群的状态

![image-20230411191320016](image/redis.assets/image-20230411191320016.png)

**==再使用redis-cli打开6381的客服端，记得指明端口==**



**==根据下面的读写测试，这里加一个-c，表示路由==**

```
redis-cli -a 111111 -p 6381 -c
```

![image-20230411191329641](image/redis.assets/image-20230411191329641.png)

**可以使用==info replication==和==cluster ndoes== 命令来查看**

![image-20230411191816166](image/redis.assets/image-20230411191816166.png)





### 3主3从集群读写

![image-20230411192632504](image/redis.assets/image-20230411192632504.png)



![image-20230411192718591](image/redis.assets/image-20230411192718591.png)

![image-20230411192618705](image/redis.assets/image-20230411192618705.png)



![image-20230411192824959](image/redis.assets/image-20230411192824959.png)

![image-20230411192808854](image/redis.assets/image-20230411192808854.png)



![image-20230411192820642](image/redis.assets/image-20230411192820642.png)

```
redis-cli -a 111111 -p 6381 -c
```

![image-20230411193152962](image/redis.assets/image-20230411193152962.png)

![image-20230411193554765](image/redis.assets/image-20230411193554765.png)

![image-20230411192830986](image/redis.assets/image-20230411192830986.png)

![image-20230411193252458](image/redis.assets/image-20230411193252458.png)

![image-20230411192836243](image/redis.assets/image-20230411192836243.png)

```
cluster keyslot k1
```

![image-20230411193328906](image/redis.assets/image-20230411193328906.png)





### 主从容错切换迁移案例(即一个master宕机)、不保证强一致性、节点从属调整(手动恢复6381master身份)

![image-20230411193727209](image/redis.assets/image-20230411193727209.png)



**容错切换迁移**

![image-20230411193812792](image/redis.assets/image-20230411193812792.png)

![image-20230411193846054](image/redis.assets/image-20230411193846054.png)

![image-20230411194103431](image/redis.assets/image-20230411194103431.png)

**==master宕机后，其真实从机上位==**

![image-20230411194132853](image/redis.assets/image-20230411194132853.png)



![image-20230411194731132](image/redis.assets/image-20230411194731132.png)

**==6381变成slave==**

![image-20230411194738722](image/redis.assets/image-20230411194738722.png)





**redis集群不保证强一致性**

![image-20230411194830000](image/redis.assets/image-20230411194830000.png)

![image-20230411194936604](image/redis.assets/image-20230411194936604.png)





**手动故障转移（节点从属调整：恢复6381master身份）**

![image-20230411195121396](image/redis.assets/image-20230411195121396.png)

![image-20230411195833357](image/redis.assets/image-20230411195833357.png)

```
cluster failover
```

![image-20230411195821023](image/redis.assets/image-20230411195821023.png)





### ==主从扩容==

![image-20230411200141308](image/redis.assets/image-20230411200141308.png)



**主从扩容全部命令总结：**

```shell
redis-server /myredis/cluster/redisCluster6387.conf		#启动6387server

redis-server /myredis/cluster/redisCluster6388.conf		#启动6388server

redis-cli -a 111111 --cluster add-node 192.168.111.100:6387 192.168.111.100:6381	
#将6387作为新的master加入集群，6381为引荐人

redis-cli -a 111111 --cluster check 192.168.111.100:6381	#第一次检查

redis-cli -a 111111 --cluster reshard 192.168.111.100:6381		#给6387分配slot

redis-cli -a 111111 --cluster check 192.168.111.100:6381		#第二次检查

redis-cli -a 111111 --cluster add-node 192.168.111.100:6388 192.168.111.100:6387 --cluster-slave --cluster-master-id xxxxxxxxxxxxxxxxxxxxx(6387id)
#让6388成为6387的从节点

redis-cli -a 111111 --cluster check 192.168.111.100:6381		#第三c
```



![image-20230411200238386](image/redis.assets/image-20230411200238386.png)



![image-20230411200258446](image/redis.assets/image-20230411200258446.png)

![image-20230411200308296](image/redis.assets/image-20230411200308296.png)



![image-20230411200329974](image/redis.assets/image-20230411200329974.png)

**==redis-cli -a 111111 --cluster add-node 192.168.111.100:6387 192.168.111.100:6381==**

![image-20230411200344808](image/redis.assets/image-20230411200344808.png)



![image-20230411200528594](image/redis.assets/image-20230411200528594.png)

**==redis-cli -a 111111 --cluster check 192.168.111.100:6381==**

![image-20230411200541581](image/redis.assets/image-20230411200541581.png)



![image-20230411200801940](image/redis.assets/image-20230411200801940.png)

**==redis-cli -a 111111 --cluster reshard 192.168.111.100:6381==**

![image-20230411200820289](image/redis.assets/image-20230411200820289.png)

![image-20230411201047651](image/redis.assets/image-20230411201047651.png)



![image-20230411201336969](image/redis.assets/image-20230411201336969.png)

**==6387的slot槽是从其他三家匀过来的==**

![image-20230411201409810](image/redis.assets/image-20230411201409810.png)



![image-20230411201212167](image/redis.assets/image-20230411201212167.png)

**==redis-cli -a 111111 --cluster check 192.168.111.100:6381==**

![image-20230411201236370](image/redis.assets/image-20230411201236370.png)



![image-20230411201435700](image/redis.assets/image-20230411201435700.png)

**==redis-cli -a 111111 --cluster add-node 192.168.111.100:6388 192.168.111.100:6387 --cluster-slave --cluster-master-id xxxxxxxxxxxxxxxxx(6387的id)==**

**==redis-cli -a 111111 --cluster add-node 192.168.111.100:6387 192.168.111.100:6381==**

![image-20230411201451758](image/redis.assets/image-20230411201451758.png)



![image-20230411201754433](image/redis.assets/image-20230411201754433.png)

**==redis-cli -a 111111 --cluster check 192.168.111.100:6381==**

![image-20230411201804991](image/redis.assets/image-20230411201804991.png)





### ==主从缩容==

![image-20230411212355577](image/redis.assets/image-20230411212355577.png)

![image-20230411212210424](image/redis.assets/image-20230411212210424.png)



**主从缩容全部命令总结：**

```shell
redis-cli -a 111111 --cluster check 192.168.111.100:6388	#获得6388的ID
redis-cli -a 111111 --cluster del-node 192.168.111.100:6388 xxxxxxxx(6388id)  #删除6388
redis-cli -a 111111 --cluster reshard 192.168.111.100:6381    #把6387的slot都给6381
redis-cli -a 111111 --cluster check 192.168.111.100:6381    #第二次检查
redis-cli -a 111111 --cluster del-node 192.168.111.100:6387 xxxxxxxx(6387id)  #删除6387
redis-cli -a 111111 --cluster check 192.168.111.100:6381	#第三次检查
```





![image-20230411212229950](image/redis.assets/image-20230411212229950.png)

```
redis-cli -a 111111 --cluster check 192.168.111.100:6388
```

![image-20230411212239192](image/redis.assets/image-20230411212239192.png)



![image-20230411212325608](image/redis.assets/image-20230411212325608.png)

```
redis-cli -a 111111 --cluster del-node 192.168.111.100:6388 xxxxxxxxxxxxxxxxx(6388id)
```

![image-20230411212426831](image/redis.assets/image-20230411212426831.png)



![image-20230411212527893](image/redis.assets/image-20230411212527893.png)

```
redis-cli -a 111111 --cluster reshard 192.168.111.100:6381
```

![image-20230411212614682](image/redis.assets/image-20230411212614682.png)

![image-20230411212639959](image/redis.assets/image-20230411212639959.png)



![image-20230411212825431](image/redis.assets/image-20230411212825431.png)

```
redis-cli -a 111111 --cluster check 192.168.111.100:6381
```

![image-20230411212837370](image/redis.assets/image-20230411212837370.png)



![image-20230411212936781](image/redis.assets/image-20230411212936781.png)

```
redis-cli -a 111111 --cluster del-node 192.168.111.100:6387 xxxxxxxxxxx(6387id)
```

![image-20230411212946012](image/redis.assets/image-20230411212946012.png)



![image-20230411213022252](image/redis.assets/image-20230411213022252.png)

```
redis-cli -a 111111 --cluster check 192.168.111.100:6381
```

![image-20230411213028972](image/redis.assets/image-20230411213028972.png)





## 9.4 总结：集群常用操作命令和CRC16算法分析

 ![image-20230411213444797](image/redis.assets/image-20230411213444797.png)



![image-20230411213935213](image/redis.assets/image-20230411213935213.png)

**==用{}设定key的分组，可让其存入同一个slot==**

![image-20230411213641606](image/redis.assets/image-20230411213641606.png)

![image-20230411213754047](image/redis.assets/image-20230411213754047.png)



![image-20230411213943972](image/redis.assets/image-20230411213943972.png)

![image-20230411214051864](image/redis.assets/image-20230411214051864.png)





![image-20230411214241003](image/redis.assets/image-20230411214241003.png)

![image-20230411214315210](image/redis.assets/image-20230411214315210.png)

![image-20230411214322712](image/redis.assets/image-20230411214322712.png)



![image-20230411215209114](image/redis.assets/image-20230411215209114.png)

查看当前槽是否有key

![image-20230411215101016](image/redis.assets/image-20230411215101016.png)



![image-20230411215221913](image/redis.assets/image-20230411215221913.png)

![image-20230411215233700](image/redis.assets/image-20230411215233700.png)





# 10、SpringBoot整合Redis

![image-20230412153753021](image/redis.assets/image-20230412153753021.png)

![image-20230412154146207](image/redis.assets/image-20230412154146207.png)



## 10.1 集成jedis

![image-20230412154225636](image/redis.assets/image-20230412154225636.png)

![image-20230412154253292](image/redis.assets/image-20230412154253292.png)

![image-20230412161522114](image/redis.assets/image-20230412161522114.png)

```xml
		<!--导入redis:jedis-->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
        </dependency>
```

写application.properties/yml

```
server.port=7777
spring.application.name=redis7_study
```

![image-20230412161525251](image/redis.assets/image-20230412161525251.png)

**==记得关闭linux防火墙：systemctl stop firewalld==**

**==还是连不上注意是不是linux不能上网，检查win + R，输入：services.msc ，启动VMware NAT Servise服务==**

![image-20230412162425540](image/redis.assets/image-20230412162425540.png)





## 10.2 集成lettuce

![image-20230412162452175](image/redis.assets/image-20230412162452175.png)

![image-20230412162616934](image/redis.assets/image-20230412162616934.png)

是线程安全的



![image-20230412163006935](image/redis.assets/image-20230412163006935.png)

```xml
		<!--导入redis：lettuce-->
        <dependency>
            <groupId>io.lettuce</groupId>
            <artifactId>lettuce-core</artifactId>
        </dependency>
```

![image-20230412164148555](image/redis.assets/image-20230412164148555.png)



## ==10.3 集成RedisTemplate==

![image-20230412164318846](image/redis.assets/image-20230412164318846.png)





### 连接单机

![image-20230412164355654](image/redis.assets/image-20230412164355654.png)

![image-20230412164445454](image/redis.assets/image-20230412164445454.png)



**改POM（最后附全部pom.xml内容）**

![image-20230412165525170](image/redis.assets/image-20230412165525170.png)

```xml
		<!--springboot与Redis整合依赖-->
        <!--redis：RedisTemplate(下面四个)-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>

        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-pool2</artifactId>
        </dependency>

        <!--swagger2-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
```



**写application.properties/yml**

![image-20230412171044640](image/redis.assets/image-20230412171044640.png)

```properties
server.port=7777
spring.application.name=redis7_study

#========================logging=========================
logging.level.root=info
logging.level.com.spongehah.redis7=info
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger- %msg%n 

logging.file.name=D:/mylogs2023/redis7_study.log
logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger- %msg%n

#=========================swagger==========================
#控制SwaggerConfig的enable的值
spring.swagger2.enabled=true
#springboot.2.6.X结合swagger2.9.X会提小documentationPluginsBootstrapper空指针异常，
#原因是在springboot2.6,X中将springMVC默认路径匹配策略从AntPathMatcher.更改为PathPatternParser,
#导致出错，解决办法是matching-strategy切换回，之前ant_path_matcher
spring.mvc.pathmatch.matching-strategy=ant_path_matcher

#==========================redis单机===========================
spring.redis.database=0
#修改为自己的真实IP
spring.redis.host=192.168.111.100
spring.redis.port=6379
spring.redis.password=xxxxxxxxxxxxxx@
spring.redis.lettuce.pool.max-active=8
spring.redis.lettuce.pool.max-wait=-1ms
spring.redis.lettuce.pool.max-idle=8
spring.redis.lettuce.pool.min-idle=0
```



**主启动类默认**

![image-20230412171555368](image/redis.assets/image-20230412171555368.png)



**业务类**

![image-20230412171528300](image/redis.assets/image-20230412171528300.png)



config.RedisConfig（解决了后面测试的序列化问题）

```java
@Configuration
public class RedisConfig
{
    /**
     * redis序列化的工具配置类，下面这个请一定开启配置
     * 127.0.0.1:6379> keys *
     * 1) "ord:102"  序列化过
     * 2) "\xac\xed\x00\x05t\x00\aord:102"   野生，没有序列化过
     * this.redisTemplate.opsForValue(); //提供了操作string类型的所有方法
     * this.redisTemplate.opsForList(); // 提供了操作list类型的所有方法
     * this.redisTemplate.opsForSet(); //提供了操作set的所有方法
     * this.redisTemplate.opsForHash(); //提供了操作hash表的所有方法
     * this.redisTemplate.opsForZSet(); //提供了操作zset的所有方法
     * @param lettuceConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory)
    {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        //设置key序列化方式string
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化方式json，使用GenericJackson2JsonRedisSerializer替换默认序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }
}
```

config.SwaggerConfig

```java
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Value("${spring.swagger2.enabled}")
    private Boolean enabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.spongehah.redis7")) //你自己的package
                .paths(PathSelectors.any())
                .build();
    }
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger2构建api接口文档 "+"\t"+ DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()))
                .description("springboot+redis整合,有问题给管理员阳哥邮件:zzyybs@126.com")
                .version("1.0")
                .termsOfServiceUrl("https://www.atguigu.com/")
                .build();
    }
}
```



service.OrderService

```java
@Service
@Slf4j
public class OrderService {
    public static final String ORDER_KEY = "ord:";
    
    @Resource
    private RedisTemplate redisTemplate;
//    private StringRedisTemplate stringRedisTemplate;
    
    public void addOrder(){
        int keyId = ThreadLocalRandom.current().nextInt(1000)+1;
        String serialNo = UUID.randomUUID().toString();
        
        String key = ORDER_KEY+keyId;
        String value = "京东订单" + serialNo;
        
        redisTemplate.opsForValue().set(key,value);
//        stringRedisTemplate.opsForValue().set(key,value);
        
        log.info("***key:{}",key);
        log.info("***value:{}",value);
    }
    
    public String getOrderById(Integer keyId){
        return (String) redisTemplate.opsForValue().get(ORDER_KEY + keyId);
//        return  stringRedisTemplate.opsForValue().get(ORDER_KEY + keyId);
    }
}

```



controller.OrderController

```java
@RestController
@Slf4j
@Api(tags = "订单接口")
public class OrderController {
    @Resource
    private OrderService orderService;
    
    @ApiOperation("新增订单")
    @RequestMapping(value = "/order/add",method = RequestMethod.POST)
    public void addOrder(){
        orderService.addOrder();
    }
    
    @ApiOperation("按照keyId查询订单")
    @RequestMapping(value = "/order/{keyId}",method = RequestMethod.GET)
    public void getOrderById(@PathVariable Integer keyId){
        orderService.getOrderById(keyId);
    }
}
```



**测试**

![image-20230412195519310](image/redis.assets/image-20230412195519310.png)

http://localhost:7777/swagger-ui.html#/

**序列化问题**
![image-20230412194149191](image/redis.assets/image-20230412194149191.png)

第一种方案：

将OrderService类中的RedisTemplate改为其子类StringRedisTemplate,此时swagger和浏览器中显示正常，若要在redis客户端中正常显示中文，redis-cli命令需要加上--raw



==第二种方案：（推荐）==

配置好RedisConfig类



### 连接集群

![image-20230412195742047](image/redis.assets/image-20230412195742047.png)





























































# POM.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.atguigu.redis7</groupId>
    <artifactId>redis7_study</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.10</version>
        <relativePath/>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <junit.version>4.12</junit.version>
        <log4j.version>1.2.17</log4j.version>
        <lombok.version>1.16.18</lombok.version>
    </properties>

    <dependencies>
        <!--guava Google 开源的 Guava 中自带的布隆过滤器-->
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>23.0</version>
        </dependency>
        <!--SpringBoot通用依赖模块-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--jedis-->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>4.3.1</version>
        </dependency>
        <!--lettuce-->
        <!--<dependency>
            <groupId>io.lettuce</groupId>
            <artifactId>lettuce-core</artifactId>
            <version>6.2.1.RELEASE</version>
        </dependency>-->
        <!--SpringBoot与Redis整合依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-pool2</artifactId>
        </dependency>
        <!--swagger2-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
        <!--Mysql数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <!--SpringBoot集成druid连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.10</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.16</version>
        </dependency>
        <!--mybatis和springboot整合-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.0</version>
        </dependency>
        <!--hutool-->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.2.3</version>
        </dependency>
        <!--persistence-->
        <dependency>
            <groupId>javax.persistence</groupId>
            <artifactId>persistence-api</artifactId>
            <version>1.0.2</version>
        </dependency>
        <!--通用Mapper-->
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper</artifactId>
            <version>4.1.5</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
        </dependency>
        <!--通用基础配置junit/devtools/test/log4j/lombok/-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>


```

​	
