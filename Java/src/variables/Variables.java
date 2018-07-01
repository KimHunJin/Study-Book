package variables;

public class Variables {
    public static void main(String[] args) {
        Variables variables = new Variables();
        variables.typeBoolean();
        variables.typeCharacter();
        variables.typeInteger();
        variables.typeReal();
    }

    /**
     논리형 (true, false)
     */
    private void typeBoolean() {
        boolean isBool = true; // boolean type is 1byte
        System.out.println("boolean : " + isBool);
    }

    /**
     문자형 ('a','b','c' ...)
     */
    private void typeCharacter() {
        char character = 'a'; // char is 2bytes
        System.out.println("char : " + character);
    }

    /**
     정수형 (-2^n ~ 2^n)
     */
    private void typeInteger() {
        byte bNum = 1; // -128 ~ 127 ; byte is 1byte
        short sNum = 1; // -32768 ~ 32767 ; short is 2bytes
        int iNum = 1; // -2,147,483,648 ~ 2,147,483,647 ; int is 4bytes
        long lNum = 1L; //-9,223,272,036,854,775,808 ~ 9,223,372,036,854,775,807 ; long is 8bytes
        System.out.println("byte : " + bNum);
        System.out.println("short : " + sNum);
        System.out.println("integer : " + iNum);
        System.out.println("long : " + lNum);
    }

    /**
     실수형 (소수점 자리 가능)
     */
    private void typeReal() {
        float fNum = 1.0f; // float is 4byte
        double dNum = 1.0d; // double is 8byte

        System.out.println("float : " + fNum);
        System.out.println("double : " + dNum);
    }
}
