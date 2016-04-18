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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by h3dg3wytch on 4/7/16.
 */
public class UserInfoFragment extends Fragment {

    public static final String ARGS_USER_INFO = "com.example.h3dg3wytch.lab4.user";

    private TextView mUserNameTextView;
    private TextView mSaltTextView;
    private TextView mHashTextView;

    //The user in which we will store data
    private User mUser;


    //Bundle to create the userFragment
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

        //Get the user from our newInstance method
        mUser = (User) getArguments().getSerializable(ARGS_USER_INFO);


    }

    //The heavy lifting of this class is done by others, it is just here to display data.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info,container, false);

        mUserNameTextView = (TextView) view.findViewById(R.id.userNameTextView);
        mUserNameTextView.setText(mUser.getUserName());

        mSaltTextView = (TextView) view.findViewById(R.id.saltTextView);
        mSaltTextView.setText(mUser.getSalt());

        mHashTextView = (TextView) view.findViewById(R.id.hashTextView);
        mHashTextView.setText(mUser.getHash());

        return view;
    }
}