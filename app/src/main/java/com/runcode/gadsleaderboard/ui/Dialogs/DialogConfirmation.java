package com.runcode.gadsleaderboard.ui.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.runcode.gadsleaderboard.R;
import com.runcode.gadsleaderboard.ui.SubmitActivity;

public  class DialogConfirmation extends AppCompatDialogFragment
{
    onYesButtonPressed mOnYesButtonPressed ;
    private TextView message;
    private ImageView mCancel;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.custom_dialog_confirmation,null);
        builder.setView(view);
        Button button = view.findViewById(R.id.confirm_dialog);
        message = view.findViewById(R.id.text_message_dialog);
        mCancel = view.findViewById(R.id.cancel_dialog);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        message.setText("Are you Sure ");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnYesButtonPressed.onYesPress(true);
                dismiss();
            }
        });
        return builder.create();
    }

    public void setOnYesButtonPressed(onYesButtonPressed onYesButtonPressed) {
        mOnYesButtonPressed = onYesButtonPressed;
    }

    public interface onYesButtonPressed {
        void onYesPress (boolean yes);
    }
}
