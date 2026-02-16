class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int i : digits) {
            freq[i]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 100; i <= 998; i += 2) {
            if (helper(i, freq)) {
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private boolean helper(int n, int[] freq) {
        int[] copy = freq.clone();  
        while (n > 0) {
            int digit = n % 10;
            if (copy[digit] == 0) {
                return false;
            }
            copy[digit]--;
            n /= 10;
        }
        return true;
    }
}
