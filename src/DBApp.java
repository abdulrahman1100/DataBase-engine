import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;


//you could do the shifting after finishing the insertion to sort again all the pages !!
// do not forget to configure the polygons 
// re arrange the test cases to ease evaluating the project 
// do not forget to add touch date column 
//do not for get to check the type  of the column along with the creation of the table 
//Inserting and deleting from index correctly.
//you should handle each methode (insert,update,delete )after creating the index 
public class DBApp {
	
	static Vector<Table> Tables=new Vector<Table>();
//	static Vector<Table> TablesNames=new Vector<Table>();
	//as you supposed to have a meta file contains the tables .
//	static TreeMap<Integer,Table> TablesCopy=new TreeMap<Integer, Table>();
	
	public DBApp() throws DBAppException, IOException {

		init();

		
		

	} 

	public void init( ) throws DBAppException, IOException {
		
		Hashtable<String,String> htblColNameType=new Hashtable<String, String>();
		Hashtable<String,String> htblColNameType2=new Hashtable<String, String>();

//		htblColNameType.put("number", "java.lang.Integer");
//		htblColNameType.put("age", "java.lang.Double");
//		htblColNameType.put("age", "java.lang.polygon");
		
//		bpt.delete(1);
//		bpt.delete(3);
//		bpt.delete(5);
//		bpt.delete(7);
//		bpt.delete(9);
		
//		htblColNameType.put("khaled", "java.lang.Double");
//		htblColNameType.put("juo", "java.lang.polygon");
		
		// first create the table 
		
//		htblColNameType.put("id", "java.lang.Integer");
//		htblColNameType.put("name", "java.lang.String");
//		htblColNameType.put("gpa", "java.lang.double");
//		createTable("Student","id",htblColNameType);
		
		
//		String data="";
//		data = new String(Files.readAllBytes(Paths.get("properties.txt")));
//		String h[]=data.split(",");
//		System.out.println(h[1]);
		
		
//		B_Plus_Tree<String, String> bpt = new B_Plus_Tree<String, String>(4);
//		Hashtable<String,String> test=new Hashtable<String, String>();
//		test.put("a", "a");
//		test.put("a", "a");
//		test.put("c", "b");
//		test.put("b", "c");
//		test.put("f", "d");
//		test.put("G", "e");
//		test.put("E", "f");
//		test.put("I", "g");
//		test.put("M", "h");
//		test.put("k", "i");
//		test.put("n", "j");
//		
//		for(Entry<String, String> entry : test.entrySet()) {
//			
//			bpt.insert(entry.getKey(),entry.getValue());
//		}
//		System.out.println(bpt.toString());
//		bpt.insert("a", "a");
//		bpt.insert("c", "b");
//		bpt.insert("b", "c");
//		bpt.insert("f", "d");
//		bpt.insert("G", "e");
//		bpt.insert("E", "f");
//		bpt.insert("I", "g");
//		bpt.insert("M", "h");
//		bpt.insert("k", "i");
//		bpt.insert("n", "j");
		
//		
//		System.out.println(bpt.toString());
		
//		bpt.delete(1);
//		bpt.delete(3);
//		bpt.delete(5);
//		bpt.delete(7);
//		bpt.delete(9);
		
//		System.out.println(bpt.toString());
		
		Hashtable htblColNameValue = new Hashtable( );
		
//		for(int i=10;i<20;i++) {
//			htblColNameValue.put("id", new Integer(i));
//			htblColNameValue.put("name", new String("tolba"+i ) );
//			htblColNameValue.put("gpa", new Double( 0.3 ) );
//			insertIntoTable( "Student" , htblColNameValue );
//		}
		
		
		//insertion test 
//		htblColNameValue.put("id", new Integer( 7 ));
//		htblColNameValue.put("name", new String("abdoh" ) );
//		htblColNameValue.put("gpa", new Double( 1 ) );
//		insertIntoTable( "Student" , htblColNameValue );
		
//		htblColNameValue.put("id", new Integer( 4 ));
//		htblColNameValue.put("name", new String("etch" ) );
//		htblColNameValue.put("gpa", new Double( 2.3) );
//		insertIntoTable( "Student" , htblColNameValue );
		
		

		// update the table test 
//		updateTable("Student", "id", htblColNameValue);

		// delete from a table 
//		deleteFromTable("Student",htblColNameValue);
		
//		htblColNameType2.put("gpa4", "java.lang.double");
//		createTable("strTableName","strClusteringKeyColumn",htblColNameType2);
//		deserialize("Student");

//		addToMetaDate("abdoh","gpa4",htblColNameType2);
		
//		getTheMetadata();	
		
		//test B+ tree index 
//		createBTreeIndex("Student","id");
	}
	public void createTable(String strTableName
			,String strClusteringKeyColumn,Hashtable<String,String> htblColNameType )
	
