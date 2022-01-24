public class RandomWalker{
    public static void main(String[] args){
        int steps = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        for (int i= 0; i <= steps; i++){
            double number = (Math.random()*4) +1;
            int numberTwo = (int) number;
            if (numberTwo == 1){
                y++;
            }else if (numberTwo == 2){
                y--;
            }else if (numberTwo == 3){
                x--;
            }else{
                x++;
            }
            System.out.println("("+ x + "," + y + ")");
        }
        double distance = Math.pow(x,2) + Math.pow(y,2);
        System.out.println("Sqaured distance = " + distance);
    }
}