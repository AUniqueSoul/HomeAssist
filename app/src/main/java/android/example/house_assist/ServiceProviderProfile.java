package android.example.house_assist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ServiceProviderProfile extends AppCompatActivity {

    ImageView ivDp;
    TextView tvName, tvLocality, tvAddress, tvState, tvPinCode, tvPrice;
    Button btn;
    String dp, name, locality, address, state, pinCode, price, customer_uid, server_provider_uid;
    FirebaseFirestore myDB;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_provider_profile);

        Intent intent = getIntent();
        server_provider_uid = intent.getStringExtra("server_provider_uid");
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address1");
        price = intent.getStringExtra("price");
        locality = intent.getStringExtra("locality");
        pinCode = intent.getStringExtra("pincode");
        state = intent.getStringExtra("state");
        dp = intent.getStringExtra("dp");

        ivDp = findViewById(R.id.service_provider_dp);
        tvName = findViewById(R.id.service_provider_name);
        tvLocality = findViewById(R.id.service_provider_locality);
        tvAddress = findViewById(R.id.service_provider_address1);
        tvState = findViewById(R.id.service_provider_state);
        tvPinCode = findViewById(R.id.service_provider_pincode);
        tvPrice = findViewById(R.id.service_provider_price);
        btn = findViewById(R.id.btn_service_provider);

        myDB = FirebaseFirestore.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        customer_uid = user.getUid();

        initData();

    }

    private void initData() {

        tvName.setText(name);
        tvLocality.setText(locality);
        tvAddress.setText(address);
        tvState.setText(state);
        tvPinCode.setText(pinCode);
        tvPrice.setText("₹ "+price);
        btn.setOnClickListener(view -> {
            Map<String,Object> map = new HashMap<>();
            map.put("customer_uid", customer_uid);
            map.put("server_provider_uid", server_provider_uid);
            map.put("address1",address);
            map.put("name", name);
            map.put("locality",locality);
            map.put("state",state);
            map.put("pin_code",pinCode);
            map.put("price",price);
            myDB.collection("ServiceRequests").add(map).addOnSuccessListener(aVoid -> {
                btn.setEnabled(false);
                btn.setText("BOOKED");
                btn.setBackgroundColor(getColor(R.color.colorAccent2));
            }).addOnFailureListener(e -> {
                //Log.d(TAG,"Failure Details"+e.toString());
                Toast.makeText(this, "Unable to Update", Toast.LENGTH_SHORT).show();
            });
        });
    }
}