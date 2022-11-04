package com.example.sqlite_quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.sqlite_quanlysinhvien.dao.SinhvienDao;
import com.example.sqlite_quanlysinhvien.model.Sinhvien;

public class EditActivity extends AppCompatActivity {
    private EditText edtht112,edtsdt112,edtemail112;
    private RadioGroup radioGroup112;
    private RadioButton radioButtonNam112,radioButtonNu112;
    private Button btnluu112,btnthoat112;
    int gioitinh112;
    private SinhvienDao sinhvienDao;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        sinhvienDao = new SinhvienDao(EditActivity.this);

        Intent intent=getIntent();
        Sinhvien sinhvien= (Sinhvien) intent.getSerializableExtra("Dulieu");
        AnhXa();
        edtht112.setText(sinhvien.getHoten112());
        edtsdt112.setText(sinhvien.getDienthoai112());
        edtemail112.setText(sinhvien.getEmail112());
        if(sinhvien.getGioitinh112()==1){
            radioButtonNam112.setChecked(true);
            gioitinh112=1;
        }
        else {
            radioButtonNu112.setChecked(true);
            gioitinh112=0;
        }
        btnthoat112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        radioGroup112.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.nam)
                {
                    gioitinh112=1;
                }
                else{
                    gioitinh112=0;
                }

            }
        });
        btnluu112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sinhvien sinhvien1 = new Sinhvien();
                sinhvien1.setHoten112(edtht112.getText().toString());
                sinhvien1.setDienthoai112(edtsdt112.getText().toString());
                sinhvien1.setEmail112(edtemail112.getText().toString());
                sinhvien1.setGioitinh112(gioitinh112);
                sinhvienDao.UpdateSinhvien(sinhvien1);


            }
        });
    }

    private void AnhXa() {
        edtht112=(EditText) findViewById(R.id.edt_hoten);
        edtsdt112=(EditText) findViewById(R.id.edt_sdt);
        edtemail112=(EditText) findViewById(R.id.edt_email);
        radioGroup112=(RadioGroup) findViewById(R.id.rg_gt);
        btnluu112=(Button) findViewById(R.id.luu);
        btnthoat112=(Button) findViewById(R.id.thoat);
        radioButtonNam112=(RadioButton) findViewById(R.id.nam);
        radioButtonNu112=(RadioButton) findViewById(R.id.nu);

    }
}