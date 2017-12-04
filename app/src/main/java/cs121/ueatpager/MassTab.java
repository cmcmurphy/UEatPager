package cs121.ueatpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Candace on 11/12/2017.
 */



public class MassTab extends Fragment{

    int newConversion, massAmount;
    String conversionTypeFrom, conversionTypeTo;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStance) {
        View v = inflater.inflate(R.layout.mass_tab, null);

        Button convert = (Button) v.findViewById(R.id.convertMass);
        final EditText enterMass = (EditText) v.findViewById(R.id.enterMass1);
        final EditText outMass = (EditText) v.findViewById(R.id.outMass2);

        final Spinner enteredMassSpinner =  v.findViewById(R.id.enteredMassSpin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.massValues, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enteredMassSpinner.setAdapter(adapter);


        final Spinner desiredMassSpinner =  v.findViewById(R.id.desiredMassSpin);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.massValues, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desiredMassSpinner.setAdapter(adapter2);
/*
        massAmount = Integer.parseInt(enterMass.getText().toString());
        conversionTypeFrom = enteredMassSpinner.getSelectedItem().toString();
        conversionTypeTo = desiredMassSpinner.getSelectedItem().toString();

*/
/*
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                massAmount = Integer.parseInt(enterMass.getText().toString());
                conversionTypeFrom = enteredMassSpinner.getSelectedItem().toString();
                conversionTypeTo = desiredMassSpinner.getSelectedItem().toString();

                if(conversionTypeTo.contains("g") && conversionTypeFrom.contains("g")) {
                    newConversion = massAmount;
                    outMass.setText(String.valueOf(massAmount));
                }else if(conversionTypeTo.contains("g") && conversionTypeFrom.contains("kg")) {
                    newConversion = 1000 * massAmount;
                    outMass.setText(String.valueOf(massAmount));
                }else if(conversionTypeTo.contains("g") && conversionTypeFrom.contains("oz")) {
                    newConversion = (int )0.035274 * massAmount;
                    outMass.setText(String.valueOf(massAmount));
                }else if(conversionTypeTo.contains("g") && conversionTypeFrom.contains("lb")) {
                    newConversion = (int).0022 * massAmount;
                    outMass.setText(String.valueOf(massAmount));
                }
            }
        });
*/



        return v;
    }
}
