package net.rmoreno.codeforgood;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final Button signup = (Button)findViewById(R.id.btn_welcome_signup);
        final Button signin = (Button)findViewById(R.id.btn_welcome_signin);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new SignupDiaglogFragment();
                dialog.show(getFragmentManager(), "Signup");
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new SigninDiaglogFragment();
                dialog.show(getFragmentManager(), "Signin");
            }
        });
    }
}
