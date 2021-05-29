package gachon.mpclass.mp_team_newnew;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class CountryFragment extends Fragment {
    View view;
    ImageButton btnIndia;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_country, container, false);

        btnIndia = (ImageButton) view.findViewById(R.id.btnIndia);

        btnIndia.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), IndiaActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
