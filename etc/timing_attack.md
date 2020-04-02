## 타이밍 어택

알고리즘의 시간차이를 이용하여 정보를 얻는 방법을 타이밍 어택이라고 한다.

예를 들어,

```

public static boolean isEquals(String a, String b) {
    if (a.length() != b.length()) {
        return false;
    }

    for (int i=0; i<a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) {
            return false;
        }
    }
    return true;
}

```

위와 같은 코드가 있다고 하자.

누구나 한 번쯤은 짜봤을 두 문자열의 비교 연산이다.

시간을 조금이라도 빠르게 하기 위해, 비교를 진행하면서 한 글자라도 달라지면 그 시점에 바로 false를 반환한다.

타이밍 어택은, 이 문자가 달라지는 시점을 미세하게 달라지는 함수의 실행 속도로 비교하여 한글자씩 맞춰가는 방법이다.

예를 들어, 100만의 길이를 가지는 두 문자열이 있을 때,
첫번째 문자가 다른 두 문자열과, 100만번째 문자가 다른 두 문자열이 같은지 확인하는 알고리즘을 위와 같은 코드로 실행하게 되면, 시간의 차이가 분명히 있을 것이다.

이를 방지하기 위해서 다음과 같은 방법을 사용한다.

다른 문자여도, 같은 문자여도 동일한 시간 복잡도를 가지게 만든다.

```

public static boolean isEquals(String a, String b) {
    if (a.length() != b.length()) {
        return false;
    }

    boolean isResult = true;

    for (int i=0; i<a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) {
            isResult = false;
        }
    }
    return isResult;
}

```

좀 더 빠른 방법으로 다음과 같은 방법이 있다.

```

public static boolean isEqual(byte[] a, byte[] b) {
    if (a.length != b.length) {
        return false;
    }

    int result = 0;
    for (int i = 0; i < a.length; i++) {
      result |= a[i] ^ b[i];
    }
    return result == 0;
}

```