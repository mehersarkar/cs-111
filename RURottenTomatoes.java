public class RURottenTomatoes {
    public static void main(String[] args){
        int[][] array2D = new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
        int[] array = new int[Integer.parseInt(args[1])];
        int b = 0;
        int b1 = 0;
        int e = 0;

        for(int a = 0; a < Integer.parseInt(args[1]); a++){
            array[a] = 0;
        }
        for(int g = 0; g < Integer.parseInt(args[0]); g++){
            for(int c = 0; c < Integer.parseInt(args[1]); c++){
                array2D[g][c] = Integer.parseInt(args[b+2]);
                b++;
            }
        }
        for(int c = 0; c < Integer.parseInt(args[1]); c++){
            for(int g = 0; g < Integer.parseInt(args[0]); g++){
                array[b1] = array[b1] + array2D[g][c];
            }
            b1++;
        }
        for(int d = 1; d < array.length; d++){
            if(array[e] == array[d]){
                e = e;
            }
            else if(array[e] < array[d]){
                e = d;
            }
        }
        System.out.println(e);
    }
}
