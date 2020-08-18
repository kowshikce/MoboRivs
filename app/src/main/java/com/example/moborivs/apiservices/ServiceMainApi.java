package com.example.moborivs.apiservices;

import com.example.moborivs.apiservices.BrandModel.BrandResp;
import com.example.moborivs.apiservices.ConfirmationModel.ConfirmReq;
import com.example.moborivs.apiservices.ConfirmationModel.ConfirmationResp;
import com.example.moborivs.apiservices.LoginModel.LoginBody;
import com.example.moborivs.apiservices.LoginModel.LoginResp;
import com.example.moborivs.apiservices.PhoneModel.PhoneResp;
import com.example.moborivs.apiservices.SignupModel.SignupReq;
import com.example.moborivs.apiservices.SignupModel.SignupResp;
import com.example.moborivs.apiservices.SpecificModel.SpecificResp;
import com.example.moborivs.constants.Constant;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class ServiceMainApi {

    private static final String URL = "http://192.168.1.104:3000";
    private static MainServiceApi api = null;

    public static MainServiceApi getApi(){
        if(api == null){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
            api = retrofit.create(MainServiceApi.class);
        }
        return api;
    }

    public interface MainServiceApi{

        //FOR SIGNUP ACTIVITY AND USER SIGNUP FORM.
        @POST("/api/v1/users/signup/")
        Call<SignupResp> getSignResponse(@Body SignupReq body);

        //FOR LOGIN ACTIVITY AND USER LOGIN.
        @POST("/api/v1/users/login/")
        Call<LoginResp> getLoginResponse(@Body LoginBody body);


        //FOR EMAIL CONFIRMATION AND USER'S VERIFICATION
        @POST("/api/v1/confirmation/{code}")
        Call<ConfirmationResp> getConfirmation(@Path("code")String code, @Body ConfirmReq req);


        //FOR BRANDS NAME
        @Headers({"Content-Type: application/json"})
        @GET("/api/v1/brands/")
        Call<BrandResp> getAllBrands(@Header("Authorization")String auth);


        //FOR SPECIFIC BRANDS
        @Headers({"Content-Type: application/json"})
        @GET("/api/v1/brands/{model}")
        Call<PhoneResp> getAllModels(@Path("model")String model, @Header("Authorization")String auth);


        //FOR SPECIFIC MODELS
        @Headers({"Content-Type: application/json"})
        @GET("/api/v1/brands/{model}/{oid}")
        Call<SpecificResp> getPhoneDetails(@Path("model")String model, @Path("oid")String id, @Header("Authorization")String auth);

    }
}
