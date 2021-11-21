package teste;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Projeto {
	private int id;
	private String nome;
	private String desc;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

}