package com.example.android.dmc_danang2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.dmc_danang2019.DAO.SinhVienDAO;
import com.example.android.dmc_danang2019.Model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDon extends AppCompatActivity {
    TextView tvMaSV, tvTenSV, tvEmail,tvTenPhong,tvTenKhuNha,tvNgayLapPhieu,tvThang,tvChiSoDienCu,tvChiSoDienMoi,tvTienDien,tvTienNuoc,tvTongCong;

    private Spinner spnYear;
    private Spinner spnMonth;
    private TextView tvResult;
    private Button btnViewDetailBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_hoa_don);
        tvMaSV=(TextView)findViewById(R.id.editMaSV);
        tvTenSV=(TextView)findViewById(R.id.editTenSV);
        tvEmail=(TextView)findViewById(R.id.editEmail);
        tvTenPhong=(TextView)findViewById(R.id.editTenPhong);
        tvTenKhuNha=(TextView)findViewById(R.id.editTenKhuNha);
        tvNgayLapPhieu=(TextView)findViewById(R.id.editNgayLapPhieu);
        tvThang=(TextView)findViewById(R.id.editThang);
        tvChiSoDienCu=(TextView)findViewById(R.id.editChiSoDienCu);
        tvChiSoDienMoi=(TextView)findViewById(R.id.editChiSoDienMoi);
        tvTienDien=(TextView)findViewById(R.id.editTienDien);
        tvTienNuoc=(TextView)findViewById(R.id.editTienNuoc);
        tvTongCong=(TextView)findViewById(R.id.editTongCong);

////////////////////////////////////////////////////////////////////////
       // tvResult =(TextView) findViewById(R.id.tv_result);
        spnYear = (Spinner) findViewById(R.id.sp_Year);
        spnMonth = (Spinner) findViewById(R.id.sp_Month);
        btnViewDetailBill = (Button) findViewById(R.id.btn_viewDetailBill);

        addSpinner1();
        selectSpinner1();
        addSpinner2();
        selectSpinner2();
        onclcikView();
    }
    //Spinner 1 add value
    public void addSpinner1() {
        List<String> list = new ArrayList<>();
        list.add("2017");
        list.add("2018");
        list.add("2019");
        list.add("2020");
        list.add("2021");

        ArrayAdapter<String> adapter = new ArrayAdapter(this,R.layout.spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnYear.setAdapter(adapter);
    }
    //Spinner 1 display Toast
    public void selectSpinner1() {
        spnYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast= Toast.makeText(getApplicationContext(),spnYear.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.TOP, 0, 350);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    //Spinner 2 add value
    public void addSpinner2() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        ArrayAdapter<String> adapter = new ArrayAdapter(this,R.layout.spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnMonth.setAdapter(adapter);
    }
    //Spinner 2 display Toast
    public void selectSpinner2() {
        spnMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast= Toast.makeText(getApplicationContext(),spnMonth.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.TOP, 0, 350);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    //Spinner 2 Display by onClick
    public void onclcikView() {
        btnViewDetailBill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //tvResult.setText("\nSpinner: "+ spnCity.getSelectedItem().toString());
                //tvResult.setText("\nSpinner: "+ spnCategory.getSelectedItem().toString());
                int year= Integer.parseInt(spnYear.getSelectedItem().toString());
                int month=Integer.parseInt(spnMonth.getSelectedItem().toString());
                SinhVienDAO sinhVienDAO=new SinhVienDAO();
                Bundle bundle = getIntent().getExtras();
                String Email=bundle.getString("Emailid");
                // String Email="phanvanduan96@gmail.com";

                SinhVien arrsinhVien= sinhVienDAO.getListSinhVien(Email,year,month);
                tvMaSV.setText("MSV: "+arrsinhVien.getMaSV().toString());
                tvTenSV.setText("Tên: "+arrsinhVien.getTenSV().toString());
                tvEmail.setText("Email: "+arrsinhVien.getEmail().toString());
                tvTenPhong.setText("Tên Phòng: "+arrsinhVien.getTenPhong().toString());
                tvTenKhuNha.setText("Tên Khu Nhà: "+arrsinhVien.getTenKhuNha().toString());
                tvNgayLapPhieu.setText("Ngày Lập Phiếu: "+arrsinhVien.getNgayLapPhieu().toString());
                tvThang.setText("Tháng: "+String.valueOf(arrsinhVien.getThangLap())+"/"+String.valueOf(arrsinhVien.getNamLap()));
                tvChiSoDienCu.setText("Chỉ Số Điện Cũ: "+String.valueOf(arrsinhVien.getChiSoDienCu()));
                tvChiSoDienMoi.setText("Chỉ Số Điện Mới: "+String.valueOf(arrsinhVien.getChiSoDienMoi()));
                tvTienDien.setText("Tiền Điện: "+String.valueOf(arrsinhVien.getReNumberTienDien())+" VNĐ");
                tvTienNuoc.setText("Tiền Nước: "+String.valueOf( arrsinhVien.getReNumberTienNuoc())+" VNĐ");
                tvTongCong.setText("Tổng Cộng: "+String.valueOf(arrsinhVien.getReNumberTong())+" VNĐ");
            }
        });
    }
}
