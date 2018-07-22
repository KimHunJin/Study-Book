package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exception {

    /**
     * 메서드 위에 예외를 붙여서 처리
     * try-catch를 사용하지 않아도 되어 소스 간결
     * 하지마느 예외의 발생 시점을 정확히 알 수 없음.
     *
     * @throws IOException
     */
    private void throwsException() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        br.close();
    }

    /**
     * try - catch를 통한 예외처리
     * 어떤 시점에서 예외가 발생했는지 알기 쉬움.
     * 소스가 길어지고, 번잡한 단점
     */
    private void trycatch() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
            br.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * try - catch - finally
     * try - catch와 같은 동작 수행
     * 단, finally를 통해 예외가 발생하든, 발생하지 않든 finally문을 수행.
     */
    private void trycatchfinally() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            System.out.println("finish");
        }
    }

    /**
     * 여러 가지 예외를 담을 수 있음.
     * 마찬가지로 throws를 통해 예외를 처리 하였기 때문에 정확한 예외 발생 시점을 모름
     *
     * @throws IOException
     * @throws NullPointerException
     */
    private void multipleException() throws IOException, NullPointerException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.close();
        String s = br.readLine();
        System.out.println(s);
    }

    /**
     * try - catch의 경우 다중 예외처리를 다음과 같이 만들 수 있음.
     * 먼저 실행되는 예외가 나중에 실행되는 예외보다 가벼운 것이어야만 함.
     * ex) IOException 다음에 Exception이 나와야 함.
     * Exception이 먼저 나오면 이후 나오는 예외가 실행되지 않아 오류 발생.
     */
    private void mulitpleTryCatch() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.close();
            String s = br.readLine();
            System.out.println(s);
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        }
    }

    private void tryCatchFinallyTryCatch() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 메모리를 할당하고 이후 close를 해줘야 하는 것들에 대해서 안전하게 메모리를 할당하고 수거해 주는 방법
     * Try - With - Resources 라고 함.
     * 사용자가 Close를 하지 않아도 자동으로 Close가 되미.
     */
    private void tryWithResources() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }


    public static void main(String[] args) {

    }
}
