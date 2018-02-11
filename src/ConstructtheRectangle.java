public class ConstructtheRectangle {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
    }

    public static void main(String[] args) {
        ConstructtheRectangle constructtheRectangle = new ConstructtheRectangle();
        constructtheRectangle.constructRectangle(10);
    }
}
