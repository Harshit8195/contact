package com.example.contactmanagerapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.contactmanagerapp.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {
    private ActivityAddNewContactBinding binding;
    private Contacts contacts;
    private AddNewContactsClickHandler handler;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        contacts = new Contacts();
        binding = DataBindingUtil.setContentView(this , R.layout.activity_add_new_contact);
        handler = new AddNewContactsClickHandler(contacts , this ,viewModel );
        binding.setClickHandler(handler);
        binding.setContact(contacts);
    }
}

