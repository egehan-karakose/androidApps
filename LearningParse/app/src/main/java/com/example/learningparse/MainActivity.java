package com.example.learningparse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*

        Veri Ekleme



        ParseObject object = new ParseObject("Fruits");
        object.put("name","banana");
        object.put("calorie",150);
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e!= null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Object Saved",Toast.LENGTH_LONG).show();
                }
            }
        });

        Veri Çekme


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Fruits");
        query.getInBackground("7GUL3B3KQz", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e != null){
                    e.printStackTrace();
                }else{
                    String objectName = object.getString("name");
                    int objecctCalorie = object.getInt("calorie");


                    System.out.println("objectName  = "+objectName);
                    System.out.println("objectCalorie  = "+objecctCalorie);
                }
            }
        });


        koşullu veri çekme

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Fruits");
        query.whereLessThanOrEqualTo("calorie",100);    //koşul


       query.findInBackground(new FindCallback<ParseObject>() {
           @Override
           public void done(List<ParseObject> objects, ParseException e) {
               if(e !=  null){
                   e.printStackTrace();
               }else{
                   if(objects.size() > 0){
                       for (ParseObject object:objects){
                           String objectName = object.getString("name");
                           int objectCalorie = object.getInt("calorie");

                           System.out.println("objectName : "+ objectName);
                           System.out.println("objectCalorie :" + objectCalorie);
                       }
                   }
               }
           }
       });

       */

        //USER USER USER USER USER


        /*

        ParseUser user = new ParseUser();
        user.setUsername("james");
        user.setPassword("123456");
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e!= null){
                    e.printStackTrace();
                }else{
                    Toast.makeText(MainActivity.this,"User Signed Up",Toast.LENGTH_SHORT).show();
                }
            }
        });
        */

        ParseUser.logInInBackground("james", "123456", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(MainActivity.this,"Welcome : " + user.getUsername(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
