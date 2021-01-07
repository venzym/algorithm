package two_pointer;

public class SlidingWindow {
    /**
     * 슬라이딩 윈도우 알고리즘
     */
    public static void main(String[] args) {

        int[] arr = {2,4,7,10,8,4,5,6,7,1};

        int k=3;

        int window_sum = 0;
        int start = 0;
        int max_sum = 0;

        for (int end=0; end<arr.length; end++) {
            window_sum += arr[end];

            if (end >= (k-1)) {//end 0부터 시작
                //해당 범위의 개수를 구하면 start, end +1 하여 다음 범위 탐색
                max_sum = Math.max(max_sum, window_sum);
                window_sum -= arr[start++];
            }
        }

        System.out.println(max_sum);

    }
}
