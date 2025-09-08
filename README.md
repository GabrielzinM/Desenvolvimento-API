# API de Tarefas ✅

Projeto desenvolvido em **Java Spring Boot** para gerenciamento de tarefas.  
Permite criar, listar, atualizar e remover tarefas de forma simples.

## 🚀 Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Maven
- H2 Database (ou outro configurado)

## 📂 Estrutura do Projeto
- `Tarefa.java` → Entidade que representa uma tarefa.
- `TarefaRepository.java` → Repositório JPA para persistência.
- `TarefaController.java` → Endpoints REST da API.
- `application.properties` → Configurações da aplicação.

🔗 Endpoints Principais

GET /tarefas → Lista todas as tarefas

POST /tarefas → Cria uma nova tarefa

GET /tarefas/{id} → Busca tarefa por ID

PUT /tarefas/{id} → Atualiza uma tarefa

DELETE /tarefas/{id} → Remove uma tarefa

📝 Licença
Este projeto foi desenvolvido para fins educacionais como parte do curso de Desenvolvimento Web Back End do Centro Universitário Internacional UNINTER.