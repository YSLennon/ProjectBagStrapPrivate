# 빌드 스테이지
FROM eclipse-temurin:17-alpine AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

# 런타임 스테이지
FROM eclipse-temurin:17-jre-alpine AS runtime

WORKDIR /app

RUN addgroup -g 1000 worker && \
    adduser -u 1000 -G worker -s /bin/sh -D worker

COPY --from=build --chown=worker:worker /app/target/*.war ./app.war

# /static 디렉토리 생성 및 권한 설정
RUN mkdir -p /app/static && chown -R worker:worker /app/static && chmod 755 /app/static
# COPY ./src/main/resources/static/src /app/static

USER worker:worker

ENV PROFILE="docker"

EXPOSE 8080

# WAR 파일을 실행하기 위한 ENTRYPOINT
ENTRYPOINT ["java", "-jar", "app.war", "--spring.profiles.active=${PROFILE}"]
