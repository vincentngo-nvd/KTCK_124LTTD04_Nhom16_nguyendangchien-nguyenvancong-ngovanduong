package com.example.ktck124_lop124lttd04_nhom16.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ktck124_lop124lttd04_nhom16.R;
import com.example.ktck124_lop124lttd04_nhom16.model.khachHang;

import java.util.List;

public class khachHangAdapter extends RecyclerView.Adapter<khachHangAdapter.khachHangViewHolder> {

    private List<khachHang> khachHangList;
    private OnKhachHangClickListener listener;

    public interface OnKhachHangClickListener {
        void onKhachHangClick(khachHang kh);
    }

    public khachHangAdapter(List<khachHang> khachHangList, OnKhachHangClickListener listener) {
        this.khachHangList = khachHangList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public khachHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false);
        return new khachHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull khachHangViewHolder holder, int position) {
        khachHang kh = khachHangList.get(position);
        holder.nameTextView.setText(kh.getTenkhachhang());
        holder.itemView.setOnClickListener(v -> listener.onKhachHangClick(kh));
    }

    @Override
    public int getItemCount() {
        return khachHangList.size();
    }

    static class khachHangViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public khachHangViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nvd_tenkhachhang);
        }
    }
}
