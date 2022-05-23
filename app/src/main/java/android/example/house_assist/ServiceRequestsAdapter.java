package android.example.house_assist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ServiceRequestsAdapter extends RecyclerView.Adapter<ServiceRequestsAdapter.MyViewHolder> {

    Context context;
    ArrayList<ServiceProvider> serviceRequestsArrayList;

    public ServiceRequestsAdapter(Context context, ArrayList<ServiceProvider> serviceRequestsArrayList) {
        this.context = context;
        this.serviceRequestsArrayList = serviceRequestsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_service_requests, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ServiceProvider data = serviceRequestsArrayList.get(position);
        holder.setIsRecyclable(false);
        holder.name.setText(data.name);
        holder.address.setText(data.address1);

    }

    @Override
    public int getItemCount() {
        return serviceRequestsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView name, address, price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.cv_service_requests);
            name = itemView.findViewById(R.id.service_requests_name);
            address = itemView.findViewById(R.id.service_requests_address);

        }
    }
}
