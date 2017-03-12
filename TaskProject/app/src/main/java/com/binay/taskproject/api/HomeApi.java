package com.binay.taskproject.api;

import com.binay.taskproject.model.Investment;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Binay on 12/03/17.
 */

public interface HomeApi {
    @POST("/")
    @FormUrlEncoded
    void saveInvestment(@Field("access_token") String auth_token,
                        @Field("time_horizon") int time,
                        @Field("goal") String goal,
                        @Field("risk_cat") int risk,
                        @Field("monthly_inv") double monthly,
                        Callback<Investment> investmentCallback);


}
