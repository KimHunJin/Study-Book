## 네이버에서 사용되는 여러가지 Data Platform, 그리고 MongoDB

네이버는 HBase를 많이 사용

> 데이터 레벨에서 샤딩이 지원되고 트랜젝션 처리가 가능한 데이터 플랫폼이 필요.

schema-less한 데이터 플랫폼의 경우 mongodb에서 키와 발류를 다 저장해야 하기에 저장공간이 커짐.
(RDBMS ; 1row 당 17bytes - MongoDB ; 1 document 당 약 48bytes)

### 샤딩
* Scale Out

### Secondary Index
* 단순 big data성 데이터는 HBase 사용

### Transaction
* ACID 지원

### node js 메모리 버퍼 문제
* eviction ; 메모리 버퍼를 비워주는 방법