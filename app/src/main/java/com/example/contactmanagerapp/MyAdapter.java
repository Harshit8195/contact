package com.example.contactmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapp.databinding.ContactListItemsBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
     private ArrayList<Contacts> contacts;

    public MyAdapter(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ContactListItemsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()) ,
               R.layout.contact_list_items , parent,false);
       return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contacts currContacts = contacts.get(position);
        holder.binding.setContact(currContacts);
    }

    @Override
    public int getItemCount() {
        if(contacts!=null) return contacts.size();
        else return 0;
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ContactListItemsBinding binding;
        public MyViewHolder(ContactListItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
