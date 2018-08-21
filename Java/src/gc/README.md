## GC (Garbage Collection)
사용하지 않는 메모리를 해제시켜주는 과정.

### Young 영역
새롭게 생긴 객체들이 머무는 영역 <br/>
이 영역에서 객체들이 사라질 때 Minor GC가 발생 <br/>

1개의 Eden 영역과 2개의 Survivor 영역으로 구성.

* 새롭게 생긴 객체들은 Eden 영역에 위치함.
* Eden 영역에서 한 번 살아남은 객체는 Survivor 영역 중 하나로 이동
* Eden 영역으로 부터 GC가 계속 발생하여 Survivor 영역으로 객체를 계속 쌓음.
* Survivor 영역이 가득 차면 다른 Survivor 영역으로 객체를 이동시킴.
* 이 과정을 반복하다 살아남은 객체들을 Old 영역으로 이동.

### Old 영역
Young 영역에서 살아남은 객체들이 머무는 영역 <br/>
Young 영역보다 GC가 덜 일어나며, 이 영역에서 객체들이 사라질 때 Major GC (Full GC)가 발생


