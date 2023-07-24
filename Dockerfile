#FROM maven:3.9.3-eclipse-temurin-17 as build
#WORKDIR /app

#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#COPY src src


#RUN mvn clean package -DskipTests
#RUN ./mvnw install -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#FROM openjdk:17-jdk
#WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
#CMD ["java","-jar","app.jar"]

#VOLUME /tmp
#ARG DEPENDENCY=/app/SpringBlogdto/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /SpringBlogdto
#ENTRYPOINT ["java","-cp","app:app/lib/*","SpringBlogdto"]

FROM maven:3.9.3-eclipse-temurin-17 as build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]