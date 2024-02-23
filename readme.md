# RabbitMQ with Spring Boot
Project One - Rabbitmq Basics
Project Two - Rabbitmq Spring and Java Advanced
Project Stream - Rabbitmq Stream with Spring Boot

#### Add rabbitmq postman collection
Within Postman add the following collection with the json file:
`rabbitmq_postman_collection.json`

### Official Rabbitmq website
https://rabbitmq.com

## Run rabbitmq without Stream
```bash
docker run -d --restart always --name rabbitmq --hostname docker-rabbitmq -p 5672:5672 -p 15672:15672 -v C:\<YOUR-DOCUMENTS-LOCATION>:/var/lib/rabbitmq/mnesia rabbitmq:3.12-management
```

Access rabbitmq docker (run this command from regular terminal, outside rabbitmq docker)
```bash
docker exec -it rabbitmq bash
```


Restart docker rabbitmq (run this command from regular terminal, outside rabbitmq docker)
```bash
docker restart rabbitmq
```

Delete container
```bash
docker rm -f rabbitmq
```


## Run rabbitmq with Stream, port 5552
```bash
docker run -d --restart always --name rabbitmq --hostname docker-rabbitmq -p 5672:5672 -p 15672:15672 -p 5552:5552 -e RABBITMQ_SERVER_ADDITIONAL_ERL_ARGS="-rabbitmq_stream advertised_host localhost" -v C:\<YOUR-DOCUMENTS-LOCATION>:/var/lib/rabbitmq/mnesia rabbitmq:3.12-management
```


Need enable plugin for java to work
```bash
docker exec -it rabbitmq bash
```

```bash
#> rabbitmq-plugins enable rabbitmq_stream
```

### Spring & Rabbitmq stream plugin
https://docs.spring.io/spring-amqp/docs/current/reference/html/stream.html

