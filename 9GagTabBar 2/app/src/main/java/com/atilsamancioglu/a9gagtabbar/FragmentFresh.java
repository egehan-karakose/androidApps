package com.atilsamancioglu.a9gagtabbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by atilsamancioglu on 14/06/2017.
 */

public class FragmentFresh extends Fragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fresh,container,false);
        textView = (TextView) view.findViewById(R.id.textView);

        return view;
    }


}
