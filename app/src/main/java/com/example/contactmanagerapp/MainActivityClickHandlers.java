package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivityClickHandlers {
    Context context;

    public MainActivityClickHandlers(Context context) {
        this.context = context;
    }
    public void onFABClick(View view){
        Intent i = new Intent(view.getContext() , AddNewContactActivity.class);
        context.startActivity(i);
    }
}
