package com.ndu.sanghiang.kners.projecttrackerfi.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ndu.sanghiang.kners.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StandarisasiFragment extends Fragment {


    public StandarisasiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standarisasi, container, false);
    }

}
