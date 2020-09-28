import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Table implements Serializable{
	String tableName;
	String clusteringKey;
	Vector<Page> Pages=new Vector<Page>();
	




	ArrayList<String> types=new ArrayList<String>();
	
	
	public String getTableName() {
		return tableName;
	}



	public void setTableName(String tableName) {
		this.tableName = tableName;
	}



	public String getClusteringKey() {
		return clusteringKey;
	}



	public void setClusteringKey(String clusteringKey) {
		this.clusteringKey = clusteringKey;
	}



	public Vector<Page> getPages() {
		return Pages;
	}



	public void setPages(Vector<Page> pages) {
		Pages = pages;
	}



	public ArrayList<String> getTypes() {
		return types;
	}



	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}



	public Table() {
		
		types.add("java.lang.Integer");
		types.add("java.lang.String");
		types.add("java.lang.Double");
		types.add("java.util.Date");
		types.add("java.lang.Boolean");
		types.add("java.awt.Polygon");
		
		
	}


	
	public static void main (String[]args) {
		@SuppressWarnings("unused")
		Table t=new Table();
	}

	
}
