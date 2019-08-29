package com.jadgroup.mvvmtutorial.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.jadgroup.mvvmtutorial.R;
import com.jadgroup.mvvmtutorial.model.User;
import com.jadgroup.mvvmtutorial.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivity context;
    LoginViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        model = ViewModelProviders.of(context).get(LoginViewModel.class);
        model.getUserObject().observe(context, userObjectObserver);
    }


    private final Observer<User> userObjectObserver = new Observer<User>() {
        @Override
        public void onChanged(@Nullable final User userObject) {
            //Update UI
            ((TextView) findViewById(R.id.txtView_email)).setText(userObject.getEmail());
            ((TextView) findViewById(R.id.txtView_pass)).setText(userObject.getPassword());
            Toast.makeText(context, "Email : " + userObject.getEmail() + "\nPassword : " + userObject.getPassword(), Toast.LENGTH_SHORT).show();
        }
    };

    public void buttonPress(View view) {
        //populating the data in view model
        model.doAction();
    }
}
