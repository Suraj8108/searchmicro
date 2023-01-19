FROM openjdk:17
EXPOSE 8090
Add target/search-project.jar search-project.jar
ENTRYPOINT ["java", "-jar", "/search-project.jar"]