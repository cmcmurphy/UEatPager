package cs121.ueatpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class LiquidTab extends Fragment {


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStance) {
        View v = inflater.inflate(R.layout.liquid_tab, null);


        Spinner enteredVolumeSpinner =  v.findViewById(R.id.enteredMassSpin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.volumeValues, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enteredVolumeSpinner.setAdapter(adapter);


        Spinner desiredVolumeSpinner =  v.findViewById(R.id.desiredMassSpin);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.volumeValues, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desiredVolumeSpinner.setAdapter(adapter2);

        /*Data entry and processing here*/



        return v;
    }

}
