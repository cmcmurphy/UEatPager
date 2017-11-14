package cs121.ueatpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Candace on 11/12/2017.
 */

public class MassTab extends Fragment{
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStance) {
        View v = inflater.inflate(R.layout.mass_tab, null);


        Spinner enteredMassSpinner =  v.findViewById(R.id.enteredMassSpin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.massValues, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enteredMassSpinner.setAdapter(adapter);


        Spinner desiredMassSpinner =  v.findViewById(R.id.desiredMassSpin);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.massValues, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desiredMassSpinner.setAdapter(adapter2);

        return v;
    }
}
