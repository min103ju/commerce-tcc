![version badge](https://img.shields.io/badge/version-0.0.1-blue)
![build badge](https://img.shields.io/badge/build-passing-brightgreen)
![coverage badge](https://img.shields.io/badge/coverage-0%25-lightgrey)
# :blush: 주문 마이크로 서비스
Commerce 서비스 중 주문 서비스.


## :hammer: Entity
* 상품 Entity에 대한 고려는 하지 않는다.
* Order Entity의 속성 정보
    1. order-id
    2. product-id
    3. quantity
    4. amount
    5. status
    6. created-at
    7. modified-at   

## :pencil2: Getting Started
### Order Service 실행
```
./gradlew :micro-order-service:bootRun
```
## :pushpin: 기능 요구사항
1. OrderController 주문 호출 시 Order 테이블에 주문 데이터를 적재한다.
2. 주문 시 Payment(결제)와 Stock(재고) 차감을 요청한다.
3-1. Payment, Stock 실패 시 Order 테이블 주문 데이터의 상태(Error), 원인을 업데이트 한다.
3-2. Payment, Stock 실패 시 Order 테이블 주문 데이터의 상태(Confirm)를 업데이트 한다. 
