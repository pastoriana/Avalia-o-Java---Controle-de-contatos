📞 Avaliação API Rest - Controle de contatos

📝 Descrição do Projeto
O projeto consiste em uma aplicação API Rest para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos. Cada Pessoa pode ter vários Contatos, e a aplicação permite operações CRUD (Criar, Ler, Atualizar, Deletar) para ambas as entidades.

🛠 Requisitos Técnicos
Linguagem: Java com Spring Boot (Versão 3.2.7)
Persistência: JPA/Hibernate
Banco de Dados: H2
Documentação: OpenAPI (Swagger)

📋 Funcionalidades
CRUD de Pessoas
Criar Pessoa: POST /api/pessoas
Obter Pessoa por ID: GET /api/pessoas/{id}
Obter Pessoa por ID para mala direta: GET /api/pessoas/maladireta/{id}
Listar todas as Pessoas: GET /api/pessoas
Atualizar Pessoa por ID: PUT /api/pessoas/{id}
Deletar Pessoa por ID: DELETE /api/pessoas/{id}

CRUD de Contatos
Adicionar um novo Contato a uma Pessoa: POST /api/contatos
Obter Contato por ID: GET /api/contatos/{id}
Listar todos os Contatos de uma Pessoa: GET /api/contatos/pessoa/{idPessoa}
Atualizar Contato por ID: PUT /api/contatos/{id}
Deletar Contato por ID: DELETE /api/contatos/{id}

🗂 Modelagem
Pessoa
ID: único, não pode ser nulo
Nome: não pode ser nulo
Endereço: pode ser nulo
CEP: pode ser nulo
Cidade: pode ser nulo
UF: pode ser nulo

Contato
ID: único, não pode ser nulo
Tipo Contato: não pode ser nulo (0 para Telefone, 1 para Celular)
Contato: não pode ser nulo
Pessoa: relacionamento ManyToOne com Pessoa

🚀 Como Executar a Aplicação
Pré-requisitos
JDK: 17+
Maven: 3.6+
Passos para execução
Clonar o repositório:
git clone https://github.com/pastoriana/AvaliacaoAPIRest.git
cd AvaliacaoAPIRest

Compilar e rodar a aplicação:
mvn clean install
mvn spring-boot:run

Acessar o console H2:
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: password

Acessar a documentação do OpenAPI (Swagger):
URL: http://localhost:8080/swagger-ui.html

🛠 Configuração do Banco de Dados
O projeto utiliza o banco de dados H2 em memória para facilitar os testes e a configuração inicial. As configurações estão no arquivo application.properties

📂 Estrutura do Projeto
O projeto segue a estrutura padrão do Spring Boot, com os pacotes organizados da seguinte maneira:

src/main/java/br/com/abps/AvaliacaoAPIRest/
    ├── AvaliacaoApiRestApplication.java
    ├── controller/
    │   ├── ControllerPessoa.java
    │   └── ControllerContato.java
    ├── model/
    │   ├── Pessoa.java
    │   └── Contato.java
    ├── repository/
    │   ├── RepositorioPessoa.java
    │   └── RepositorioContato.java
    └── dto/
        └── PessoaDTO.java

✨ Considerações Finais
Este projeto foi desenvolvido como parte de um desafio para a criação de uma API Rest utilizando Java com Spring Boot. Caso haja alguma dúvida ou problema, sinta-se à vontade para abrir uma issue no repositório.
