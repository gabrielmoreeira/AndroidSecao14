package mediaescolcarmvc.com.br.mediaescolarmvc.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mediaescolcarmvc.com.br.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import mediaescolcarmvc.com.br.mediaescolarmvc.model.MediaEscolar;


public class DataSource extends SQLiteOpenHelper {

    private static final String DB_NAME = "media_escolar.sqlite";
    private static final int DB_VERSION = 2;

    Cursor cursor;
    // Precisa do ID da coluna e o conteudo

    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(MediaEscolarDataModel.criarTabela());
        }catch (Exception e){
            Log.e("Media","DB----> ERRO: " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Backup dos dados

    }

    public boolean insert(String tabela, ContentValues dados){

        boolean sucesso = true;

        try{

            sucesso = db.insert(tabela,null,dados) > 0;

        }catch (Exception e){

            sucesso = false;
        }

        return sucesso;
    }

    public boolean deletar(String tabela, int id){

        boolean sucesso = true;

        try {
            sucesso = db.delete(tabela,"id=?",new String[]{Integer.toString(id)}) > 0;
        } catch (Exception e){
            return  false;
        }

        return sucesso;
    }

    public boolean alterar(String tabela, ContentValues dados){

        boolean sucesso = true;

        int id = dados.getAsInteger("id");

        try {
            sucesso = db.update(tabela,
                                 dados,
                                "id=?",
                                 new String[]{Integer.toString(id)}) > 0;
        } catch (Exception e){
            return  false;
        }

        return sucesso;
    }


    /**
     * Método que recebe a tabela e a chave da tabela para realizar a busca no banco de dados
     * @param tabela
     * @param id
     * @return retorna verdadeiro ou falso caso não encontre os dados.
     */
    public boolean buscar(String tabela, int id){

        boolean sucesso = true;

        MediaEscolar obj = new MediaEscolar();

        String sql = "SELECT * FROM " + tabela +
                     " WHERE id = " + MediaEscolarDataModel.getId();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            obj.setId(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getId())));
        }
        return  sucesso;

    }

    public List<MediaEscolar> getAllMediaEscolar(){

        MediaEscolar obj;
        List<MediaEscolar> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + MediaEscolarDataModel.getTABELA() + " ORDER BY id";

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
           do {
               obj = new MediaEscolar();
               obj.setId(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getId())));
               obj.setMateria(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getMateria())));
               lista.add(obj);
           } while (cursor.moveToNext());
        }

        cursor.close();

        return lista;
    }

}
