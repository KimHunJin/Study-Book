# Java8 Hash Map

[참고](https://www.nagarro.com/en/blog/post/24/performance-improvement-for-hashmap-in-java-8)

HashMap에서 성능 저하 요소가 가장 컸던 부분은 해시충돌이 발생했을 때다. <br/>
java7에서는 해시 충돌이 발생 시 Linked List로 관리했다. 이 경우 최악의 시간이 O(N)이 소요되게 된다. <br/>
속도가 조금 더 빠른 concurrent Hash Map을 사용해도 되지만, concurrent 패키지는 기본적으로 동기화가 되어있다. <br/>
concurrent의 hash 충돌 기법을 참고하여 자바8에서는 hash 충돌 기법이 개선됐다.

java8에서의 hashMap의 performance를 크게 끌어올리는 변경점은 binary tree의 사용이다. <br/>
버킷의 수가 특정 개수에 도달하게 되면 linked list로 이뤄졌던 값을 binary tree로 변경한다.<br/>
이 경우 최악의 시간이 O(log(n))이 된다. 특정 케이스에서는 기본 해시맵 보다 느릴 수 있으나, <br/>
해시 충돌이 많이 발생하는 대용량의 데이터일 때 기존 해시맵보다 확연한 성능 차이를 보여준다. (링크 참고)
