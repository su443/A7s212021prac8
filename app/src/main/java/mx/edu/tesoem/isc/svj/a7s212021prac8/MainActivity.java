package mx.edu.tesoem.isc.svj.a7s212021prac8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    EditText txtnombre, txtedad, txtsexo, txtresul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtsexo = findViewById(R.id.txtsexo);
        txtresul = findViewById(R.id.txtresul);
    }

    public void CJSON(View v){
        Datos dato = new Datos ();
        Gson gson = new Gson();
                dato.setNombre(txtnombre.getText().toString());
                dato.setEdad(txtedad.getText().toString());
                dato.setSexo(txtsexo.getText().toString());
            txtresul.setText(gson.toJson(dato));

    }

    public void CClase(View v){
        Gson gson = new Gson();
        Datos dato = gson.fromJson(txtresul.getText().toString(),Datos.class);

        txtnombre.setText(dato.getNombre());
        txtedad.setText(dato.getEdad());
        txtsexo.setText(dato.getSexo());
        

    }
}