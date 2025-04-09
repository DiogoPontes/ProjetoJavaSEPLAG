# Etapa de build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package spring-boot:repackage -DskipTests

# Etapa de execução
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/concurso-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
