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

/**
 * Created by h3dg3wytch on 4/7/16.
 */
public class UserInfoFragment extends Fragment {

    public static final String ARG_USER = "user";

    private EditText mUserEditText;
    private EditText mPasswordEditText;

    private Button mSubmitButton;

    private User mUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_new_user, container, false);

        mSubmitButton = (Button) view.findViewById(R.id.newUserSubmitButton);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult();
                getActivity().finish();

            }
        });

        return view;


    }

    private void setResult(){

        Intent i = new Intent();
        i.putExtra(ARG_USER, new User());
        getActivity().setResult(Activity.RESULT_OK, i);

    }


}
