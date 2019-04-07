package com.example.android.dmc_danang2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NhanThongBao extends AppCompatActivity {
    TextView tvThang, tvTienDien, tvTienNuoc, tvTongCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_thong_bao);
        tvThang = (TextView) findViewById(R.id.editThang);
        tvTienDien = (TextView) findViewById(R.id.editTienDien);
        tvTienNuoc = (TextView) findViewById(R.id.editTienNuoc);
        tvTongCong = (TextView) findViewById(R.id.editTongCong);
        Bundle bundle = getIntent().getExtras();
        tvThang.setText("Tháng :" + bundle.getString("Thang") + "/" + bundle.getString("Nam"));
        tvTienDien.setText("Tiền Điện :" + bundle.getString("TienDien"));
        tvTienNuoc.setText("Tiền Nước :" + bundle.getString("TienNuoc"));
        tvTongCong.setText("Tổng Tiền :" + bundle.getString("TongCong"));

    }
}
