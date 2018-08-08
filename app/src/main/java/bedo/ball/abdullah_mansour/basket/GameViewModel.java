package bedo.ball.abdullah_mansour.basket;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import bedo.ball.abdullah_mansour.basket.DB.AppDatabase;
import bedo.ball.abdullah_mansour.basket.DB.MatchesEntry;

import bedo.ball.abdullah_mansour.basket.DB.AppDatabase;
import bedo.ball.abdullah_mansour.basket.DB.MatchesEntry;

public class GameViewModel extends ViewModel {

    // COMPLETED (6) Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<MatchesEntry> matchesEntryLiveData;

    // COMPLETED (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId
    public GameViewModel(AppDatabase database, int taskId) {
        matchesEntryLiveData = database.matchesDAO().loadTaskById(taskId);
    }

    // COMPLETED (7) Create a getter for the task variable
    public LiveData<MatchesEntry> getTask() {
        return matchesEntryLiveData;
    }
}
