package com.example.sqlite_quanlysinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite_quanlysinhvien.adapter.SinhvienAdapter;
import com.example.sqlite_quanlysinhvien.dao.SinhvienDao;
import com.example.sqlite_quanlysinhvien.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvsinhvien;
    private List<Sinhvien> sinhvienList;
    private SinhvienAdapter adapter;
    private SinhvienDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvsinhvien=(ListView) findViewById(R.id.lv_sinhvien);

        sinhvienList=new ArrayList<Sinhvien>();
        dao = new SinhvienDao(MainActivity.this);
        sinhvienList = dao.getALL();


        adapter = new SinhvienAdapter(getApplicationContext(),sinhvienList);
        lvsinhvien.setAdapter(adapter);
        lvsinhvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sinhvien sv =sinhvienList.get(position);
                Intent intent=new Intent(MainActivity.this,EditActivity.class);
                intent.putExtra("Dulieu",sv);
                startActivity(intent);

            }
        });
        lvsinhvien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Sinhvien sv=sinhvienList.get(position);
                dao.DeleteSinhvien("" +sv.getMasv112());
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.them)
        {
            Intent intent = new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);

        }
        if(id == R.id.thoat)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sinhvienList.clear();
        sinhvienList.addAll(dao.getALL());
        adapter.notifyDataSetChanged();

    }
}