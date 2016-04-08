package com.example.h3dg3wytch.lab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by h3dg3wytch on 4/1/16.
 */
public class SaltFragment extends Fragment {

    private static final int REQUEST_USER = 0;

    private static ArrayList<User> mUsers;
    //Input fields
    private EditText mUserEditText;
    private EditText mPasswordEditText;

    private Button mSubmitButton;
    private Button mNewUserButton;

    private User mUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salt, container, false);

        if(mUsers == null){
            mUsers = new ArrayList<>();
        }

        mUserEditText = (EditText) view.findViewById(R.id.saltUserEditText);
        mUserEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setUserName(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPasswordEditText = (EditText) view.findViewById(R.id.saltPasswordEditText);
        mPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setPassword(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSubmitButton = (Button) view.findViewById(R.id.saltSubmitButton);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), UserInfoActivity.class);
                i.putExtra(UserInfoFragment.ARGS_USER_INFO, new User());
                startActivity(i);

            }
        });

        mNewUserButton = (Button) view.findViewById(R.id.saltNewUserButton);
        mNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), NewUserActivity.class);

                startActivityForResult(i,REQUEST_USER );
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_USER) {
                User user = (User) data.getSerializableExtra(NewUserFragment.ARG_USER);
                Toast.makeText(getActivity(), user.getUserName(), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getActivity(), "BAD REACTION", Toast.LENGTH_SHORT).show();
        }
    }
}
