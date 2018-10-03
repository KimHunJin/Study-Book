package prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numbers);

        int number = Integer.parseInt(br.readLine());

        List<String> result = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            long sum = 0;
            for (int j = i + 1; j < input.length; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    sum = numbers[i] + numbers[j] + numbers[k];
                    if(number == sum) {
                        String s = (i+1) + " " + (j+1) + " " + (k+1);
                        result.add(s);
                    } else if(number < sum) {
                        break;
                    }
                }
            }
        }

        if(result.size() > 0) {
            for(String s : result){
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
