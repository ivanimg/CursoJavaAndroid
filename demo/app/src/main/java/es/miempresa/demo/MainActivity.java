package es.miempresa.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void recibirDatos(View view){
        EditText et = findViewById(R.id.idT);

        String mensaje = et.getText().toString();
        System.out.println(mensaje);

        Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("param1", mensaje);
        startActivity(i);
    }

    public void abreActividad(android.view.View view){
        System.out.println("Imprimiendo en consola");

        Intent intent = new Intent (this, Activity2.class);
        EditText editText = (EditText) findViewById(R.id.idT);
        String message = editText.getText().toString();

    }

}
