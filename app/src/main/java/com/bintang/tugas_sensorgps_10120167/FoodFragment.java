package com.bintang.tugas_sensorgps_10120167;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//Nama  : Bintang Zulhikman Hakim
//NIM   : 10120167
//Kelas : IF 4

public class FoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        SupportMapFragment mapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);

        // check condition
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                mapFragment.getMapAsync(googleMap -> {
                    //Lokasi 1
                    LatLng lokasi1 = new LatLng(-6.8890902, 107.6183439);
                    MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Warkop ADD");
                    //Lokasi 2
                    LatLng lokasi2 = new LatLng(-6.8911423, 107.6205443);
                    MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Warteg Panorama");
                    //Lokasi 3
                    LatLng lokasi3 = new LatLng(-6.8911423, 107.6205546);
                    MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Ayam XO Papa Gil");
                    //Lokasi 4
                    LatLng lokasi4 = new LatLng(-6.8888247, 107.6185714);
                    MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Warkop Jagorasa");
                    //Lokasi 5
                    LatLng lokasi5 = new LatLng(-6.8887164, 107.6190873);
                    MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Warteg Selera 2");

                    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi3,17));
                    googleMap.addMarker(options1);
                    googleMap.addMarker(options2);
                    googleMap.addMarker(options3);
                    googleMap.addMarker(options4);
                    googleMap.addMarker(options5);


            });
        }
        else {
            // When permission is not granted
            // Call method
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 100);
        }
        // Return view
        return view;
    }

}