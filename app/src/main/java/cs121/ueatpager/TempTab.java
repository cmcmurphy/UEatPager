package cs121.ueatpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.EditText;



public class TempTab extends Fragment {

    double newConversion, tempAmount;
    String conversionTempFrom, conversionTempTo;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStance) {
        View v = inflater.inflate(R.layout.temp_tab, null);

        Button convert = (Button) v.findViewById(R.id.convertTemp);
        final EditText enteredTemp = (EditText) v.findViewById(R.id.enterTemp);
        final EditText outedTemp = (EditText) v.findViewById(R.id.outTemp);

        final Spinner enteredTempSpinner =  v.findViewById(R.id.enteredTempSpin);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getActivity(), R.array.tempValues, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enteredTempSpinner.setAdapter(adapter4);


        final Spinner desiredTempSpinner =  v.findViewById(R.id.desiredTempSpin);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.tempValues, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desiredTempSpinner.setAdapter(adapter3);

        /*Data entry and processing here*/

        // doConversions(enteredVolumeSpinner, desiredVolumeSpinner, enterMass, outTemp);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempAmount = Integer.parseInt(enteredTemp.getText().toString());
                conversionTempFrom = enteredTempSpinner.getSelectedItem().toString();
                conversionTempTo = desiredTempSpinner.getSelectedItem().toString();
//Fahrenheit
                if (conversionTempFrom.matches("Fahrenheit")) {
                    if (conversionTempTo.matches("Fahrenheit") && conversionTempFrom.matches("Fahrenheit")) {
                        newConversion = tempAmount;
                        outedTemp.setText(String.valueOf(tempAmount));
                    } else if (conversionTempFrom.matches("Fahrenheit") && conversionTempTo.matches("Celsius")) {
                        newConversion = (Math.round(((tempAmount-32)*(.556)) * 100.0)/100.0);
                        outedTemp.setText(String.valueOf(newConversion));
                    }
                }
//Celsius
                if (conversionTempFrom.matches("Celsius")) {
                    if (conversionTempTo.matches("Celsius") && conversionTempFrom.matches("Celsius")) {
                        newConversion = tempAmount;
                        outedTemp.setText(String.valueOf(tempAmount));
                    } else if (conversionTempFrom.matches("Celsius") && conversionTempTo.matches("Fahrenheit")) {
                        newConversion = (Math.round(((tempAmount*(1.8))+32) * 100.0)/100.0);
                        outedTemp.setText(String.valueOf(newConversion));
                    }
                }

            }
        });
        return v;
    }
}