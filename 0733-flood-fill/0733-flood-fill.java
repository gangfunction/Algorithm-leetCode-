class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        int origin_color = image[sr][sc];
        fill(image, sr, sc, origin_color,color);
        return image;
    }
    private void fill(int[][] image , int sr, int sc , int color, int newColor){
        if( sr<0 ||sc<0 || sr>=image.length || sc>=image[0].length||image[sr][sc]!=color){
            return;
        }
        image[sr][sc]= newColor;
        fill(image,sr-1,sc,color,newColor);
        fill(image,sr+1,sc,color,newColor);
        fill(image,sr,sc-1,color,newColor);
        fill(image,sr,sc+1,color,newColor);
        

    }
}