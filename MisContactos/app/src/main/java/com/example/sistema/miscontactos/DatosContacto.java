package com.example.sistema.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DatosContacto extends AppCompatActivity {

    private String mNombre;
    private String mFechaNacimiento;
    private String mTelefono;
    private String mEMail;
    private String mDescripcionContacto;

    TextView tvFechaNacimiento;
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEMail;
    TextView tvDescripcionContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_datos);

        Bundle bundle = getIntent().getExtras();

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvFechaNacimiento = (TextView)findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvEMail = (TextView)findViewById(R.id.tvEMail);
        tvDescripcionContacto = (TextView)findViewById(R.id.tvDescripcionContacto);

        mNombre = bundle.getString(getResources().getString(R.string.nombre));
        mFechaNacimiento = bundle.getString(getResources().getString(R.string.fecha_nacimiento));
        mTelefono = bundle.getString(getResources().getString(R.string.telefono));
        mEMail = bundle.getString(getResources().getString(R.string.email));
        mDescripcionContacto = bundle.getString(getResources().getString(R.string.descripcion_contacto));

        tvNombre.setText(mNombre);
        tvFechaNacimiento.setText(getResources().getString(R.string.fecha_nacimiento) + ": " + mFechaNacimiento);
        tvTelefono.setText(getResources().getString(R.string.telefono) + ": " + mTelefono);
        tvEMail.setText(getResources().getString(R.string.email) + ": " + mEMail);
        tvDescripcionContacto.setText(getResources().getString(R.string.descripcion_contacto) + ": " + mDescripcionContacto);
    }

    public void editarContacto(View view) {

        Intent intent = new Intent();
        intent.putExtra(getResources().getString(R.string.nombre), mNombre);
        intent.putExtra(getResources().getString(R.string.fecha_nacimiento), mFechaNacimiento);
        intent.putExtra(getResources().getString(R.string.telefono), mTelefono);
        intent.putExtra(getResources().getString(R.string.email), mEMail);
        intent.putExtra(getResources().getString(R.string.descripcion_contacto), mDescripcionContacto);
        setResult(RESULT_OK, intent);
        finish();
    }
}
