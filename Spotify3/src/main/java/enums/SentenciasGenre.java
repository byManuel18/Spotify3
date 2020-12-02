package enums;

public enum SentenciasGenre {
	SELECTBYID("SELECT * FROM genero WHERE id=?"),
	INSERT("INSERT INTO genero(nombre) VALUES(?)"),
	UPDATE("UPDATE genero SET nombre=? WHERE id=?"),
	DELETE("DELETE FROM genero WHERE id=?"),
	SELECTALL("SELECT * FROM genero WHERE id>0"),
	EXIST("SELECT * FROM genero WHERE nombre=?")
	;

	private String sql="";

	private SentenciasGenre(String sql){
		this.sql=sql;
	}

	public String getSQL(){
		return this.sql;
	}
}
