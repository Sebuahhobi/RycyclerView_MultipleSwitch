package sebuahhobi.multipleswitch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import sebuahhobi.multipleswitch.adapter.AdapterMain;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = (RecyclerView) findViewById(R.id.recycler_view_main);

        //  Pada contoh kali ini kita akan membuat 10 item di dalam RecyclerView
        ArrayList<Integer> listViewType = new ArrayList<>();
        listViewType.add(AdapterMain.TYPE_1);
        listViewType.add(AdapterMain.TYPE_4);
        listViewType.add(AdapterMain.TYPE_4);
        listViewType.add(AdapterMain.TYPE_1);
        listViewType.add(AdapterMain.TYPE_4);
        listViewType.add(AdapterMain.TYPE_4);
        //  Buat objek AdapterMain untuk recyclerViewMain
        AdapterMain adapterMain = new AdapterMain(listViewType, this, "Tes1");  //  this adalah mengarah ke Context (MainActivity.this)

        //  Set layout manager recyclerViewMain
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewMain.setLayoutManager(layoutManager);

        //  Set adapter recyclerViewMain
        recyclerViewMain.setAdapter(adapterMain);
    }
}