package com.example.contactmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private final contactDAO ContactDAO;
    private ContactsDatabase contactsDatabase;
    ExecutorService executor;
    Handler handler;


    public Repository(Application application) {
        contactsDatabase = ContactsDatabase.getInstance(application);
        this.ContactDAO = contactsDatabase.getContactDAO();
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public void addContact(Contacts contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                ContactDAO.insert(contact);
            }
        });
    }
    public void deleteContact(Contacts contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                ContactDAO.delete(contact);
            }
        });
    }
    public LiveData<List<Contacts>> getAllContact(){
        return ContactDAO.getAllContact();
    }
}
