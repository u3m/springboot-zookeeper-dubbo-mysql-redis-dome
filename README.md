## 一个基于springboot和dubbo构建的rpc项目
#### 项目架构 springboot+zookeeper+dubbo+mysql+redis 
+ mysql 框架用 mybatis 
+ OAuth2 + JWT 为登录验证 
+ zookeeper 采用集群，我会在阿里云构建一个3个zookeeper的集群 
+ MQ 采用 RabbitMQ

#### zookeeper 集群启动命令
```
/usr/local/zookeeper/zookeeper-3.4.8-01/bin/zkServer.sh start
/usr/local/zookeeper/zookeeper-3.4.8-02/bin/zkServer.sh start
/usr/local/zookeeper/zookeeper-3.4.8-03/bin/zkServer.sh start
```
