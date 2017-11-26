#TCP 粘包/拆包

### 一、原因

#### 1. 应用程序write写入的字节大小大于套接口发送缓冲区的大小,拆包



#### 2.待发送数据大于MSS（最大报文长度），TCP在传输前将进行拆包。

MSS是最大报文段长度的缩写。

MSS是TCP报文段中的数据字段的最大长度。

数据字段加上TCP首部才等于整个的TCP报文段。

所以MSS并不是TCP报文段的最大长度，而是：MSS=TCP报文段长度-TCP首部长度

#### 3. 以太网帧的 payload 大于 MTU 进行 IP 分片

MTU,最大传输单元（Maximum Transmission Unit，MTU）是指一种通信协议的某一层上面所能通过的最大数据包大小（以字节为单位）。

在计算网络中，表示每一种链路层都规定了所能传送的帧的**数据部分长度上限**

参考资料(http://blog.csdn.net/yusiguyuan/article/details/22785927)

#### 4. 接收数据端的应用层没有及时读取接收缓冲区中的数据，将发生粘包。


### 二、解决方案
#### 1. 消息定长

 比如每个消息的报文大小都为固定长度的200字节，如果不够，空位补空格

#### 2. 在包尾增加回车换行符进行分割
 FTP协议

#### 3. 将消息头和消息体，消息头中包含消息总长度的字段

 通常为消息头的第一个字段使用```int32```来表示消息的总长度

#### 4. 更复杂的应用层协议