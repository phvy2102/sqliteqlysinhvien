package com.example.sqlite_quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.sqlite_quanlysinhvien.dao.SinhvienDao;
import com.example.sqlite_quanlysinhvien.model.Sinhvien;

public class AddActivity extends AppCompatActivity {
    private EditText edtht,edtsdt,edtemail;
    private RadioGroup radioGroup;
    private int gioitinh =1;
    private Button btnthem,btnthoat;
    private SinhvienDao sinhvienDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Anhxa();
        sinhvienDao=new SinhvienDao(AddActivity.this);
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                  if(checkedId==R.id.nam)
                  {
                      gioitinh=1;
                  }
                  else{
                      gioitinh=0;
                  }

            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten112=edtht.getText().toString();
                String sdt112=edtsdt.getText().toString();
                String email112=edtemail.getText().toString();
                Sinhvien sv=new Sinhvien(hoten112,gioitinh,sdt112,email112);
                sinhvienDao.AddSinhvien(sv);
            }
        });

    }

    private void Anhxa() {
        edtht=(EditText) findViewById(R.id.edt_hoten);
        edtsdt=(EditText) findViewById(R.id.edt_sdt);
        edtemail=(EditText) findViewById(R.id.edt_email);
        radioGroup=(RadioGroup) findViewById(R.id.rg_gt);
        btnthem=(Button) findViewById(R.id.them);
        btnthoat=(Button) findViewById(R.id.thoat);


 }
}