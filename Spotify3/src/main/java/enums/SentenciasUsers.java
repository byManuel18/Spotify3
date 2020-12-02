package enums;

public enum SentenciasUsers {
	INSERTUSERS("INSERT INTO usuario (nombre,correo,foto,activo) VALUES(?,?,?,?)"),
	SELECTBYID("SELECT * FROM usuario WHERE id=?"),
	UPDATEUSER("UPDATE usuario SET nombre=?,correo=?,foto=?,activo=? WHERE id=?"),
	DEFUSE("UPDATE usuario SET activo=false WHERE id=?"),
	SUBSCRIBERS("SELECT user.id, user.nombre,user.correo, user.foto,user.activo FROM usuario"
			+ " as user JOIN suscripcion sub ON sub.id_usuario=user.id JOIN lista as"
			+ " list ON list.id=sub.id_lista WHERE list.id=? AND user.activo=1"),
	SELECTBYEMAIL("SELECT * FROM usuario WHERE correo=?")
	;

	private String sql="";

	private SentenciasUsers(String sql){
		this.sql=sql;
	}

	public String getSQL(){
		return sql;
	}

}
