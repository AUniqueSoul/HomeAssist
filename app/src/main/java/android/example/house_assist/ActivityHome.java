package android.example.house_assist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class ActivityHome extends AppCompatActivity implements ChipNavigationBar.OnItemSelectedListener {

    ChipNavigationBar navBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadFragment(new HomeFragment());

        navBar = findViewById(R.id.bottom_nav);
        navBar.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_menu, menu);
        return true;
    }

    private void loadFragment(Fragment fragment){

        if (fragment!=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        } else {
            Toast.makeText(this, "Fragment not found!", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onItemSelected(int i) {

        Fragment fragment = null;
        switch (i){
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.orders:
                fragment = new OrderFragment();
                break;
            case R.id.message:
                fragment = new MessageFragment();
                break;
        }

        loadFragment(fragment);

    }
}