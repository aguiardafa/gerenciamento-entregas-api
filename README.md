# gerenciamento-entregas-api

Projeto Back-end "Rest API" de um `Sistema de Gerenciamento de Entregas`, implementado em Java com Spring Boot.

<a href="#backers" alt="Last Commit">
<img src="https://img.shields.io/github/last-commit/aguiardafa/gerenciamento-entregas-api" /></a>
<a href="https://github.com/aguiardafa/gerenciamento-entregas-api/pulse" alt="Activity">
<img src="https://img.shields.io/github/commit-activity/y/aguiardafa/gerenciamento-entregas-api" /></a>
<a href="#backers" alt="Repository Size">
<img src="https://img.shields.io/github/repo-size/aguiardafa/gerenciamento-entregas-api" /></a>
<a href="#backers" alt="Language Portuguese">
<img src="https://img.shields.io/badge/language-Portuguese-yellow" /></a>

## Sistema de Gerenciamento de Entregas:

Trata-se de um <b>sistema básico para gerência de entregas</b>, através do cadastro dos principais dados de uma entrega, o registro dos vínculos com o respectivo Cliente e Destinatário, e o controle do fluxo da entrega, por meio do Status da entrega. Ainda, possibilita o registro histórico de possíveis ocorrências relacionadas as entregas.

<p align="center"><img alt="Imagem do Projeto" id="imagem" title="#Projeto" height="400px" src="https://raw.githubusercontent.com/aguiardafa/gerenciamento-entregas-api/main/.github/Image.png" /></p>

Foi implementado com fins acadêmicos, sendo construído como atividade do curso `Mergulho Spring REST (MSR)`, ocorrido de 10 a 17 de janeiro de 2022, promovido pela [AlgaWorks](https://www.algaworks.com/).

Para finalizar o Projeto e concluir, por hora, meus estudos, implementei a funcionalidade de cancelamento de entrega e o consumo da API ViaCEP para preencher automaticamente o endereço das entregas com base no informe do CEP na solicitação de entrega, ambas fora do escopo do Curso da Algaworks.

O projeto foi gerado com [Spring Initializer](https://start.spring.io/) - <b>Spring Boot version 2.6.2</b>.

### 🛒 Requisitos do Projeto:

Antes de começar, você vai precisar ter instalado em sua máquina os seguintes recursos:

- [Git](https://git-scm.com/);
- [Java JDK](https://www.oracle.com/java/technologies/downloads/);
- [Apache Maven](https://maven.apache.org/download.cgi); e
- [MySQL Server](https://dev.mysql.com/downloads/mysql/).

<b>Dica: </b>Caso queira customizar o Projeto, é recomendado utilizar algum editor especializado em código, que suporte trabalhar com projetos Maven, por exemplo o [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/).

### 📀 Para executar o Projeto:

1. Baixe este Repositório, executando o comando Git: `git clone https://github.com/aguiardafa/gerenciamento-entregas-api`;
2. Execute o comando Maven `mvn clean install` pelo terminal, aberto na raiz da pasta do Repositório, para baixar as dependências do projeto através do Maven;
3. Ainda pelo terminal, aberto na raiz da pasta do Repositório, execute o comando Maven `mvn spring-boot:run` para executar a aplicação; e
- <b>Obs.: </b>A mensagem que aparece no final <b>"Tomcat started on port(s): 8080 (http)"</b> significa que a Aplicação Web foi inciada e está acessível na porta 8080.
4. Acesse a url `http://localhost:8080/entregas` pelo navegador para visualizar o Sistema.
- <b>Dica: </b>Caso queira uma melhor experiência de acesso aos Endpoints da API, é recomendado utilizar algum API Client, que facilita a interação e visualização de APIs, por exemplo o [Postman](https://www.getpostman.com/) (importe o arquivo [EntregasAPI.postman_collection.json](https://raw.githubusercontent.com/aguiardafa/gerenciamento-entregas-api/main/EntregasAPI.postman_collection.json) no Postman, que todos Endpoints da API serão disponibilizados para interação).

### 🛠 Tecnologias/ferramentas utilizadas:

As seguintes tecnologias/ferramentas/conceitos foram utilizadas na construção do projeto:

- [Spring](https://spring.io/)
- [JPA](https://pt.wikipedia.org/wiki/Java_Persistence_API)
- [Lombok](https://projectlombok.org/)
- [Postman](https://www.getpostman.com/) *Testar os Endpoints da API
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) *Confirmar alterações no DB do Sistema
- [Flyway Database migrations](https://flywaydb.org/)
- [Bean Validation](https://beanvalidation.org/)
- [Exception Handler](https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
- [Json Property](https://qastack.com.br/programming/12583638/when-is-the-jsonproperty-property-used-and-what-is-it-used-for)
- [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)
- [Model Mapper](http://modelmapper.org/getting-started/)
- [Arquitetura DDD](https://www.devmedia.com.br/java-e-domain-driven-design-na-pratica-java-magazine-87/19019)
- [Padrão REST API](https://restfulapi.net/)
- [Karma Commit Messages](http://karma-runner.github.io/1.0/dev/git-commit-msg.html)
- [Spring REST Client - RestTemplate](https://www.baeldung.com/rest-template)
- [Brazilian zip code API - ViaCEP](https://viacep.com.br/)

'* Ferramentas opcionais

## Sobre o Curso Mergulho Spring REST (MSR)

O curso é bem básico e voltado para quem nunca desenvolveu uma REST API com Java e Spring. Contudo, possui uma abordagem bem didática e sempre fundamentada nos conceitos e documentações, bem como nas boas práticas do mercado. Assim sendo, também faz-se válido como reforço para quem já possui experiência com a tecnologia utilizada.

É 100% online e gratuito, e aborda os fundamentos de REST, os Métodos e Códigos de status HTTP, a conceituação do Ecossistema Spring, a implementação de um Sistema Back-end (REST API) Java com Spring Boot e Spring MVC, a persistência de dados com Jakarta Persistence, Spring Data JPA e Flyway, validações com Bean Validation e tratamento de exceptions.

Link para o curso [Mergulho Spring REST (MSR)](https://msr.algaworks.com/)

<p align="center"><img alt="Vídeo do Projeto" id="video1" title="#VideoProjeto" height="450px" src="https://raw.githubusercontent.com/aguiardafa/gerenciamento-entregas-api/main/.github/Video1.gif" /></p>

## 👨‍💻Autor

<a href="https://github.com/aguiardafa" style="text-decoration: none;">
<img style="border-radius: 50% !important;" src="https://avatars.githubusercontent.com/u/16319889?v=4" width="48px" height="48px" alt="Diego Aguiar"/>
<br />
<span> Feito por Diego Aguiar 👋 Entre em contato! </span> 
</a>

