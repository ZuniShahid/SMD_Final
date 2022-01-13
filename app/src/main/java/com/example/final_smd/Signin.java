package com.example.final_smd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class Signin extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myReference;
    EditText editText1, editText2;
    Button button;
    String email, password,key;
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        editText1 = findViewById(R.id.emailText);
        editText2 = findViewById(R.id.passwordText);
        button = findViewById(R.id.btn2);
        //email = editText1.getText().toString();


    }

    public void sigin(View view) {
        String emaill = editText1.getText().toString().trim();
        String pass = editText2.getText().toString().trim();

        checkemail(emaill,pass);

    }


    void checkemail(String emaill,String pass)
    {
        db.collection("login").whereEqualTo("email",emaill).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                Toast.makeText(Signin.this, "Email confirmed", Toast.LENGTH_SHORT).show();
                checkpassword(pass);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Signin.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void checkpassword(String pass)
    {
        db.collection("login").whereEqualTo("password",pass).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                Toast.makeText(Signin.this, "Email and Paswsword confirmed and passed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Signin.this,TabScreen.class);
                startActivity(intent);

            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Signin.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}