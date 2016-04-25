package icesi.i2t.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Domiciano on 23/04/2016.
 */
public class OtraActividad extends Activity{
    TextView salida;
    EditText color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skin1);

        salida = (TextView) findViewById(R.id.salida);
        color = (EditText) findViewById(R.id.color);

        Persona p = (Persona) getIntent().getExtras().getSerializable("persona");

        if(p != null){
            Calendar calendar = Calendar.getInstance();
            int hora = calendar.get(Calendar.HOUR_OF_DAY);
            int minutos = calendar.get(Calendar.MINUTE);
            String str_horas = hora+":"+minutos;

            salida.setText(str_horas+" -> Su nombre es " + p.getNombre() + " y su cedula es " + p.getCedula());
        }



    }

    public void aceptarColor(View view) {
        Intent i = new Intent();
        i.putExtra("color", color.getText().toString());
        setResult(10, i);
        finish();
    }
}
