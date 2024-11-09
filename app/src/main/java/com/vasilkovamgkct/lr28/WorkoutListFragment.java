package com.vasilkovamgkct.lr28;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WorkoutListFragment extends Fragment {

    public interface Listener {
        void itemClicked(long id);
    }

    private Listener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout_list, container, false);

        ListView listViewWorkouts = view.findViewById(R.id.listViewWorkouts);
        String[] workoutNames = new String[Workout.workouts.length + 1]; // +1 для секундомера
        for (int i = 0; i < Workout.workouts.length; i++) {
            workoutNames[i] = Workout.workouts[i].getName();
        }
        workoutNames[Workout.workouts.length] = "Stopwatch"; // Добавляем пункт для секундомера

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1, workoutNames);
        listViewWorkouts.setAdapter(adapter);

        listViewWorkouts.setOnItemClickListener((parent, view1, position, id) -> {
            if (position == Workout.workouts.length) { // Если это секундомер
                ((MainActivity) getActivity()).openStopwatchFragment(); // Открыть секундомер
            } else {
                if (listener != null) {
                    listener.itemClicked(id);
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Listener) {
            listener = (Listener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement WorkoutListFragment.Listener");
        }
    }
}
