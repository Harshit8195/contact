package com.example.contactmanagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.contactmanagerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContactsDatabase contactsDatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    private MyAdapter adapter;

    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers handlers;

    RecyclerView recyclerView;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        handlers = new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandler(handlers);

        recyclerView = activityMainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new MyAdapter(contactsArrayList);
        contactsDatabase = ContactsDatabase.getInstance(this);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        myViewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {

                contactsArrayList.clear();
                for(Contacts c : contacts){
                    Log.v("HARSH" , c.getName());
                    contactsArrayList.add(c);
                }
                adapter.notifyDataSetChanged();
            }
        });



        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0 , ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Contacts c = contactsArrayList.get(viewHolder.getAdapterPosition());
                myViewModel.deleteContact(c);
            }
        }).attachToRecyclerView(recyclerView);

    }
}