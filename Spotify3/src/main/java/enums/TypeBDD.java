package enums;

public enum TypeBDD {

	H2("jdbc:h2:"),
	MySQL("jdbc:mysql:");

	private String type="";

	private TypeBDD(String type){
		this.type=type;
	}

	public String getType(){
		return type;
	}

}
