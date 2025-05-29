# Olá!

Primeiramente, muito obrigado pela oportunidade. Essa é a primeira atividade do teste da L2. A segunda atividade pode ser encontrada [clicando aqui](https://github.com/allan-assis/escolinha-girafales).

**Sobre o projeto:** <br/>
Criado no *Initializr* usando Spring Boot v3.5.0, Java 17 e Maven. Desenvolvimento no VSCode, conteinerização com Docker e testes da API com Swagger. <br/>

## Rodando a API

### Execução Local (sem Docker)

1. **Compilar e rodar**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

2. A aplicação será iniciada em `http://localhost:8080`.

### Execução com Docker

1. **Build da imagem**:

   No diretório do projeto:

   ```bash
   docker build -t embalagem-api:latest .
   ```

2. **Executar o container**:

   ```bash
   docker run -d --name embalagem-api -p 8080:8080 embalagem-api:latest
   ```

3. Para parar/remover:

   ```bash
   docker stop embalagem-api
   docker rm embalagem-api
   ```

### Acessando o Swagger UI

Com a aplicação rodando (local ou Docker), abra no navegador:

```
http://localhost:8080/swagger
```
