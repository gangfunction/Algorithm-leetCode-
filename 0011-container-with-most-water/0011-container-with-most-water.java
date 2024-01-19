class Solution {
        /**
        넓이를 구하는 것인데. 결과값의 최댓값을 구하는게 주 목적
        장르가 투 포인터 문제 그러면 투포인터를 활용해서 문제를 푸는게 좋을거같고,
        하나는 좌측끝, 하나는 우측끝에 두어야한다.
        그러면 변수로 두어야하는게 가로변하고 세로변
        넓이를 갱신하는 공식은 세로변(값)* 가로변(거리)
        
        */
    public static int maxArea(int[] height) {
        if(height.length ==2){
            if(height[0]>height[1]){
                return height[1];
            }
            else{
                return height[0];
            }
        }
        int lp =0 , rp=height.length-1;
        int maxIndex = findIndex(height);
        int distance;
        int tempMax=0;
        int area;
        if(height.length ==3){
            if(height[0]>height[2]&& height[1]>=(height[0]*2)){
                return height[1];
            }
            else if(height[2]>=height[0] && height[1]>=(height[2]*2)){
                return height[1];
            }

        }
        while(lp != rp && lp< height.length&& rp<height.length && 0<=lp && 0<=rp){
            if(height[lp] > height[rp]){  
                area = square(height[rp],rp-lp, tempMax);
                tempMax = area;
                rp -=1;
            }
            else if( height[lp] < height[rp]){
                area = square(height[lp],rp-lp,tempMax);
                tempMax = area;
                lp +=1;
            }
            else if(height[lp] == height[rp]){
                area = square(height[rp],rp-lp, tempMax);
                tempMax = area;
                lp +=1;
                rp -=1;
            }
        }
        return tempMax;
    }
    private static int square(int x, int y, int tempMax){
        if(tempMax> (x*y)){
            return tempMax;
        }
        return x*y;
    }
    private static int findIndex(int[] height){
        int tpMax = 0;
        int answer = 0;
        for(int i=0; i<height.length; i++){
            if(tpMax < height[i]){
                tpMax = height[i];
                answer = i;
            }
        }
        return answer;
    }
}