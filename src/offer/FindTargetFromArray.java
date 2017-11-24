package offer;

/**
 * 在二维数组中查找一个数；
 * 这个二维数组是有规律的，每一行从左到右是递增的，每一列从上到下是递增的。
 * 1.是否四个角都可以作为起始点
 * 2.为什么左上角和右下角不能作为起始点?
 * 思路: 比它小的元素都在它的左方或者上方, 比它大的元素都在它的右边或者下方
 * https://github.com/gatieme/CodingInterviews
 * 1.如果查找从右上角开始，如果要查找的数字不在右上角，则每次可以剔除一列或一行。
 * 2.也可以从左下角开始。
 * 3.但是不能从左上角或者右下角开始。
 */
public class FindTargetFromArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println("7:" + find(matrix, 7));    // 要查找的数在数组中
        System.out.println("5:" + find(matrix, 5));    // 要查找的数不在数组中
        System.out.println("1:" + find(matrix, 1));    // 要查找的数是数组中最小的数字
        System.out.println("15:" + find(matrix, 15));   // 要查找的数是数组中最大的数字
        System.out.println("0:" + find(matrix, 0));    // 要查找的数比数组中最小的数字还小
        System.out.println("16:" + find(matrix, 16));   // 要查找的数比数组中最大的数字还大
        System.out.println("16:" + find(null, 16));     // 健壮性测试，输入空指针
    }

    public static boolean find(int array[][], int target) {
        if (array == null || array.length < 1 || array[0].length < 1) {
            return false;
        }
        //列
        int col = array[0].length - 1;
        //行
        int row = 0;
        //从右上角开始
        while (col >= 0 && row < array.length) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
