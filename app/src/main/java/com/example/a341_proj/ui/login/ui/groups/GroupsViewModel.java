package com.example.a341_proj.ui.login.ui.groups;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GroupsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GroupsViewModel() {
        mText = new MutableLiveData<>();
       // mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}