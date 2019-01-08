package mediaescolcarmvc.com.br.mediaescolarmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import mediaescolcarmvc.com.br.mediaescolarmvc.R;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_PUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        apresentarTelaSplash();

    }


    private void apresentarTelaSplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //DataSource ds = new DataSource(getApplicationContext());

                //TODO remover este código daqui
                //MediaEscolar obj = new MediaEscolar();

                /*obj.setMateria("Portugues");
                obj.setBimestre("1° Bimestre");
                obj.setSituacao("Reprovado");
                obj.setNotaProva(10);
                obj.setNotaMateria(10);
                obj.setMediaFinal(10);
                //obj.setSituacao("Reprovado");

                MediaEscolarController mediaEscolarController = new MediaEscolarController(getBaseContext());

                //mediaEscolarController.salvar(obj);

                obj.setId(3);
                //mediaEscolarController.deletar(obj);
                mediaEscolarController.alterar(obj);*/


               // MediaEscolarController mediaEscolarController = new MediaEscolarController(getBaseContext());
                //List<MediaEscolar> objetos = mediaEscolarController.listar();

                //obj.setId(2);
               // mediaEscolarController.buscar(obj);
               // Log.i("BUSCAR DADOS: ", "ID: " + obj.getId());

                //for (MediaEscolar obj: objetos) {
                //    Log.i("CRUD LISTAR ","ID: " + obj.getId() + " - Matéria: " + obj.getMateria());
               // }

                Intent telaPrincipal =
                        new Intent(SplashActivity.this, MainActivity.class);

                startActivity(telaPrincipal);

                finish();

            }
        },SPLASH_TIME_PUT);
    }

}
