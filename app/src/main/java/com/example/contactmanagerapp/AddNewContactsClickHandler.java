package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactsClickHandler {
    Contacts contacts;
    Context context;
    private MyViewModel viewModel;

    public AddNewContactsClickHandler(Contacts contacts, Context context, MyViewModel viewModel) {
        this.contacts = contacts;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onClickSubmitBTN(View view){
        if(contacts.getName() == null || contacts.getEmail() == null){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(context , MainActivity.class);
//            i.putExtra("Name" , contacts.getName());
//            i.putExtra("Email" , contacts.getEmail());

            Contacts c = new Contacts(contacts.getName() , contacts.getEmail());
            viewModel.addnewContact(c);
            context.startActivity(i);
        }
    }
}
