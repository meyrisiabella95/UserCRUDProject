package com.b.usercrudproject.rest;

import com.b.usercrudproject.model.GetUser;
import com.b.usercrudproject.model.PostPutDelUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public class ApiInterface {
    @GET("users")
    public Call<GetUser> getUser() {
        return null;
    }

    @FormUrlEncoded
    @POST("users")
    public Call<PostPutDelUser> postUser(String toString, String s, @Field("name") String name,
                                         @Field("job") String job) {
        return null;
    }

    @FormUrlEncoded
    @PUT("users")
    Call<PostPutDelUser> putUser(@Field("name") String name,
                                 @Field("job") String job) {
        return null;
    }

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "users", hasBody = true)
    Call<PostPutDelUser> deleteUser(@Field("id") String id) {
        return null;
    }

}
