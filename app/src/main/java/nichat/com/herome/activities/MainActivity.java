package nichat.com.herome.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nichat.com.herome.fragments.FinalFragment;
import nichat.com.herome.fragments.MainFragment;
import nichat.com.herome.R;
import nichat.com.herome.fragments.SecondFragment;


//Created on 7/6/2018
//By Paritosh Nichat
//This app was created to learn about how to manage Fragments in an android application.
//This app has three fragments in total-MainFragments,SecondFragments,FinalFragments.

public class MainActivity extends AppCompatActivity implements MainFragment.OnMainFragmentInteractionListener,SecondFragment.OnSecondFragmentInteractionListener,FinalFragment.OnFinalFragmentInteractionListener {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);



//        For fragment,you first need FragmentManager.FragmentManager manages the fragments.
//        FragmentManager is used to create transactions for adding, removing or replacing fragments.
//        getFragmentManager()
//        Returns the FragmentManager for interacting with fragments associated with this activity.
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
//        Then you have to create a Fragment object.
        android.support.v4.app.Fragment fragment = manager.findFragmentById(R.id.fragment_container);
//        MainFragment extends Fragment class.
        if(fragment == null){
            fragment = new MainFragment();
//            Fragment Transaction is required to perform a set of operations on the Fragments.
//            fragmentManager.beginTransaction();
//            Starts a series of edit operations on the Fragments associated with this FragmentManager.
            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
//            Adds the fragment to activity state.
            transaction.add(R.id.fragment_container,fragment);
//            Commits the operations performed.
            transaction.commit();
        }


    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFinalFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSecondFragmentInteraction(Uri uri) {

    }

    public void loadMainFragment(){
        MainFragment main = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,main).addToBackStack(null).commit();
    }

    public void loadSecondFragment(){
        SecondFragment second = new SecondFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,second).addToBackStack(null).commit();
    }

    public void loadFinalFragment(){
        FinalFragment lastFragment = new FinalFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,lastFragment).addToBackStack(null).commit();
    }

}
