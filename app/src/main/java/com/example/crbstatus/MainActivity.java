package com.example.crbstatus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RelativeLayout creditR,progressL,cert,markets,score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creditR = findViewById(R.id.report);
        progressL = findViewById(R.id.progressLoad);
        cert = findViewById(R.id.cert);
        markets = findViewById(R.id.icm);
        score = findViewById(R.id.score);


        if (!isNetworkAvailable()){
            Toast.makeText(MainActivity.this,"Check your network connection",Toast.LENGTH_SHORT).show();
        }
//        ConnectivityManager cm =
//                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//        boolean isConnected = activeNetwork != null &&
//                activeNetwork.isConnected();
//
//        if (!isConnected)
//        {
//            return false;
//        }
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertt = new AlertDialog.Builder(MainActivity.this);
                View vViewBb = getLayoutInflater().inflate(R.layout.pop_up,null);
                final EditText idNumber = vViewBb.findViewById(R.id.enter_id);
                Button done = vViewBb.findViewById(R.id.done);

                alertt.setView(vViewBb);
                final AlertDialog vv = alertt.create();
                vv.show();
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isNetworkAvailable()){
                            Toast.makeText(MainActivity.this,"Check your network connection",Toast.LENGTH_SHORT).show();
                        }
                        if (idNumber.getText().toString().isEmpty()){
                            idNumber.setError("Required");
                        }if (idNumber.getText().length()<8 || idNumber.getText().length()>8){
                            Toast.makeText(MainActivity.this,"Please input a valid ID number",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            vv.dismiss();
                            new CountDownTimer(3000, 1000) { // 10 seconds, in 1 second intervals
                                public void onTick(long millisUntilFinished) {
                                    showProgress();
                                }

                                public void onFinish() {
                                    hideProgress();
                                    final int min = 54;
                                    final int max = 57;
                                    final int randomn = new Random().nextInt((max - min) + 1) + min;
                                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                    View vViewB = getLayoutInflater().inflate(R.layout.creditscore,null);
                                    TextView random = vViewB.findViewById(R.id.random_score);
                                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    });

                                    alert.setView(vViewB);
                                    AlertDialog alll = alert.create();
                                    alll.show();
                                    random.setText(""+Integer.toString(randomn)+"%");
                                }
                            }.start();

                        }
                    }
                });
            }
        });

        markets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setMessage("This feature is coming soon")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });

        cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                View vView = getLayoutInflater().inflate(R.layout.pop_up,null);
                final EditText idNumber = vView.findViewById(R.id.enter_id);
                Button done = vView.findViewById(R.id.done);

                alert.setView(vView);
                final AlertDialog all = alert.create();
                all.show();
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isNetworkAvailable()){
                            Toast.makeText(MainActivity.this,"Check your network connection",Toast.LENGTH_SHORT).show();
                        }
                        if (idNumber.getText().toString().isEmpty()){
                            idNumber.setError("Required");
                        }if (idNumber.getText().length()<8 || idNumber.getText().length()>8){
                            Toast.makeText(MainActivity.this,"Please input a valid ID number",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            all.dismiss();
                            new CountDownTimer(3000, 1000) { // 10 seconds, in 1 second intervals
                                public void onTick(long millisUntilFinished) {
                                    showProgress();
                                }

                                public void onFinish() {
                                    hideProgress();
                                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                                    alertDialog.setMessage("Request received! Due to a high number of applicants, this process takes 24hrs.")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                }
                                            });
                                    AlertDialog dialog = alertDialog.create();
                                    dialog.show();
                                }
                            }.start();
                        }
                    }
                });
            }
        });

        creditR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.pop_up,null);
                final EditText idNumber = view1.findViewById(R.id.enter_id);
                Button done = view1.findViewById(R.id.done);

                dialog.setView(view1);
                final AlertDialog dialog11 = dialog.create();
                dialog11.show();
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isNetworkAvailable()){
                            Toast.makeText(MainActivity.this,"Check your network connection",Toast.LENGTH_SHORT).show();
                        }
                        if (idNumber.getText().toString().isEmpty()){
                            idNumber.setError("Required");
                        }if (idNumber.getText().length()<8 || idNumber.getText().length()>8){
                            Toast.makeText(MainActivity.this,"Please input a valid ID number",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            dialog11.dismiss();
                            new CountDownTimer(3000, 1000) { // 10 seconds, in 1 second intervals
                                public void onTick(long millisUntilFinished) {
                                    showProgress();
                                }

                                public void onFinish() {
                                    hideProgress();
                                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                                    alertDialog.setMessage("Your request is being processed. Check after a few minutes")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                }
                                            });
                                    AlertDialog dialog = alertDialog.create();
                                    dialog.show();
                                }
                            }.start();
                        }
                    }
                });
            }
        });


    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void prog(){
        new CountDownTimer(3000, 1000) { // 10 seconds, in 1 second intervals
            public void onTick(long millisUntilFinished) {
                showProgress();
            }

            public void onFinish() {
                hideProgress();
            }
        }.start();
    }
    private void showProgress(){
        progressL.setVisibility(View.VISIBLE);
    }
    private void hideProgress(){
        progressL.setVisibility(View.GONE);
    }
}
