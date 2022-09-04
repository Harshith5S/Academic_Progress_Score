package com.android.aps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.aps.databinding.ActivityMainBinding;

import Additional.CheckPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        //check RunTimePermissions...............
        CheckPermission.checkAndRequestPermissions ( MainActivity.this );
        binding = ActivityMainBinding.inflate ( getLayoutInflater ( ) );
        setContentView ( binding.getRoot ( ) );


        setSupportActionBar ( binding.toolbar );


        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent ( );
        String appLinkAction = appLinkIntent.getAction ( );
        Uri appLinkData = appLinkIntent.getData ( );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ( ).inflate ( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ( );

        //noinspection SimplifiableIfStatement
        if (id == R.id.Lec_login) {
            Intent i = new Intent(MainActivity.this, AdminLogin.class);
            startActivity(i);
        }
        if (id == R.id.Fac_Login) {
            Intent i = new Intent(MainActivity.this, FacLogin.class);
            startActivity(i);
        }
        if (id == R.id.Profile_View) {
            Intent i = new Intent(MainActivity.this, ViewPager.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected ( item );
    }


}