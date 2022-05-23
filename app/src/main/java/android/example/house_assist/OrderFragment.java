package android.example.house_assist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class OrderFragment extends Fragment {

    Context context;
    RecyclerView rv;
    ArrayList<ServiceProvider> serviceRequestsArrayList;
    ServiceRequestsAdapter adapter;
    FirebaseFirestore db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);
        context = view.getContext();
        rv = view.findViewById(R.id.rv_service_requests);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(context));

        db = FirebaseFirestore.getInstance();
        serviceRequestsArrayList = new ArrayList<ServiceProvider>();
        adapter = new ServiceRequestsAdapter(context ,serviceRequestsArrayList);
        rv.setAdapter(adapter);

        EventChangeListener();

        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    private void EventChangeListener() {

        db.collection("ServiceRequests").addSnapshotListener((value, error) -> {
            assert value != null;
            for (DocumentChange dc : value.getDocumentChanges()) {
                if (dc.getType() == DocumentChange.Type.ADDED) {
                    serviceRequestsArrayList.add(dc.getDocument().toObject(ServiceProvider.class));
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

}