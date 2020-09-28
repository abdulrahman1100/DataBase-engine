import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

@SuppressWarnings("serial")
public class Page implements Serializable{
	transient int min =0;
	transient int max=0;
	
	static Vector<ArrayList<Object>> Records2=new Vector<ArrayList<Object>>();
	
	///////////
	ArrayList<Record> Tuples=new ArrayList<Record>();
	 /////////////
	ArrayList<Object> header=new ArrayList<Object>();
	ArrayList<Object> headerTypes=new ArrayList<Object>();
	
	static Vector<ArrayList<Object>> Records=new Vector<ArrayList<Object>>();
	
	transient int pageNumber;
	String location="";
	

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Page(String fileName) throws IOException {
		
//		@SuppressWarnings("rawtypes")
		Hashtable htblColNameValue = new Hashtable( );
//		
//		htblColNameValue.put("id", new Integer( 5 ));
//		htblColNameValue.put("name", new String("Ahmed Noor" ) );
//		htblColNameValue.put("gpa", new Double( 0.95 ) );
//		
//		
//		
//		
//		insert(htblColNameValue);
//		htblColNameValue.put("id", new Integer( 4 ));
//		
//		insert(htblColNameValue);
//		
//		printRecords();
//		
//		int capacity = getPageCapacity(fileName);
//		this.max = getPageCapacity(fileName);
//		
//		Records.setSize(capacity); 
		
//		Hashtable htblColNameValue = new Hashtable( );
//		htblColNameValue.put("id", new Integer( 2343432 ));
//		htblColNameValue.put("name", new String("p Noor" ) );
//		htblColNameValue.put("gpa", new Double( 0.8 ) );
//		insert2(htblColNameValue,"id");
//		
//		htblColNameValue.put("id", new Integer( 3 ));
//		htblColNameValue.put("name", new String("k" ) );
//		htblColNameValue.put("gpa", new Double( 0.1 ) );
//		insert2(htblColNameValue,"id");
//		
//		htblColNameValue.put("id", new Integer( 10 ));
//		htblColNameValue.put("name", new String("a" ) );
//		htblColNameValue.put("gpa", new Double( 0.952 ) );
//		insert2(htblColNameValue,"id");
//		
//		htblColNameValue.put("id", new Integer( 6 ));
//		htblColNameValue.put("name", new String("h" ) );
//		htblColNameValue.put("gpa", new Double( 0.5 ) );
//		insert2(htblColNameValue,"id");
//		
//		htblColNameValue.put("id", new Integer( 12 ));
//		htblColNameValue.put("name", new String("g" ) );
//		htblColNameValue.put("gpa", new Double( 0.3 ) );
//		insert2(htblColNameValue,"id");
//		
//		htblColNameValue.put("id", new Integer( 7 ));
//		htblColNameValue.put("name", new String("g" ) );
//		htblColNameValue.put("gpa", new Double( 0.3 ) );
//		insert2(htblColNameValue,"id");
//		
//		htblColNameValue.put("id", new Integer( 9 ));
//		htblColNameValue.put("name", new String("jj" ) );
//		htblColNameValue.put("gpa", new Double( 0.2 ) );
//		insert2(htblColNameValue,"id");
//		
//		Remove_record(7);
//		
//		htblColNameValue.put("id", new Integer( 7 ));
//		htblColNameValue.put("name", new String("g" ) );
//		htblColNameValue.put("gpa", new Double( 0.3 ) );
//		insert2(htblColNameValue,"id");
		
//		printTuples();
	
	}
	
	public  void  Remove_record(Object key) {
		int index=-1;
		boolean found=false;
		for(Record r:this.getTuples()) {
			if(r.getClusteringKey().equals(key)) {
				
				index=this.getTuples().indexOf(r);
				
//				this.getTuples().remove(index);
				found=true;
			}
		}
		if(found) {
			this.getTuples().remove(index);
			System.out.println("Record with key "+"'"+key+"'"+" has been removed successfully !");
			}
		
		
		
		
	}
	public  void printRecords() {
		
		for(ArrayList<Object> e:Records) {
			System.out.println("this is :"+e);
		}
	}
	
	public void printTuples() {
		for(Record r:Tuples) {
			r.printRecord();
		}
	}
	public static int lookFor(Vector<ArrayList<Object>> Records,String s) {
		
		for (int i = 0; i < Records.size(); i++) {
			ArrayList<Object> a=Records.get(i);
			if(a.contains(s)) {
				return i; 
			}
			
			
		}
		return -1;
		
		
	}





	public void insert2(Hashtable<String,Object> htblColNameType,String ClusteringKey) {
		
		Record r=new Record();
		boolean found=false;
		for (Map.Entry<String,Object> entry:htblColNameType.entrySet()) {
			
			String s=entry.getKey();
			if(s.equals(ClusteringKey)) {
				//hey boy you need to check for the value not for the key !!
				for(Record rec:Tuples) {
					if(rec.getClusteringKey().equals(entry.getValue())) {
						found=true;
					}
				}
				if(!found)
				r.setClusteringKey((Comparable) entry.getValue());
			}else {
				r.getRow().add(entry.getValue());
			}
		}
		// this condition is to make sure that we wont add the same id for two records if you tried to insert 
		//aa tuples with an existed id 
		if(!found) {
			Tuples.add(r);
			Collections.sort(Tuples,new Record());
			
			for(Record re:Tuples) {
//				System.out.println("in ");
				re.printRecord();
			}
		}else {
			// handling the exception of inserting the same id !
			System.out.println("this id already in use ");
			System.out.println();
		}
		
		

		
	}



	//awesome !!



	public void insert(Hashtable<String,Object> htblColNameType) {
		// consider a hash table !
		
		for (Map.Entry<String,Object> entry:htblColNameType.entrySet()) {
			String s=entry.getKey();
			if(lookFor(Records,s)!=-1) {
				int y=lookFor(Records,s);
				//this if for not adding the same name twice !
				if(!Records.get(y).contains(entry.getValue())) {
				Records.get(y).add(entry.getValue());
				}
			}else {
				ArrayList<Object> a=new ArrayList<Object>();
				//awesome !!
					a.add(entry.getKey());
				
					a.add(entry.getValue());
				
				
				Records.add(a);
			}
}

		
	}
	public ArrayList<Object> getHeaderTypes() {
		return headerTypes;
	}
	public void setHeaderTypes(ArrayList<Object> headerTypes) {
		this.headerTypes = headerTypes;
	}
	
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	


	public ArrayList<Record> getTuples() {
		return Tuples;
	}
	public void setTuples(ArrayList<Record> tuples) {
		Tuples = tuples;
	}
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public Vector<ArrayList<Object>> getRecords() {
		return Records;
	}

	public static void setRecords(Vector<ArrayList<Object>> records) {
		Records = records;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

		public static Vector<ArrayList<Object>> getRecords2() {
			return Records2;
		}
		public static void setRecords2(Vector<ArrayList<Object>> records2) {
			Records2 = records2;
		}
		public ArrayList<Object> getHeader() {
			return header;
		}
		public void setHeader(ArrayList<Object> header) {
			this.header = header;
		}
	
	
	public int getPageCapacity(String fileName) throws IOException  {
		int x=0;
		 
		@SuppressWarnings("unused")
		String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get(fileName))); 
	    String h[]=data.split(",");
		x=Integer.parseInt(h[1]);
		
		return x ;
		
	}

	public static void main(String[]args) throws IOException {
		
		String fileName="properties.txt";
		@SuppressWarnings("unused")
		Page t=new Page(fileName);

	}

}

