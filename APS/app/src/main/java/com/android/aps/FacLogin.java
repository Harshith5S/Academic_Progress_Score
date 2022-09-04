package com.android.aps;

import static Additional.Validation.passwordValidation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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
import java.util.HashMap;
import java.util.regex.Pattern;

import Additional.HttpParse;

public class FacLogin  extends AppCompatActivity {

    private EditText name,password;
    CheckBox checkBox;
    Button login;
    String sharedPref[]=null;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    String HttpURL = "http://192.168.101.1/aps/faculty_login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_facultylogin );
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
            name.setText(sharedPref[0]);
            password.setText(sharedPref[1]);
        }





        if(preferences.contains("checked") && preferences.getBoolean("checked", false)) {
            checkBox.setChecked(true);
        }else {
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
                if (!"".equals(name.getText().toString()) && !"".equals(password.getText().toString())&&( passwordValidation (password))){
                    Intent i = new Intent ( FacLogin.this, Blank.class );
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
                        Toast.makeText( FacLogin.this, "Validate the password with caps letter ,numbers,special characters",
                                Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }

    public void FacLoginFunction(final String email, final String password){

        class FacLoginClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {
                super.onPostExecute(httpResponseMsg);

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                    finish();
                    Intent intent = new Intent(FacLogin.this, Final_Output.class);
                    startActivity(intent);

                }
                else{

                    Toast.makeText(FacLogin.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("name",params[0]);
                hashMap.put("password",params[1]);
                String finalResult = httpParse.postRequest(hashMap, HttpURL);
                return finalResult;
            }
        }

        FacLoginClass facLoginClass = new FacLoginClass();
        facLoginClass.execute(String.valueOf(name),password);
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
        checkBox = findViewById(R.id.checkBox);


    }

}