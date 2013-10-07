package dsa1;

import java.util.Arrays;


public class Homework1 implements Mergesort {


	public Homework1(){
		super();
		//public constructor
	}
	
	@Override
	public int[] getFirstHalfOf(int[] array) {
		return Arrays.copyOfRange(array, 0, (int) Math.round((1.0*array.length)/2));
	}

	@Override
	public int[] getSecondHalfOf(int[] array) {

		return Arrays.copyOfRange(array, (int) Math.round((1.0*array.length)/2),array.length);
	}

	@Override
	public int[] merge(int[] firstHalf, int[] secondHalf) {
		int[] ret = new int[firstHalf.length + secondHalf.length];
		//secondHalfIndex
		int sHi = 0; 
		//firstHalfIndex
		int fHi = 0;
		//retIndex
		int rI = 0;	
		while(rI<ret.length){
			if(sHi >= secondHalf.length){
				ret[rI++] = firstHalf[fHi++];
			}else if(fHi >= firstHalf.length){
				ret[rI++] = secondHalf[sHi++];
			}else if(firstHalf[fHi] < secondHalf[sHi]){
				ret[rI++] = firstHalf[fHi++];
			}else{
				ret[rI++] = secondHalf[sHi++];
			}
		}

		return ret;
	}

	@Override
	public int[] mergesort(int[] array) {
		int[] fH = getFirstHalfOf(array);
		int[] sH = getSecondHalfOf(array);

		if(fH.length > 1){
			fH = mergesort(fH);
		}

		if(sH.length > 1){
			sH = mergesort(sH);
		}

		return merge(fH, sH);
	}


}

/*
* Naimplementujte třídu Homework1 implementující rozhraní Mergesort.
*/

interface Mergesort { 

   // vrati nesetridenou kopii prvni poloviny (horni celou cast) pole array

   int[] getFirstHalfOf(int[] array); 

   // vrati nesetridenou kopii druhe poloviny (dolni celou cast) pole array

   int[]getSecondHalfOf(int[] array); 

   // slije prvky v firstHalf a secondHalf do jednoho pole a vrati ho

   int[]merge(int[] firstHalf, int[] secondHalf); 

   // vrati setridenou kopii pole array

   int[]mergesort(int[] array); 

}
