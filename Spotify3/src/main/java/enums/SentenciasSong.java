package enums;

public enum SentenciasSong {
	SELECTBYID("SELECT * FROM cancion WHERE id=?"),
	INSERT("INSERT INTO cancion(nombre,duracion,id_genero,id_disco) VALUES(?,?,?,?)"),
	UPDATE("UPDATE cancion SET nombre=?,duracion=?,id_genero=?,id_disco=? WHERE id=?"),
	DELETE("DELETE FROM cancion WHERE id=?"),
	SELECTALL("SELECT * FROM cancion"),
	SELECTFORPLAYLIST("SELECT c.id, c.nombre, c.duracion, c.id_genero, c.id_disco "
			+ "FROM cancion AS c JOIN lista_cancion AS lc ON c.id=lc.id_cancion JOIN lista AS l ON l.id=lc.id_lista WHERE l.id=?"),
	SELECTFORDISC("SELECT * FROM cancion WHERE id_disco=?"),
	SELECTBYNAME("SELECT * FROM cancion WHERE nombre LIKE ?"),
	EXIST("SELECT * FROM cancion WHERE id_disco=? AND nombre=?")
	;
	private String sql="";

	private SentenciasSong(String sql) {
		this.sql = sql;
	}

	public String getSQL(){
		return this.sql;
	}
}
