plugins {
    java
    id("org.springframework.boot") version "3.2.2"
    // 충돌을 일으키는 dependency-management 플러그인을 과감히 제거했습니다.
}

group = "com.likelion"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // dependency-management 플러그인이 없으므로, 버전을 직접 명시하여 안정적으로 가져옵니다.
    // 과제 제한 조건(Spring Web 외 추가 금지)을 완벽하게 만족합니다.
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}