package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import enums.TypeBDD;
import utilities.ConnectionManager;

@XmlRootElement(name="CHANEL")
@XmlAccessorType(XmlAccessType.FIELD)
public class Options {

	private TypeBDD typeBDD;

	public Options() {
		this(TypeBDD.H2);
	}

	public Options(TypeBDD typeBDD) {
		this.typeBDD=typeBDD;
	}

	public TypeBDD getTypeBDD() {
		return typeBDD;
	}

	public void setTypeBDD(TypeBDD typeBDD) {
		if(this.typeBDD!=typeBDD){
			this.typeBDD = typeBDD;
			ConnectionManager.ChangeConection();
		}

	}




}
