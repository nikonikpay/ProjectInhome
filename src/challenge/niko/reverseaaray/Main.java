package challenge.niko.reverseaaray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {1,34,56,2,98};
        System.out.println("Array is +" + Arrays.toString(array));
        reverse(array);
        System.out.println("Reversed array :" + Arrays.toString(array));

    }

    public static void reverse(int[] array){
        int maxIndex = array.length -1;
        int halfIndex = array.length /2;
        for (int i = 0; i < halfIndex; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex -i ] = temp ;

        }




    }
}
