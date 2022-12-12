package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapa extends AppCompatActivity  implements OnMapReadyCallback {
    Button puzzlefinal;
    TextView contador;
    private Marker marker;
    private GoogleMap mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        MapFragment mapFragment = (MapFragment)getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //ids

        puzzlefinal = findViewById(R.id.puzzleBtn);
        contador = findViewById(R.id.contadorPuzzle);
        puzzlefinal.setVisibility(View.GONE);
        // BBDD
        HechosSQLiteHelper dinadbh =
                new HechosSQLiteHelper(this, "DBDina", null, 1);
        ProgresoDao pd = new ProgresoDao();
        int cuantos = pd.cuantosJuegosHechos(dinadbh);
        contador.setText(cuantos+"");

        if(cuantos == 7){
            puzzlefinal.setVisibility(View.VISIBLE);
        }

        puzzlefinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mapa.this, Puzzle.class);
                startActivity(intent);
            }
        });

    }

    private void obtenerPosicion () {
        CameraPosition cameraPosicion = mapa.getCameraPosition();

        LatLng coordenadas = cameraPosicion.target;
        double latitud = coordenadas.latitude;
        double longitud = coordenadas.longitude;

        Toast.makeText(this, "Lat: "+latitud  +'\n' +
                "Long: "+ longitud, Toast.LENGTH_SHORT).show();
    }
    private void insertarMarcador(){

        //  marker = mapa.addMarker(new MarkerOptions().position(new LatLng(40.3936945, -3.701519)) //Madrid
        //          .title("Pais: España")
        //          .snippet("La capital de España es Madrid"));
        marker = mapa.addMarker(new MarkerOptions().position(new LatLng(42.8466, -2.67332)) //Vitoria
                .title("Pais Vasco: Vitoria")
                .snippet("Green Capital"));
        marker.setVisible(true);

        marker.showInfoWindow();
        //marker.hideInfoWindow();

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mapa.getUiSettings().setMapToolbarEnabled(true);

        mapa.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Projection proj = mapa.getProjection();
                Point coord = proj.toScreenLocation(latLng);

                Toast.makeText(mapa.this, "Click " +
                                "\nLatitud: " + latLng.latitude +
                                "\nLongitud: " + latLng.longitude +
                                "\nX: " + coord.x + " - Y: " + coord.y,
                        Toast.LENGTH_SHORT).show();
            }
        });
        //Al pulsar sobre el marcador
        mapa.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();//Visualizar info marcador
                //marker.hideInfoWindow(); //Ocultar info marcador
                Toast.makeText(mapa.this, "Marcador Pulsado:\n" + marker.getTitle(), Toast.LENGTH_SHORT).show();
                mapa.getUiSettings();

                return true;
            }
        });
    }
}