plugins {
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22" // @Configuration, @Component 등 스프링이 프록시 객체 생성을 할 수 있도록 open처리
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "me.hs"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		// Spring Cloud BOM 추가 - 사용 중인 Spring Boot 버전에 맞는 BOM 선택
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.1") // 최신 안정 버전 권장
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
