package com.example.gabrielmoura.ace1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**  import eli.testes.R;
 *
 */

public class EmAltaFragment extends Fragment {
    private static final String TAG = "EmAltaFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_em_alta, container, false);

        return view;
    }

}