# use grpc in java

- ✅ simple start use grpc in java. a case on create ad
- ✅ 4 grpc model. simple start stream grpc in java
- ✅  we build grpc Microservices on Springboot + consul
- how grpc works?
- when we use grpc online, what we shoud do ?
  - such as Interceptor，set timeout, error parser 
  - error parser
  - meta data
  - load balance
- how to use grpc security ? 
- how to test grpc, run grpc on docker?
- grpc Observability ? how to debug grpc application ?
- Grpc ecological environment. some tools community provider

# build springboot Microservice use consul


```proto
syntax = "proto3";

option java_package = "cn.beckbi.pb";
option java_outer_classname = "AdInfo";

message Ad {
  int32 id = 1;
  string name = 2;
  string description = 3;
  float price = 4;
}

message AdId {
  int32 id = 1;
}

service AdRpc {
  rpc addAd(Ad) returns (AdId);
  rpc getAd(AdId) returns (Ad);
}
```

- start consul 
  - consul agent -dev -ui=true -client 0.0.0.0 &
  - view http://127.0.0.1:8500/ui/dc1/services

run server kgrpc-springboot-server

run server kgrpc-springboot-client

visit http://127.0.0.1:7302/ad?name=666   you can see we create an ad in mem






