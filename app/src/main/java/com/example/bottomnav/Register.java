package com.example.bottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bottomnav.POJO.User;
import com.example.bottomnav.Service.APIService;
import com.example.bottomnav.Service.ServerRequest;
import com.example.bottomnav.Service.ServerResponse;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity implements Callback<ServerResponse> {


    EditText edtname,edtpass;
    Button btnreg;
    String txtname,txtpass,url;
    ProgressBar pgbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnreg=findViewById(R.id.btnreg);
        edtname=findViewById(R.id.nameedit);
        edtpass=findViewById(R.id.passedit);
        pgbar=findViewById(R.id.progressBar1);
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtname=edtname.getText().toString();
                txtpass=edtpass.getText().toString();
                register(txtname,txtpass);

            }
        });


    }

    private void register(String txtname, String txtpass) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.1.5/php_proj/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService=retrofit.create(APIService.class);
        User user = new User();
        user.setName(txtname);
        user.setPassword(txtpass);
        ServerRequest request = new ServerRequest();
        request.setOperation("");
        request.setUser(user);
        Call<ServerResponse>call=apiService.operation(request);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
        ServerResponse resp = response.body();
        Toast.makeText(getBaseContext(),resp.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(Call<ServerResponse> call, Throwable t) {
        Toast.makeText(getBaseContext(),t.getMessage(),Toast.LENGTH_LONG).show();
    }
}
