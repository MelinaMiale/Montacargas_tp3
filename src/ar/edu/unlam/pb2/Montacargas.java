package ar.edu.unlam.pb2;

public class Montacargas {

	private Double pesoTotal;
	private Double pesoM�ximoPermitido;
	private Boolean seAlcanzoCapacidadM�xima; 
	
	public Montacargas(Double pesoM�ximoPermitido) {
		this.pesoTotal = 0.0;
		this.pesoM�ximoPermitido = pesoM�ximoPermitido;
		this.seAlcanzoCapacidadM�xima = false;
	}
	
	public Double obtenerLaCapacidadDisponibleDelMontacargas () {
		return this.pesoM�ximoPermitido - this.pesoTotal;
	}

	public Double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public Double getPesoM�ximoPermitido() {
		return pesoM�ximoPermitido;
	}

	public void setPesoM�ximoPermitido(Double pesoM�ximoPermitido) {
		this.pesoM�ximoPermitido = pesoM�ximoPermitido;
	}
	

	public Boolean getSeAlcanzoCapacidadM�xima() {
		return seAlcanzoCapacidadM�xima;
	}

	public void setSeAlcanzoCapacidadM�xima(Boolean seAlcanzoCapacidadM�xima) {
		this.seAlcanzoCapacidadM�xima = seAlcanzoCapacidadM�xima;
	}

	public void agregarPeso(Double pesoAAgregarEnElMontacargas) {
		//Double diferenciaDePesoFaltanteParaLlegarAlPesoMaximo = this.pesoM�ximoPermitido - this.pesoTotal;
		if(this.pesoTotal < this.pesoM�ximoPermitido && 
				this.obtenerLaCapacidadDisponibleDelMontacargas() >= pesoAAgregarEnElMontacargas) {
			this.pesoTotal += pesoAAgregarEnElMontacargas;
			this.seAlcanzoCapacidadM�xima = this.pesoTotal.equals(this.pesoM�ximoPermitido) ? true : false;
		}
	}

	public void restarPeso(Double pesoARestarAlMontacargas) {
		if(pesoARestarAlMontacargas <= this.pesoTotal) {
			this.pesoTotal = this.pesoTotal - pesoARestarAlMontacargas;	
		}
	}

	
}
