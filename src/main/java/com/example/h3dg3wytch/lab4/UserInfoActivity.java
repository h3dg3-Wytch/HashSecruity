package com.example.h3dg3wytch.lab4;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by h3dg3wytch on 4/7/16.
 */
public class UserInfoActivity extends SingleFragmentActivity {
    @Override
    public Fragment getFragment() {


        return new UserInfoFragment();
    }
}
