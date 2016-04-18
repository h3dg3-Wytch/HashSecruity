package com.example.h3dg3wytch.lab4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by h3dg3wytch on 4/1/16.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    public abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        FragmentManager fragmentSupportManager = getSupportFragmentManager();

        Fragment fragment = fragmentSupportManager.findFragmentById(R.id.container);

        if(fragment == null){
            fragment = getFragment();
            fragmentSupportManager.beginTransaction().add(R.id.container, fragment).commit();
        }
    }
}
