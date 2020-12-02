package enums;

public enum Escenas {
	INICIO("/views/Start"),
	REGISTRY("/views/Registry"),
	ADMINISTRATION("/views/Administration"),
	GENRE("/views/GenreView"),
	ARTIST("/views/ArtistView"),
	USERVIEW("/views/UserView"),

	;
	private String url;

    Escenas(String fxmlFile) {
        this.url = fxmlFile;
    }

    public String getUrl() {
        return url;
    }

}
