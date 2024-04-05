package edu.psu.sweng888.p5.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import edu.psu.sweng888.p4.MakeupItem;

import edu.psu.sweng888.p5.R;

public class DashboardFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyCardAdapter adapter;
    private List<MakeupItem> itemList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Assuming you have a list of MakeupItem objects
        List<MakeupItem> makeupItemList = getMakeupItems(); // Implement this method to fetch or generate your data
        adapter = new MyCardAdapter(makeupItemList);
        recyclerView.setAdapter(adapter);

        return root;
    }

    // Method to fetch or generate your MakeupItem list
    private List<MakeupItem> getMakeupItems() {
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

        // Add more items as needed
        return itemList;
    }
}
