# 📝 To-Do List API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

Uma API robusta para gerenciamento de tarefas (To-Do List) desenvolvida com **Java** e **Spring Boot**. O sistema conta com autenticação de usuários, criptografia de senhas e persistência de dados.

---

## ✨ Funcionalidades

- **Gerenciamento de Usuários:** - Cadastro de usuários com validação.
  - Criptografia de senhas utilizando **BCrypt**.
- **Gerenciamento de Tarefas:** - Criação de tarefas com título, descrição e prioridade.
  - Listagem de tarefas vinculadas apenas ao usuário autenticado.
  - Atualização parcial de informações de tarefas.
- **Segurança:**
  - Filtro customizado para autenticação em rotas protegidas.
  - Tratamento global de exceções para respostas amigáveis.

---

## 🛠️ Tecnologias e Dependências

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.2.5
* **Banco de Dados:** H2 Database (em memória para desenvolvimento)
* **Segurança:** BCrypt (at.favre.lib)
* **Produtividade:** Lombok
* **DevOps:** Docker & Dockerfile

---

## 🚀 Como Executar

### Pré-requisitos
* Java 17+
* Maven

### Passo a passo
1. Clone o repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/todolist.git](https://github.com/SEU_USUARIO/todolist.git)
2. Instale as dependências:
   ```bash
   mvn clean install
3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   * A API estará rodando em http://localhost:8080
   
## 📌 Endpoints da API

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/users/` | Cadastra um novo usuário |
| `POST` | `/tasks/` | Cria uma tarefa (Requer Auth) |
| `GET` | `/tasks/` | Lista tarefas do usuário logado |
| `PUT` | `/tasks/{id}` | Atualiza uma tarefa por ID |

## 📂 Estrutura de Arquivos

```text
src/main/java/br/com/vinicius/todolist/
├── errors/     # Tratamento de exceções customizadas
├── filter/     # Filtros de autenticação (Basic Auth)
├── task/       # Model, Repository e Controller de Tarefas
├── user/       # Model, Repository e Controller de Usuários
└── utils/      # Classes utilitárias (Copy Properties)
```

## 🐳 Rodando com Docker
Se preferir utilizar containers, utilize o Dockerfile incluso:
```bash
docker build -t todolist-app .
docker run -p 8080:8080 todolist-app
```

Feito por Vinicius 🚀
