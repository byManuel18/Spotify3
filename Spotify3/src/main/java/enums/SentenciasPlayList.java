package enums;

public enum SentenciasPlayList {
	SELECTBYID("SELECT * FROM lista WHERE id=? "),
	SELECTALL("SELECT * FROM lista"),
	SELECTFORCREATOR("SELECT * FROM lista WHERE id_usuario=?"),
	SELECTFORUSERSUBSCRIBER("SELECT list.id, list.nombre, list.id_usuario, list.descripcion FROM "
			+ "lista as list JOIN suscripcion as sub ON sub.id_lista=list.id JOIN usuario as user ON"
			+ " user.id=sub.id_usuario where user.id=?"),
	DELETE("DELETE  FROM lista WHERE id=?"),
	INSERT("INSERT INTO lista(nombre,descripcion,id_usuario) VALUES(?,?,?)"),
	UPDATE("UPDATE lista SET nombre=?,descripcion=?, WHERE id=?"),
	ADDSONGTOPLAYLIST("INSERT INTO lista_cancion(id_lista,id_cancion) VALUES(?,?)"),
	DELETESONGFROMPLAYLIST("DELETE FROM lista_cancion WHERE id_lista=? AND id_cancion=?"),
	SLECTALLEXCEPTUSER("SELECT * FROM lista WHERE id_usuario !=?"),
	SLECTALLEXCEPTUSERANDNAME("SELECT * FROM lista WHERE id_usuario !=? AND nombre LIKE ?"),
	SUBSCRIBE("INSERT INTO suscripcion(id_usuario,id_lista) VALUES(?,?)"),
	DESUSBSCRIBE("DELETE FROM suscripcion WHERE id_usuario=? AND id_lista=?"),
	SLECTALLEXCEPTUSERANDNAMEFROMCREATOR("SELECT l.nombre,l.id,l.descripcion,l.id_usuario FROM lista"
			+ " AS l JOIN usuario AS u ON l.id_usuario=u.id WHERE l.id_usuario!=? AND u.nombre LIKE ?"),
	EXIST("SELECT * FROM lista WHERE id_usuario=? AND nombre=?")
	;

	private String sql = "";

	private SentenciasPlayList(String sql) {
		this.sql = sql;
	}

	public String getSQL() {
		return this.sql;
	}
}
