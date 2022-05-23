package android.example.house_assist;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment extends Fragment {

    ImageView plumber, carpenter, electrician;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        plumber = view.findViewById(R.id.category_plumber);
        carpenter = view.findViewById(R.id.category_carpenter);
        electrician = view.findViewById(R.id.category_electrician);

        plumber.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), CategoryPlumber.class)));

        carpenter.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), CategoryCarpenter.class)));

        electrician.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), CategoryElectrician.class)));

        return view;
    }
}