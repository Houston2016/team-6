package net.rmoreno.codeforgood;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Andy Tran on 2/19/2016.
 */
public class SignupDiaglogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_signup, null);

        final EditText name = (EditText)view.findViewById(R.id.txt_signup_name);
        final EditText email = (EditText)view.findViewById(R.id.txt_signup_email);
        final EditText zipcode = (EditText)view.findViewById(R.id.txt_signup_zip);
        final Button signupButton = (Button)view.findViewById(R.id.btn_signup);

        builder.setView(view);

        return builder.create();
    }
}
