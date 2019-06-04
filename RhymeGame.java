import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import java.io.*;

public class RhymeGame{
	String word;
	 ArrayList<String> words=new ArrayList<String>();
	ArrayList<String> rhymes=new ArrayList<String>();
	public RhymeGame(String w) {
		word=w;
	}
	public void getArray() {
		try {
			
			String url="https://www.rhymezone.com/r/rhyme.cgi?Word="+word+"&typeofrhyme=perfect&org1=syl&org2=l&org3=y";
			
			Document doc = Jsoup.connect(url).userAgent("Chrome/74.0.3729.131").get();

			Elements temp=doc.select("a");
			for(Element a:temp) {
				String b=a.text();
				b=b.replaceAll(" ", "_");
				
				
				if(a.attr("href").equals("d="+b)) {
					rhymes.add(a.text().toLowerCase().replaceAll("-","").replaceAll("'", ""));
					
				}
				
			}
		//System.out.println(rhymes);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private void merge(ArrayList<String> a,int first,int mid,int last){
		ArrayList<String> b= new ArrayList<String>(a.size());
		   int c=mid;
   int d=first;
   while(c<=last && d<mid){
    
     if(a.get(d).length()>a.get(c).length()){
         b.add(a.get(c));
        
         c++;
         
      }
   else{
         b.add(a.get(d));
         
         d++;
         
      }
       
     }
		while(d<mid){
			b.add(a.get(d++));
			
		}
		while(c<=last){
			b.add(a.get(c++));
			
		}
		for(int o=first;o<=last;o++){
			a.set(o,b.get(o-first));
			
		}
	}


  /**
   *  Recursive mergesort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void mergeSort(ArrayList <String> a, int first, int last){
	//Add your code here
	   if(last>first){
	      
	      int m=first+(last-first)/2;
	      mergeSort(a,first,m);
	      mergeSort(a,m+1,last);
	      merge(a,first,m+1,last);
	   }
  }
  public void sortWords() {
	 
	  try {
	  	Scanner in=new Scanner(new File("words.txt"));
	  	for(int i=0; i<10; i++) {
	  		words.add(in.next());
		  
	  	}
	  	mergeSort(words,0,words.size());
	  }
	  catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
  }
	public static String getRandomWord() {
		String word="";
		try {
			Scanner in=new Scanner(new File("words.txt"));
			Random rand=new Random();
			int a=rand.nextInt(10000);
			for(int i=0; i<a;i++) {
				in.next();
			} 
			word=in.next();
			while((word.length()<5||word.contains("fuck")||word.contains("shit")||word.contains("pussy"))) {
				word=in.next();
			}
			return word;
			
					
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "a";
		}
		
	}
	
	
}