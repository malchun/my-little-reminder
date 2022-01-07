# Building micronaut service

## Initial service
Created new project using next resources:

 * [very-first-microservice-with-micronaut-and-kotlin](https://medium.com/reverse-engineering/creating-your-very-first-microservice-with-micronaut-and-kotlin-9be6be4a58d5)
 * [micronaut-creating-first-graal-app-maven-kotlin](https://guides.micronaut.io/latest/micronaut-creating-first-graal-app-maven-kotlin.html)
 * [micronaut-guide](https://docs.micronaut.io/latest/guide/#creatingServer)

then added swagger as explained in [micronaut-swagger-doc](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html) 
(don't forget to expose swagger index.html like [here](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html#exposingSwaggerOutput)).
More on OpenAPI/Swagger [swagger-core-doc](https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Getting-started)
Micronaut has a gradle plugin [micronaut-gradle-plugin-doc](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)) which has tasks `dockerBuild` and `dockerBuildNative`.
Those tasks build native or usual Java docker image, so docker-compose for native image was added. For base image Java 17 was chosen because why not?

### Testing 
For testing example from [creating-your-first-micronaut-app-gradle-kotlin](https://guides.micronaut.io/latest/creating-your-first-micronaut-app-gradle-kotlin.html)
was used and slightly modified. There were a couple of problems:

 * To run tests I had to update `java version` for gradle in IDEA to 17 and then gradle version in `gradle-wrapper.properties` to 7.3 - lowest to work with Java 17
 * Example uses `retrieve()` function, but it returns only body. To check also rest of response there is a function `exchange()` which requires response body type. 
For Java Strings it should be set as `Java::class.java` or you get `CodecException`

For tests given/when/then semantics was chosen (like this of [Spock](https://github.com/spockframework/spock)) as a simple visible reminder of good test structure 