# password validate

Api para validar senha.

### Montar ambiente

1. Baixar o Java 11.
2. Baixar o projeto (git clone).
3. Na linha de comando e na raiz do projeto, gerar o jar do projeto:
   `./mvnw clean install`
4. Subir a aplicação a partir do modulo application(lendo o arquivo application-local.yml):
   `./mvnw spring-boot:run -Dspring.profiles.active=local`

# Criar a imagem
docker build \
--tag password-validate \        
--build-arg VERSION=001 \         
--build-arg REVISION=REVISION \         
--build-arg PROJECT_NAME=password-validate \     
-f devops/Dockerfile .

# Executar a imagem gerada
docker run \     
-e PROJECT_NAME=password-validate \         
-e VERSION=001 \
-e REVISION= \
-e javaXms='-Xms1024m' \         
-e javaXmx='-Xmx1536m' \      
-e environment=local \         
-p 8080:8080 \     
password-validate

### Swagger
http://localhost:8080/validate-api/v2/api-docs

http://localhost:8080/validate-api/swagger-ui/#/Validate

## Request
### Exemplo request de senha valida
curl --location --request POST 'http://localhost:8080/validate-api/v1/password/validation' \
--header 'Content-Type: text/plain' \
--data-raw 'AbTp9!fok'

### Exemplo request de senha inválida
curl --location --request POST 'http://localhost:8080/validate-api/v1/password/validation' \
--header 'Content-Type: text/plain' \
--data-raw 'AbTp9 fok'

### 
1. Arquitetura
   * Utilizando arquitetura hexagonal por conta da flexibilidade de implementação de modulos
   * Escolhido request 
2. swagger
   * Documentacao expondo api rest
3. Observabilidade 
   * Implementacao de logs
   * APM, o apm pode se adicionado posteriormente rodando junto com a aplicação passando o jar do APM escolhido no run da aplicação
4. Patterns
   1. SOLID
      * Utilizando os conceitos de SOLID
5. Clean code 
   * Utilizado sonar para qualidade de código
6. Tests
   * Criado módulo de testes de integracao - integration-tests
   * Criado tests para modulo validation
7. Design de api
   * Utilizado método post para nao expor o dado
   * Retorno 200 para resposta valida com body valor true
   * Retorno 400 para resposta invalida com body valor false
   * A proposta é receber uma string com o valor da senha e obter a resposta, caso há nessecidade de receber um json e ou a alteração para um método GET, é simples a alteração.
8. Melhorias
   * Aplicar executor design pattern, criar a camada do patter e refatorar