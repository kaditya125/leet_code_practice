class Solution {
    public int numberOfBeams(String[] bank) {
        int pre = 0;

        for (int i = 0; i < bank[0].length(); i++) {
            if (bank[0].charAt(i) == '1') {
                pre++;
            }
        }

        int current = 0;
        int res = 0;

        for (int i = 1; i < bank.length; i++) {
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') 
                {
                    current++;
                }
            }

            if (current != 0) {
                res += current * pre;
                pre = current;
                current = 0;
            }
        }

        return res;
    }
}
