# web-list

## What's This About?

This is simple RESTful application to consume and display data. Redis is used as a data structure store. The application is based on DropWizard framework.

## Prerequisities

- Java >= 1.7
- Maven 3
- Up and running Redis instance. For example you can use Docker instance for it: `docker run -d --name redis-web-list -p 6379:6379 redis`

## Configuration

Set up Redis IP address using system environment variable: `REDIS_SERVICE_HOST`
If it is not set then `localhost` is used.

## Build

```bash
$ mvn clean install
```

## Run

```bash
$ java -jar target/web-list-0.0.1-SNAPSHOT.jar server configuration.yaml
```

## Add data to service

```bash
curl -H "Content-Type: application/json" --data '{"text":"foo"}' http://localhost:8080/list
```

## Display data

```bash
curl http://localhost:8080/list
```

or just copy `http://localhost:8080/list` to your WEB browser

## Prepare Docker image

You can also prepare Docker image with **web-list** application. In project directory you can find Dockerfile for it.

```bash
docker build -t "zreigz/web-list" .
```



