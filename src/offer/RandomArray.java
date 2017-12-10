package offer;

import test.Test;

import java.util.Random;

public class RandomArray {

    public static void main(String[] args) {
        getNumber(100);
        System.out.println(ReverseSentence("Good nihao"));
    }

    public static int[] getNumber(int total) {
        int[] NumberBox = new int[total];            //容器A
        int[] rtnNumber = new int[total];            //容器B
        for (int i = 0; i < total; i++) {
            NumberBox[i] = i;        //先把N个数放入容器A中
        }
        int end = total - 1;

        for (int j = 0; j < total; j++) {
            int num = new Random().nextInt(end + 1);    //取随机数
            rtnNumber[j] = NumberBox[num];            //把随机数放入容器B
            NumberBox[num] = NumberBox[end];            //把容器A中最后一个数覆盖所取的随机数
            end--;                                    //缩小随机数所取范围
        }
        Test.qSort(rtnNumber);
        return rtnNumber;                            //返回int型数组
    }

    private static String ReverseSentence(String str) {
        return str.length() > 0 ? ReverseSentence(str.substring(1)) + str.charAt(0) : "";
    }


    private static boolean equal(int i) {
        return 31 * i == ((i << 5) - i);
    }
}
