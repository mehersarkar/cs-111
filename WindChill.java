public class WindChill {
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double v = Double.parseDouble(args[1]);
        // if(T > Math.abs(50) || ( v > 120 || v < 3)) {
        //     System.out.println(" The formula is not valid if T is larger than 50 in absolute value or if v is larger than 120 or less than 3");
        //     return;
        // }
        double w = 35.74 + 0.6215*T + (0.4275*T - 35.75) * Math.pow(v, 0.16);
        // System.out.println("Temperature = " + T);
        // System.out.println("Wind speed = " + v);
        System.out.println(w);
    }
}
