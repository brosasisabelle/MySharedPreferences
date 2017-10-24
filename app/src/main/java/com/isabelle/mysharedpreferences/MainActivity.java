package com.isabelle.mysharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    Button btnSave, btnDisplay;
    EditText etUsername, etPassword;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnDisplay = (Button) findViewById(R.id.btn_display);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
    }

    public void saveInfo (View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
    }

    public void loadInfo (View view) {
        String user = preferences.getString("username", "");
        String pwd = preferences.getString("password", "");
        tvDisplay.setText("The password of " + user + " is " + pwd);
    }
}
