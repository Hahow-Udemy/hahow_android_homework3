package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText edNtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    public void go(View view){
        String s = edNtd.getText().toString();
        if (s.equals("")){
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.please_enter_ntd)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }
        else{
            float ntd = Float.parseFloat(s);
            float us = ntd * 30.9f;
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.usd_is) + us)
                    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNtd.setText("");
                        }
                    })
                    .show();
        }

    }

    private void findView() {
        edNtd = findViewById(R.id.ntd);
    }

}
