import java.util.ArrayList;
import java.util.Arrays;

class Homework1 implements Mergesort {

    public int[] getFirstHalfOf(int[] array) {
        Double d = (double)(array.length/2D);
        return Arrays.copyOfRange(array, 0, (int)Math.ceil(d));
    }

    public int[] getSecondHalfOf(int[] array) {
        Double d = (double)(array.length/2D);
        return Arrays.copyOfRange(array, (int)Math.ceil(d), array.length);
    } 

    public int[] merge(int[] firstHalf, int[] secondHalf) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int prvniPole = 0;
        int druhePole = 0;

        while (prvniPole < firstHalf.length && druhePole < secondHalf.length) {
            if (firstHalf[prvniPole] < secondHalf[druhePole]) {
                tmp.add(firstHalf[prvniPole]);
                prvniPole++;
            } else {
                tmp.add(secondHalf[druhePole]);
                druhePole++;
            }
        }
        for (int i = prvniPole; i < firstHalf.length; i++) {
            tmp.add(firstHalf[i]);
        }
        for (int i = druhePole; i < secondHalf.length; i++) {
            tmp.add(secondHalf[i]);
        }

        int[] vysledek = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            vysledek[i] = tmp.get(i);
        }

        return vysledek;
    }

    public int[] mergesort(int[] array) {
        if (array.length < 2) return array.clone();
        return merge(mergesort(getFirstHalfOf(array)),
                     mergesort(getSecondHalfOf(array))).clone();
    }

}
