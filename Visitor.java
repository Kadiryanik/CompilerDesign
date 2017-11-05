interface Visitor {
	public int visit(EqList e);
	public int visit(FnLExp e);
	public int visit(Eq e);
	public int visit(Exp e);
	public int visit(IdExp e);
	public int visit(NumExp e);
	public int visit(PlusExp e);
	public int visit(MinusExp e);
	public int visit(TimesExp e);
	public int visit(DivideExp e);
	public int visit(ModExp e);
	public int visit(PowerExp e);
	public int visit(FnRExp e);
}