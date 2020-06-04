# Oauth2 com Spring

Neste desafio você receberá um projeto Maven pré-configurado com Springboot, Spring-JPA, Spring-WEB, Spring-Security e banco de dados H2.

Utilize a lib [Spring Security OAuth2 AutoConfigure](https://mvnrepository.com/artifact/org.springframework.security.oauth.boot/spring-security-oauth2-autoconfigure/2.1.6.RELEASE) para utilizar Oauth2 no seu projeto spring.

1. Configure o Resource Server através da annotation @EnableResourceServer para expor o endpoint /user e bloquear todos os outros.

2. Configure o Authentication Server através da annotation @EnableAuthorizationServer.

    - O Email dos Usuários deve ser utilizado como login
    - A aplicação deve ser configurada para utilizar o UserRepository para buscar o Usuario por e-mail
    - A senha não deve estar encriptada

3. Utilize a propriedade do spring para setar scope password, client_id e client_secret.

        security.oauth2.client.scope=password
        security.oauth2.client.client-secret=
        security.oauth2.client.client-id=

4. `GET /oauth/token`: recebendo `client_id`, `client_secret`, `grant_type`, `user` e `password`. A resposta será um JSON contendo as seguintes informações:

        {
            "access_token": "798df339-c920-4e42-9eb7-8bab168d6480",
            "token_type": "bearer",
            "refresh_token": "b0efcd1e-1459-47b6-8a55-ec09af2202b6",
            "expires_in": 85759,
            "scope": "read write trust"
        }

5. `GET /user`: deverá ser acessado sem autenticação.

6. `GET /company`: deverá ser acessado apenas com autenticação. Utilize a autenticação Bearer + token para conseguir acesso.
