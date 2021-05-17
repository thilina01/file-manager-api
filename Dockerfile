# Build Stage for Spring boot application image
FROM openjdk:16-jdk-alpine as build

WORKDIR application

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x ./mvnw
# download the dependency if needed or if the pom file is changed
RUN ./mvnw dependency:go-offline -B

RUN ./mvnw package -DskipTests

RUN cp /application/target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

# Production Stage for Spring boot application image
FROM openjdk:16-alpine as production
ARG TZ='Asia/Colombo'
ENV DEFAULT_TZ ${TZ}
RUN apk upgrade --update \
  && apk add -U tzdata \
  && cp /usr/share/zoneinfo/${DEFAULT_TZ} /etc/localtime \
  # && apk del tzdata \
  && rm -rf /var/cache/apk/*

WORKDIR application
COPY --from=build application/dependencies/ ./
COPY --from=build application/spring-boot-loader/ ./
COPY --from=build application/snapshot-dependencies/ ./
COPY --from=build application/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

#docker build -t thilina01/oms-api:test .
