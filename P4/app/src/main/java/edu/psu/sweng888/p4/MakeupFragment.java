package edu.psu.sweng888.p4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class MakeupFragment extends Fragment {

    private RecyclerView recyclerView;
    private MakeupAdapter adapter;
    private List<MakeupItem> itemList;

    public MakeupFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();

        // Add some sample makeup items (replace with actual data)
        itemList.add(new MakeupItem("Matte Lipstick", "MAC Cosmetics", "$19"));
        itemList.add(new MakeupItem("Fit Me Foundation", "Maybelline", "$7"));
        itemList.add(new MakeupItem("Naked Palette", "Urban Decay", "$54"));
        itemList.add(new MakeupItem("SuperStay Matte Ink Liquid Lipstick", "Maybelline", "$9"));
        itemList.add(new MakeupItem("Better Than Sex Mascara", "Too Faced", "$26"));
        itemList.add(new MakeupItem("Hoola Matte Bronzer", "Benefit Cosmetics", "$30"));
        itemList.add(new MakeupItem("Shape Tape Concealer", "Tarte Cosmetics", "$27"));
        itemList.add(new MakeupItem("Soft Matte Lip Cream", "NYX Professional Makeup", "$6.50"));
        itemList.add(new MakeupItem("Dipbrow Pomade", "Anastasia Beverly Hills", "$21"));
        itemList.add(new MakeupItem("Chocolate Bar Eyeshadow Palette", "Too Faced", "$49"));
        itemList.add(new MakeupItem("Tattoo Liner", "Kat Von D Beauty", "$20"));
        itemList.add(new MakeupItem("Liquid Matte Lipstick", "Huda Beauty", "$20"));
        itemList.add(new MakeupItem("Milani Baked Blush", "Milani", "$8.99"));
        itemList.add(new MakeupItem("Brow Wiz", "Anastasia Beverly Hills", "$23"));
        itemList.add(new MakeupItem("NARS Radiant Creamy Concealer", "NARS Cosmetics", "$30"));


        //set the list in the adapter
        adapter = new MakeupAdapter(itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
