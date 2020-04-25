package pattern;

import java.sql.Connection;

public class FactoryPattern {

    public static void main(String[] args) {
        DBConnection oracle = new Oracle();
        DBConnection maria = new MariaDB();
    }
}

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
