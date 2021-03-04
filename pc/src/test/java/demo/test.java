package demo;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * 算法练习
 */
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        Boolean a = false;
        s = scanner.nextLine();
        if (!s.equals("###")) {
            a = huiwen(s);
        }
        System.out.println(a);
    }
    @Test
    public void demo() {
        String s = "abcdef";
        System.out.println(s.charAt(1));
    }
    //回文
    public static Boolean huiwen(String s) {
        for (int i = 0;i< s.length();i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
    //1+2+..+100
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
