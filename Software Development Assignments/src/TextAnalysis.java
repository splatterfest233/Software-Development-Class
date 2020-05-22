import java.util.*;
import java.net.*;
public class TextAnalysis {

	 public static void main(String[] args) throws Exception {
		 //Instantiating the URL class
	      URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
	      //Retrieving the contents of the specified page
	      Scanner sc = new Scanner(url.openStream());
	      //Instantiating the StringBuffer class to hold the result
	      StringBuffer sb = new StringBuffer();
	      while(sc.hasNext()) {
	         sb.append(sc.next());
	         sb.append(" ");
	         //System.out.println(sc.next());
	      }
	      //Retrieving the String from the String Buffer object
	      String result = sb.toString();
	     String nohtml = result.replaceAll("\\<[^>]*>","");
	     nohtml = nohtml.replaceAll("&mdash;", " ");
	     
	     int poemStart = nohtml.indexOf("The Raven", 1100);
	     String poemTest = nohtml.replace(nohtml.substring(0, poemStart), "");
	     String poem = poemTest.substring(0, poemTest.indexOf("End"));
	     
	     String[] words = poem.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
	     
	     Map<String, Integer> counts = wordCount(words);
	     List<Map.Entry<String,Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(
	    		    counts.entrySet()
	    		);
	    		Collections.sort(
	    		    entries
	    		,   new Comparator<Map.Entry<String,Integer>>() {
	    		        public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b) {
	    		            return Integer.compare(b.getValue(), a.getValue());
	    		        }
	    		    }
	    		);
	    		int i = 0;
	    		for (Map.Entry<String,Integer> e : entries) {
	    		    System.out.println(e.getKey()+":"+e.getValue());
	    		    i++;
	    		    if(i >= 20)
	    		    	break;
	    		}
	 
	 }
	 
	 public static Map<String, Integer> wordCount(String[] strings) {
		  Map<String, Integer> map = new HashMap<String, Integer> ();
		  for (String s:strings) {
		    
		    if (!map.containsKey(s)) {  // first time we've seen this string
		      map.put(s, 1);
		    }
		    else {
		      int count = map.get(s);
		      map.put(s, count + 1);
		    }
		  }
		  return map;
		}
	 
	

}