			throws DBAppException, IOException{
		
		Table t=new Table();
		t.tableName=strTableName;
		t.setClusteringKey(strClusteringKeyColumn);
		Tables.add(t);
		
		
		
		addToMetaDate(strTableName,strClusteringKeyColumn,htblColNameType);
		
		createPage(t);
//		createPage(t);
//		System.out.println("now se : !!"+t.Pages.get(0).getHeader());
//		System.out.println(t.Pages.get(0).getPageNumber());
//		deserialize(strTableName);
//		System.out.println(Tables.get(0).tableName);
		

		
	}
	//why we serialize 2 pages at the same  time  0 , 1 ???
	
	
	public static Page createPage(Table t) throws IOException {
		
		ArrayList<ArrayList<String>> a=getTheMetadata();
		String s=t.getTableName();
		ArrayList<Object> header=new ArrayList<Object>();
		ArrayList<Object> headerTypes= new ArrayList<Object>();
		
		for(ArrayList<String> aa:a) {
			// so yes i checked if all the headers belong to just one table 
			// i mean all the data are for the same table 
			if(aa.get(0).equals(s)) {
				
				
				header.add(aa.get(1));
				headerTypes.add(aa.get(2));
			}
		}
//		System.out.println("the header is : "+header);//we have created the header 
		Page p=new Page("properties.txt");
		
		p.setHeader(header);
//		p.getRecords().add(header);
		p.setHeaderTypes(headerTypes);
		int x=t.Pages.size();
		t.Pages.add(p); 
		//we supposed to give the page a number !
		p.setPageNumber(x);
	
		
		  try {
//			  System.out.println(p.getPageNumber());
		         FileOutputStream fileOut = new FileOutputStream(x+".ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(p);
		         out.close();
		         fileOut.close();
		         System.out.println("Serialized data is saved in "
		         		+x+".ser");
		         
		         FileOutputStream tableout =new FileOutputStream(t.tableName+".ser");
		         ObjectOutputStream outtable = new ObjectOutputStream(tableout);
		         outtable.writeObject(t);
		         outtable.close();
		         tableout.close();
		         System.out.println("Serialized data is saved in "
			         		+t.tableName+".ser");
		         
		         
		        
		      } catch (IOException i) {
		         i.printStackTrace();
		      }
		
		
		return p;
	}

	// the method splits the metadata file and put the table columns in an array and return it back !
	public static ArrayList<ArrayList<String>> getTheMetadata() throws IOException {
		
		//first we need to load the meta data file !!
		String data = ""; 
		
	
	    try {
			data = new String(Files.readAllBytes(Paths.get("metadata.csv")));
		} catch (IOException e) {
			System.out.println("You need to create the table first !");
			
		}
	    
	    
	    String []ss=data.split("\n");

	   ArrayList<ArrayList<String>> a=new ArrayList<ArrayList<String>>();
	   
	    for (int i = 0; i < ss.length; i++) {
	    	 String f[]=ss[i].split(",");
	    	 ArrayList<String > n=new ArrayList<String>();
	    	for (int j = 0; j < f.length; j++) {
				n.add(f[j]);
	    	}
	    	a.add(n);
	    }
//	    System.out.println("this is the meta data !!\n"+a);
//	    System.out.println(a);
	return a;
		
		
		
	}
	//here if wee did not create the meta data yet we do so 
	//,then we can add to the methode any column as discussed it is like adding a column in a table !
	public static ArrayList<ArrayList<String>> addToMetaDate(String strTableName
			,String strClusteringKeyColumn,Hashtable<String,String> htblColNameType)
					throws IOException {
		
		 boolean added=false;
		 boolean indexed=false;
		 boolean ClusteringKey=false;
		 String s="";
		 String t="";
		 ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();

		 ArrayList<ArrayList<String>> b = new ArrayList<ArrayList<String>>();
		 ArrayList<ArrayList<String>> f = new ArrayList<ArrayList<String>>();
		 try {
			a=getTheMetadata();

		} catch (IOException e) {
			
			System.out.println("Empty metadata !!"+"\n");
		}
		 
		 for(Map.Entry<String,String> entry:htblColNameType.entrySet()) {
				
				
				String colName=entry.getKey();
			
				String colType=entry.getValue();
				if(colName.equals(strClusteringKeyColumn)) {
					ArrayList<String> f2=new ArrayList<String>();
					ClusteringKey=true;
					f2.add(strTableName);
					f2.add(colName);
					f2.add(colType);
					f2.add(ClusteringKey+"");
					f2.add(indexed+"");
					f.add(f2);
					s+=strTableName+","+colName+","+colType+","+ClusteringKey+","+indexed+"\n";
				}else {
					ClusteringKey=false;
					ArrayList<String> f2=new ArrayList<String>();
					f2.add(strTableName);
					f2.add(colName);
					f2.add(colType);
					f2.add(ClusteringKey+"");
					f2.add(indexed+"");
					f.add(f2);
					s+=strTableName+","+colName+","+colType+","+ClusteringKey+","+indexed+"\n";
				}
				
				
				
		 	}
		 
		System.out.println("a : "+a);
		System.out.println();
		System.out.println("f : "+f);
		System.out.println();
		System.out.println("s : "+s);
		
			if(a.isEmpty()) {
				File fnew=new File("metadata.csv");
				 FileWriter f2 = new FileWriter(fnew, true);
				 f2.append(s);
				 f2.close();
			}else {
				for (int i = 0; i < f.size(); i++) {
					if(!a.contains(f.get(i))) {
						File fnew=new File("metadata.csv");
						 FileWriter f2 = new FileWriter(fnew, true);
						 String sd="";
						 
						 sd+=f.get(i).get(0)+","+f.get(i).get(1)+","
						 +f.get(i).get(2)+","+f.get(i).get(3)+","+f.get(i).get(4)+"\n";
						 
						 // to indicate that i add a row so the row was
						 //not in the table to help in the insertion !!
						 added=true;
						 
						 f2.append(sd);
						 f2.close();
					}
				}
			}
	
		 return a;
	}

	
	//here we are looking in the tablbles to get the table through it`s name 
	// sorry but you need to look at the metadata file ! 
	//yes iam looking for it in the metadata file 
	public static Table lookForTheTable(String strTableName) throws IOException {
		
		ArrayList<ArrayList<String>> a =getTheMetadata();
		boolean found=false;
		for(ArrayList<String> n:a) {
			if(strTableName.equals(n.get(0))) {
				found=true;
			}
		}
		Table T=null;
		if(found) {
			T=deserialize(strTableName);
		}

		return T;
	}
	public static Page deserializePage(int PageNumber) {
		
		Page p=null ;
		
		 try {
	         FileInputStream fileIn = new FileInputStream(PageNumber+".ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	          p= (Page) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         
	      } catch (ClassNotFoundException c) {
	         System.out.println("Page class not found");
	         c.printStackTrace();

	      }
		 
		 return p;
		
	}
	
	public static Table deserialize (String strTableName) {

		
		Table T = null;
		
	      try {
	         FileInputStream fileIn = new FileInputStream(strTableName+".ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         T = (Table) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         
	      } catch (ClassNotFoundException c) {
	         System.out.println("Table class not found");
	         c.printStackTrace();

	      }
//	      System.out.println("the tuples are :  ");
//	      System.out.println();
//	      System.out.println("the last page number is : ");
	      T.getPages().get(T.getPages().size()-1).getPageNumber();
	      return T;
	}

	
	//we have a methode to create a page so we so not need to create a page her 
	//instead we will just serialize it 
	public static  void serialize(Table t,Page p) {
		
		
		
		try {
//			  System.out.println(p.getPageNumber());
		         
		         
		         FileOutputStream tableout =
				         new FileOutputStream(t.tableName+".ser");
		         ObjectOutputStream outtable = new ObjectOutputStream(tableout);
		         outtable.writeObject(t);
		         outtable.close();
		         tableout.close();
		         System.out.println("Serialized table is saved in "
			         		+t.tableName+".ser");
		         //i think this will solve the problem 
		         if(p.getRecords().size()==200) {
		        	 
		        	 FileOutputStream fileOut = new FileOutputStream(p.getPageNumber()+".ser");
			         ObjectOutputStream out   = new ObjectOutputStream(fileOut);
			         out.writeObject(p);
			         out.close();
			         fileOut.close();
			         System.out.println("Serialized page is saved in "
			         		+p.getPageNumber()+".ser");
		         }
		         
		      } catch (IOException i) {
		         i.printStackTrace();
		      }
	}

	
		
	public void insertIntoTable(String strTableName
			,Hashtable<String,Object> htblColNameValue)throws DBAppException, IOException{
		
		//for the first insertion we have to insert the header in the page to insert don to it !!
		
		// i supposed to save the clustering key of a each table 
		//here am looking if the table is in the metadata file 
		Table t =lookForTheTable(strTableName);
		String s="";
		Page p=null;
		if(t!=null) {
			s=t.getClusteringKey();
			p=t.getPages().get(t.getPages().size()-1);
		
			//we need a condition here to see if we already inserted the row !!
			if(p.getTuples().size()<200) {
				p.insert2(htblColNameValue,t.clusteringKey);
				p.printRecords();
				System.out.println("the headers are : "+p.getHeader());
			}else {
				//this case if the page is full of records 
				Page p2=createPage(t);
				p2.insert2(htblColNameValue,t.clusteringKey);
				p2.printRecords();
				
			}
				
				
			
			
			
			serialize(t,p);
		}else {
			return;
		}
		System.out.println("inserted successfully !");
		
		
		
		//we should handle the case of creating a new page after the first 
		//page is full because the serialization methode goes directly to create a new page 
		
		
//				deserialize(strTableName);
//		ArrayList<Object> freq=new ArrayList<Object>(p.getHeader().size());
//		Object freq2[]=new Object[p.getHeader().size()];
//		
//		for(Map.Entry<String,Object> entry:htblColNameValue.entrySet()) {
//			
//			
//			
//			
//			String ColName = entry.getKey();
//			Object ColValue=entry.getValue();
//			for (int i = 0; i < p.getHeader().size(); i++) {
//				if(ColName.equals(p.getHeader().get(i))) {
//					freq2[i]=ColValue;
//				}
//				
//			}
//			
//		}
//		freq.add(freq2);
//		System.out.println("the freq is :  "+Arrays.deepToString(freq2));
//		System.out.println(freq);
//		p.getRecords2().add(freq);
//		serialize(t,p);
		
		
//		
//		try {
//			ArrayList<ArrayList<String>> a=getTheMetadata();
//			
//			for (int i = 0; i < a.size(); i++) {
//				ArrayList<String> b=a.get(i);
//				
//				for (int j = 0; j < b.size(); j++) {
//					
//					if(b.get(j).equals(strTableName)) {
//						
//						Table t=lookForTheTable(strTableName);
//						
//						t.Pages.get(t.Pages.size()-1).insert(htblColNameValue);
//						System.out.println("inserted successfully !!");
//						//after we might need to sort our table in some pattern !!!
//						
//					}else {
//						System.out.println("tables is not created !");
//					}
//				}
//			}
//			//now look for the table if existed just insert in the page !!
//		} catch (IOException e) {
//			System.out.println("Insertion Faild !!");
//		}
//		
//		
//		//is there a table with that name ?
//		
//		//second case is the page full //and the insertion is in the last of it //create a new page ?
//		//else shift the rows down !! 
//		
//		
//		//remember you need to check for the types before inserting !! if it is in list of types 
//		
	}
	
	
	
	public void updateTable(String strTableName,String strClusteringKey,Hashtable<String,Object> htblColNameValue )
			throws DBAppException, IOException{
		Hashtable<String,Object> htblColNameValue2=(Hashtable<String, Object>) htblColNameValue.clone();
		Table t =lookForTheTable(strTableName);
		Page p=null;
		if(t==null) {
			System.out.println("No such a table !");
			
		}else{
			Object key=KeyValue(strClusteringKey,htblColNameValue);

			//first remove the record then insert the new one to get the update !

			
			p=search_for_page(key,t.getPages());
			p.Remove_record(key);
			serialize(t,p);
			
			insertIntoTable(strTableName, htblColNameValue2);
			
//			p.printTuples();

		}
		
		
	}
	
	//look for a certain records in each page ! 
	public static Page search_for_page(Object key,Vector<Page> Pages) {
		//you could just use the collection .binary search instead of the below code ! :)
		
		String record_index="-1";
		Page page=null;
		boolean found=false;
		for(Page p:Pages) {
//			ArrayList<Record> r=deserializePage(p.getPageNumber()).getTuples();
		
			for(Record r2:p.getTuples()) {
				if(key.equals(r2.getClusteringKey())) {
			
					record_index=p.getTuples().indexOf(r2)+","+p.getPageNumber();
					page=p;
					found=true;
				}
			}
			
		}
		
		if(!found) {
			System.out.println("no record with that key to be removed !");
		}

		return page;
		
	}
	//to get the value to be updated in the table according to the clustering key !
	//the methods works correctly 
	public static Object KeyValue(String strClusteringKey,Hashtable<String,Object> htblColNameValue) {
		
		
		Object key=null;
		for(Map.Entry<String, Object> entry:htblColNameValue.entrySet()) {
			if(entry.getKey().equals(strClusteringKey)) {
				key=entry.getValue();
//				System.out.println("the value to be updates having the id : "+key);
			}
		}
		
		return key;
	}

	
	
	public void deleteFromTable(String strTableName,Hashtable<String,Object> htblColNameValue)throws DBAppException, IOException{
		
		
		Table t =lookForTheTable(strTableName);
		Page p=null;
		if(t==null) {
			System.out.println("No such a table !");
			
		}else{
			String strClusteringKey=t.getClusteringKey();
			Object key=KeyValue(strClusteringKey,htblColNameValue);
			p=search_for_page(key,t.getPages());
			p.Remove_record(key);
			p.printTuples();
			serialize(t,p);
			
			
		}
			
		//use remove the record method and do not forget to remove it from the Tuples !!
	}
	
	@SuppressWarnings("rawtypes")
	//because i though it was easy to implement ,i ignored it till the last minute and i did not do it :)
	public Iterator selectFromTable(SQLTerm[] arrSQLTerms,String[] strarrOperators)throws DBAppException{
		
		
		
		return null;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void createBTreeIndex(String strTableName,String strColName) throws DBAppException{
		//we should read a file to get the number of keys from it !
		String data = ""; 
		int node_size = 0;
	    try {
	    	
			data = new String(Files.readAllBytes(Paths.get("properties.txt")));
			String h[]=data.split(",");
			node_size=Integer.parseInt(h[3]);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("you have a problem in properties file ");
		} 
		
		// you will insert the key in the B+ tree as the data in the column that you need to create the index for 
		// do not forget to change the column index from false to true ;
		Vector<Object> col_to_be_indexed=new Vector<Object>();
		Vector<Record> Records=new Vector<Record>();
		
		B_Plus_Tree<Comparable<Object>, Object> bpt=new B_Plus_Tree<Comparable<Object>, Object>(node_size);
		HashMap<Object,Object>trial_B_Tree=new HashMap<Object, Object>();
		
		Table t=null;
		try {
				t =lookForTheTable(strTableName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No such a table to create an index on !");
		}
		if(t!=null) {
			
		
		ArrayList<Object> headers=t.getPages().get(0).getHeader();
		
		int col_index=-1;
		for(int i=0;i<headers.size();i++) {
			//but what should be the case of the clustering key was in the middle ! just add the condition with && :)
			if(headers.get(i).equals(strColName)&&!(headers.get(i).equals(t.getClusteringKey()))) {

				col_index=i;
//				System.out.println(i);
			}
		}
		// index < Row.size() because the header has the clustering key in the last place !
		
		
		if(col_index!=-1&&col_index<t.getPages().get(0).getTuples().get(0).getRow().size()) {
			for(Page p:t.getPages()) {
				for(Record r:p.getTuples()) {
					
					col_to_be_indexed.add(r.getRow().get(col_index));
					
//					System.out.println("the index will be created on the clustering key : "+r.getRow().get(col_index));
					
					Records.add(r);
					
					trial_B_Tree.put(r.getRow().get(col_index), r);
				}
				
			}
		}else {
			//here the index should be on the clustering column 
//			System.out.println("the index will be created on the clustering key : "+t.getClusteringKey());
			for(Page p:t.getPages()) {
				for(Record r:p.getTuples()) {
					col_to_be_indexed.add(r.getClusteringKey());
//					System.out.println("the index will be created on the clustering key : "+r.getClusteringKey());
					Records.add(r);
					
					trial_B_Tree.put(r.getClusteringKey(), r);
				}
			}
			
		}
		
		
		for(Map.Entry<Object, Object>entry:trial_B_Tree.entrySet()) {
			
			
				
				bpt.insert((Comparable<Object>)entry.getKey(),entry.getValue());
				System.out.println(bpt.search((Comparable<Object>) entry.getKey())+" : "+entry.getValue());
			
			
			
			
			
			}
		System.out.println(bpt.toString());
		
		}else {
			System.out.println("no such a table ");
		}
		
	}
	

	public void createRTreeIndex(String strTableName,String strColName) throws DBAppException{
		// it should be the same code for polygnns except we should only get the column that has the polygons inside ease !!
		// you will insert the key in the B+ tree as the data in the column that you need to create the index for 
				// do not forget to change the column index from false to true ;
				Vector<Object> col_to_be_indexed=new Vector<Object>();
				Vector<Record> Records=new Vector<Record>();
				
				//the first entry for the the column data because it will be considered  as a key for the tree map !
				//the second entry for the record it self 
				HashMap<Object,Object>trial_B_Tree=new HashMap<Object, Object>();
				
				Table t=null;
				try {
						t =lookForTheTable(strTableName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("No such a table to create an index on !");
				}
				
				ArrayList<Object> headers=t.getPages().get(0).getHeader();
				
				int col_index=-1;
				for(int i=0;i<headers.size();i++) {
					//but what should be the case of the clustering key was in the middle ! just add the condition with && :)
					if(headers.get(i).equals(strColName)&&!(headers.get(i).equals(t.getClusteringKey()))) {

						col_index=i;
						System.out.println(i);
					}
				}
				// index < Row.size() because the the Row does not has the clustering key entry 
				//but the header has if we did not put the condition there will be a null pointer exception 
				
			
				if(col_index!=-1&&col_index<t.getPages().get(0).getTuples().get(0).getRow().size()) {
					for(Page p:t.getPages()) {
						for(Record r:p.getTuples()) {
							
							col_to_be_indexed.add(r.getRow().get(col_index));
							//we could add the record along with the col in  hash set to ease the insertion into the B+ tree 
							
							System.out.println("the index will be created on the clustering key : "+r.getRow().get(col_index));
							
							Records.add(r);
							
							trial_B_Tree.put(r.getRow().get(col_index), r);
						}
						
					}
				}else {
					//here the index should be on the clustering column 
//					System.out.println("the index will be created on the clustering key : "+t.getClusteringKey());
					for(Page p:t.getPages()) {
						for(Record r:p.getTuples()) {
							col_to_be_indexed.add(r.getClusteringKey());
							System.out.println("the index will be created on the clustering key : "+r.getClusteringKey());
							Records.add(r);
							
							
						}
					}
					
				}
				
				if(col_index!=-1) {
					 String h=(String) t.getPages().get(0).getHeaderTypes().get(col_index);
					 
					if(h.equals("java.lang.Polygon")) {
						B_Plus_Tree<Polygon, Record> bpt=new B_Plus_Tree<Polygon, Record>();
						int counter=0;
						for(Object d:col_to_be_indexed) {
						
							bpt.insert((Polygon)d, Records.get(counter));
							counter++;
						}
					}
					}

	}
	
	
	public static void main (String []args) throws DBAppException, IOException {
		@SuppressWarnings("unused")
		DBApp db=new DBApp();
	}
}
