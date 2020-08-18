package com.example.moborivs.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;
import com.example.moborivs.R;
import com.example.moborivs.apiservices.PhoneModel.PhoneResp;
import com.example.moborivs.apiservices.ServiceMainApi;
import com.example.moborivs.fragments.PhoneAdapter.PhoneViewAdapter;
import com.example.moborivs.persiststorage.Account;
import com.example.moborivs.persiststorage.AccountRepository;
import com.example.moborivs.ui.sharePreference.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Phones extends Fragment{


    RecyclerView recyclerView;
    PhoneViewAdapter phoneViewAdapter;
    Context mContext;
    public static final String TAG = "p";
    public static final String BRAND = "Samsung";
    SessionManager sessionManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_phones_lay, container, false);

        mContext = getContext();
        recyclerView = view.findViewById(R.id.frag_phone_main_recycler_view_id);
        phoneViewAdapter = new PhoneViewAdapter(mContext);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        recyclerView.setAdapter(phoneViewAdapter);

        sessionManager = SessionManager.getInstance(getContext());


        Glide.get(mContext).setMemoryCategory(MemoryCategory.LOW);

        setData();
        return view;
    }



    public void setData(){
        Log.i(TAG, "TOken is: ");
       final Call<PhoneResp> respCall = ServiceMainApi.getApi().getAllModels(BRAND, token(sessionManager.getAccount().getToken()));
       respCall.enqueue(new Callback<PhoneResp>() {
           @Override
           public void onResponse(Call<PhoneResp> call, Response<PhoneResp> response) {
               Log.i(TAG, "onResponse");
               if(!response.isSuccessful()){
                   /*if(response.code() == 401){
                       Intent intent = new Intent(getContext(), LoginActivity.class);
                       startActivity(intent);
                   }*/
                   Log.i(TAG, "unsuccessful");
                   return;
               }

               phoneViewAdapter.setDatas(response.body().getModels());
           }

           @Override
           public void onFailure(Call<PhoneResp> call, Throwable t) {
               Log.i(TAG, "onFailure"+t.getMessage());
           }
       });
    }

    public String token(String auth){
        return String.format("Bearer %s", auth);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
