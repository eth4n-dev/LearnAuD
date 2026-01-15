public class ReverseArray {

    // A helper method to reverse an array
    public static int[] reverse(int[] input){
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++){
            output[i] = input[input.length - i - 1];
        }

        return output;
    }

}
