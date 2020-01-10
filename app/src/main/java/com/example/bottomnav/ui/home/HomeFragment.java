package com.example.bottomnav.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnav.Adapter.itemAdapter;
import com.example.bottomnav.Adapter.numAdapter;
import com.example.bottomnav.MainActivity;
import com.example.bottomnav.POJO.item;
import com.example.bottomnav.POJO.number;
import com.example.bottomnav.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    RecyclerView recv,recv2;
    List<item> itemlist;
    List<number>numlist;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        recv=root.findViewById(R.id.recv);
        recv2=root.findViewById(R.id.recv2);

        //loadlist
        loaddata();


        LinearLayoutManager lm=new LinearLayoutManager(root.getContext());
        LinearLayoutManager lv=new LinearLayoutManager(root.getContext());

        recv.setLayoutManager(lm);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recv.setAdapter(new itemAdapter(root.getContext(),itemlist));


        recv2.setLayoutManager(lv);
        lv.setOrientation(LinearLayoutManager.HORIZONTAL);
        recv2.setAdapter(new numAdapter(root.getContext(),numlist));

        return root;
    }
    private void loaddata() {
        itemlist=new ArrayList<>();
        numlist=new ArrayList<>();
        item Item=new item("BO BO");
        item Item2=new item("Mg Mg");
        item Item3=new item("Ko Ko");
        item Item4=new item("Zaw");
        itemlist.add(Item);
        itemlist.add(Item2);
        itemlist.add(Item3);
        itemlist.add(Item4);

        number n1=new number("0000");
        number n2=new number("1111");
        number n3=new number("2222");
        number n4=new number("3333");
        number n5=new number("4444");
        numlist.add(n1);
        numlist.add(n2);
        numlist.add(n3);
        numlist.add(n4);
        numlist.add(n5);
    }
}