# ===== STAGE 1 - BUILD =====
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copia apenas pom primeiro (melhora cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia código
COPY src ./src

# Gera o jar
RUN mvn clean package -DskipTests


# ===== STAGE 2 - RUNTIME =====
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copia jar do estágio build
COPY --from=build /app/target/*.jar app.jar

# Variáveis padrão (podem ser sobrescritas no docker-compose)
ENV PORT=8080
ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]