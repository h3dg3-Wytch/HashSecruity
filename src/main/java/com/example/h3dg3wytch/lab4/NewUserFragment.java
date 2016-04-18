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

/**
 * Created by h3dg3wytch on 4/7/16.
 */
public class NewUserFragment extends Fragment {

    public static final String ARG_USER = "user";

    private EditText mUserEditText;
    private EditText mPasswordEditText;

    private Button mSubmitButton;

    private User mUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUser = new User();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_user, container, false);

        mUserEditText = (EditText) view.findViewById(R.id.newUserUserEntryEditText);

        //Sets the username
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

        //Sets the password
        mPasswordEditText = (EditText) view.findViewById(R.id.newUserPasswordEditText);
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

        mSubmitButton = (Button) view.findViewById(R.id.newUserSubmitButton);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mUser.getPassword() != null && mUser.getUserName() != null && !mUser.getPassword().equals("") &&  !mUser.getUserName().equals("")) {
                    setResult();
                    getActivity().finish();
                }else{
                    Toast.makeText(getActivity(), "Please enter a valid username and password!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;


    }

    private void setResult(){

        Intent i = new Intent();
        i.putExtra(ARG_USER, mUser);
        getActivity().setResult(Activity.RESULT_OK, i);

    }







}
