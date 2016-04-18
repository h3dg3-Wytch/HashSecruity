package com.example.h3dg3wytch.lab4;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SaltActivity extends SingleFragmentActivity {

    @Override
    public Fragment getFragment() {
        return new SaltFragment();
    }

}
