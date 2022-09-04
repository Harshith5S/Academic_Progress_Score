package com.android.aps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.valueOf;

public class AdminActivity extends AppCompatActivity {

    EditText editTextStudentFB, editTextSubjectResult;
    Spinner spinnerPaperPublication, spinnerQualification, spinnerFDPs, spinnerTBPublication, spinnerFunds, spinnerActivity;
    Button btnSubmit;

    Integer studentFB, totalSR;
    String pp, qual, fdp, tbp, fund, ca;

    String[] paperPublication = {"Journal", "International Conference", "National Conference"};
    String[] qualification = {"PhD (Completed)", "PhD (Registered)", "M.Tech"};
    String[] fdps = {"Conduct", "Attend"};
    String[] textbookPublication = {"Yes", "No"};
    String[] funds = {"Yes", "No"};
    String[] activities = {"Yes", "No"};

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit);
        editTextStudentFB = findViewById(R.id.editTextStudentFB);
        editTextSubjectResult = findViewById(R.id.editTextSubjectResult);
        spinnerPaperPublication = findViewById(R.id.spinnerPaperPublication);
        spinnerQualification = findViewById(R.id.Qualification);
        spinnerFDPs = findViewById(R.id.spinnerFDPs);
        spinnerTBPublication = findViewById(R.id.spinnerTBPublication);
        spinnerFunds = findViewById(R.id.spinnerFunds);
        spinnerActivity = findViewById(R.id.spinnerActivity);
        btnSubmit = findViewById(R.id.btnSubmit);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(AdminActivity.this, android.R.layout.simple_spinner_item, paperPublication);
        adapter = new ArrayAdapter<String>(AdminActivity.this, android.R.layout.simple_spinner_item, qualification);
        adapter = new ArrayAdapter<String>(AdminActivity.this, android.R.layout.simple_spinner_item, fdps);
        adapter = new ArrayAdapter<String>(AdminActivity.this, android.R.layout.simple_spinner_item, textbookPublication);
        adapter = new ArrayAdapter<String>(AdminActivity.this, android.R.layout.simple_spinner_item, funds);
        adapter = new ArrayAdapter<String>(AdminActivity.this, android.R.layout.simple_spinner_item, activities);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaperPublication.setAdapter(adapter);
        spinnerQualification.setAdapter(adapter);
        spinnerFDPs.setAdapter(adapter);
        spinnerTBPublication.setAdapter(adapter);
        spinnerFunds.setAdapter(adapter);
        spinnerActivity.setAdapter(adapter);
        //Array Adapter Intialization
        ArrayAdapter<CharSequence> SPP;
        ArrayAdapter<CharSequence> SQ;
        ArrayAdapter<CharSequence> SFDP;
        ArrayAdapter<CharSequence> STBP;
        ArrayAdapter<CharSequence> SF;
        ArrayAdapter<CharSequence> SA;
        //Spinner class Intialization
        Spinner spinnerPaperPublication =(Spinner)findViewById(R.id.spinnerPaperPublication);
        Spinner spinnerQualification    =(Spinner)findViewById(R.id.Qualification);
        Spinner spinnerFDPs             =(Spinner)findViewById ( R.id.spinnerFDPs ) ;
        Spinner spinnerTBPublication    =(Spinner)findViewById ( R.id.spinnerTBPublication ) ;
        Spinner spinnerFunds            =(Spinner)findViewById ( R.id.spinnerFunds ) ;
        Spinner spinnerActivity         =(Spinner)findViewById ( R.id.spinnerActivity ) ;
        //Spinner for PaperPublication
        SPP =    new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,paperPublication);
        SPP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaperPublication.setAdapter(SPP);
        String paperPublication  = spinnerPaperPublication.getSelectedItem().toString();
        //Spinner for Quallification
        SQ =    new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,qualification);
        SQ.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQualification.setAdapter(SQ);
        String qualification  = spinnerPaperPublication.getSelectedItem().toString();

        //Spinner for Faculty Development Program's
        SFDP =    new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,fdps);
        SFDP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFDPs.setAdapter(SFDP);
        String fdps  = spinnerPaperPublication.getSelectedItem().toString();

       //Spinner for Text Book Publication
        STBP =    new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,textbookPublication);
        STBP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFDPs.setAdapter(STBP);
        String textbookPublication  = spinnerPaperPublication.getSelectedItem().toString();
        // Spinner class for Funds
        SF =    new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,funds);
        SF.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFDPs.setAdapter(SF);
        String funds  = spinnerPaperPublication.getSelectedItem().toString();
       // Spinner class for Activities in college level as well as University Level
        SA =    new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,activities);
        SA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFDPs.setAdapter(SF);
        String activities  = spinnerPaperPublication.getSelectedItem().toString();


        System.out.println(fdps);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentFB = valueOf(editTextStudentFB.getText().toString());
                totalSR = valueOf(editTextSubjectResult.getText().toString());
                pp = spinnerPaperPublication.toString();
                qual = spinnerQualification.toString();
                fdp = spinnerFDPs.toString();
                tbp = spinnerTBPublication.toString();
                fund = spinnerFunds.toString();
                ca = spinnerActivity.toString();

            }
        });

    }
}
