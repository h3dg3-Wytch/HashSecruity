package com.example.h3dg3wytch.lab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by h3dg3wytch on 4/7/16.
 */
public class UserInfoFragment extends Fragment {

    public static final String ARGS_USER_INFO = "com.example.h3dg3wytch.lab4.user";

    private User mUser;

    public static UserInfoFragment newInstance(User user){

        Bundle args = new Bundle();
        args.putSerializable(ARGS_USER_INFO, user);
        UserInfoFragment fragment = new UserInfoFragment();
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUser = (User) getArguments().getSerializable(ARGS_USER_INFO);
        Toast.makeText(getActivity(), mUser.toString(), Toast.LENGTH_SHORT).show();

    }
}
