# Manipulação de dados com Spring

Neste desafio você receberá um projeto Maven pré-configurado com Springboot, Spring-JPA e banco de dados H2. Este projeto também contém as classes de entidade `entity` já criadas para o Modelo de Entidade Relacionamento abaixo:

[Clique aqui para visualizar o modelo de entidade relacionamento](https://codenation-challenges.s3-us-west-1.amazonaws.com/java-10/codenation-sample-2.png)

No pacote `service` estão disponíveis interfaces de serviço para cada uma das classes `entity`.
São elas:

- UserService.java
- CandidateService.java
- SubmissionService.java
- AccelerationService.java
- CompanyService.java
- ChallengeService.java

Crie classes de serviço implementado as interfaces acima, e também as classes `repository` para manipulação dos dados.

## Services

### UserService

- findById: buscar um usuário por id
- save: Cria ou altera um usuário na base de dados
- findByAccelerationName: busca candidatos pelo nome da aceleração
- findByCompanyId: buscar usuários relacionados com uma empresa.

### CandidateService

- findByCompanyId: buscar um candidato pelo id da empresa 
- findByAccelerationId: buscar candidatos de uma aceleração
- save: Cria ou altera um candidato na base de dados

### SubmissionService

- findHigherScoreByChallengeId: Buscar o maior score de um determinado desafio
- findByChallegeIdAndAccelerationId: buscar submissões de um determinado desafio de uma determinada aceleração
- save: Cria ou altera um desafio na base de dados

### AccelerationService

- findAccelerationById: buscar uma aceleração por id
- findAccelerationByName: buscar uma aceleração pelo nome
- findByCompanyId: buscar acelerações vinculadas com uma empresa
- save: Cria ou altera uma aceleração

### CompanyService

- findById: buscar uma empresa pelo id
- findbyAccelerationId: buscar empresas de uma aceleração
- findByUserId: buscar empresas relacionadas com um usuário
- save: Cria ou altera uma empresa

### ChallengeService

- findByAccelerationIdAndUserId: buscar desafios feitos por um usuario em determinada aceleração
- save: Cria ou altera um desafio

##  Informações adicionais:
- O projeto deve `buildar` e `iniciar` sem erros
- Utilize o comando `mvn spring-boot:run` para iniciar a aplicação