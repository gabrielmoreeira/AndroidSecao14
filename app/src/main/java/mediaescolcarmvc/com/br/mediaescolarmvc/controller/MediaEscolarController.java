package mediaescolcarmvc.com.br.mediaescolarmvc.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import mediaescolcarmvc.com.br.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import mediaescolcarmvc.com.br.mediaescolarmvc.datasource.DataSource;
import mediaescolcarmvc.com.br.mediaescolarmvc.model.MediaEscolar;

public class MediaEscolarController extends DataSource {

    ContentValues dados;

    public MediaEscolarController(Context context) {
        super(context);
    }

    // TODO: implementar calculo da média
    public double calcularMedia(MediaEscolar obj){
        return (obj.getNotaProva() + obj.getNotaTrabalho()) / 2;
    }

    // TODO: Implementar calculo do resultado final
    public String resultadoFinal(double media){
        return media >= 7? "Aprovado" : "Reprovado" ;
    }

    public boolean salvar(MediaEscolar obj){

        boolean sucesso = true;

        dados = new ContentValues();

        // Passa os dados da data model
        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(), obj.getNotaTrabalho());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = insert(MediaEscolarDataModel.getTABELA(),dados);

        return sucesso;
    }

    public boolean deletar(MediaEscolar obj){

        boolean sucesso = true;

        sucesso = deletar(MediaEscolarDataModel.getTABELA(), obj.getId());

        return sucesso;
    }

    public boolean alterar(MediaEscolar obj){

        boolean sucesso = true;

        dados = new ContentValues();

        // Passa os dados da data model
        dados.put(MediaEscolarDataModel.getId(), obj.getId());
        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(), obj.getNotaTrabalho());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = alterar(MediaEscolarDataModel.getTABELA(),dados);

        return sucesso;
    }

    public List<MediaEscolar> listar() {
        return getAllMediaEscolar();
    }

    public boolean buscar(MediaEscolar obj){

        boolean sucesso = true;

        sucesso = buscar(MediaEscolarDataModel.getTABELA(),obj.getId());

        return sucesso;
    }
}
