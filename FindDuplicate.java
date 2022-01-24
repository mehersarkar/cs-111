public class FindDuplicate {
    public static void main(String[] args){
        int[] array = new int[args.length];
        boolean m = false;
        for(int i = 0; i < args.length; i++){
            array[i] = Integer.parseInt(args[i]);
        }
        for(int x = 0; x < array.length; x++){
            for(int y = x+1; y < array.length; y++){
                if(array[x] == array[y]){
                    m = true;
                }
            }
        }
        System.out.println(m);
    }
}
