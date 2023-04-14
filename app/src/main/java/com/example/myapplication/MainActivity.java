package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    private TextView tvAmount, tvTime;
    private EditText etAmount, etTime;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setOnInputListener();
        setViewClickListener();
    }

    private void initView() {
        tvAmount = findViewById(R.id.amount_show);
        tvTime = findViewById(R.id.time_show);
        etAmount = findViewById(R.id.amount);
        etTime = findViewById(R.id.time);
        button = findViewById(R.id.submit);
    }

    private void setOnInputListener() {
        etAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                NumberUtil.keep2Decimal(this, charSequence, etAmount);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (etAmount.hasFocus()) {
                    tvAmount.setText(editable.toString());
                }
            }
        });

        etTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (etTime.hasFocus()) {
                    tvTime.setText(editable.toString());
                }
            }
        });


    }


    private void setViewClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tvAmount.getText()) || TextUtils.isEmpty(tvTime.getText())) {
                    Toast.makeText(MainActivity.this, "can not empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                ResultUtil.saveResult(tvAmount.getText().toString(), tvTime.getText().toString());
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }
}