# 消息队列 Kafka

LinkedIn 用于日志处理的分布式消息队列

1. Kafka维护消息类别的东西是主题（topic）
2. 我们称发布消息到Kafka主题的进程叫生产者（producer）
3. 我们称订阅主题、获取消息的进程叫消费者（consumer）
4. Kafka是由多个服务器组成的机器，每个服务器称作代理（broker）

无论是kafka集群，还是producer和consumer 都依赖于zookeeper 来保证系统可用性，为集群保存一些meta信息。

每个消息分区(partition) 只能被同组的一个消费者进行消费

Kafka只能保证一个partition中的消息被某个consumer 消费时,消息是顺序的。事实上,从Topic角度来说,消息仍不是有序的。

Kafka的四个要素：Producer（消息生产者）、Server Broker（服务代理器）、Zookeeper（协调者）、Consumer（消息消费者）

一个独立进行消息获取、消息记录和消息分送操作的队列称之为Topic

Apache Kafka将Topic拆分成多个分区（Partition），这些分区（Partition）可能存在于同一个Broker上也可能存在于不同的Broker上，Kafka会为每个分区创建一个独立文件。

一条消息记录只会被分配到一个分区进行存储，并且这些消息以分区为单位保持顺序排列。这些分区是Apache Kafka性能的第一种保证方式：单位数量相同的消息将分发到存在于多个Broker服务节点上的多个Partition中，并利用每个Broker服务节点的计算资源进行独立处理。

每一个分区都中会有一个或者多个段（segment）结构。一个段（segment）结构包含两种类型的文件：.index后缀的索引文件和.log后缀的数据文件。前一个index文件记录了消息在整个topic中的序号以及消息在log文件中的偏移位置（offset），通过这两个信息，Kafka可以在后一个log文件中找到这条消息的真实内容。

如果某个Topic下只有一个分区，就不能实现消息的负载均衡。另外Topic下的分区数量也只能是固定的，不可以在使用Topic时动态改变，这些分区在Topic被创建时使用命令行指定或者参考Broker Server中配置的默认值。

zookeeper集群需要记录/协调的工作包括：当前整个Kafka集群中有哪些Broker节点以及每一个节点处于什么状态（活动/离线/状态）、当前集群中所有已创建的Topic以及分区情况、当前集群中所有活动的消费者组/消费者、每一个消费者组针对每个topic的索引位置等。

当一个消费者上线，并且在消费消息之前。首先会通过zookeeper协调集群获取当前消费组中其他消费者的连接状态，并得到当前Topic下可用于消费的分区和该消费者组中其他消费者的对应关系。如果当前消费者发现Topic下所有的分区都已经有一一对应的消费者了，就将自己置于挂起状态。

如果当前消费者连接时，发现整个Kafka集群中存在一个消费者（记为消费者A）关联Topic下多个分区的情况，且消费者A处于繁忙无法处理这些分区下新的消息（即消费者A的上一批Pull的消息还没有处理完成）。这时新的消费者将接替原消费者A所关联的一个（或者多个）分区，并且一直保持和这个分区的关联。

**由于Kafka集群中只保证同一个分区（Partition）下消息队列中消息的顺序。** 所以当一个或者多个消费者分别Pull一个Topic下的多个消息分区时，您在消费者端观察的现象可能就是消息顺序是混乱的。这里我们一直在说消费者端的Pull行为，是指的Topic下分区中的消息并不是由Broker主动推送到（Push）到消费者端，而是由消费者端主动拉取（Pull）。

Kafka中partition（分区）和replication（复制）是两个完全不同的概念：
1. partition:将若干条消息按照一定的规则分别存放在不同的区域，一条消息只存入一个区域（且Topic下多个分区可以存在于同一个Broker上）
2. replication:为了保证消息在被消费前不会丢失，需要将某一个区域中的消息集合复制出多个副本（同一个分区的多个副本不能存放在同一个Broker上）。    
    >Kafka将分区的多个副本分为两种角色：Leader和Follower，Leader Broker是主要服务节点，消息只会从消息生产者发送给Leader Broker，消息消费者也只会从Leader Broker中Pull消息。Follower Broker为副本服务节点，正常情况下不会公布给生产者或者消费者直接进行操作。Follower Broker服务节点将会主动从Leader Broker上Pull消息。

消息生产者并没有连接到zookeeper协调服务，而是直接和多个Kafka Server Brokers建立了连接。和其他种类的消息队列的设计不同，在整个Kafka方案中消息生产者（Producer）会有很多重要规则的决定权，例如         
1. 消费生产者（Producer）可以决定向指定的Topic的哪一个分区（Partition）发送消息。而不是由Broker来决定。
2. Kafka中的多个消息生产者（Producer）并不需要ZooKeeper服务中的任何信息为它们协调发送过程，因为没有什么可协调的。生产者唯一需要知道的Topic有多少个分区以及每个分区，分别存在于哪些Broker上的信息都是来源于对某一个Broker的直接查询。所以Kafka集群中只剩下了Broker和Consumer需要进行协调

在Kafka的实现中，强一致性复制是指当Leader Partition收到消息后，将在所有Follower partition完成这条消息的复制后才认为消息处理成功，并向消息生产者返回ack信息；弱一致性复制是指当Leader partition收到消息后，只要Leader Broker自己完成了消息的存储就认为消息处理成立，并向消息生产者返回ack信息（复制过程随后由Broker节点自行完成）；

Apache Kafka集群中的消费者以线程为单位，一个消费者只消费一个分区（Partition）中的消息，且整个系统中的消费者大于等于Topic中的分区数量





