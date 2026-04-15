package com.example.clase7;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        String name  = getIntent().getStringExtra("name");
        String desc  = getIntent().getStringExtra("desc");
        String photo = getIntent().getStringExtra("photo");
        int atack    = getIntent().getIntExtra("atack", 0);
        int def      = getIntent().getIntExtra("def", 0);

        ImageView imageView = findViewById(R.id.detallePhoto);
        TextView tvName     = findViewById(R.id.detalleName);
        TextView tvDesc     = findViewById(R.id.detalleDesc);
        TextView tvAtack    = findViewById(R.id.detalleAtack);
        TextView tvDef      = findViewById(R.id.detalleDef);

        tvName.setText(name);
        tvDesc.setText(desc);
        tvAtack.setText("ATK: " + atack);
        tvDef.setText("DEF: " + def);
        Glide.with(this).load(photo).into(imageView);
    }
}