class Solution {
    public int totalMoney(int n) {
        int totalMoney = 0;
        int currentDay = 1;  
        int currentAmount = 1;
        int intial=1;

        for (int i = 0; i < n; i++) {
            totalMoney += currentAmount;
            currentAmount++;

           
            if (currentDay % 7 == 0) {
                currentDay = 1;  
                currentAmount=intial+1;
                intial++;
            } else {
                currentDay++;  
            }
        }

        return totalMoney;
    }
}
