package com.example.ktck124_lop124lttd04_nhom16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Khachsan_Adapter extends RecyclerView.Adapter<Khachsan_Adapter.khachsanViewHolder>  {
    private final List<khachsan_Model> mListKhachsan;
    private final Context context;

    public Khachsan_Adapter(Context context, List<khachsan_Model> mListKhachsan) {
        this.context = context;
        this.mListKhachsan = mListKhachsan;
    }

    @NonNull
    @Override
    public khachsanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new khachsanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull khachsanViewHolder holder, int position) {
        khachsan_Model ks = mListKhachsan.get(position);
        if (ks == null) {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  static  class khachsanViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_tenKhachSan;
        private TextView tv_Gia;
        public khachsanViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tenKhachSan = itemView.findViewById(R.id.tv_tenkhachsan);
            tv_Gia = itemView.findViewById(R.id.tv_gia);
        }
    }

}
