package mediaescolcarmvc.com.br.mediaescolarmvc.fragmets;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mediaescolcarmvc.com.br.mediaescolarmvc.R;
import mediaescolcarmvc.com.br.mediaescolarmvc.view.MainActivity;

public class BimestreAFragment extends Fragment {

    Button btnCalcular;
    EditText editMateria;
    EditText editNotaProva;
    EditText editNotaTrabalho;
    TextView txtResultado;
    TextView txtSituacaoFinal;

    double notaProva;
    double notaTrabalho;
    double media;

    boolean dadosValidados = true;

    View view;

    Context context;

    public BimestreAFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bimestre_a, container, false);

        editMateria      = view.findViewById(R.id.editMateria);
        editNotaProva    = view.findViewById(R.id.editNotaProva);
        editNotaTrabalho = view.findViewById(R.id.editNotaTrabalho);
        btnCalcular      = view.findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    if (editNotaProva.getText().toString().length() > 0) {
                        notaProva = Double.parseDouble(editNotaProva.getText().toString());

                        if (notaProva > 10) {
                            dadosValidados = false;
                            Toast.makeText(context, "Nota inválida!", Toast.LENGTH_SHORT).show();
                            editNotaProva.requestFocus();

                        } else {
                            dadosValidados = true;
                        }

                    } else {
                        editNotaProva.setError("*");
                        editNotaProva.requestFocus();
                        dadosValidados = false;
                    }

                    if (editNotaTrabalho.getText().toString().length() > 0) {
                        notaTrabalho = Double.parseDouble(editNotaTrabalho.getText().toString());


                        if (notaTrabalho > 10) {
                            dadosValidados = false;
                            Toast.makeText(context, "Nota inválida!", Toast.LENGTH_SHORT).show();
                            editNotaTrabalho.requestFocus();

                        } else {
                            dadosValidados = true;
                        }

                    } else {
                        editNotaTrabalho.setError("*");
                        editNotaTrabalho.requestFocus();
                        dadosValidados = false;
                    }

                    if (editMateria.getText().toString().length() == 0) {
                        editMateria.setError("*");
                        editMateria.requestFocus();
                        dadosValidados = false;
                    }

                    // Após Validação
                    if (dadosValidados) {
                        media = (notaProva + notaTrabalho) / 2;

                        txtResultado.setText(MainActivity.formatarValorDecimal(media));

                        if (media >= 7) txtSituacaoFinal.setText("Aprovado");
                        else txtSituacaoFinal.setText("Reprovado");

                        editNotaProva.setText(MainActivity.formatarValorDecimal(notaProva));
                        editNotaTrabalho.setText(MainActivity.formatarValorDecimal(notaTrabalho));

                        //salvarSharedPreferences();

                    }

                } catch (Exception e) {

                    Toast.makeText(context, "Informe as notas...", Toast.LENGTH_LONG).show();

                }


                /*if(editMateria.getText().length() == 0){

                    editMateria.setError("*");

                    editMateria.requestFocus();

                    dadosValidados = false;
                }

                if (editNotaTrabalho.getText().length() == 0){

                    editNotaTrabalho.setError("*");

                    editNotaTrabalho.requestFocus();

                    dadosValidados = false;
                }

                if(editNotaProva.getText().length() == 0){

                    editNotaProva.setError("*");

                    editNotaProva.requestFocus();

                    dadosValidados = false;
                }*/


            }
        });

        return view;
    }


}
