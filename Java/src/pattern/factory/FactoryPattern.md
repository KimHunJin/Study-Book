## Factory Method Pattern

팩토리 패턴은 구체적인 생성 방법을 자식 클래스에서 정의하는 방법이다.

```
abstract class DBConnection {

    String getUser() {
        Connection c = getConnection();

        // c.~~

        return "유저";
    }

    abstract Connection getConnection();
}

class Oracle extends DBConnection {

    @Override
    Connection getConnection() {

        //return new Connection("오라클);
        return null;
    }
}

class MariaDB extends DBConnection {

    @Override
    Connection getConnection() {
        // return new Connection("마리아디비");
        return null;
    }
}
```
