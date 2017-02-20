package com.example.developer.sampleapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {
    GridView eventsGrid;
    EventsListAdapter mAdapter;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intilizationView();
    }

    private void intilizationView() {
        eventsGrid = (GridView) findViewById(R.id.vG_aoel_offerEventList);
        mAdapter=new EventsListAdapter();
        eventsGrid.setAdapter(mAdapter);

        button= (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertdialog();
            }
        });

    }


    public void alertdialog(){

        AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
        builderSingle.setIcon(R.mipmap.ic_launcher);
        builderSingle.setTitle("Select One Name:-");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Hardik");
        arrayAdapter.add("Archit");
        arrayAdapter.add("Jignesh");
        arrayAdapter.add("Umang");
        arrayAdapter.add("Gatti");

        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(MainActivity.this);
                builderInner.setMessage(strName);
                builderInner.setTitle("Your Selected Item is");
                builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                    }
                });
                builderInner.show();
            }
        });
        builderSingle.show();


    }

    private class EventsListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
           return 10;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getViewTypeCount() {
            // return the total number of view types. this value should never change at runtime
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            // return a value between 0 and (getViewTypeCount - 1)
            return position % 2 ;
        }


        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {

            final LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                if ((position % 2) == 0) {
                    view = inflater.inflate(R.layout.adapter_offerevent_left, viewGroup, false);
                } else {
                    view = inflater.inflate(R.layout.rowitem_category_gridview_recyclerview, viewGroup, false);
                }
            }
            return view;
        }

    }

}
