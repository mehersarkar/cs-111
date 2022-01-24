public class CheckDigit {
    public static void main (String[] args) {
        long number = Long.parseLong(args[0]);
        int length = String.valueOf(number).length();
        long sum1 = 0;
            long sum2 = 0;

        for(int i = 0; i < length ; i++){
            sum1 = sum1 + (number%10);
            number = (number/10/10);

        }
        number = Long.parseLong(args[0]);
        number = number/10;
        for(int i = 0; i < length ; i++){
            sum2 = sum2 + (number%10);
            number = (number/10/10);
        
        }
        sum1 = sum1%10;
        sum2 = sum2%10;
        sum2 = sum2*3;
        sum2 = sum2%10;
        long finalsum = sum1 + sum2;
        finalsum = finalsum%10;
        System.out.println(finalsum);
    }
}