import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        List<Boolean> list;
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine(),10);

        if(n<=1) {
            return;
        }

        list = new ArrayList<>(n+1);

        list.add(false);
        list.add(false);

        for(int i=2;i<=n;i++) {
            list.add(i,true);
        }

        for(int i=2;i*i<=n;i++) {
            if(list.get(i)) {
                for(int j=i*i; j<=n; j+=i) {
                    list.set(j,false);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i=0; i<=n; i++){
            if(list.get(i)){
                sb.append(i);
                sb.append(",");
            }
        }
        sb.setCharAt(sb.length()-1, '}');

        System.out.println(sb.toString());

    }
}
