package Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.aps.R;

import androidx.fragment.app.Fragment;

public class Childfragment3 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        super.onCreateView(inflater, container, savedInstanceState);
        final Button btn = (Button) view.findViewById(R.id.btn3);

        btn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://forms.gle/YqdVH6Lvuc8TZd8NA");
                Intent i = new Intent(  Intent.ACTION_VIEW,uri );
                startActivity(i);
            }
        } );

        return view;

    }

}