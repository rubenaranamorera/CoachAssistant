package com.armoz.coachassistant.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.armoz.coachassistant.base.AndroidApplication;
import com.armoz.coachassistant.base.component.ApplicationComponent;

public abstract class BaseActivity extends Activity {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    /*
    public void showError(String message){
        showSnackbar(message, Color.RED);
    }

    public void showConfirmation(String message){
        showSnackbar(message, Color.GREEN);
    }

    public void showAlert(String message){
        showSnackbar(message, Color.YELLOW);
    }

    private void showSnackbar(String message, int green) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(green);
        snackbar.show();
    }
*/
    protected void setView(View view){
        this.view = view;
    }

}
