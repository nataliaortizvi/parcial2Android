package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase db;

    private Button okbt;
    private TextView preguntatx;
    private EditText puntajetx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        okbt = findViewById(R.id.okbt);
        preguntatx = findViewById(R.id.preguntatx);
        puntajetx = findViewById(R.id.puntajetx);

        db = FirebaseDatabase.getInstance();

        loadDatabase();

        okbt.setOnClickListener(
                (v) -> {
                    String p = puntajetx.getText().toString();
                    int punt = Integer.parseInt(p);

                    if(punt >= 0 && punt <= 10){
                        DatabaseReference ref = db.getReference().child("preguntasDo/prom");
                        Elpuntaje mipuntaje = new Elpuntaje(
                                "1",
                                punt
                        );

                        ref.setValue(mipuntaje);
                        puntajetx.setText("");
                    }else{
                        Toast.makeText(this, "Escriba un número entre 0 y 10", Toast.LENGTH_LONG).show();
                    }
                }
            );
    }

    private void loadDatabase() {
        DatabaseReference ref = db.getReference().child("preguntasDo/preg");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot data) {
                        Log.d("aaa",""+data.getValue());
                        if(data.getValue() == null){
                            preguntatx.setText("No hay pregunta");
                        }

                        for (DataSnapshot child : data.getChildren()){
                            lapreguntaH pregunta = child.getValue(lapreguntaH.class);

                            preguntatx.setText(pregunta.getPregunta());

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                }
        );
    }
}