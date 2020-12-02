package enums;

public enum SentenciasDisc {
	SELECTBYID("SELECT * FROM disco WHERE id=?"),
	INSERT("INSERT INTO disco(nombre, foto, id_artista, fecha_produccion) VALUES(?,?,?,?)"),
	UPDATE("UPDATE disco SET nombre=?, foto=?, fecha_produccion=? WHERE id=?"),
	DELETE("DELETE FROM disco WHERE id=?"),
	SELECTALL("SELECT * FROM disco"),
	SELECTBYAUTHOR("SELECT * FROM disco WHERE id_artista=?"),
	SELECTBYNAME("SELECT * FROM disco WHERE nombre LIKE ?"),
	EXIST("SELECT * FROM disco WHERE id_artista=? AND nombre=?"),
	;
	private String sql="";

	private SentenciasDisc(String sql){
		this.sql=sql;
	}

	public String getSQL(){

		return this.sql;
	}
}
