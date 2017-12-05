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

    double newConversion, massAmount;
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

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                massAmount = Integer.parseInt(enterMass.getText().toString());
                conversionTypeFrom = enteredMassSpinner.getSelectedItem().toString();
                conversionTypeTo = desiredMassSpinner.getSelectedItem().toString();

                if (conversionTypeFrom.matches("g")) {
                    if (conversionTypeTo.matches("g")) {
                        newConversion = massAmount;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("kg")) {
                        newConversion = Math.round((massAmount / 1000) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("oz")) {
                        newConversion =  Math.round((0.035274 * massAmount) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("lb")) {
                        newConversion =  Math.round((0.0022 * massAmount) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    }
                }

                //Math.round(() * 100.0)/100.0

                if (conversionTypeFrom.matches("kg")) {
                    if (conversionTypeTo.matches("g")) {
                        newConversion =  Math.round((massAmount * 1000) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("kg")) {
                        newConversion = massAmount;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("oz")) {
                        newConversion = Math.round((35.274 * massAmount) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("lb")) {
                        newConversion = Math.round((2.2 * massAmount) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    }
                }

                if (conversionTypeFrom.matches("oz")) {
                    if (conversionTypeTo.matches("g")) {
                        newConversion = Math.round((28.3495 * massAmount) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("kg")) {
                        newConversion = Math.round((0.0283495 * massAmount) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("oz")) {
                        newConversion = massAmount;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("lb")) {
                        newConversion = Math.round((0.0625 * massAmount) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    }
                }

                if (conversionTypeFrom.matches("lb")) {
                    if (conversionTypeTo.matches("g")) {
                        newConversion = Math.round((453.592 * massAmount) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("kg")) {
                        newConversion = Math.round((0.453592 * massAmount) * 100.0)/100.0;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("oz")) {
                        newConversion = 16 * massAmount;
                        outMass.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("lb")) {
                        newConversion = massAmount;
                        outMass.setText(String.valueOf(newConversion));
                    }
                }



            }
        });

        return v;
    }
}
