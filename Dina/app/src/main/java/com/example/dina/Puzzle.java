package com.example.dina;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.text.BoringLayout;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Puzzle extends AppCompatActivity implements  View.OnDragListener, View.OnLongClickListener {

    private static final String TAG = Puzzle.class.getSimpleName();
    private ImageView iPieza1, iPieza2, iPieza3, iPieza4, iPieza5, iPieza6, iPieza7, iPieza8;
    private View vPieza1, vPieza2, vPieza3, vPieza4, vPieza5, vPieza6, vPieza7, vPieza8;
    private int piezasColocadas = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle);
        findViews();
        implementEvents();
        opacity();
    }

    private void opacity() {
        vPieza1.getBackground().setAlpha(30);
        vPieza2.getBackground().setAlpha(30);
        vPieza3.getBackground().setAlpha(30);
        vPieza4.getBackground().setAlpha(30);
        vPieza5.getBackground().setAlpha(30);
        vPieza6.getBackground().setAlpha(30);
        vPieza7.getBackground().setAlpha(30);
        vPieza8.getBackground().setAlpha(30);
    }

    //Find all views and set Tag to all draggable views
    private void findViews() {
        iPieza1 = findViewById(R.id.iPieza_1);
        iPieza1.setTag("IMAGE_PIEZA_1");
        iPieza2 = findViewById(R.id.iPieza_2);
        iPieza2.setTag("IMAGE_PIEZA_2");
        iPieza3 = findViewById(R.id.iPieza_3);
        iPieza3.setTag("IMAGE_PIEZA_3");
        iPieza4 = findViewById(R.id.iPieza_4);
        iPieza4.setTag("IMAGE_PIEZA_4");
        iPieza5 = findViewById(R.id.iPieza_5);
        iPieza5.setTag("IMAGE_PIEZA_5");
        iPieza6 = findViewById(R.id.iPieza_6);
        iPieza6.setTag("IMAGE_PIEZA_6");
        iPieza7 = findViewById(R.id.iPieza_7);
        iPieza7.setTag("IMAGE_PIEZA_7");
        iPieza8 = findViewById(R.id.iPieza_8);
        iPieza8.setTag("IMAGE_PIEZA_8");

        vPieza1 = findViewById(R.id.vPieza_1);
        vPieza2 = findViewById(R.id.vPieza_2);
        vPieza3 = findViewById(R.id.vPieza_3);
        vPieza4 = findViewById(R.id.vPieza_4);
        vPieza5 = findViewById(R.id.vPieza_5);
        vPieza6 = findViewById(R.id.vPieza_6);
        vPieza7 = findViewById(R.id.vPieza_7);
        vPieza8 = findViewById(R.id.vPieza_8);
    }


    //Implement long click and drag listener
    private void implementEvents() {
        //add or remove any view that you don't want to be dragged
        iPieza1.setOnLongClickListener(this);
        iPieza2.setOnLongClickListener(this);
        iPieza3.setOnLongClickListener(this);
        iPieza4.setOnLongClickListener(this);
        iPieza5.setOnLongClickListener(this);
        iPieza6.setOnLongClickListener(this);
        iPieza7.setOnLongClickListener(this);
        iPieza8.setOnLongClickListener(this);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.vPieza_1).setOnDragListener(this);
        findViewById(R.id.vPieza_2).setOnDragListener(this);
        findViewById(R.id.vPieza_3).setOnDragListener(this);
        findViewById(R.id.vPieza_4).setOnDragListener(this);
        findViewById(R.id.vPieza_5).setOnDragListener(this);
        findViewById(R.id.vPieza_6).setOnDragListener(this);
        findViewById(R.id.vPieza_7).setOnDragListener(this);
        findViewById(R.id.vPieza_8).setOnDragListener(this);
    }



    @Override
    public boolean onLongClick(View view) {
        // Create a new ClipData.
        // This is done in two steps to provide clarity. The convenience method
        // ClipData.newPlainText() can create a plain text ClipData in one step.

        // Create a new ClipData.Item from the ImageView object's tag
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

        // Instantiates the drag shadow builder.
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

        // Starts the drag
        view.startDrag(data//data to be dragged
                , shadowBuilder //drag shadow
                , view//local data about the drag and drop operation
                , 0//no needed flags
        );

        //Set view visibility to INVISIBLE as we are going to drag the view
//        view.setVisibility(View.INVISIBLE);

        return true;
    }

    // This is the method that the system calls when it dispatches a drag event to the
    // listener.
    @Override
    public boolean onDrag(View view, DragEvent event) {
        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // returns true to indicate that the View can accept the dragged data.
                    return true;
                }
                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                // Applies any color tint to the View, when the dragged view entered into drag acceptable view
                // Return true; the return value is ignored.

