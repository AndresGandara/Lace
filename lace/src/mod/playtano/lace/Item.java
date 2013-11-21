package mod.playtano.lace;

import java.sql.Date;
import android.text.format.Time;

public class Item{
	
	private String titulo;
	private String coordenadas;
	private boolean prioridad;
	private Date fechaRecordatorio;
	private Time horaRecordatorio;
	private Date fechaCreacion;
	private Time horaCreacion;
	
	public Item(){
		super();
	}
	
	public Item(String titulo, String coordenadas, boolean prioridad, Date fechaRecordatorio, 
			Time horaRecordatorio, Date fechaCreacion, Time horaCreacion){
		super();
		this.titulo = titulo;
		this.coordenadas = coordenadas;
		this.prioridad = prioridad;
		this.fechaRecordatorio = fechaRecordatorio;
		this.horaRecordatorio = horaRecordatorio;
		this.fechaCreacion = fechaCreacion;
		this.horaCreacion = horaCreacion;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("titulo =").append(getTitulo()).append("\n");
		sb.append("coordenadas =").append(getCoordenadas()).append("\n");
		sb.append("prioridad =").append(isPrioridad()).append("\n");
		sb.append("fechaRecordatorio =").append(getFechaRecordatorio()).append("\n");
		sb.append("horaRecordatorio =").append(getHoraRecordatorio()).append("\n");
		sb.append("fechaCreacion =").append(getFechaCreacion()).append("\n");
		sb.append("horaCreacion =").append(getHoraCreacion()).append("\n");
		return sb.toString();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	public boolean isPrioridad() {
		return prioridad;
	}
	public void setPrioridad(boolean prioridad) {
		this.prioridad = prioridad;
	}
	public Date getFechaRecordatorio() {
		return fechaRecordatorio;
	}
	public void setFechaRecordatorio(Date fechaRecordatorio) {
		this.fechaRecordatorio = fechaRecordatorio;
	}
	public Time getHoraRecordatorio() {
		return horaRecordatorio;
	}
	public void setHoraRecordatorio(Time horaRecordatorio) {
		this.horaRecordatorio = horaRecordatorio;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Time getHoraCreacion() {
		return horaCreacion;
	}
	public void setHoraCreacion(Time horaCreacion) {
		this.horaCreacion = horaCreacion;
	}	
	
}
