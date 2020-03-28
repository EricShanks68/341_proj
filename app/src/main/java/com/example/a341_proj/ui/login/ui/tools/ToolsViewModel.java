package com.example.a341_proj.ui.login.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a341_proj.R;
import com.example.a341_proj.ui.login.LoginActivity;
import com.example.a341_proj.ui.login.MainActivity;

public class ToolsViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Would you like to Logout?");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
