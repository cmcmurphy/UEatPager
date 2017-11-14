package cs121.ueatpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class QuickConverter extends Fragment {
    private FragmentTabHost mTabHost;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceStance) {
       // return inflater.inflate(R.layout.quick_converter, container, false);

    // This class is the 3rd fragment in my ViewPager,
    // to which I wanted to add 2 tabs....

                mTabHost = new FragmentTabHost(getActivity());
                mTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.quick_converter);

                Bundle arg1 = new Bundle();
                arg1.putInt("Arg for Frag1", 1);
                mTabHost.addTab(mTabHost.newTabSpec("Tab1").setIndicator("Volume"),
                        LiquidTab.class, arg1);

                Bundle arg2 = new Bundle();
                arg2.putInt("Arg for Frag2", 2);
                mTabHost.addTab(mTabHost.newTabSpec("Tab2").setIndicator("Weight"),
                        MassTab.class, arg2);

                Bundle arg3 = new Bundle();
                arg2.putInt("Arg for Frag3", 3);
                mTabHost.addTab(mTabHost.newTabSpec("Tab3").setIndicator("Temperature"),
                        TempTab.class, arg3);
                return mTabHost;
            }

            @Override
            public void onDestroyView() {
                super.onDestroyView();
                mTabHost = null;
            }
        }




