package net.rmoreno.codeforgood;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Andy Tran on 2/19/2016.
 */
public class SigninDiaglogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_signin, null);

        final EditText email = (EditText)view.findViewById(R.id.txt_signin_email);
        final Button signinButton = (Button)view.findViewById(R.id.btn_signin);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProjectActivity.class);
                startActivity(intent);
            }
        });

        builder.setView(view);

        return builder.create();
    }
}
