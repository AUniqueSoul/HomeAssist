package android.example.house_assist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {

    private static final String TAG = "ServiceReqAdapter";
    Context context;
    ArrayList<ServiceProvider> ordersArrayList;
    FirebaseFirestore db;
    FirebaseUser user;
    String uid;

    public OrdersAdapter(Context context, ArrayList<ServiceProvider> ordersArrayList) {
        this.context = context;
        this.ordersArrayList = ordersArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_orders, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        uid = user.getUid();
        db = FirebaseFirestore.getInstance();

        ServiceProvider data = ordersArrayList.get(position);
        holder.setIsRecyclable(false);
        holder.name.setText(data.name);
        holder.locality.setText(data.locality);
        holder.address.setText(data.pin_code);
        holder.price.setText(data.price);
        holder.cv.setOnClickListener(view -> {
            Intent i = new Intent(context, ServiceProviderProfile.class);
            i.putExtra("server_provider_uid", data.server_provider_uid);
            i.putExtra("name", data.name);
            i.putExtra("address1", data.address1);
            i.putExtra("price", data.price);
            i.putExtra("locality", data.locality);
            i.putExtra("pin_code", data.pin_code);
            i.putExtra("state", data.state);
            i.putExtra("phone", data.phone);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return ordersArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView name, locality, address, price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.cv_order);
            name = itemView.findViewById(R.id.order_name);
            address = itemView.findViewById(R.id.order_locality);
            locality = itemView.findViewById(R.id.order_address);
            price = itemView.findViewById(R.id.order_price);

        }
    }
}
