package com.problems.simple;

import java.util.LinkedList;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image[0] == null) return null;
        if (sr > image.length || sc > image[0].length) return image;
        if (image[sr][sc] == newColor) return image;
        LinkedList<Pair> pixels  = new LinkedList<Pair>();
        int scrColor = image[sr][sc];
        
        image[sr][sc] = newColor;
        pixels.add(new Pair(sr, sc));
        floodFillImage(image, scrColor, newColor, pixels);
        return image;
        
    }
    
    private void floodFillImage(int[][] image, int srcColor, int newColor, LinkedList<Pair> pixels) {
        while (!pixels.isEmpty()) {
            Pair pixel = pixels.poll();
            updatePixel(image, pixel.getFirst(), pixel.getSecond(), newColor);
            
            //left
            if (isValid(image, pixel.getFirst()-1, pixel.getSecond(), srcColor))
                pixels.add(new Pair(pixel.getFirst()-1, pixel.getSecond()));     
            //right
            if (isValid(image, pixel.getFirst()+1, pixel.getSecond(), srcColor))
                pixels.add(new Pair(pixel.getFirst()+1, pixel.getSecond())); 
            //top
             if (isValid(image, pixel.getFirst(), pixel.getSecond()-1, srcColor))
                pixels.add(new Pair(pixel.getFirst(), pixel.getSecond()-1)); 
            //bottom
            if (isValid(image, pixel.getFirst(), pixel.getSecond()+1, srcColor))
                pixels.add(new Pair(pixel.getFirst(), pixel.getSecond()+1)); 
        }
    }
    
    private void updatePixel(int[][] image, int row, int col, int newColor) {
        image[row][col] = newColor;
    }
    private boolean isValid (int[][] image, int row, int col, int scrColor) {
         return row < image.length && row >= 0
            && col < image[0].length && col >= 0
            && image[row][col] == scrColor;
    }
    
    class Pair{
        int firstElement;
        int secondElement;
        
        public Pair(int firstElement, int secondElement){
            this.firstElement = firstElement;
            this.secondElement = secondElement;
        }
        public int getFirst(){
            return firstElement;
        }
        
        public int getSecond(){
            return secondElement;
        }
    }
}

