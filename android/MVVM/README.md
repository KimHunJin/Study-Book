## MVVM Pattern / Retrofit2 / Dagger2 / rxjava2(rxandroid2)

### MVVM Pattern
> Model + View + ViewModel <br/>
> [MVVM Pattern 소개](https://docs.microsoft.com/en-us/xamarin/xamarin-forms/enterprise-application-patterns/mvvm) <br/>
> [데이터 바인딩 라이브러리](https://developer.android.com/topic/libraries/data-binding/)

![MVVM Architecture](https://docs.microsoft.com/en-us/xamarin/xamarin-forms/enterprise-application-patterns/mvvm-images/mvvm.png)

1. Model
    * 데이터
2. View
    * 화면에 표현될 레이아웃
3. ViewModel
    * View에 연결 할 데이터와 명령으로 구성
    * 변경 알림을 통해 View에게 상태 변화 전달
    * 전달 받은 상태 변화를 화면에 반영할 지에 대한 선택은 View가 가짐
    * 명령은 UI를 통해 동작

* **ViewModel은 Model을 알지만 View를 알지 못함.**
* **View는 Model을 알지 못하나 ViewModel을 알 수 있음**


### Retrofit2
> [Retrofit2](https://square.github.io/retrofit/) : A type-safe HTTP client for Android and Java

### Dagger2
> [Dagger2](https://github.com/google/dagger) : A fast dependency injector for Android and Java.

### rxJava (rxAndroid)
> [rxJava](https://github.com/ReactiveX/RxJava) :  Reactive Extensions for the JVM <br/>
> [rxAndroid](https://github.com/ReactiveX/RxAndroid) : Reactive Extensions for Android
