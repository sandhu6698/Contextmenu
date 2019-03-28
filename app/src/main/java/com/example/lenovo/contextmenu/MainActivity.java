package com.example.lenovo.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] contacts = {"Edufect", "Google", "Infosys", "Accenture"};
    ArrayAdapter<String> adapter;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        position = info.position;
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select");
        menu.add(0, 0, 0, "Call");
        menu.add(0, 0, 0, "SMS");
        menu.add(0,0,0,"Email");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle().equals("Call")) {
            Toast.makeText(getApplicationContext(), "Calling : " + contacts[position], Toast.LENGTH_LONG).show();
        } else if (item.getTitle().equals("SMS")) {
            Toast.makeText(getApplicationContext(), "Messaging : " + contacts[position], Toast.LENGTH_LONG).show();
        } else if(item.getTitle().equals("Email")) {
            Toast.makeText(getApplicationContext(), "Emailed : " + contacts[position], Toast.LENGTH_LONG).show();
        }else
            return false;

        return super.onContextItemSelected(item);
    }
}