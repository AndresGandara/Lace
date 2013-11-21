package mod.playtano.lace;

public class Tarea {
	private int idTarea;
	private String titulo;
	private String nombreTarea;
	private boolean status;
	
	public Tarea() {
		super();
	}
	
	public Tarea(int idTarea, String titulo, String nombreTarea, boolean status){
		super();
		this.idTarea = idTarea;
		this.titulo = titulo;		
		this.nombreTarea = nombreTarea;
		this.status = status;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("idTarea =").append(getIdTarea()).append("\n");
		sb.append("titulo =").append(getTitulo()).append("\n");		
		sb.append("nombreTarea =").append(getNombreTarea()).append("\n");
		sb.append("status =").append(isStatus()).append("\n");
		return sb.toString();
	}
	
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNombreTarea() {
		return nombreTarea;
	}
	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}	
	
}
