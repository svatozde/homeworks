interface InterSearch {
   
    public int search(int first, int last, int what, int[] data);
}

public class homework2 implements InterSearch {
    @Override
    public int search(int first, int last, int what, int[] data) {
		
    	 if(data[first] == what) return first; //nalezli jsme, treba kontrolovat kvuli deleni nulou dale v algoritmu
    	    else if(first == last || data[first] ==  data[last]) return -1; //zarazka rekurze

    	    //provedeme odhad pozice hledaneho cisla na zaklade soucasneho rozsahu pozic, hodnot mezi a hledane hodnoty
    	    int index = first + Math.round((last - first)/(data[last] - data[first])) * (what - data[first]);
    	    
    	    if(data[index] == what) return index;//cislo jsme nalezli
    	    //nenalezli jsme, pokracujeme v prave polovine, pokud je hledane cislo vyssi nez predel
    	    else if(data[index] < what) return search( index + 1, last, what,data);
    	    //nenalezli jsme, pokracujeme v leve polovine, pokud je hledane cislo nizsi nez predel
    	    else return search( first, index - 1,what,data);
    	
    }
}
