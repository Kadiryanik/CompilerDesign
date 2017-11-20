import java.util.*;

class EvalTable {
	Hashtable table[] = new Hashtable[1000];
	int index = -1;
	public void beginScope() {
		table[++index] = new Hashtable();
	}

	public void endScope() {
		index--;
	}

	public void put(String id, int value) {	
		table[index].put(id, new Integer(value));
	}

	public int get(String id){
		return ((Integer)table[index].get(id)).intValue();
	}
}