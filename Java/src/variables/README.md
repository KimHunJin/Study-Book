## 변수

java는 기본형(primitive)과 참조형(reference) 타입을 가진다.

### 기본형(primitive type)
1. 논리형 : boolean
2. 문자형 : char
3. 정수형 : byte, short, int, long
4. 실수형 : float, double


| | 1byte | 2byte | 4byte | 8byte |
|-|-------|-------|-------|-------|
| 논리형| boolean | | | |
| 문자형 | | char | | |
| 정수형 | byte | short | int | long |
| 실수형 | | | float | double |

### 참조형(reference type)
> 기본형을 제외한 나머지 타입, 객체의 주소를 저장한다.


### 형변환
> 변수 또는 리터널의 타입을 다른 타입으로 변환하는 것.

[key word]
1. boolean을 제외한 나머지 7개의 기본형은 서로 형변환 가능.
2. 기본형과 참조형은 서로 형변환 불가
3. 서로 다른 타입의 변수간의 연산은 형변환을 하는 것이 원칙
4. 값의 범위가 작은 타입에서 큰 타입으로의 형변환은 생략 가능
