package tannu.ankita.eatit;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import tannu.ankita.eatit.Model.User;

public class Profile extends AppCompatActivity {

    MaterialEditText editTextMobile, editTextName, editTextPassword;
    Button buttonCreateProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextMobile = (MaterialEditText) findViewById(R.id.editTextMobile);
        editTextName = (MaterialEditText) findViewById(R.id.editTextName);
        editTextPassword = (MaterialEditText) findViewById(R.id.editTextPassword);

        buttonCreateProfile = (Button) findViewById(R.id.buttonCreateProfile);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        buttonCreateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(Profile.this);
                mDialog.setMessage("Please Wait");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(editTextMobile.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(Profile.this, "Phone number already exits", Toast.LENGTH_SHORT).show();
                        } else
                            {
                            mDialog.dismiss();
                            User user = new User(editTextName.getText().toString(), editTextPassword.getText().toString());
                            table_user.child(editTextMobile.getText().toString()).setValue(user);
                            Toast.makeText(Profile.this, "created sucessfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}


