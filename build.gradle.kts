import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.6.0"
	id("io.spring.dependency-management") version "1.0.6.RELEASE"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.6.0"
	id("org.jetbrains.kotlin.kapt") version "1.6.0"
	id("io.micronaut.application") version "3.0.1"
}

group = "my.little"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

micronaut {
	version("3.2.0")
	runtime("netty")
	testRuntime("junit5")
	processing {
		incremental(true)
		annotations("my.little.reminder.*")
	}
}

dependencies {
	kapt("io.micronaut.openapi:micronaut-openapi")
	implementation("io.micronaut:micronaut-http-client")
	implementation("io.micronaut:micronaut-management")
	implementation("io.micronaut:micronaut-runtime")
	implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("io.swagger.core.v3:swagger-annotations")
	runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

allOpen {
	annotation("io.micronaut.aop.Around")
}

dependencyManagement {
	imports {
		mavenBom("io.micronaut:micronaut-bom:3.2.0")
	}
}

kapt {
	arguments {
		arg("micronaut.openapi.views.spec", "redoc.enabled=true,rapidoc.enabled=true,swagger-ui.enabled=true,swagger-ui.theme=flattop")
	}
}