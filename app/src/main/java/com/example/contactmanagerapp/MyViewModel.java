package com.example.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private Repository myRepository;
    LiveData<List<Contacts>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }
    public void addnewContact(Contacts contact){
        myRepository.addContact(contact);
    }
    public void deleteContact(Contacts contact){
        myRepository.deleteContact(contact);
    }
    public LiveData<List<Contacts>> getAllContacts(){
       allContacts=  myRepository.getAllContact();
       return allContacts;
    }

}
