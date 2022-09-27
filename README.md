# password validate

Api para validar senha.

### Montar ambiente

1. Baixar o Java 11.
2. Baixar o projeto (git clone).
3. Na linha de comando e na raiz do projeto, gerar o jar do projeto:
   `./mvnw clean install`
4. Subir a aplicação (lendo o arquivo application-local.yml):
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
curl --location --request POST 'http://localhost:8080/validate-api/v1/validate/validate-password' \
--header 'Content-Type: text/plain' \
--data-raw 'AbTp9!fok'

### Exemplo request de senha inválida
curl --location --request POST 'http://localhost:8080/validate-api/v1/validate/validate-password' \
--header 'Content-Type: text/plain' \
--data-raw 'AbTp9 fok'

### ok
1. arquitetura hexagonal
2. swagger


### TODO
1. Adicionar logs
2. Adicionar validação para body null
3. docker file
4. tests