package com.runcode.gadsleaderboard.ui.Dialogs;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.runcode.gadsleaderboard.R;

public class DialogError extends AppCompatDialogFragment
{


    private ImageView mImage;
    private TextView message;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog,null);
        builder.setView(view);
        mImage = view.findViewById(R.id.image_message_dialog);
        message = view.findViewById(R.id.text_message_dialog);
        message.setTextColor(Color.RED);
        mImage.setImageResource(R.drawable.ic_error_24);
        message.setText(R.string.error_message_dialog);
        return builder.create();
    }
}
