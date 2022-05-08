package ar.edu.unlam.pb2;

public class Montacargas {

	private Double pesoTotal;
	private Double pesoMáximoPermitido;
	private Boolean seAlcanzoCapacidadMáxima; 
	
	public Montacargas(Double pesoMáximoPermitido) {
		this.pesoTotal = 0.0;
		this.pesoMáximoPermitido = pesoMáximoPermitido;
		this.seAlcanzoCapacidadMáxima = false;
	}
	
	public Double obtenerLaCapacidadDisponibleDelMontacargas () {
		return this.pesoMáximoPermitido - this.pesoTotal;
	}

	public Double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public Double getPesoMáximoPermitido() {
		return pesoMáximoPermitido;
	}

	public void setPesoMáximoPermitido(Double pesoMáximoPermitido) {
		this.pesoMáximoPermitido = pesoMáximoPermitido;
	}
	

	public Boolean getSeAlcanzoCapacidadMáxima() {
		return seAlcanzoCapacidadMáxima;
	}

	public void setSeAlcanzoCapacidadMáxima(Boolean seAlcanzoCapacidadMáxima) {
		this.seAlcanzoCapacidadMáxima = seAlcanzoCapacidadMáxima;
	}

	public void agregarPeso(Double pesoAAgregarEnElMontacargas) {
		//Double diferenciaDePesoFaltanteParaLlegarAlPesoMaximo = this.pesoMáximoPermitido - this.pesoTotal;
		if(this.pesoTotal < this.pesoMáximoPermitido && 
				this.obtenerLaCapacidadDisponibleDelMontacargas() >= pesoAAgregarEnElMontacargas) {
			this.pesoTotal += pesoAAgregarEnElMontacargas;
			this.seAlcanzoCapacidadMáxima = this.pesoTotal.equals(this.pesoMáximoPermitido) ? true : false;
		}
	}

	public void restarPeso(Double pesoARestarAlMontacargas) {
		if(pesoARestarAlMontacargas <= this.pesoTotal) {
			this.pesoTotal = this.pesoTotal - pesoARestarAlMontacargas;	
		}
	}

	
}
