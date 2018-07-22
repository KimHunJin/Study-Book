
## 예외처리

예외는 두 가지로 나뉨.

컴파일 시 에러를 체크해 주는 CheckedException과

생각하지 못한 개발적인 오류로 인해 실행 시 생기는 UnCheckedException 으로 나뉨.

UnCheckedException에 대한 에러를 잡아 주는 역할을 예외처리라고 함.

## 예외처리 방법
예외처리 방법은 크게 2가지로 분류.

throws를 사용하여 메서드 뒤에서 예외를 처리하는 방법과

try - catch를 통해 메서드 내에서 예외를 처리하는 방법.

ex) void test() throws IOException { }  // throws로 처리

ex) void test() { try { } catch (IOException ie) { } // try - catch 사용

throws를 사용하면 예외의 정확한 발생시점을 알지 못하지만, 코드가 간결해지고 편하다는 장점이 있음.

try - catch를 사용하면 예외의 발생 시점을 알기 쉬움. 다만 코드가 번잡해짐.



### try - catch - finally
try - catch를 사용할 경우 예외 처리 유무에 관계없이 필수적으로 실행시켜야 할 것들이 있음.
이를 보통 finally에서 실행 
ex)
```
try {
    br = new BufferedReader(new InputSystemReader(System.in));
} catch (IOException ie) {

} finally {
    System.out.println("finally");
}
```

보통 close문을 finally에서 실행

```
try {
    br = new BufferedReader(new InputSystemReader(System.in));
} catch (IOException ie) {

} finally {
    try {
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

다만, finally에서도 try - catch가 붙어야 함.

소스가 길어짐. 그래서 jdk7부터 try - with - resources가 나옴.

```
try(BufferedReader br = new BufferedReader(new InputSystemReader(System.in))) {

} catch(IOException ie) {

}
```

자원의 할당이 종료되면 자동으로 메모리에서 지워줌.