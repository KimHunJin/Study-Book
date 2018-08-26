# Union Find

[2018 카카오 코드Festival C번](https://www.acmicpc.net/problem/15956)  
[1717 집합의 표현](https://www.acmicpc.net/problem/1717)  
[1976 여행가자](https://www.acmicpc.net/problem/1976)  
[10775 공항](https://www.acmicpc.net/problem/10775)  
[9938 방 청소](https://www.acmicpc.net/problem/9938)  
[3780 Corporative Network](https://www.acmicpc.net/problem/3780)  

## 개념
### Union Find 란?
* 대표적 그래프 알고리즘으로, `합집합 찾기` 라는 의미를 가지고 있다. 
* 상호 배타적 집합(Disjoint-set) 이라고도 한다. 
* 여러 노드가 존재할 때, 두 개의 노드를 선택해서 두 노드가 서로같은 그래프에 속하는지 판별하는 알고리즘이다.
* 두 가지 연산이 존재한다. 
  - Find : x 가 어떤집합에 포함되어 있는지 찾는 연산
  - Union : x와 y가 포함되어 있는 집합을 합치는 연산 

### 구조 
![image](https://user-images.githubusercontent.com/7833598/44299715-6b62d200-a336-11e8-8c47-53e1e7c6101f.png)

가장 위에 있는 노드가 각 트리의 루트라 본다면, 그 트리에 속해 있는 정점들은 같은 집합이다. 

## Find
두 원소가 같은 집합에 속해있는지 확인하는 방법은 각각의 루트를 찾아서 같은지 비교하는 것이다.
find 연산은 **특정 정점의 루트** 를 찾아주는 연산이다. 

```java
private int find(int x) {
    if(x == parent[x]) return x;
    else find(p[x]);
}
```
자신의 부모에 대한 정보를 저장한 배열이 `parent` 이고, `parent[root] = -1` 로 초기화 한다. 
> Arrays.fill(parent, -1); 등으로 초기화 작업 필요. 

### Find에서의 시간 단축
![image](https://user-images.githubusercontent.com/7833598/44299778-47ec5700-a337-11e8-812e-cefdfdb1dc3d.png)

문제는, 이런 구조에서 `find(6)` 을 호출 시, 재귀함수 호출이 많이 이루어진다는 점이다. 
**한번 6의 root가 2인것을 알았다면, 6을 떼어내서 2의 아래로 붙인다.**
이러한 방식으로 이 트리를 아래와 같이 바꿀 수 있다. 

![image](https://user-images.githubusercontent.com/7833598/44299805-94379700-a337-11e8-9590-84dcd06ad9e9.png)

이 개선된 find 를 구현하면 기존 find 코드에 한줄만 추가하면 된다.
```java
private int find(int x) {
    if(x == parent[x]) return x;
    paretn[x] = find(parent[x]);
    return find(p[x]);
}
```
크기가 N인 Union-Find 구조에 M번 find 연산을 수행한다고 가정하자.
개선 전 최악 시간복잡도는 `O(MN)` 이다. (노드가 일렬로 연결되어 있는 경우)
개선 후 최악 시간복잡도는 `O(Mlong*N)` 이다. (* : Ackman function)
> [Ackman 함수 설명](https://en.wikipedia.org/wiki/Ackermann_function)


## Union
두 집합을 하나로 합쳐주는 연산이다. 
과정은 다음과 같다.

1. 합칠 두 집합이 같은 집합인지 확인하고, 같다면 종료한다.
2. 다르다면, 둘 중 하나의 root를 다른 집합 root의 child가 되도록 연결한다. 

```java
private void merge(int a, int b) {
    a = find(a);
    b = find(b);
    if(a == b) return;
    parent[b] = a;
}
```
b의 부모를 a로 지정함으로써 합치는 코드이다. 

### Union+
`집합의 크기` 를 저장할 수 있다면 유용하게 사용할 수 있다. 
`parent[root]` 값은 음수이고, 항상 절대값이 0보다 크다. 
따라서, parent[root]값을 음수로 하되, `Math.abs(parent[root]) == fistSet.size()` 로 지정한다. 

```java
private void merge(int a, int b) {
    a = find(a);
    b = find(b);
    if(a == b) return;
    parent[a] += parent[b];
    parent[b] = a;
}
```
parent[a] 와 parent[b] 모두 각자 집합의 크기에 대한 정보를 가지고 있다. 
parent[a] += parent[b] 로 갱신해줌으로써 새로운 집합의 크기에 대한 정보를 일정하게 유지할 수 있다. 

이러한 생각을 응용한다면, 집합 크기가 큰 쪽이 root가 되도록 강제하는 방법도 가능하다. 

## 출처
[브랜든의 블로그](http://brenden.tistory.com/33)  
[라이_네이버 블로그](https://kks227.blog.me/220791837179)
