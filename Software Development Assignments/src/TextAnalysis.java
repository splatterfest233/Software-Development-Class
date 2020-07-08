import java.util.*;
import java.net.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.Scene;
public class TextAnalysis extends Application{
	
	static Text text;

	 public static void main(String[] args) throws Exception{
		 
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
	      String nohtml = htmlRemoval(result);

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
	    		text = new Text("");
	    		for (Map.Entry<String,Integer> e : entries) {
	    		    System.out.println(e.getKey()+":"+e.getValue());
	    		    i++;
	    		    text.setText(text.getText() + e.getKey()+":"+e.getValue() +"\n");
	    		    if(i >= 20)
	    		    	break;
	    		}
	    		launch(args);
	 }
	 /**
	  * Takes full string from website and removes html tags and special characters
	  * 
	  * @param result
	  * @return
	  */
	 
	 public static String htmlRemoval(String result) {
		 String nohtml = result.replaceAll("\\<[^>]*>","");
	     nohtml = nohtml.replaceAll("&mdash;", " ");
	     return nohtml;
	 }
	 
	 /**
	  * Takes the string array of each word in the poem and counts the occurrences,
	  * inputing them into a hashmap where each word is paired with the number of occurrences. 
	  * @param strings
	  * @return
	  */
	 
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
	 
	 
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Word Counts");
		
		StackPane layout = new StackPane();
		layout.getChildren().add(text);
		
		Scene scene = new Scene(layout, 250, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
