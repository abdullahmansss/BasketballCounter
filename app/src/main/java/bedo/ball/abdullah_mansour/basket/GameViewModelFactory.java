package bedo.ball.abdullah_mansour.basket;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import bedo.ball.abdullah_mansour.basket.DB.AppDatabase;

import bedo.ball.abdullah_mansour.basket.DB.AppDatabase;

public class GameViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    // COMPLETED (2) Add two member variables. One for the database and one for the taskId
    private final AppDatabase mDb;
    private final int mTaskId;

    // COMPLETED (3) Initialize the member variables in the constructor with the parameters received
    public GameViewModelFactory(AppDatabase database, int taskId) {
        mDb = database;
        mTaskId = taskId;
    }

    // COMPLETED (4) Uncomment the following method
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new GameViewModel(mDb, mTaskId);
    }
}