
# POC - Monitoramento de aplicações com Prometheus e Grafana
Tecnologias:

 - Java 8
 - Spring (Boot, MVC, Data JPA)
 - Prometheus
 - Grafana 

## Build
***Requer JDK 8 (não JRE)***

Clonar o repositório:

    git clone https://github.com/matheuscirillo/spring-boot-prometheus-monitoring/

Entrar no diretório:

    cd spring-boot-prometheus-monitoring/

Não possui testes unitários, então vamos pular a verificação do maven com a flag `-DskipTests`

Caso possua Maven em variável ambiente:

    mvn clean install -DskipTests
    
Caso **não** possua Maven em variável ambiente:

    mvnw clean install -DskipTests

## Iniciando a aplicação

Após o build, acessar a pasta `spring-boot-prometheus-monitoring/target`

    cd spring-boot-prometheus-monitoring/target

Executar o jar manualmente:

    java -jar poc-springboot-prometheus-0.0.1-SNAPSHOT.jar

O *Embedded Tomcat* irá subir na porta 8080. Caso essa porta esteja ocupada, é possível passar outra porta via linha de comando. Por exemplo:

    java -jar poc-springboot-prometheus-0.0.1-SNAPSHOT.jar --server.port=9000

A aplicação irá subir, também, um banco H2  em memória, minando, assim, a necessidade de possuir algum RDBMS a parte instalado na máquina.

## Endpoints disponíveis na aplicação

`POST /customers` - cria um cliente

**Request body**

    {
      "name": "Matheus Cirillo",
      "birthdate": "29/12/1998"
    }

**Response body**

*Não há corpo de resposta*
___

`GET /customers` - listar todos os clientes

**Request body**

*Por ser um GET, não possui corpo*

**Response body**

    [
      {
        "name": "Matheus Cirillo",
        "birthdate": "29/12/1998"
      }
    ]

___
`GET /customers/{id}` - retornar detalhes de um cliente específico

**Request**

*Por ser um GET, não posui corpo, porém recebe uma PathVariable*. Exemplo:

    http://127.0.0.1:8080/customers/1

**Response body**

    {
      "id": 1,
      "name": "Matheus Cirillo",
      "birthdate": "29/12/1998"
    }
