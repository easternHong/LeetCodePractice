/**
 * Created by hds on 17-9-28.
 */
public class Print99 {

    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }
            System.out.println();
        }
        System.out.println();

        //用一个数打印
        for (int i = 1, j = 1; i <= 9; j++) {
            System.out.print(i + "*" + j + "=" + i * j + " ");
            if (i == j) {
                i++;
                System.out.println();
                j = 0;
            }
        }
    }
}
