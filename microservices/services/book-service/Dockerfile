FROM maven:3.9.9-eclipse-temurin-24-alpine AS builder
LABEL authors="wujciak"

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:24-jdk-alpine AS jre-build

WORKDIR /app

RUN apk add --no-cache binutils

COPY --from=builder /app/target/*.jar app.jar

RUN jdeps --ignore-missing-deps -q \
    --recursive \
    --multi-release 24 \
    --print-module-deps \
    --class-path app.jar \
    app.jar > deps.info

RUN jlink \
    --verbose \
    --add-modules $(cat deps.info | grep -v 'requires' | grep -v 'uses' | awk '{print $1}' | tr '\n' ',')java.desktop,java.management,java.naming,java.security.jgss,java.instrument,jdk.unsupported,java.sql,java.net.http,jdk.crypto.ec,java.xml,jdk.httpserver \
    --strip-debug \
    --compress 2 \
    --no-header-files \
    --no-man-pages \
    --output /custom_jre

FROM alpine:3.22.1

WORKDIR /app

ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY --from=jre-build /custom_jre $JAVA_HOME
COPY --from=builder /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
