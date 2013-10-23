interface InterSearch {
   
    public int search(int first, int last, int what, int[] data);
}

public class homework2 implements InterSearch {
    @Override
    public int search(int first, int last, int what, int[] data) {
		
    	 if(data[first] == what) return first; 
    	    else if(first == last || data[first] ==  data[last]) return -1; 

    	    int index = first + Math.round((last - first)/(data[last] - data[first])) * (what - data[first]);
    	    
    	    if(data[index] == what) return index;
    	    else if(data[index] < what) return search( index + 1, last, what,data);
    	    else return search( first, index - 1,what,data);
    	
    }
}
