package com.example.bottomnav.ui.dollar;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnav.Payment_sec;
import com.example.bottomnav.R;
import com.example.bottomnav.ui.home.HomeViewModel;

public class DollarFragment extends Fragment {

    private DollarViewModel mViewModel;
    private CardView card1,card2,card3;

    public static DollarFragment newInstance() {
        return new DollarFragment();
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(DollarViewModel.class);
        View root = inflater.inflate(R.layout.dollar_fragment, container, false);
        card1=root.findViewById(R.id.card);
        card2=root.findViewById(R.id.card2);
        card3=root.findViewById(R.id.card3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), Payment_sec.class));
            }
        });
        return root;
    }
    }
