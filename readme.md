### RPC
> RPC（Remote Procedure Call）是一种远程调用协议，简单地说就是能使应用像调用本地方法一
>样的调用远程的过程或服务，可以应用在分布式服务、分布式计算、远程服务调用等许多场景。说起 RPC 大家并不陌生，业界有很多开源的优秀 RPC 框架，例如 Dubbo、Thrift、gRPC、Hprose 等等。
>下面先简单介绍一下 RPC 与常用远程调用方式的特点，以及一些优秀的开源 RPC 框架。

### 参考
http://h2ex.com/820 <br/>
https://github.com/weibocom/motan <br/>
https://github.com/weibocom/motan/blob/master/docs/wiki/zh_quickstart.md <br/>

###使用
首先启动 consul.exe
consul agent -dev
 or
consul agent -dev -bind  127.0.0.1
进入ui页面
http://127.0.0.1:8500/ui/

然后启动服务器
src/main/javaquickstart/Server.java
然后启动客户端
src/main/javaquickstart/Client.java

###相关下载
[consul](https://www.consul.io/downloads.html)

