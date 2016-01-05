package bounswe2015group5.xplore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class is created by Mert Oguz on 06/11/2015.
 */
public class Signup extends Activity {

    /**
     * UI references
     * @author Mert Oguz
     */
    private EditText edtMail, edtUsername, edtPass, edtPassRetype;
    private TextView guestLogin, loginText;
    private Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup);

        edtMail     = (EditText) findViewById(R.id.signup_email);
        edtUsername = (EditText) findViewById(R.id.signup_name);
        edtPass     = (EditText) findViewById(R.id.signup_pass);
        edtPassRetype = (EditText) findViewById(R.id.signup_repass);

        signupBtn = (Button) findViewById(R.id.signupBtn);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSignup();
            }
        });

        guestLogin = (TextView) findViewById(R.id.guestLogin);
        guestLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginAsGuest();
            }
        });

        loginText = (TextView) findViewById(R.id.signup_login);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginPage();
            }
        });

    }

    private void goToLoginPage() {
        startActivity(new Intent(Signup.this, Login.class));
        finishAffinity();
    }

    private void LoginAsGuest() {
        startActivity(new Intent(Signup.this, MainActivity.class));
        finish();
    }

    /**
     * Sign-Up function. Checks if the given inputs are okay.
     * @author Mert Oguz
     */
    private void attemptSignup() {

        final String email = edtMail.getText().toString();
        final String name = edtUsername.getText().toString();
        final String pass = edtPass.getText().toString();
        final String pass_retype = edtPassRetype.getText().toString();
        final String URL = getString(R.string.service_url) + "RegisterUser"; //for POST to server

        if(!pass.equals(pass_retype)) {
            Toast.makeText(getApplicationContext(), "Passwords Don't Match", Toast.LENGTH_SHORT).show();
            return;
        }
        if(email.isEmpty()||name.isEmpty()||pass.isEmpty()||pass_retype.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please fill in all of the required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Globals.connectionManager.registerUser(Signup.this, email, pass, name);
    }

}
