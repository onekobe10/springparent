# Redis 

 Redis 是单线程的。由于Redis的性能瓶颈在于内存读写速度，而不是CPU，设计者将Redis设计成了单线程模式，其所有操作都是原子性的，避免了多线程带来的复杂性。

1. 单机的database
> 1. Redis 单机支持多个数据库，并且每个数据库的数据是隔离的，不能共享，并且基于单机才有，如果是集群则没有数据库的概念。
> 2. 每个数据库对外都是一个从0开始的递增数字命名，Redis默认支持16个数据库（可以通过配置文件支持更多，无上限），可以通过配置databases来修改这一数字。客户端与Redis建立连接后会自动选择0号数据库，不过可以随时使用SELECT命令更换数据库，如要选择1号数据库：
```
    redis> SELECT 1
    OK
    redis [1] > GET foo
    (nil)
```
> 3. Redis不支持自定义数据库的名字，每个数据库都以编号命名，开发者必须自己记录哪些数据库存储了哪些数据。另外Redis也不支持为每个数据库设置不同的访问密码，所以一个客户端要么可以访问全部数据库，要么连一个数据库也没有权限访问。
> 4. 一个Redis实例，默认有16个数据库，数据库中的数据是隔离的。但是多个数据库之间不是完全隔离的，一些命令是作用于整个Redis实例的，比如FLUSHALL,可以清空一个Redis实例中所有数据库的数据。
> 5. 玖富钱包基金组使用的是一个Redis实例中的database 15
2. Redis 集群的实现
> 1. Redis 集群的实现采用数据分片（sharding）来实现。一个 Redis 集群包含 16384 个哈希槽（hash slot），数据库中的每个键都属于这 16384 个哈希槽的其中一个，集群使用公式 CRC16(key) % 16384 来计算键 key 属于哪个槽，其中CRC16(key) 语句用于计算键 key 的 CRC16 校验和，然后和 116384 取模。
> 2. 节点按分配的 slot 存储数据，如果增加了节点，会把原有节点的 slot 都取一部分放到新增的节点中去。
> 3. 如果一个节点出问题，就会导致集群不能使用，因此必须给集群中的每个节点增加备份 slave，才能保证高可用。
3. key value 大小和数量限制
> 1. 一个key或是value大小最大是512M
```
To give you a few examples (all obtained using 64-bit instances):

An empty instance uses ~ 3MB of memory.
1 Million small Keys -> String Value pairs use ~ 85MB of memory.
1 Million Keys -> Hash value, representing an object with 5 fields, use ~ 160 MB of memory.

What is the maximum number of keys a single Redis instance can hold? and what the max number of elements in a Hash, List, Set, Sorted Set?
Redis can handle up to 232 keys, and was tested in practice to handle at least 250 million keys per instance.

Every hash, list, set, and sorted set, can hold 232 elements.

In other words your limit is likely the available memory in your system.
```
4. Redis 数据类型
> 1. String
> 2. hash
> 3. list
> 4. set
> 5. orderedSet

