------------------------
集群角色				|
------------------------
	# Leader
		* 集群核心,唯一
		* 集群内部各个服务器的调度者
		* 事务请求(写操作)的唯一调度和处理者,保证集群中事务处理的顺序性
			- create,setData,delete 等涉及了写的操作,需要统一转发给Leader处理
			- Leader需要决定编号,执行操作.这个过程称之为一个事务
		
	# Follower
		* 处理客户端非事务请求(读),转发事务请求给Leader
		* 参与集群Leader选举投票
	
	# Observer
		* 如果ZooKeeper集群的读取负载很高,或者客户端多到跨机房,可以设置一些observer服务器,以提高读取的吞吐量
		* Observer 和Follower比较相似
		* 其实就是针对非事务请求的横向扩展,事务性请求也会转发给Leader区别
		* Observer 不属于法定人数,不参加选举也不响应提议
		* Observer 不需要将事务持久化到磁盘,一旦observer被重启,需要从leader重新同步整个名字空间
		* 通常用于:在不影响集群事务处理能力的前提下,提升集群的非事务处理能力


------------------------
集群搭建				|
------------------------
	# 集群数量一般为奇数
		* 2n + 1 台server组成
		* 为了保证Leader选举(基于Paxos算法),能得到多数的支持
	
	# 修改主机名称到ip地址映射配置(host)

	# 修改Zookeeper配置文件(server配置项,添加一个或者多个server节点配置)
		server.[id]=[host]:[heart-port]:[election-port]
		* [id] 节点的id
		* [host] 节点的host
		* [heart-port] 节点心跳/数据交互端口
		* [election-port] 节点的选举端口

		* 如果是伪集群的话,那么系统设置端口不能相同,不然会冲突

	# 设置myid
		* 在 dataDir 目录下创建一个文件:myid
		* 内容为当前节点的的id编号

	# 启动集群
		* 挨个启动即可

	# 需要保证集群中,服务器的时间是同步的
		

------------------------
OBServer				|
------------------------
	# 在OBServer对应节点的配置文件下添加如配置
		peerType=observer

	# 所有节点的配置文件,必须指定哪些节点是Observer
		server.1=ip1:2888:3888
		server.2=ip2:2888:3888
		server.3=ip3:2888:3888
		server.4=ip4:2888:3888:observer