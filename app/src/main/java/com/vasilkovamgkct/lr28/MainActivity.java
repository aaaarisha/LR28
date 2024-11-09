package com.vasilkovamgkct.lr28;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            WorkoutListFragment listFragment = new WorkoutListFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, listFragment);
            transaction.commit();
        }
    }

    @Override
    public void itemClicked(long id) {
        WorkoutDetailFragment detailsFragment = new WorkoutDetailFragment();
        detailsFragment.setWorkout(id);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, detailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // Метод для открытия StopwatchFragment
    public void openStopwatchFragment() {
        StopwatchFragment stopwatchFragment = new StopwatchFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, stopwatchFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
