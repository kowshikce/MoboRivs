package com.example.moborivs.fragments.PhoneAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moborivs.R;
import com.example.moborivs.apiservices.PhoneModel.Model;

import java.util.ArrayList;
import java.util.List;

public class PhoneViewAdapter extends RecyclerView.Adapter<PhoneViewAdapter.PhoneViewHolder>{

    List<Model> datas;
    Context context;
    private static final String IMG_URL = "http://192.168.1.104:3000/api/v1/images/";

    public PhoneViewAdapter( Context context) {
        this.datas = new ArrayList<>();
        this.context = context;
    }

    public void setDatas(List<Model> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.frag_phones_recycler_item_view, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        Model currentModel = datas.get(position);
        String description = String.format("%s | %s | %s | %s", currentModel.getChipset(), currentModel.getCPU(), currentModel.getRAM(), currentModel.getInternalMemory());
        String price = String.format("%s %s %s", "Price:", currentModel.getApproxPriceEUR(), "EUR");
        holder.shortDescription.setText(description);
        holder.textPrice.setText(price);
        holder.textView.setText(currentModel.getModel());
        Glide.with(context).load(IMG_URL+currentModel.getImgUrl()).fitCenter().placeholder(R.drawable.profileicon).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class PhoneViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView, shortDescription, textPrice;
        public PhoneViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.mobile_img_view_id);
            textView = itemView.findViewById(R.id.mobile_text_view_id);
            shortDescription  = itemView.findViewById(R.id.mobile_text_view_short_desc_id);
            textPrice = itemView.findViewById(R.id.mobile_text_view_price_id);
        }
    }
}
