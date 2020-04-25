# Collection Framework

![Collection Framework](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/collection_framework.png)

> 다수의 데이터를 쉽고 효과적으로 처리할 수 있는 표준화된 방법을 제공하는 클래스의 집합을 의미
    - 데이터를 **저장**하는 자료구조와 **처리**하는 자료구조를 구조화하여 클래스로 구현해 놓은 것
        - List
        - Set
        - Map
    - 구조상 차이로 List와 Set은 Collection을 상속받지만, Map은 별도로 정의

- List
    - 순서가 있는 데이터 집합
    - Vector, ArrayList, LinkedList ...
    
    
- Set
    - 순서가 없는 데이터 집합
    - 중복을 허용하지 않음
    - HashSet, TreeSet ...
    - TreeSet이나 LinkedSet의 경우 순서를 유지함.
    
- Map
    - Key와 Value의 쌍으로 이루어진 데이터 집합
    - 순서가 없음
    - Key는 중복 허용 X, Value는 중복 허용 O
    - HashMap, TreeMap, HashTable ...
    - TreeMap이나 LinkedHashMap의 경우 순서 유지


---

### HashMap vs HashTable vs ConcurrentHashMap

- HashMap
	- 동기화가 되어있지 않음

- HashTable
	- 동기화가 자동으로 되어있음

- ConcurrentHashMap
	- Thread-safe한 HashMap
    
