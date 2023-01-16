package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
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

        puzzlefinal = findViewById(R.id.puzzleFinal);
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

        marker = mapa.addMarker(new MarkerOptions().position(new LatLng(43.33450283507816, -3.039349459816046))
                .title("Sardina saltzaileen omenerako monumentua")
                );
        marker.setVisible(true);

        marker.showInfoWindow();
        marker = mapa.addMarker(new MarkerOptions().position(new LatLng(43.333518, -3.038331))
                .title("Arrantzaleen auzoa")
        );
        marker.setVisible(true);

        marker.showInfoWindow();
        marker = mapa.addMarker(new MarkerOptions().position(new LatLng(43.32900318126162, -3.0323053585039936))
                .title("Arrantzatzen duen haurraren eskultura")
        );
        marker.setVisible(true);

        marker.showInfoWindow();
        marker = mapa.addMarker(new MarkerOptions().position(new LatLng(43.330333133956486, -3.031112341060796))
                .title("Sarturtziko portua")
        );
        marker.setVisible(true);

        marker.showInfoWindow();
        marker = mapa.addMarker(new MarkerOptions().position(new LatLng(43.33093367976051, -3.0306794450093046))
                .title("Arrantzaleen Kofradia edo Arraina saltzeko etxea")
        );
        marker.setVisible(true);

        marker.showInfoWindow();
        marker = mapa.addMarker(new MarkerOptions().position(new LatLng(43.33040796856918, -3.029608358503928))
                .title("Karmengo Ama Birjina")
        );
        marker.setVisible(true);

        marker.showInfoWindow();
        marker = mapa.addMarker(new MarkerOptions().position(new LatLng(43.33093766293911, -3.0315689315146916))
                .title("Itsasoko ama: Arraun kluba")
        );
        marker.setVisible(true);

        marker.showInfoWindow();

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        mapa.getUiSettings().setMapToolbarEnabled(true);
        CameraUpdate camUpd1 =
                CameraUpdateFactory.newLatLngZoom(new LatLng(43.333149, -3.035268),15);
        mapa.moveCamera(camUpd1);
        insertarMarcador();
        mapa.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Projection proj = mapa.getProjection();
                Point coord = proj.toScreenLocation(latLng);

                Toast.makeText(mapa.this, "Mesedez, klik egin hurrengo posizioan",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //Al pulsar sobre el marcador
        mapa.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();//Visualizar info marcador
                //marker.hideInfoWindow(); //Ocultar info marcador
                mapa.getUiSettings();
                if(marker.getTitle().equals("Sardina saltzaileen omenerako monumentua")){
                    Intent intent = new Intent(mapa.this, ExplicacionAct1.class);
                    startActivity(intent);
                }
                if(marker.getTitle().equals("Arrantzaleen auzoa")){
                    Intent intent = new Intent(mapa.this, ExplicacionAct2.class);
                    startActivity(intent);
                }
                if(marker.getTitle().equals("Arrantzatzen duen haurraren eskultura")){
                    Intent intent = new Intent(mapa.this, ExplicacionAct3.class);
                    startActivity(intent);
                }
                if(marker.getTitle().equals("Sarturtziko portua")){
                    Intent intent = new Intent(mapa.this, ExplicacionAct4.class);
                    startActivity(intent);
                }
                if(marker.getTitle().equals("Arrantzaleen Kofradia edo Arraina saltzeko etxea")){
                    Intent intent = new Intent(mapa.this, ExplicacionAct5.class);
                    startActivity(intent);
                }
                if(marker.getTitle().equals("Karmengo Ama Birjina")){
                    Intent intent = new Intent(mapa.this, ExplicacionAct6.class);
                    startActivity(intent);
                }
                if(marker.getTitle().equals("Itsasoko ama: Arraun kluba")){
                    Intent intent = new Intent(mapa.this, ExplicacionAct7.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }
}