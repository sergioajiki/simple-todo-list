# Simple TodoList API

Esta é uma API simples para gerenciamento de tarefas (TodoList) desenvolvida em Java Spring Boot, utilizando um banco de dados MySQL. A API oferece operações básicas para manipulação de tarefas, como criação, leitura, atualização e exclusão.

## Configuração do Ambiente

Antes de executar a aplicação, certifique-se de ter o Java, o Maven e o Docker instalados em seu ambiente de desenvolvimento.

### Docker Compose
Utilize o arquivo docker-compose.yml fornecido para configurar o banco de dados MySQL.
>docker-compose up -d

### Execução da Aplicação

>mvn spring-boot:run


## Endpoints

**GET /tasks:** Retorna todas as tarefas cadastradas.

**POST /tasks:** Cadastra uma nova tarefa.

**PATCH /tasks/updateTaskInprogress/{id}:** Altera o status da tarefa para "InProgress" com base no ID fornecido.

**PATCH /tasks/updateTaskDone/{id}:** Altera o status da tarefa para "Done" com base no ID fornecido.

**PATCH /tasks/updatePriority/{id}:** Altera a prioridade da tarefa com base no ID fornecido.

**DELETE /tasks/{id}:** Apaga a tarefa com base no ID fornecido.

## Documentação Swagger
Acesse a documentação da API em http://localhost:8080/swagger-ui/index.html para visualizar uma demonstração interativa da API utilizando o Swagger.
