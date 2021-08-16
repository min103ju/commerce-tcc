![version badge](https://img.shields.io/badge/version-0.0.1-blue)
![build badge](https://img.shields.io/badge/build-passing-brightgreen)
![coverage badge](https://img.shields.io/badge/coverage-0%25-lightgrey)
# :blush: TCC MSA 주문 서비스 개발
Order Service, Payment Service, Stock Service 
총 3개의 Micro Service로 구성.
TCC를 위한 MSA이기 때문에 Rest API로 TCC만을 위한 Repository.
Zuul, Eureka, Config Server 등 MSA에 필요한 다른 서버는 무시한다.

## :hammer: 개발환경
* Java : JDK 1.8
* Spring : Spring Boot 2.5.2
* Build : Gradle
* DB : H2, MariaDB
* JPA : Spring Data JPA

## :pencil2: Getting Started
### Gradle Dependency
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-web'
compileOnly 'org.projectlombok:lombok'
runtimeOnly 'com.h2database:h2'
annotationProcessor 'org.projectlombok:lombok'
runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```
## :pushpin: 기능 요구사항
1. Order Service는 제품 주문에 대한 비즈니스를 담고 있다.
2. 주문 시 Payment(결제)와 Stock(재고) 차감을 진행한다.
3. Payment Service와 Stock Service는 각각 테이블에 임시 데이터를 저장한다.
4-1. 정상 응답 후 Order Service는 응답으로 온 Confirm URI를 호출한다.
4-2. 실패 응답 히 Order Service는 응답으로 온 Cancel URI을 호출한다.
5. Confirm/Cancel로 임시 데이터를 업데이트한다.

## :bulb: 프로그램 요구사항
1. Google Java Style Guide Conventions를 따른다.
2. the AngularJS Commit Conventions를 따른다.
3. TDD로 개발한다. 