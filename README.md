# 📘 Cadastro de Alunos

Projeto em Java com interface gráfica (Swing) e banco de dados MySQL, desenvolvido para realizar o cadastro, listagem, atualização e remoção de alunos.

## 🧰 Tecnologias utilizadas

- **Java 17+**
- **Swing (GUI)**
- **MySQL**
- **JDBC (MySQL Connector)**
- **IntelliJ IDEA**
- **Maven (gerenciador de dependências)**

## 📦 Funcionalidades

- ✅ Cadastro de alunos com:
  - Nome
  - Matrícula
  - Curso
  - Email

- ✅ Listagem dos alunos cadastrados  
- ✅ Atualização de informações  
- ✅ Remoção de alunos

## 🛠️ Configuração do ambiente

### 1. Clonar o repositório

```bash
git clone https://github.com/KaikeRosa/cadastro-alunos.git
cd cadastro-alunos
```

### 2. Criar o banco de dados no MySQL

Execute no MySQL Workbench:

```sql
CREATE DATABASE cadastro_escolar;
USE cadastro_escolar;

CREATE TABLE alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) UNIQUE NOT NULL,
    curso VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);
```

### 3. Configurar a conexão com o banco de dados

No arquivo `ConnectionFactory.java`, atualize os dados de acesso ao banco:

```java
String url = "jdbc:mysql://localhost:3306/cadastro_escolar";
String user = "seu_usuario";
String password = "sua_senha";
```

### 4. Rodar o projeto

Abra o projeto no IntelliJ e execute a classe `Main.java`. A interface será exibida com as opções de cadastro e gerenciamento de alunos.

## 📁 Estrutura do Projeto

```
src/
├── dao/
│   └── AlunoDAO.java
├── model/
│   └── Aluno.java
├── util/
│   └── ConnectionFactory.java
├── view/
│   └── AlunoForm.java
└── Main.java
```

## 👤 Autor

- [Kaike Rosa](https://github.com/KaikeRosa)