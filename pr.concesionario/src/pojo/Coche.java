package pojo;

public class Coche {

	private int id;
	private String modelo;
	private int potenciaHP;
	private int anoLanzamiento;
	private int nVelocidades;
	private int id_marca;
	
	public Coche(String modelo, int potenciaHP, int anoLanzamiento, int nVelocidades, int id_marca) {
		super();
		this.modelo = modelo;
		this.potenciaHP = potenciaHP;
		this.anoLanzamiento = anoLanzamiento;
		this.nVelocidades = nVelocidades;
		this.id_marca = id_marca;
	}
	
	
	public Coche(int id, String modelo, int potenciaHP, int anoLanzamiento, int nVelocidades, int id_marca) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.potenciaHP = potenciaHP;
		this.anoLanzamiento = anoLanzamiento;
		this.nVelocidades = nVelocidades;
		this.id_marca = id_marca;
	}

	
	
	public int getId_marca() {
		return id_marca;
	}



	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPotenciaHP() {
		return potenciaHP;
	}

	public void setPotenciaHP(int potenciaHP) {
		this.potenciaHP = potenciaHP;
	}

	public int getAnoLanzamiento() {
		return anoLanzamiento;
	}

	public void setAnoLanzamiento(int anoLanzamiento) {
		this.anoLanzamiento = anoLanzamiento;
	}

	public int getnVelocidades() {
		return nVelocidades;
	}

	public void setnVelocidades(int nVelocidades) {
		this.nVelocidades = nVelocidades;
	}
	
	@Override
	public String toString() {
		return "Coche [id=" + id + ", modelo=" + modelo + ", potenciaHP=" + potenciaHP + ", anoLanzamiento="
				+ anoLanzamiento + ", nVelocidades=" + nVelocidades + ", id_marca=" + id_marca + "]\n";
	}
	
	
	
}
