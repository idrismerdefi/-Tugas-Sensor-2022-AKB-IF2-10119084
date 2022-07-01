package com.example.tugas_sensor_2022_akb_if2_10119084.maps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tugas_sensor_2022_akb_if2_10119084.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Muhammad Idris Merdefi
 * 10119084
 * IF2
 */
public class MapsResto extends Fragment {
    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng lokasi1 = new LatLng(-6.894408269939875, 107.6173616817855);
            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Bebek Om Aris DU").snippet("Restoran Bebek").icon(BitmapDescriptorFactory.fromResource(R.drawable.logoresto)));
            LatLng lokasi2 = new LatLng(-6.894605070028213, 107.61705541247467);
            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("Susu Murni Unpad").snippet("Angkringan Susu").icon(BitmapDescriptorFactory.fromResource(R.drawable.logoresto)));
            LatLng lokasi3 = new LatLng(-6.897273547691207, 107.6157404161805);
            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Du Dimsum").snippet("Restoran DimSum").icon(BitmapDescriptorFactory.fromResource(R.drawable.logoresto)));
            LatLng lokasi4 = new LatLng(-6.897249988610912, 107.61234677359268);
            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("Kartika Sari Bandung").snippet("Temapt Oleh-Oleh").icon(BitmapDescriptorFactory.fromResource(R.drawable.logoresto)));
            LatLng lokasi5 = new LatLng(-6.890478732172719, 107.61552974549586);
            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Kawan Kopi").snippet("Tempat Kopi").icon(BitmapDescriptorFactory.fromResource(R.drawable.logoresto)));

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(lokasi4));
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi4,18));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.maps_resto, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}
