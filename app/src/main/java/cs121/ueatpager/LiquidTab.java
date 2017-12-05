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
                if (conversionTypeFrom.matches("fl oz")) {
                    if (conversionTypeTo.matches("fl oz") && conversionTypeFrom.matches("fl oz")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("cups")) {
                        newConversion = Math.round((liquidAmount / 8) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("tbsp")) {
                        newConversion = liquidAmount * 2;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("tsp")) {
                        newConversion = liquidAmount * 6;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("L")) {
                        newConversion = Math.round((4.25 * (liquidAmount / 8)) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("pt")) {
                        newConversion = Math.round((liquidAmount * 0.0520421) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("qt")) {
                        newConversion = Math.round((liquidAmount / 32) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }

                //cups
                if (conversionTypeFrom.matches("cups")) {
                    if (conversionTypeFrom.matches("cups") && conversionTypeTo.matches("fl oz")) {
                        newConversion = Math.round((liquidAmount * 8.446) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("cups") && conversionTypeTo.matches("cups")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("cups") && conversionTypeTo.matches("tbsp")) {
                        newConversion = Math.round((liquidAmount* 16.23) * 100.0)/100.0 ;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("cups") && conversionTypeTo.matches("tsp")) {
                        newConversion = Math.round((liquidAmount * 48.69) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("cups") && conversionTypeTo.matches("L")) {
                        newConversion =  Math.round(((liquidAmount *.24)) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("cups") && conversionTypeTo.matches("pt")) {
                        newConversion = Math.round((liquidAmount * 0.5072) * 100.0) / 100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("cups") && conversionTypeTo.matches("qt")) {
                        newConversion =  Math.round((liquidAmount * 0.2536) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    }


                }

//tsp
                if (conversionTypeFrom.matches("tsp")) {
                    if (conversionTypeFrom.matches("tsp") && conversionTypeTo.matches("fl oz")) {
                        newConversion =  Math.round((liquidAmount/6) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tsp") && conversionTypeTo.matches("cups")) {
                        newConversion = Math.round((liquidAmount/48 ) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tsp") && conversionTypeTo.matches("tbsp")) {
                        newConversion =  Math.round((liquidAmount / 3) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tsp") && conversionTypeTo.matches("tsp")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tsp") && conversionTypeTo.matches("L")) {
                        newConversion =  Math.round((((liquidAmount/(48 * 4.25))) * 100.0)/100.0);
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tsp") && conversionTypeTo.matches("pt")) {
                        newConversion =  Math.round((liquidAmount / 8) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tsp") && conversionTypeTo.matches("qt")) {
                        newConversion = ((liquidAmount/48*4));
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }
//tbsp
                if (conversionTypeFrom.matches("tbsp")) {
                    if (conversionTypeFrom.matches("tbsp") && conversionTypeTo.matches("fl oz")) {
                        newConversion = Math.round((liquidAmount * .52042) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tbsp") && conversionTypeTo.matches("cups")) {
                        newConversion = Math.round((liquidAmount * .061611) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tbsp") && conversionTypeTo.matches("tbsp")) {
                        newConversion =  Math.round((liquidAmount) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tbsp") && conversionTypeTo.matches("tsp")) {
                        newConversion = liquidAmount * 3;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tbsp") && conversionTypeTo.matches("L")) {
                        newConversion =  Math.round((liquidAmount * 0.0147) * 100.0)/100.0 ;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tbsp") && conversionTypeTo.matches("pt")) {
                        newConversion =  Math.round((liquidAmount * .02602) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("tbsp") && conversionTypeTo.matches("qt")) {
                        newConversion = Math.round((liquidAmount * 0.0130) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }

//L
                if (conversionTypeFrom.matches("L")) {
                    if (conversionTypeFrom.matches("L") && conversionTypeTo.matches("fl oz")) {
                        newConversion =  Math.round(liquidAmount*33.184) * 100.0/100.0; //33.184;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("L") && conversionTypeTo.matches("cups")) {
                        newConversion =  Math.round(liquidAmount*4.227) * 100.0/100.0;//4.227
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("L") && conversionTypeTo.matches("tbsp")) {
                        newConversion =  Math.round(liquidAmount *67.628) * 100.0/100.0;//67.628;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("L") && conversionTypeTo.matches("tsp")) {
                        newConversion =  Math.round(liquidAmount*202.884) * 100.0/100.0;//202.884;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("L") && conversionTypeTo.matches("L")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("L") && conversionTypeTo.matches("pt")) {
                        newConversion = liquidAmount *1000;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("L") && conversionTypeTo.matches("qt")) {
                        newConversion =  Math.round(liquidAmount * 1.05669) * 100.0/100.0; //1.05669;
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }
//pt
                if (conversionTypeFrom.matches("pt")) {
                    if (conversionTypeFrom.matches("pt") && conversionTypeTo.matches("fl oz")) {
                        newConversion = Math.round((liquidAmount * 19.2152) * 100.0)/100.0;//0.0351951
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("pt") && conversionTypeTo.matches("cups")) {
                        newConversion = Math.round((liquidAmount * 2.367) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("pt") && conversionTypeTo.matches("tbsp")) {
                        newConversion = Math.round((liquidAmount * 38.43) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("pt") && conversionTypeTo.matches("tsp")) {
                        newConversion = Math.round(( liquidAmount * 115.291) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("pt") && conversionTypeTo.matches("L")) {
                        newConversion = Math.round((liquidAmount * 0.568261) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("pt") && conversionTypeTo.matches("pt")) {
                        newConversion = liquidAmount;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeFrom.matches("pt") && conversionTypeTo.matches("qt")) {
                        newConversion = Math.round((liquidAmount * 0.5) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    }
                }

                if (conversionTypeFrom.matches("qt")) {
                    if (conversionTypeTo.matches("fl oz")) {
                        newConversion = liquidAmount * 40;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("cups")) {
                        newConversion = Math.round((liquidAmount * 4.7355) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("tbsp")) {
                        newConversion = Math.round((liquidAmount * 76.8608) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("tsp")) {
                        newConversion = Math.round((liquidAmount * 230.582) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("L")) {
                        newConversion = Math.round((liquidAmount * 1.13) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("pt")) {
                        newConversion = Math.round((liquidAmount * 2) * 100.0)/100.0;
                        outLiquid.setText(String.valueOf(newConversion));
                    } else if (conversionTypeTo.matches("qt")) {
                        newConversion = liquidAmount;
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

        if(conversionTypeTo.matches("fl oz") && conversionTypeFrom.matches("fl oz")){
            newConversion = liquidAmount;
            toText.setText(String.valueOf(liquidAmount));
        }else if(conversionTypeFrom.matches("fl oz")  && conversionTypeTo.matches("cups") ){
            newConversion = liquidAmount/3;
            toText.setText(String.valueOf(newConversion));
        }
    }*/
}

