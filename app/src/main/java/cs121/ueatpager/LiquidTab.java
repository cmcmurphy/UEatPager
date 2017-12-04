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


public class LiquidTab extends Fragment {

    double newConversion, liquidAmount;
    String conversionTypeFrom, conversionTypeTo;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStance) {
        View v = inflater.inflate(R.layout.liquid_tab, null);

        Button convert = (Button) v.findViewById(R.id.convert);
        final EditText enterLiquid = (EditText) v.findViewById(R.id.enterLiquid);
        final EditText outLiquid = (EditText) v.findViewById(R.id.outLiquid);

        final Spinner enteredVolumeSpinner =  v.findViewById(R.id.enteredMassSpin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.volumeValues, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enteredVolumeSpinner.setAdapter(adapter);


        final Spinner desiredVolumeSpinner =  v.findViewById(R.id.desiredMassSpin);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.volumeValues, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desiredVolumeSpinner.setAdapter(adapter2);

        /*Data entry and processing here*/

        // doConversions(enteredVolumeSpinner, desiredVolumeSpinner, enterMass, outLiquid);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liquidAmount = Integer.parseInt(enterLiquid.getText().toString());
                conversionTypeFrom = enteredVolumeSpinner.getSelectedItem().toString();
                conversionTypeTo = desiredVolumeSpinner.getSelectedItem().toString();
//fl oz
                if (conversionTypeFrom.contains("fl oz")) {
                    if (conversionTypeTo.contains("fl oz") && conversionTypeFrom.contains("fl oz")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(liquidAmount));
                    } else if (conversionTypeFrom.contains("fl oz") && conversionTypeTo.contains("cups")) {
                        newConversion = liquidAmount / 8;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("fl oz") && conversionTypeTo.contains("tbsp")) {
                        newConversion = liquidAmount * 2;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("fl oz") && conversionTypeTo.contains("tsp")) {
                        newConversion = liquidAmount * 6;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("fl oz") && conversionTypeTo.contains("L")) {
                        newConversion = 4 * (liquidAmount / 8) + (int) .25 * (liquidAmount / 8);
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("fl oz") && conversionTypeTo.contains("mL")) {
                        newConversion = liquidAmount / 8;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("fl oz") && conversionTypeTo.contains("qt")) {
                        newConversion = liquidAmount / 32;
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }

                //cups
                if (conversionTypeFrom.contains("cups")) {
                    if (conversionTypeFrom.contains("cups") && conversionTypeTo.contains("fl oz")) {
                        newConversion = liquidAmount * 8;
                        outLiquid.setText(String.valueOf(liquidAmount));
                    } else if (conversionTypeFrom.contains("cups") && conversionTypeTo.contains("cups")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("cups") && conversionTypeTo.contains("tbsp")) {
                        newConversion = 3 * (liquidAmount * 8);
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("cups") && conversionTypeTo.contains("tsp")) {
                        newConversion = liquidAmount * 5;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("cups") && conversionTypeTo.contains("L")) {
                        newConversion = 4 * (liquidAmount / 8) + (int) .25 * (liquidAmount / 8);
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("cups") && conversionTypeTo.contains("mL")) {
                        newConversion = liquidAmount / 8;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("cups") && conversionTypeTo.contains("qt")) {
                        newConversion = liquidAmount / 32;
                        outLiquid.setText(String.valueOf(newConversion));
                    }


                }
//tsp
                if (conversionTypeFrom.contains("tsp")) {
                    if (conversionTypeFrom.contains("tsp") && conversionTypeTo.contains("fl oz")) {
                        newConversion = liquidAmount * 6;
                        outLiquid.setText(String.valueOf(liquidAmount));
                    } else if (conversionTypeFrom.contains("tsp") && conversionTypeTo.contains("cups")) {
                        newConversion = 8 * (liquidAmount * 6);
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tsp") && conversionTypeTo.contains("tbsp")) {
                        newConversion = liquidAmount / 3;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tsp") && conversionTypeTo.contains("tsp")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tsp") && conversionTypeTo.contains("L")) {
                        newConversion = 4 * (8 * (liquidAmount * 6)) + (int) .25 * (4 * (8 * (liquidAmount * 6)));
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tsp") && conversionTypeTo.contains("mL")) {
                        newConversion = liquidAmount / 8;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tsp") && conversionTypeTo.contains("qt")) {
                        newConversion = 4 * (8 * (liquidAmount * 6));
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }
//tbsp
                if (conversionTypeFrom.contains("tbsp")) {
                    if (conversionTypeFrom.contains("tbsp") && conversionTypeTo.contains("fl oz")) {
                        newConversion = liquidAmount * 6;
                        outLiquid.setText(String.valueOf(liquidAmount));
                    } else if (conversionTypeFrom.contains("tbsp") && conversionTypeTo.contains("cups")) {
                        newConversion = 8 * (liquidAmount * 6);
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tbsp") && conversionTypeTo.contains("tbsp")) {
                        newConversion = liquidAmount / 3;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tbsp") && conversionTypeTo.contains("tsp")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tbsp") && conversionTypeTo.contains("L")) {
                        newConversion = 4 * (8 * (liquidAmount * 6)) + (int) .25 * (4 * (8 * (liquidAmount * 6)));
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tbsp") && conversionTypeTo.contains("mL")) {
                        newConversion = liquidAmount / 8;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("tbsp") && conversionTypeTo.contains("qt")) {
                        newConversion = 4 * (8 * (liquidAmount * 6));
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }

//L
                if (conversionTypeFrom.contains("L")) {
                    if (conversionTypeFrom.contains("L") && conversionTypeTo.contains("fl oz")) {
                        newConversion = liquidAmount*33.184; //33.184;
                        outLiquid.setText(String.valueOf(liquidAmount));
                    } else if (conversionTypeFrom.contains("L") && conversionTypeTo.contains("cups")) {
                        newConversion = liquidAmount*4.227;//4.227
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("L") && conversionTypeTo.contains("tbsp")) {
                        newConversion = liquidAmount *67.628;//67.628;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("L") && conversionTypeTo.contains("tsp")) {
                        newConversion = liquidAmount*202.884;//202.884;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("L") && conversionTypeTo.contains("L")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("L") && conversionTypeTo.contains("mL")) {
                        newConversion = liquidAmount *1000;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("L") && conversionTypeTo.contains("qt")) {
                        newConversion = liquidAmount * 1.05669; //1.05669;
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }
//mL
                if (conversionTypeFrom.contains("mL")) {
                    if (conversionTypeFrom.contains("mL") && conversionTypeTo.contains("fl oz")) {
                        newConversion = liquidAmount ;//0.0351951
                        outLiquid.setText(String.valueOf(liquidAmount));
                    } else if (conversionTypeFrom.contains("mL") && conversionTypeTo.contains("cups")) {
                        newConversion = liquidAmount*4;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("mL") && conversionTypeTo.contains("tbsp")) {
                        newConversion = liquidAmount *67;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("mL") && conversionTypeTo.contains("tsp")) {
                        newConversion = liquidAmount*202;//202.884;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("mL") && conversionTypeTo.contains("L")) {
                        newConversion = liquidAmount/1000;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("mL") && conversionTypeTo.contains("mL")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.contains("mL") && conversionTypeTo.contains("qt")) {
                        newConversion = liquidAmount ;
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }
            }
        });


        return v;
    }

    //Attempt to make dynamic result display
    // work in progress
   /* void doConversions(Spinner fromSpinner, Spinner toSpinner, EditText fromText, EditText toText){
        liquidAmount = Integer.parseInt(fromText.getText().toString());
        conversionTypeFrom = fromSpinner.getSelectedItem().toString();
        conversionTypeTo = toSpinner.getSelectedItem().toString();

        if(conversionTypeTo.contains("fl oz") && conversionTypeFrom.contains("fl oz")){
            newConversion = liquidAmount;
            toText.setText(String.valueOf(liquidAmount));
        }else if(conversionTypeFrom.contains("fl oz")  && conversionTypeTo.contains("cups") ){
            newConversion = liquidAmount/3;
            toText.setText(String.valueOf(newConversion));
        }
    }*/
}

