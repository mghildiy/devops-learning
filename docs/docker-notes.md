Cheat sheet:
```
https://www.docker.com/sites/default/files/d8/2019-09/docker-cheat-sheet.pdf
```

A very simple docker file for a java app:

```
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

FROM command tells docker which JDK version to use as we need a JVM to run our application.
With ARG we define variables which we can then use in dockerfile later on.
COPY tells docker to copy content into container.
ENTRYPOINT tells docker how to configure container to run.

Create an image in local image store with dockerfile:
```
docker build -t <image-name>:<tag> .
```
--tag/-t option is for creating a tag. If not provided, default tag is 'latest'.
Generated image has an id which can be used instead of image name in various docker commands.

List images:
```
docker image ls
```
Delete an image form local image store
```
docker image rm <image-name>:<tag>
```

Pull and push iage form docker registry:
```
docker pull <image-name>:<tag>
docker push <image-name>:<tag>
```

Create a container from an image:
```
docker run --name <continaer-name> -p <host-port>:<container-port> <image-name>:<tag>
```
image-name can be replaced by image id. If tag is not provided, 'latest' tag is used. Docker assigns an id to the
container.

List running containers:
```
docker container ls
```
-all option would list stopped container too.

Stop a running container:
```
docker container stop <container-name>
OR
docker container stop <container-id>
```
Container name can  be replaced by container id.

Stop a running container:
```
docker container kill <container-name>
OR
docker container kill <container-id>
```

Delete all running and stopped containers:
```
docker container rm -f $(docker ps -aq)
```





