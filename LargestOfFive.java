public class LargestOfFive{
    public static void main(String[] args){
        int LargestValue = Integer.parseInt(args[0]);
        for(int i=0; i < args.length; i++){
            int number = Integer.parseInt(args[i]);
            if (number > LargestValue){
            LargestValue = number;
            }
        }
        System.out.println(LargestValue);
    }
}