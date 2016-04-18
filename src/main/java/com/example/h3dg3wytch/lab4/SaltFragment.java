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

    //The string that stores the password, we don't want the user object to hold onto it
    private String mPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //If there are no users, create them
        if(mUsers == null){
            mUsers = new ArrayList<>();
        }

        //If there isn't a user object, create it. It's how we will store our data
        if(mUser == null){
            mUser = new User();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salt, container, false);
        //Gets the username
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

        //sets the password
        mPasswordEditText = (EditText) view.findViewById(R.id.saltPasswordEditText);
        mPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              mPassword = s.toString();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //submit logic
        mSubmitButton = (Button) view.findViewById(R.id.saltSubmitButton);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //We get the user
                User u = getUser();
                //We see if we can log in
                if(logIn(u)) {
                    //If we get here, we launch the activity with the user object
                    Intent i = new Intent(getActivity(), UserInfoActivity.class);
                    i.putExtra(UserInfoFragment.ARGS_USER_INFO, u);
                    startActivity(i);
                }else{
                    //The user didn't enter the correct info if we got here
                    Toast.makeText(getActivity(), "Invalid login", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Launches the new user activity
        mNewUserButton = (Button) view.findViewById(R.id.saltNewUserButton);
        mNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), NewUserActivity.class);

                startActivityForResult(i, REQUEST_USER);
            }
        });

        return view;
    }

    //Here we process the results from other activies
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_USER) {
                User user = (User) data.getSerializableExtra(NewUserFragment.ARG_USER);
                Toast.makeText(getActivity(), user.getHash(), Toast.LENGTH_SHORT).show();
               mUsers.add(user);
            }
        }else{
            //Bad mojo code, we get here if the world ends
            Toast.makeText(getActivity(), "BAD REACTION", Toast.LENGTH_SHORT).show();
        }
    }



    //Checks to see if user is in the system
    private User getUser() {
        //we will check if the important user fields are populated
        if (mUser.getUserName() != null && mPassword != null && !mPassword.equals("")) {
            //go through the arraylsit
            for (User u : mUsers) {
                //if they have the same username, we return the user
                if(mUser.getUserName().equals(u.getUserName())){
                    return u;
                }
            }
            //We didn't find anything, we get null
            return null;
        }else{
            //They didn't populate the fields
            return null;
        }

    }

    //Check the hash logic
    private boolean logIn(User user){
        //If the user is null, it means we didn't find it, we return
        if(user == null)
            return false;

        //get the salt from the user
        String salt = user.getSalt();
        //generate the password from the salt and the hash
        String password = PasswordStorage.getSecurePassword(mPassword, salt);

        //If the generated password matches the hash, we have a log in. otherwise we return false.
        if(password.equals(user.getHash())) {
            return true;
        }else{
            return false;
        }

    }
}
