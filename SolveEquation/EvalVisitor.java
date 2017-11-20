public class EvalVisitor implements Visitor {
	EvalTable t;
	EqList el;

	public static void main(String args[]) throws ParseException{
		EqList el = new Parser(System.in).Parser();
		int a = new TypeVisitor(new SymTable()).visit(el);
		System.out.println("Parse " + ((a != 0) ? "Failed!" : "Succeed!"));
		if (a == 0){
			int n = new EvalVisitor(el).evalFn("main", 0);
			System.out.println("n = " + n);
		}
	}

	public EvalVisitor(EqList el) {
		t = new EvalTable();
		this.el = el;
	}

	public int evalFn(String fname, int n){
		t.beginScope();
		int result = 0;
		EqList el2 = el;
		do{
			if(el2.e.f.id.equals(fname)){
				if(el2.e.f.e instanceof NumExp){
					if(((NumExp)el2.e.f.e).num == n){
						result = el2.e.e.accept(this);
						break;
					}
				} else if(el2.e.f.e instanceof IdExp){
					t.put(((IdExp)el2.e.f.e).id, n);
					result = el2.e.e.accept(this);
					break;
				}
			}
			el2 = el2.el;
		} while(el2 != null);
		t.endScope();
		return result;
	}

	public int visit(EqList e){
		return 0;
	}
	public int visit(FnLExp e){
		return 0;
	}
	public int visit(Eq e){
		return 0;
	}
	public int visit(Exp e){
		return e.accept(this);
	}
	public int visit(IdExp e){
		return t.get(e.id);
	}
	public int visit(NumExp e){
		return e.num;
	}
	public int visit(PlusExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a + b;
	}
	public int visit(MinusExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a - b;
	}
	public int visit(TimesExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a * b;
	}
	public int visit(DivideExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a / b;
	}
	public int visit(ModExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a % b;
	}
	public int visit(PowerExp e){
		int a = e.e1.accept(this);
		int b = e.e2.accept(this);

		return a ^ b;
	}
	public int visit(FnRExp e){
		return evalFn(e.id, e.e.accept(this));
	}
}