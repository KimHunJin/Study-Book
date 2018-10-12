## Druid를 활용한 빅데이터 분석

### 1. 데이터 분석의 필요성
	* 사용자의 편의를 위해

### 2. Druid? 그게 뭔데?
	* 컬럼기반 분산 저장소
	* Time 기반 Partitioning
	* 실시간/배치 데이터 저장기능 제공
	* 데이터 질의 기능 제공

#### Druid vs ElasticSearch vs Kudu
* Druid
	- 저장/질의기능 제공
	- 빠른 필터처리
* Elasticsearch
	- 기존 사용 플랫폼
	- 저장/질의 기능 제공

* Apach Kudu
	- 가장 적은 저장공간
	- 빠른 조회(Scan) 기능
	- 질의기능 미제공(질의엔진 필요)