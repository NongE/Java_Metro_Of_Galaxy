# Java_Seatro(Metro_Of_Galaxy)


## 개발환경
* Ubuntu 20.04.2 LTS
* Intellij Community

## 기능
* 특정 시간대에 특정 역에 대해 이용객이 앉아서 지하철을 이용할 수 있을지 예측치를 제공하는 서비스
* Front는 React, Back은 Spring Boot로 구성 예정
* 예측 데이터의 경우 Python을 활용하여 회귀 모델을 사용할 예정




이하 내용은 새롭게 기획되는 내용을 토대로 수정 예정임

---

## (구) Metro Of Galaxy 구조
<img src = "./Images/MOG_Design/MOG.jpg" width = "80%">

### MogService
* 조회
  * 데이터베이스 내 모든 역사에 대한 이름 조회
  * 특저 역사에 대한 정보 조회 (전화번호, 주소, 이용객 수, 앉을 수 있는 예측치 등)

### PredictSubwayUser
* 특정 역사, 특정 시간대의 지하철의 앉을 수 있는 예측치가 저장되어 있는 DB에 접근

### SubwayIdRepository
* 기본적인 역사 정보(호선, 역사명)이 저장되어 있는 DB에 접근

### SubwayInfoRepository
* 역사 별 상세 정보(주소, 전화번호 등)이 저장되어 있는 DB에 접근



## Tech Stack
* Java 11
* Spring Boot (Spring Data JPA)
* Swagger 2
* MariaDB
* OpenAPI ([서울 열린데이터 광장, 서울시 지하철 호선별 역별 시간대별 승하차 인원 정보](http://data.seoul.go.kr/dataList/OA-12252/S/1/datasetView.do))
