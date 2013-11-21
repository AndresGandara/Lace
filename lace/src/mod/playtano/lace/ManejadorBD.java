package mod.playtano.lace;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ManejadorBD extends SQLiteOpenHelper{
	private SQLiteDatabase db;
	
	public ManejadorBD(Context context) {
		super(context, "LaceBD", null, 1);
	}	

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE item (" +
				"titulo VARCHAR(25) PRIMARY KEY," +
				"FOREING KEY(coordenadas) REFERENCES lugar(coordenadas)," +
				"prioridad BOOLEAN NOT NULL," +
				"fecharecordatorio DATE," +
				"horarecordatorio TIME," +
				"fechacreacion DATE NOT NULL," +
				"horacreacion TIME NOT NULL" +
				")");
		
		db.execSQL("CREATE TABLE nota (" +
				"FOREING KEY(titulo) REFERENCES item(titulo) ON DELETE CASCADE," +
				"texto TEXT" +
				")");
		
		db.execSQL("CREATE TABLE tarea (" +
				"idtarea INT PRIMARY KEY," +
				"FOREING KEY(titulo) REFERENCES item(titulo) ON DELETE CASCADE," +
				"nombretarea VARCHAR(60)" +
				"status BOOLEAN" +
				")");
		
		db.execSQL("CREATE TABLE etiqueta (" +
				"idetiqueta INT PRIMARY KEY AUTOINCREMENT," +
				"FOREING KEY(titulo) REFERENCES item(titulo) ON DELETE CASCADE," +
				"nombreetiquetaa VARCHAR(60)" +
				")");
		
		db.execSQL("CREATE TABLE lugar (" +
				"coordenadas INT PRIMARY KEY AUTOINCREMENT," +
				"nombrelugar VARCHAR(60)" +
				")");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//
	}
	
	public void creaNota(Nota nota){
		db = getWritableDatabase();
		db.execSQL("INSERT INTO item VALUES('" + nota.getTitulo() +
				"', '" + nota.getCoordenadas() +
				"', " + nota.isPrioridad() +
				", '" + nota.getFechaRecordatorio() +
				"', '" + nota.getHoraRecordatorio() +
				"', '" + nota.getFechaCreacion() +
				"', '" + nota.getHoraCreacion() +
				"')");
		
		db.execSQL("INSERT INTO nota VALUES('" + nota.getTitulo() + 
				"', '" + nota.getTexto() +
				"')");
	}
	
	public void actualizaNota(Nota nota){
		db = getWritableDatabase();
		ContentValues actualizarNota = new ContentValues();
		//actualizarNota.put(llave, valor);
		actualizarNota.put("coordenadas", nota.getCoordenadas());
		actualizarNota.put("prioridad", nota.isPrioridad());
		actualizarNota.put("fecharecordatorio", nota.getFechaRecordatorio().toString());
		actualizarNota.put("horarecordatorio", nota.getHoraRecordatorio().toString());
		actualizarNota.put("fechacreacion", nota.getFechaCreacion().toString());
		actualizarNota.put("horacreacion", nota.getHoraCreacion().toString());
		//db.update(NombreTabla, valores, condicion WHERE, argumentos WHERE);
		db.update("item", actualizarNota, "titulo = " + nota.getTitulo(), null);
		
		ContentValues actualizarNota2 = new ContentValues();
		actualizarNota2.put("texto", nota.getTexto());
		db.update("nota", actualizarNota2, "titulo = " + nota.getTitulo(), null);
	}
	
	public void eliminaNota(Nota nota){
		db = getWritableDatabase();
		//db.delete(NombreTabla, condicion WHERE, argumentos WHERE);
		db.delete("item", "titulo = " + nota.getTitulo(), null);
	}
	
	
	public void creaLista(Item item){
		db = getWritableDatabase();
		db.execSQL("INSERT INTO item VALUES('" + item.getTitulo() +
				"', '" + item.getCoordenadas() +
				"', " + item.isPrioridad() +
				", '" + item.getFechaRecordatorio() +
				"', '" + item.getHoraRecordatorio() +
				"', '" + item.getFechaCreacion() +
				"', '" + item.getHoraCreacion() +
				"')");
	}
	
	public void actualizaLista(Item item){
		db = getWritableDatabase();
		ContentValues actualizarItem = new ContentValues();
		//actualizarNota.put(llave, valor);
		actualizarItem.put("coordenadas", item.getCoordenadas());
		actualizarItem.put("prioridad", item.isPrioridad());
		actualizarItem.put("fecharecordatorio", item.getFechaRecordatorio().toString());
		actualizarItem.put("horarecordatorio", item.getHoraRecordatorio().toString());
		actualizarItem.put("fechacreacion", item.getFechaCreacion().toString());
		actualizarItem.put("horacreacion", item.getHoraCreacion().toString());
		//db.update(NombreTabla, valores, condicion WHERE, argumentos WHERE);
		db.update("item", actualizarItem, "titulo = " + item.getTitulo(), null);		
	}
	
	public void eliminaLista(Item item){
		db = getWritableDatabase();
		//db.delete(NombreTabla, condicion WHERE, argumentos WHERE);
		db.delete("item", "titulo = " + item.getTitulo(), null);
	}
	
	
	public void creaTarea(Tarea tarea){
		db = getWritableDatabase();
		db.execSQL("INSERT INTO tarea VALUES(" + tarea.getIdTarea() +
				", '" + tarea.getTitulo() +
				"', '" + tarea.getNombreTarea() +
				"', " + tarea.isStatus() +
				")");		
	}
	
	public void actualizaTarea(Tarea tarea){
		db = getWritableDatabase();
		ContentValues actualizarItem = new ContentValues();
		//actualizarNota.put(llave, valor);
		actualizarItem.put("status", tarea.isStatus());
		//db.update(NombreTabla, valores, condicion WHERE, argumentos WHERE);
		db.update("tarea", actualizarItem, "idtarea = " + tarea.getIdTarea() + " and titulo = " + tarea.getTitulo(), null);		
	}
	
	public void eliminaTarea(Tarea tarea){
		db = getWritableDatabase();
		//db.delete(NombreTabla, condicion WHERE, argumentos WHERE);
		db.delete("tarea", "idtarea = " + tarea.getIdTarea() + " and titulo = " + tarea.getTitulo(), null);
	}
	

}
