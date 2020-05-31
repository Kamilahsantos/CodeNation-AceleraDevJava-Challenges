# Gerador de frases do Monty Python

Monty Python foi um dos grupos de comediantes mais influentes e reverenciados da história da TV. Vamos criar uma API para gerar frases aleatórias coletadas dos episódios da trupe, de acordo com nosso ator favorito.

## Tópicos

Neste desafio você aprenderá:

- Java
- Criar APIs
- Testar APIs
- Ler dados de um banco de dados
- Spring Boot
- JPA

## Requisitos
​
Para este desafio você precisará de:

- Java 8 (ou superior)
- Git

## Detalhes

Banco de dados *H2* com uma tabela chamada *scripts* com a estrutura:


```
CREATE TABLE IF NOT EXISTS "scripts" (
  "id" INTEGER PRIMARY KEY,
  "episode" INTEGER,
  "episode_name" TEXT,
  "segment" TEXT,
  "type" TEXT,
  "actor" TEXT,
  "character" TEXT,
  "detail" TEXT,
  "record_date" TIMESTAMP,
  "series" TEXT,
  "transmission_date" TIMESTAMP
);
CREATE INDEX "ix_scripts_index"ON "scripts" ("index");
```

Na coluna *detail* estão as frases que devem ser apresentadas pela API. Na coluna *actor*, consta o nome do ator.

A API deve responder pelas seguintes URLs:

## /v1/quote

Método: GET

Retorna uma frase aleatória de qualquer ator.


## /v1/quote/{actor}

Método: GET

Retorna uma frase aleatória do ator passado como parâmetro.

O formato esperado em ambas URLs é uma _Response JSON_:

```json
{"actor":"John Cleese","quote":"Yes, cigarettes. My hovercraft is full of eels."}
```

## Rodando a aplicação

Executar o comando `gradlew bootRun`

A aplicação estará disponível em `http://localhost:8080`
