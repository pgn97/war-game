package model;

 class Carta {

	 Geometria geometria;
	 Territorio territorio;
	 String url;
	 
	Carta(Geometria g, Territorio t, String u){
		geometria = g;
		territorio = t;
		url = u;
	}
	
	Geometria getGeometria (){
		return geometria;
	}
	
	Territorio getTerritorio () {
		return territorio;
	}
	
	void setTerritorio (Territorio t) {
		territorio = t;
	}
	
	void setGeometria (Geometria g){
		geometria = g;
	}
	
	String getUrl() {
		return url;
	}
	void setUrl(String u){
        url = u;
}
	
}
