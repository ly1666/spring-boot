package demo;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;
        int k;
        i = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(i+k);
    }
    @Test
    public void demo() {
        System.out.println(sum(1));
    }
    public static int sum(int num){
        if(num == 100){
            return 100;
        }
        int var = num +sum(num+1);
        System.out.println(var);
        return var;
        //return num + sum(num+1);
    }
}
