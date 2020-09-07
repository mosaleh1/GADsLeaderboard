package com.runcode.gadsleaderboard.ui.Dialogs;

import android.app.Dialog;
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

public class DialogSuccess extends AppCompatDialogFragment
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
        mImage.setImageResource(R.drawable.success_image);
        message.setText(R.string.success_message_dialog);
        return builder.create() ;
    }
}
