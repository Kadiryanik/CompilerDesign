import java.util.*;

class SymTable {
	Hashtable table_f = new Hashtable();
	Hashtable table_v;

	public void beginScope() {
		table_v = new Hashtable();
	}

	public void endScope() {
		table_v = null;
	}

	public void put(String id, int value) {	
		if(value == 0){
			table_v.put(id, new Integer(value));
		} else {
			table_f.put(id, new Integer(value));
		}
	}

	public int get(String id, int value){
		if(value == 0){
			return ((Integer)table_v.get(id)).intValue();
		}else{
			return ((Integer)table_f.get(id)).intValue();
		}
	}

	public boolean contains(String id, int value) {
		if(value == 0){
			return table_v.containsKey(id);			
		}
		return table_f.containsKey(id);
	}
}