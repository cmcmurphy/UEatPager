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

public class TempTab extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStance) {
        View v = inflater.inflate(R.layout.temp_tab, null);


        Spinner enteredTempSpinner =  v.findViewById(R.id.enteredTempSpin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.tempValues, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enteredTempSpinner.setAdapter(adapter);


        Spinner desiredTempSpinner =  v.findViewById(R.id.desiredTempSpin);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.tempValues, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desiredTempSpinner.setAdapter(adapter2);

        return v;
    }
}
