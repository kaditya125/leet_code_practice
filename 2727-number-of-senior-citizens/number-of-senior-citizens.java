class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(int i=0;i<details.length;i++)
        {
            if (details[i].length() >= 14) {
            String str= details[i].substring(11,13);
            int age = Integer.parseInt(str);
            if(age>60)
            {
                count++;
            }
            }
        }
        return count;
    }
}