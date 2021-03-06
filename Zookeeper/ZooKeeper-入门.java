-------------------------
ZooKeeper-入门			 |
-------------------------
	# Zookeeper,翻译过来就是动物园管理组
	# 有趣的是,你会发现.很多技术的LOGO,或者图标都是动物.PHP,Hadoop等..
	# 官网
		https://zookeeper.apache.org/
	
	# 分布式协调框架
		* 本质上就是一个分布式的小文件存储系统(树形目录结构)
	
	# 教程
		https://edu.aliyun.com/lesson_1343_11455#_11455

-------------------------
特性					 |
-------------------------
	# 全局一致性
		* Zookeeper集群中,每个server保存一份相同数据副本
		* client无论连接到哪个server,展示的数据都是一样的
		* 这是最重要的特征(CAP中CP的实现)

	# 可靠性
		* 如果消息被集群中的任何一个服务器接受,那么将会被所有服务器接受
		* 一个服务器收到消息后,同步到所有的节点

	# 顺序性
		* 全局有序
			- 同一台服务器,A消息在B消息之前发布,则集群内所有服务器上,A消息都将在B消息前被发布
			- 处理服务器先创建了A,后创建了B,那么集群中所有的服务器都是先创建A再创建B
		* 偏序
			- 一个消息B,在A消息后,被同一个发布者发布,A必将排在B的前面
			- 客户端先发送A消息服务端就先处理A
	
	# 数据更新原子性
		* 一次操作,要么全部成功,要么全部失败,不存在中间状态
		* 半数以上节点成功即为成功

	# 实时性
		* 保证客户端在一个时间间隔范围内获取到服务器的更新消息,或者服务器的失效消息
		* 客户端能获取到实时的信息

-------------------------
目录结构				 |
-------------------------
	bin
	conf
	contrib
	dist-maven
	docs
	lib
	recipes
	src
	build.xml
	ivy.xml
	ivysettings.xml
	zookeeper-3.4.13.jar