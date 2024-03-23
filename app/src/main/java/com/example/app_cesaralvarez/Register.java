package com.example.app_cesaralvarez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Register extends AppCompatActivity {
    EditText username, password, repassword;
    Button signup, singnin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        EditText iduser = (EditText) findViewById(R.id.edtid);
        username = (EditText) findViewById(R.id.edtusername);
        password = (EditText) findViewById(R.id.edtpassword);
        repassword = (EditText) findViewById(R.id.edtRtpassword);
        signup = (Button) findViewById(R.id.btnSave);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = iduser.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String  repass = repassword.getText().toString();

                if(id.equals("") ||user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(Register.this, "Por favor ingresa toda la informacion", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false){
                            Boolean insert = DB.insertData(id,user, pass);
                            if(insert == true){
                                Toast.makeText(Register.this, "Guardado Exitoso!!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Register.this, "Error al Guardar!!, Verifica tu datos", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Register.this, "El usuario ya existe!! ", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "La contraseña no coincide!! ", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });
    }
}
