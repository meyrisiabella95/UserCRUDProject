package com.b.usercrudproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.b.usercrudproject.model.PostPutDelUser;
import com.b.usercrudproject.rest.ApiClient;
import com.b.usercrudproject.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText editEmail, editFName, editLName, editAva;
    Button btnInsert, btnBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editEmail= (EditText) findViewById(R.id.editEmail);
        editFName = (EditText) findViewById(R.id.editFName);
        editLName = (EditText) findViewById(R.id.editLName);
        editAva = (EditText) findViewById(R.id.editAva);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelUser> postUserCall = mApiInterface.postUser(
                        editEmail.getText().toString(),
                        editFName.getText().toString(),
                        editLName.getText().toString(),
                        editAva.getText().toString());
                postUserCall.enqueue(new Callback<PostPutDelUser>() {
                    @Override
                    public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}