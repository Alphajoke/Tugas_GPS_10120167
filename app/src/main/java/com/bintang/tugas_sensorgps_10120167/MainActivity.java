package com.bintang.tugas_sensorgps_10120167;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.bintang.tugas_sensorgps_10120167.databinding.ActivityMainBinding;

//Nama  : Bintang Zulhikman Hakim
//NIM   : 10120167
//Kelas : IF 4

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFagment(new MapsFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.maps:
                    replaceFagment(new MapsFragment());
                    break;
                case R.id.m_terdekat:
                    replaceFagment(new FoodFragment());
                    break;
                case R.id.profile:
                    replaceFagment(new ProfileFragment());
                    break;
                case R.id.info:
                    replaceFagment(new AppInfoFragment());
                    break;

            }

            return true;
        });
    }

    private void replaceFagment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBase,fragment);
        fragmentTransaction.commit();
    }
}