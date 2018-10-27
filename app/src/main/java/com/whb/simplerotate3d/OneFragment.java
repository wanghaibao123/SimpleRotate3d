package com.whb.simplerotate3d;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    private TextView text;
    private static final String KEY_TEXT = "text";
    public OneFragment() {

    }

    public static Fragment newInstance(String text) {
        Fragment fragment = new OneFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text = view.findViewById(R.id.text);
        text.setText(getArguments().get(KEY_TEXT).toString());
    }


}
