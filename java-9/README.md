# ORM Java

Este desafio contém um projeto Maven pré-configurado com Springboot, Spring-JPA e banco de dados H2.
Abaixo você encontra um Modelo Entidade Relacionamento de um banco de dados utilizado pela Code Nation.

[Clique aqui para visualizar o modelo de entidade relacionamento](https://codenation-challenges.s3-us-west-1.amazonaws.com/java-9/codenation-sample.png)

Você utilizará o package `entity` para criar as entidades JPA para o modelo proposto.

Informações adicionais:
- O projeto deve `buildar` e `iniciar` sem erros
- Verifique os *logs* para ter certeza de que suas tabelas foram criadas corretamente
- Utilize o comando `mvnw spring-boot:run` para iniciar a aplicação

O que será  avaliado:

- Colunas não nulas
- Tamanho das colunas
- Relacionamento entre tabelas (bidirecionalmente)
- Nome de tabelas e colunas