//                view.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_IN);

                // Invalidate the view to force a redraw in the new tint
                view.invalidate();

                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                // Re-sets the color tint to blue, if you had set the BLUE color or any color in ACTION_DRAG_STARTED. Returns true; the return value is ignored.

                //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);

                //If u had not provided any color in ACTION_DRAG_STARTED then clear color filter.
                view.getBackground().clearColorFilter();
                // Invalidate the view to force a redraw in the new tint
                view.invalidate();

                return true;
            case DragEvent.ACTION_DROP:
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);

                // Gets the text data from the item.
                String dragData = item.getText().toString();

                // Displays a message containing the dragged data.
                Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_SHORT).show();

                // Turns off any color tints
                view.getBackground().clearColorFilter();

                // Invalidates the view to force a redraw
                view.invalidate();

                View container = view;//caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                if (dragData.equals(iPieza1.getTag())) {
                    if (container == vPieza1) {
                        iPieza1.setVisibility(View.INVISIBLE);
                        vPieza1.getBackground().setAlpha(255);
                        piezasColocadas++;
                    }
                }
                if (dragData.equals(iPieza2.getTag())) {
                    if (container == vPieza2) {
                        iPieza2.setVisibility(View.INVISIBLE);
                        vPieza2.getBackground().setAlpha(255);
                        piezasColocadas++;
                    }
                }
                if (dragData.equals(iPieza3.getTag())) {
                    if (container == vPieza3) {
                        iPieza3.setVisibility(View.INVISIBLE);
                        vPieza3.getBackground().setAlpha(255);
                        piezasColocadas++;
                    }
                }
                if (dragData.equals(iPieza4.getTag())) {
                    if (container == vPieza4) {
                        iPieza4.setVisibility(View.INVISIBLE);
                        vPieza4.getBackground().setAlpha(255);
                        piezasColocadas++;
                    }
                }
                if (dragData.equals(iPieza5.getTag())) {
                    if (container == vPieza5) {
                        iPieza5.setVisibility(View.INVISIBLE);
                        vPieza5.getBackground().setAlpha(255);
                        piezasColocadas++;
                    }
                }
                if (dragData.equals(iPieza6.getTag())) {
                    if (container == vPieza6) {
                        iPieza6.setVisibility(View.INVISIBLE);
                        vPieza6.getBackground().setAlpha(255);
                        piezasColocadas++;
                    }
                }
                if (dragData.equals(iPieza7.getTag())) {
                    if (container == vPieza7) {
                        iPieza7.setVisibility(View.INVISIBLE);
                        vPieza7.getBackground().setAlpha(255);
                        piezasColocadas++;
                    }
                }
                if (dragData.equals(iPieza8.getTag())) {
                    if (container == vPieza8) {
                        iPieza8.setVisibility(View.INVISIBLE);
                        vPieza8.getBackground().setAlpha(255);
                        piezasColocadas++;
                    }
                }

                varificadorCompletado();

                // Returns true. DragEvent.getResult() will return true.
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                // Turns off any color tinting
                view.getBackground().clearColorFilter();

                // Invalidates the view to force a redraw
                view.invalidate();

            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }


        return true;
    }

    private void varificadorCompletado(){
        if(piezasColocadas == 8){
            Dialogo_final_puzzle d1 = new Dialogo_final_puzzle();
            d1.show(getSupportFragmentManager(),"mensaje");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(Puzzle.this, mapa.class);
                    startActivity(intent);
                    finish();;
                }
            }, 10000);
        }
    }


}