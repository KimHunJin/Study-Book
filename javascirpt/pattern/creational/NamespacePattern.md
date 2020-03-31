## Namespace 패턴
> 하나의 전역 객체를 만들고, 모든 기능을 이 객체에 추가하는 패턴

```
// 전역 객체 
var MYAPP = {}; 

// 생성자 
MYAPP.Parent = function() {}; 
MYAPP.Child = function() {}; 

// 변수 
MYAPP.some_var = 1; 

// 객체 컨테이너 
MYAPP.modules = {}; 

// 객체들을 컨테이너 안에 추가한다. 
MYAPP.modules.module1 = {}; 
MYAPP.modules.module1.data = { a : 1, b : 2 }; 
MYAPP.modules.module2 = {};
```

- 코드 내의 이름 충돌 방지

- 네임 스페이스 생성하기 전에 존재 여부 확인

```
// 위험한 패턴 
var MYAPP = {}; 

----

// 개선된 패턴 
if(typeof MYAPP === 'undefined') { 
	var MYAPP = {}; 
} 

// 또는 더 짧게 쓸 수 있다. 
var MYAPP = MYAPP || {};
```

typescript에서 namespace를 잘못 사용할 경우 불필요한 namespace가 될 수 있다.
예를들어
```
export namespace Shapes {
	export class Triangle {}
	export class Square {}
}
```
와 같은 코드는 불필요한 코드가 된다.
shape가 triangle이나 square을 감싸고 있을 이유가 없기 때문이다.

위 코드는 ```shapes.ts``` 파일 안에
```
export class Triangle {}
export class Square {}
```

로 변경하여 사용하는 것이 바람직하다.