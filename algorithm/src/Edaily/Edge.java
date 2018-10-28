package Edaily;

import java.util.Scanner;

public class Edge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i=1, j=n*n;i<=n;i++,j--) {
            sum += i;
            sum += j;
        }
        for(int i=1; i<n-1; i++) {
            sum += (1+n*i);
            sum += (n*(i+1));
        }
        System.out.println(sum);
    }
}
