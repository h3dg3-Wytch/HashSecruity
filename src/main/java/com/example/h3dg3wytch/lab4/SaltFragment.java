package com.example.h3dg3wytch.lab4;

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
 * Created by h3dg3wytch on 4/1/16.
 */
public class SaltFragment extends Fragment {
    //Input fields
    private EditText mUserEditText;
    private EditText mPasswordEditText;

    private Button mSubmitButton;

    private User mUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salt, container, false);

        mUser = new User();

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

                Toast.makeText(getActivity(), mUser.getUserName() + " " + mUser.getPassword(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}
