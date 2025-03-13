# RABBIT MQ SAMPLE PROJECT

### RabbitMQ Management using Podman on Windows

- Step-by-step guide to create a RabbitMQ container using Podman: 
  - Pull the RabbitMQ image with command: 
    - podman pull rabbitmq:latest
  - Create and run the RabbitMQ container with command:
    - podman run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:latest
  - To open the RabbitMQ management interface, follow these steps:
    - Ensure RabbitMQ Management Plugin is Enabled:
    - By default, the RabbitMQ management plugin is enabled within the official RabbitMQ Docker image. If it's not, you can enable it with: 
      - podman exec rabbitmq rabbitmq-plugins enable rabbitmq_management

- Access the Management Interface:
  - Open your web browser and go to http://localhost:15672.
  - If you're accessing it from a different machine, replace localhost with the IP address of the machine running the RabbitMQ container.
  - Login:
    - The default username and password are both "guest".
