# ---- ESTÁGIO 1: Build ----
# Usando uma imagem oficial do Maven com o JDK 21, conforme especificado no seu pom.xml.
FROM maven:3.9-eclipse-temurin-21 AS build

# Define o diretório de trabalho dentro do contêiner.
WORKDIR /app

# Copia o arquivo pom.xml para baixar as dependências.
COPY pom.xml .

# Otimização: baixa as dependências antes de copiar o código para aproveitar o cache do Docker.
RUN mvn dependency:go-offline

# Copia todo o código-fonte do seu projeto.
COPY src ./src

# Executa o build do Maven para gerar o arquivo .jar.
# A flag -DskipTests acelera o processo por não rodar os testes durante o build.
RUN mvn package -DskipTests


# ---- ESTÁGIO 2: Execução ----
# Usando uma imagem JRE (Java Runtime Environment) leve e correspondente à sua versão Java (21).
FROM eclipse-temurin:21-jre

# Define o diretório de trabalho.
WORKDIR /app

# Expõe a porta padrão do Spring Boot (8080). O Render irá mapeá-la automaticamente.
EXPOSE 8080

# Copia o arquivo .jar gerado no estágio 'build' para a imagem final.
# O nome do JAR foi extraído do seu pom.xml (<artifactId> e <version>).
COPY --from=build /app/target/dslist-0.0.1-SNAPSHOT.jar app.jar

# Comando para iniciar sua aplicação Spring Boot quando o contêiner for executado.
ENTRYPOINT ["java", "-jar", "app.jar"]