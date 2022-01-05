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
Those tasks build native or usual Java docker image, so docker-compose for native image was added.
