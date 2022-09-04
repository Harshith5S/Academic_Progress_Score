package com.android.aps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class AdminLogin extends AppCompatActivity {

    private EditText name,password;
    CheckBox checkBox;
    Button login;
    String sharedPref[]=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_adminlogin );
        //IntializeIds..............
        intailizeIds();
        //SharedPref....................
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("USER_PREF", MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        //Get Shared Pref........................
        String PrefData=getPreference(preferences,"USER_LOGIN_DTLS_String");
        if(null!=PrefData && PrefData.length()>0 && !PrefData.equals("$") )
        {
            sharedPref=PrefData.split( Pattern.quote("$"));
            name.setText("Admin");
            password.setText("Admin@1");
        }

        if(preferences.contains("checked") && preferences.getBoolean("checked", false)) {
            checkBox.setChecked(true);
        }
        else {
            checkBox.setChecked(false);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox.isChecked()) {
                    editor.putBoolean("checked",true);
                    editor.putString("USER_LOGIN_DTLS_String",name.getText().toString()+"$"+password.getText().toString());
                    editor.apply();
                    editor.commit();
                }else{
                    editor.putBoolean("checked", false);
                    editor.apply();
                    editor.clear();

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(name.getText().toString()) && !"".equals(password.getText().toString())){
                    Intent i = new Intent ( AdminLogin.this, AdminDashboard.class );
                    startActivity ( i );

                    ArrayList<Object> list = new ArrayList<Object> ();
                    list.add ( name.getText ().toString () );

                    i.putExtra ( "itemlist", (Serializable) list );
                }
                else
                {
                    if("".equals(name.getText().toString()) ){
                        ((EditText) findViewById(R.id.username)).setError("user name not valid");
                    }
                    else if ("".equals ( password.getText ().toString () )){
                        ((EditText) findViewById(R.id.password)).setError("password not valid");
                        Toast.makeText( AdminLogin.this, "Validate the password with caps letter ,numbers,special characters",
                                Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }





    public static String getPreference(SharedPreferences pref, String key)
    {
        String pref_Data=pref.getString(key, null);
        return  pref_Data;


    }

    public void intailizeIds()
    {

        name = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.btn);
        checkBox = (CheckBox)findViewById(R.id.checkBox);


    }

}
