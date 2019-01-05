package mediaescolcarmvc.com.br.mediaescolarmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import mediaescolcarmvc.com.br.mediaescolarmvc.R;
import mediaescolcarmvc.com.br.mediaescolarmvc.controller.MediaEscolarController;
import mediaescolcarmvc.com.br.mediaescolarmvc.model.MediaEscolar;

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

                MediaEscolar obj = new MediaEscolar();

                obj.setMateria("Artes");
                obj.setBimestre("1° Bimestre");
                obj.setSituacao("Aprovado");
                obj.setNotaProva(10);
                obj.setNotaMateria(10);
                obj.setMediaFinal(10);
                obj.setSituacao("Aprovado");

                MediaEscolarController mediaEscolarController = new MediaEscolarController(getBaseContext());

                mediaEscolarController.salvar(obj);

                Intent telaPrincipal =
                        new Intent(SplashActivity.this, MainActivity.class);

                startActivity(telaPrincipal);

                finish();

            }
        },SPLASH_TIME_PUT);
    }

}
