import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

class Record implements Comparator<Record>,Serializable{
	
	
	Comparable ClusteringKey;
	ArrayList<Object> Row=new ArrayList<Object>();
	
	
	
	public ArrayList<Object> getRow() {
		return Row;
	}


	public void setRow(ArrayList<Object> row) {
		Row = row;
	}




	public Comparable getClusteringKey() {
		return ClusteringKey;
	}


	public void setClusteringKey(Comparable clusteringKey) {
		this.ClusteringKey = clusteringKey;
	}

	public void RemoveRecord() {
		Row.clear();
		setClusteringKey(null);
	}

	@Override
	public int compare(Record arg0, Record arg1) {
		
			
			return arg0.getClusteringKey().compareTo(arg1.getClusteringKey());
		
	}
		
	
	public  void printRecord() {
		
		System.out.println(this.getClusteringKey()+":"+this.getRow());
	}
	public String toString() {
		
		String s=this.getClusteringKey()+":"+this.getRow();
		
		return s;
		
	}
	
	public static void main (String[]args) {
		Record r=new Record();
		ArrayList<Object> Row=new ArrayList<Object>();
		Row.add(2);
		Row.add("ahmed");
		Row.add(2/22/22);
		r.setRow(Row);
		r.setClusteringKey('a');
		
		Record r2=new Record();
		ArrayList<Object> Row2=new ArrayList<Object>();
		Row2.add(7);
		Row2.add("khaled");
		Row2.add(2/22/22);
		r2.setRow(Row2);
		r2.setClusteringKey('b');
		
		Record r3=new Record();
		ArrayList<Object> Row3=new ArrayList<Object>();
		Row3.add(2);
		Row3.add("jo");
		Row3.add(2/22/2020);
		r3.setRow(Row3);
		r3.setClusteringKey('a');
		
		
		
		ArrayList<Record> a=new ArrayList<Record>();
		
		a.add(r);
		a.add(r2);
		a.add(r3);
		
		Collections.sort(a,new Record());
		

		for(Record rr:a) {
			rr.printRecord();
		}
		
		
	}

}
