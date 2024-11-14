import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    static char[] nums;
    static int limitCount;
    static String result;
    
	public static void main(String args[]) throws Exception
	{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums = st.nextToken().toCharArray();
            limitCount = Integer.parseInt(st.nextToken());
            result = "";
            dfs(0, 0);
            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void dfs(int start, int depth) {
        if (depth == limitCount) {
            String current = new String(nums);
            if (current.compareTo(result) > 0) {
                result = current;
            }
            return;
        }
        for (int i = start; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                swap(i, j);
                dfs(i, depth + 1);
                swap(i, j);
            }
        }
    }
    
    private static void swap(int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}