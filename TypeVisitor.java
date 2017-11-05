public class TypeVisitor implements Visitor {
	Table t;

	public TypeVisitor(Table t) {
		this.t = t;
	}

	public int visit(EqList e){
		int a = e.e.accept(this);
		int b = 0;
		if(e.el != null){
			b = e.el.accept(this);
		}
		return a + b;
	}
	public int visit(FnLExp e){
		if(!t.contains(e.id, 1)){ // 1: func
			t.put(e.id, 1); // 1: func
		}

		if(e.e instanceof IdExp){
			t.put(((IdExp)e.e).id, 0); // 0: variables
		}
		return 0;
	}
	public int visit(Eq e){
		t.beginScope();
		int a = e.f.accept(this);
		int b = e.e.accept(this);
		t.endScope();
		return a + b;
	}
	public int visit(Exp e){
		e.accept(this);
		return 0;
	}
	public int visit(IdExp e){
		if(t.contains(e.id, 0)){ // 0: variables
			return 0;
		}

		System.out.println("var " + e.id + " not defined!");
		return 1;
	}
	public int visit(NumExp e){
		return 0;
	}
	public int visit(PlusExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a + b;
	}
	public int visit(MinusExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a + b;
	}
	public int visit(TimesExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a + b;
	}
	public int visit(DivideExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a + b;
	}
	public int visit(ModExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a + b;
	}
	public int visit(PowerExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a + b;
	}
	public int visit(FnRExp e){
		if(t.contains(e.id, 1)){ // 1: functions
			int a = e.e.accept(this);
			return a;
		}

		System.out.println("function " + e.id + " not defined!");
		return 1; // Error
	}
}