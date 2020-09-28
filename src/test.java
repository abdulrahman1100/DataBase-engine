import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;



public class test {

	public static void main (String[]args) {
		
		
	 Vector<ArrayList<String>> Records=new Vector<ArrayList<String>>();
	 
	 ArrayList<String> a=new ArrayList<String>();
	 ArrayList<String> b=new ArrayList<String>();
	 ArrayList<String> c=new ArrayList<String>();
	 
	 a.add("3");
	 a.add("1");
	 a.add("2");
	 
	 
//	 b.add("5"); 
//	 b.add("6");
//	 b.add("8");
	 
//	 b.add("a");
//	 b.add("b");
//	 b.add("c");
//	 
//	 c.add("true");
//	 c.add("false");
//	 c.add("false");

		Records.add(a);
		Records.add(b);
		Records.add(c);
		
			Collections.sort(Records,new Comparator<ArrayList<String>>() {

			

				@Override
				public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {
					
					return Integer.parseInt(arg0.get(0))-Integer.parseInt(arg1.get(0));
					// TODO Auto-generated method stub
					
				}
					
			});
			
			System.out.println(Records);
		
		

	}
}
