package cs121.ueatpager;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.content.Context;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class MyRecipes extends Fragment {
    EditText RecipeName;
    EditText ServingSizeNumber;
    EditText Description;

    //Add more ingredients option
    private LinearLayout mLayout;
    private Button mButton;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStance){
        View rootView = inflater.inflate(R.layout.my_recipes, container, false);

        RecipeName = (EditText) rootView.findViewById(R.id.recipeName);
        ServingSizeNumber = (EditText) rootView.findViewById(R.id.servingSizeNumber);
        Description = (EditText) rootView.findViewById(R.id.description);

        //Igredients
        mLayout = (LinearLayout) rootView.findViewById(R.id.linearLayout);
        mButton = (Button) rootView.findViewById(R.id.button);
        mButton.setOnClickListener(onClick());
                
        return rootView;
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText myEditText = new EditText(getActivity());
                myEditText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                mLayout.addView(myEditText);
            }
        };
    }

}
