package cn.zhangxd.registry;

import org.junit.jupiter.api.Test;

public class demo {
    public static void main(String[] args) {
        System.out.println(sum(1));
    }

    @Test
    public void demo() {
        System.out.println(sum(1));
    }
    public static int sum(int num){
        if(num == 100){
            return 100;
        }
        return num + sum(num+1);
    }
}
