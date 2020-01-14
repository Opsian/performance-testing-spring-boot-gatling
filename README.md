# Gatling Test

This is the source code for the article [Performance Testing Spring Boot with Gatling](https://www.opsian.com/blog/performance-test-spring-boot-gatling/) on the Opsian Blog.
This README helps you replicate what is described.

## Building the docker image

Make sure you have [Docker](https://www.docker.com/) installed. 
You can sign up for the [Opsian trial](https://www.opsian.com/) and download the `libopsian.so` binary to the root of the project.
Also, run `gradle:assemble` to generate the Uberjar. Move this into the root of the project - this should be in `build/libs/` directory.
Once it is in the root directory you can run

```bash
docker build -t opsian/gatlingtest:v1 .
```

and start it with

```bash
docker run -it -p 8080:8080 opsian/gatlingtest:v1
```

On a side note, there should be a running Kafka node on your machine.
If you are running the Kafka node on your machine but the app on Docker then change the host (or windows, linux etc) so it can communicate with the node.

```java
props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "docker.for.mac.localhost:9092");
```

## Running the load test

The load test simulation can be found `user-files/simulations/gatling/BasicSimulation.scala`
Download [Gatling](https://gatling.io/) and unzip. Place the simulation in the simulations folder and run the following bash command:

```bash
bin/gatling.sh -s test.GatlingTestSimulation
```

