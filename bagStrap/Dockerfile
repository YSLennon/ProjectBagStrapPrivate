

# 빌드 스테이지
FROM amazoncorretto:17 AS builder

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline -B

COPY . .

RUN chmod +x ./mvnw

RUN ./mvnw package -DskipTests


# 런타임 스테이지
FROM amazoncorretto:17 AS builder

WORKDIR /app

RUN addgroup -g 1000 worker && \
    adduser -u 1000 -G worker -s /bin/sh -D worker

COPY --from=build --chown=worker:worker /app/target/*.jar ./main.jar

USER worker:worker

ENV PROFILE=${PROFILE}

EXPOSE 8081

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "main.jar"]