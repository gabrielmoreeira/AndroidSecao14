package mediaescolcarmvc.com.br.mediaescolarmvc.fragmets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mediaescolcarmvc.com.br.mediaescolarmvc.R;

public class BimestreAFragment extends Fragment {

    View view;

    public BimestreAFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bimestre_a, container, false);

        return view;
    }


}
