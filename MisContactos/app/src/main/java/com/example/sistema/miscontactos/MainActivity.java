package com.example.sistema.miscontactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import java.util.Calendar;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;

    TextInputEditText tietNombre;
    private static TextInputEditText tietFechaNacimiento;
    TextInputEditText tietTelefono;
    TextInputEditText tietEMail;
    TextInputEditText tietDescripcionContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tietNombre = (TextInputEditText) findViewById(R.id.tietNombre);
        tietFechaNacimiento = (TextInputEditText) findViewById(R.id.tietFechaNacimiento);
        tietTelefono = (TextInputEditText) findViewById(R.id.tietTelefono);
        tietEMail = (TextInputEditText) findViewById(R.id.tietEMail);
        tietDescripcionContacto = (TextInputEditText) findViewById(R.id.tietDescripcionContacto);
    }

    public void confirmarContacto(View view) {

        Intent intent = new Intent(this, DatosContacto.class );
        intent.putExtra(getResources().getString(R.string.nombre), tietNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.fecha_nacimiento), tietFechaNacimiento.getText().toString());
        intent.putExtra(getResources().getString(R.string.telefono), tietTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.email), tietEMail.getText().toString());
        intent.putExtra(getResources().getString(R.string.descripcion_contacto), tietDescripcionContacto.getText().toString());
        startActivityForResult(intent, SECOND_ACTIVITY_RESULT_CODE);
    }

    // // Este metodo es llamado cuando la siguiente actividad es finalizada
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // Verifica la siguiente actividad con un resultado OK
        if (requestCode == SECOND_ACTIVITY_RESULT_CODE) {
            if (resultCode == RESULT_OK) {
                tietNombre.setText(intent.getStringExtra(getResources().getString(R.string.nombre)));
                tietFechaNacimiento.setText(intent.getStringExtra(getResources().getString(R.string.fecha_nacimiento)));
                tietTelefono.setText(intent.getStringExtra(getResources().getString(R.string.telefono)));
                tietEMail.setText(intent.getStringExtra(getResources().getString(R.string.email)));
                tietDescripcionContacto.setText(intent.getStringExtra(getResources().getString(R.string.descripcion_contacto)));
            }
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH );
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            tietFechaNacimiento.setText(String.format("%02d", day) + "/" + String.format("%02d", month + 1) + "/" + String.valueOf(year));
        }
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
