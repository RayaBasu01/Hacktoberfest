import java.util.*;
public class PascalsTriangle {
    public static void main(String[] args) {
        int n=4;
        List<List<Integer>> ans=generateFulltriangle(n);

        System.out.println(ans);

        List<Integer> ans1=getRow(n);
        System.out.println(ans1);
    }

    public static List<List<Integer>> generateFulltriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;
        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; ++j)
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));
            pre = row;
            res.add(row);
        }
        return res;
    }

    static List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <k; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }
}
