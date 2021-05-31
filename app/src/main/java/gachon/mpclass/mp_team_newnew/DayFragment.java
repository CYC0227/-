package gachon.mpclass.mp_team_newnew;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class DayFragment extends Fragment {
    View view;
    ImageButton christmas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_day, container, false);
        christmas = (ImageButton) view.findViewById(R.id.btnChristmas);

        christmas.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChristmasActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
