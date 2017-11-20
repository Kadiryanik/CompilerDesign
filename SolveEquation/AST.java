class EqList {
	Eq e;
	EqList el;
	public EqList(Eq a, EqList b) {
		e = a;
		el = b;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class FnLExp {
	String id;
	Exp e;
	public FnLExp(String a, Exp b) {
		id = a;
		e = b;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class Eq {
	FnLExp f;
	Exp e;
	public Eq(String a, Exp b, Exp c){
		f = new FnLExp(a, b);
		e = c;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

abstract class Exp { 
	public abstract int accept(Visitor v);
}

class IdExp extends Exp {
	String id;
	public IdExp(String a) {
		id = a;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class NumExp extends Exp {
	int num;
	public NumExp(String a) {
		num = Integer.parseInt(a);
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class PlusExp extends Exp {
	Exp e1, e2;
	public PlusExp(Exp a, Exp b) {
		e1 = a;
		e2 = b;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class MinusExp extends Exp {
	Exp e1, e2;
	public MinusExp(Exp a, Exp b) {
		e1 = a;
		e2 = b;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class TimesExp extends Exp {
	Exp e1, e2;
	public TimesExp(Exp a, Exp b) {
		e1 = a;
		e2 = b;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class DivideExp extends Exp {
	Exp e1, e2;
	public DivideExp(Exp a, Exp b) {
		e1 = a;
		e2 = b;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class ModExp extends Exp {
	Exp e1, e2;
	public ModExp(Exp a, Exp b) {
		e1 = a;
		e2 = b;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class PowerExp extends Exp {
	Exp e1, e2;
	public PowerExp(Exp a, Exp b) {
		e1 = a;
		e2 = b;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}

class FnRExp extends Exp {
	String id;
	Exp e;
	public FnRExp(String a, Exp b) {
		id = a;
		e = b;
	}

	public int accept(Visitor v){
		return v.visit(this);
	}
}