package mediaescolcarmvc.com.br.mediaescolarmvc.controller;

import android.content.ContentValues;
import android.content.Context;

import mediaescolcarmvc.com.br.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import mediaescolcarmvc.com.br.mediaescolarmvc.datasource.DataSource;
import mediaescolcarmvc.com.br.mediaescolarmvc.model.MediaEscolar;

public class MediaEscolarController extends DataSource {

    ContentValues dados;

    public MediaEscolarController(Context context) {
        super(context);
    }

    // TODO: implementar calculo da média
    public void calcularMedia(){

    }

    // TODO: Implementar calculo do resultado final
    public void resultadoFinal(){

    }

    public boolean salvar(MediaEscolar obj){

        boolean sucesso = true;

        dados = new ContentValues();

        // Passa os dados da data model
        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(), obj.getNotaMateria());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = insert(MediaEscolarDataModel.getTABELA(),dados);

        return sucesso;
    }


}
