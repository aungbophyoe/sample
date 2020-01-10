package com.example.bottomnav.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(mText.toString());
    }

    public LiveData<String> getText(String a) {
        mText.setValue(a);
        return mText;
    }
}