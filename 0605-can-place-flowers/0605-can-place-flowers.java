class Solution {
    /**
    0이 연속으로 세개 있거나, 양 끝 하나전에 영이있는경우
    */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int counter =0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    counter++;
                }
            }
        }
        return counter >= n;
    }
    

}