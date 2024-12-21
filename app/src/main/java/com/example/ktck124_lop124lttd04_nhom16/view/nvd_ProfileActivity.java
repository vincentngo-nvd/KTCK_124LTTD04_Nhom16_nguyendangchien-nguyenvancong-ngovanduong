package com.example.ktck124_lop124lttd04_nhom16.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktck124_lop124lttd04_nhom16.R;
import com.example.ktck124_lop124lttd04_nhom16.adapter.khachHangAdapter;
import com.example.ktck124_lop124lttd04_nhom16.model.khachHang;

import java.util.ArrayList;
import java.util.List;

public class nvd_ProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private khachHangAdapter adapter;
    private List<khachHang> khachHangList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Đúng phương thức
        setContentView(R.layout.activity_profile);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dữ liệu mẫu
        khachHangList = new ArrayList<>();
        khachHangList.add(new khachHang(1, "Nguyễn Đăng Chiến", 1, "Đà Nẵng", "nguyendangchien@example.com"));
        khachHangList.add(new khachHang(2, "Nguyễn Văn Công", 1, "Hà Nội", "nguyenvancong@example.com"));
        khachHangList.add(new khachHang(3, "Ngô Văn Dương", 1, "Hồ Chí Minh", "ngovanduong@example.com"));

        adapter = new khachHangAdapter(khachHangList, kh -> {
            // Xử lý khi click vào item
            System.out.println("Clicked on: " + kh.getMakh());
        });

        recyclerView.setAdapter(adapter);
    }
}
