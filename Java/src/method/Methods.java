package method;

public class Methods {

    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.voidMethod();
        methods.stringMethod();
        methods.intMethod();
        methods.polymorphismMethod();
        methods.polymorphismMethod("string");
        methods.polymorphismMethod(5);
        methods.polymorphismMethod(5,10);
    }

    /**
     * has not return value
     */
    private void voidMethod() {
        System.out.println("has not return value");
    }

    /**
     *
     * @return String value
     */
    private String stringMethod() {
        System.out.println("return string value");
        String s = "result";
        return  s;
    }

    /**
     *
     * @return int value
     */
    private int intMethod() {
        System.out.println("return int value");
        int i = 1;
        return i;
    }

    /**
     * 오버로딩
     */
    private void polymorphismMethod() {
        System.out.println("오버로딩");
    }

    /**
     * change params
     * @param a
     * @param b
     */
    private void polymorphismMethod(int a, int b) {
        System.out.println(a + b);
        System.out.println("오버로딩 - 파라미터 변환");
    }

    /**
     * change params and return type
     * @param s
     * @return String
     */
    private String polymorphismMethod(String s) {
        System.out.println("오버로딩 - 파라미터, 리턴타입 변환");
        return s;
    }

    private int polymorphismMethod(int i) {
        System.out.println("오버로딩 - 파라미터 타입");
        return i;
    }

    /**
     * error
     * 리턴 타입만 바꿔서는 에러 발생
     */
//    private String polymorphismMethod() {
//        return "";
//    }

}
