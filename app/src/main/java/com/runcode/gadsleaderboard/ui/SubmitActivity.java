package com.runcode.gadsleaderboard.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.runcode.gadsleaderboard.R;
import com.runcode.gadsleaderboard.data.PostDataInterface;
import com.runcode.gadsleaderboard.ui.Dialogs.DialogConfirmation;
import com.runcode.gadsleaderboard.ui.Dialogs.DialogError;
import com.runcode.gadsleaderboard.ui.Dialogs.DialogSuccess;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SubmitActivity extends AppCompatActivity {
    EditText fNameEd , lNameEd , emailEd ,githubLinkEd ;
    Button submit ;
    private String mFname;
    private String mLname;
    private String mEmail;
    private String mGithubLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Toolbar toolbar = findViewById(R.id.toolbar_submitActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        declareViews();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfValueIsEmpty()){
                    showConfirmationDialog();
                }
                else {
                    Toast.makeText(getApplicationContext(), "please fill the missing data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showConfirmationDialog() {
        DialogConfirmation dialog = new DialogConfirmation();
        dialog.show(getSupportFragmentManager(),"Confirmation dialog");
        dialog.setOnYesButtonPressed(new DialogConfirmation.onYesButtonPressed() {
            @Override
            public void onYesPress(boolean yes) {
                submitData();
            }
        });
    }

    private void submitData()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .build();

        PostDataInterface postDataInterface = retrofit.create(PostDataInterface.class);

        Call<Void> call = postDataInterface.postToForm(mFname,mLname,mEmail,mGithubLink);

        call.enqueue(new Callback<Void>()
        {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200)
                {
                    Toast.makeText(SubmitActivity.this, "Successfully submit the data", Toast.LENGTH_SHORT).show();
                    showSuccessDialog();
                }
                else {
                    Toast.makeText(SubmitActivity.this, "error while submit the data", Toast.LENGTH_SHORT).show();
                    showFailedDialog();
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showFailedDialog();
            }
        });
    }

    private void showFailedDialog() {
        DialogError dialogError = new DialogError();
        dialogError.show(getSupportFragmentManager(),"Error Dialog");
    }

    private void showSuccessDialog() {
        DialogSuccess dialog = new DialogSuccess();
        dialog.show(getSupportFragmentManager(),"Success Dialog");
    }

    private boolean checkIfValueIsEmpty() {
        getValuesFromEditText();
        return !(TextUtils.isEmpty(mFname.trim()) || TextUtils.isEmpty(mLname.trim())
                || TextUtils.isEmpty(mEmail.trim()) || TextUtils.isEmpty(mGithubLink.trim()));
    }

    private void getValuesFromEditText() {
        mFname = fNameEd.getText().toString();
        mLname = lNameEd.getText().toString();
        mEmail = emailEd.getText().toString();
        mGithubLink = githubLinkEd.getText().toString();
    }

    private void declareViews() {
        fNameEd = findViewById(R.id.first_name);
        lNameEd = findViewById(R.id.last_name);
        emailEd = findViewById(R.id.email);
        githubLinkEd = findViewById(R.id.project_link_github);
        submit =findViewById(R.id.submit);
    }

}