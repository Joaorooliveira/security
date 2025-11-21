# 🛡️ Spring Security JWT API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

## 📖 Sobre o Projeto

Este projeto é uma **API REST** desenvolvida para demonstrar uma implementação segura e escalável de autenticação e autorização.

O objetivo principal é fornecer um sistema de login **Stateless** (sem sessão no servidor), onde a segurança é garantida através de **Tokens JWT** assinados digitalmente. O projeto segue as melhores práticas de arquitetura e segurança modernas.

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.5.7**
* **Spring Security** (Autenticação e Autorização)
* **Auth0 Java-JWT** (Geração e Validação de Tokens)
* **Spring Data JPA** (Persistência de dados)
* **PostgreSQL** (Banco de dados Relacional)
* **Flyway** (Versionamento de Banco de Dados / Migrations)
* **Lombok** (Redução de código boilerplate)
* **Bean Validation** (Validação de dados de entrada)

## ⚙️ Funcionalidades

- [x] **Cadastro de Usuário** (com senha criptografada usando BCrypt)
- [x] **Login Seguro** (retorna Token JWT Bearer)
- [x] **Proteção de Rotas** (Middleware/Filtro que intercepta requisições)
- [x] **Validação de Token** (Verificação de assinatura e expiração)
- [x] **Tratamento de Exceções de Segurança**

## 🛠️ Como Rodar

### Pré-requisitos
* Java 21 instalado
* PostgreSQL rodando na porta `5432`
* Banco de dados criado com o nome: `tutorialseguranca`

### Configuração do Banco
Certifique-se de que seu `application.properties` está apontando para o seu banco local:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tutorialseguranca
spring.datasource.username=postgres
spring.datasource.password=123
```
### Executando
```bash
# Clone o repositório
git clone https://github.com/joaorooliveira/security.git

# Entre na pasta
cd security

# Execute com Maven Wrapper
./mvnw spring-boot:run
```

## 🔌 Endpoints da API

### 🔓 Público: Registrar Usuário

POST /auth/register
**Body:**
```json
{
  "name": "João Victor",
  "email": "joao@email.com",
  "password": "senha_secreta"
}
```
### 🔓 Público: Login

POST /auth/login
**Body:**
```json
{
  "email": "joao@email.com",
  "password": "senha_secreta"
}
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
### 🔒 Protegido: Rota de Teste

GET /test

Header necessário: Authorization: Bearer <seu_token_aqui>
