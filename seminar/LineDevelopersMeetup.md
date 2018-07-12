## Line Developers Meetup (2018.07.10 화)
> 오랫만에 세미나에 와서 열심히 들었으나,,, 내겐 너무 높은 레벨이라 아무것도 모르겠다 ㅎㅎㅎ
이해한 만큼만 작성,,,

### [Line Central Dogma](https://github.com/line/centraldogma)
service에 사용되는 configuration을 저장하기 위한 가장 안전한 저장소는?

--> vs코드 내에서 하드 코딩!	
```
but.. service를 다른 configurationd으로 설정하고 싶다면?
다시 내리고 새로 코딩... =
So! needs the other repository
```	
--> 그래서 나왔다. Central Dogma!

주로 JSON파일 저장하는데 사용 <br/>

안전해야 하기에 안전성에 도움되는 것들 지원 (버전관리 등)
> github처럼 소스를 관리하는데, github에 올릴 수 없는 것들을 관리 해주는 것.




### [Line Armeria](https://github.com/line/armeria)
웹 backend의 대부분은 비동기임 

--> blocking synchronized를 하여서 어떻게 해결은 하는데 과연 이거로 모든걸 다 할 수 있을까?

--> 사용하기 힘든 프레임워크는 누구도 원하지 않음

--> 그래서 나왔다 Armeria

자바로 만들기 엄청 불편한 rest api등을 쉽게 해주는 듯 하다.
builder패턴을 활용해 http와 https의 개별포트 적용 가능.
리퀘스트 타임 제한 역시 어렵지 않음.
빌더패턴을 활용해 동작할 기능과 반환 값을 서비스로 제공.

```
// hello world basic
Server server = new ServerBuilder()
.http(8080)
.https(8443)
.tlsSelfSigned()
.service("/", (ctx, req) -> HttpsResponse.of(" hello world"))
.build();
server.start();
```

### [Redis Cluster](#)
> 레디스는 싱글 스레드다!

클러스터 할 때 주로 사용 된다.
```
들어보면 되게 좋은데 뭔지 모르겠다 ㅎㅎㅎㅎㅎ
Automatic bursting detection도 되고,
monitoring도 되는데 하나도 모르겠네,,, 이렇게 또 자괴감 ++
```
 - 동적 리사이즈 지원


