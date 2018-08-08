package bedo.ball.abdullah_mansour.basket;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import bedo.ball.abdullah_mansour.basket.DB.AppDatabase;
import bedo.ball.abdullah_mansour.basket.DB.MatchesEntry;

import java.util.List;

import bedo.ball.abdullah_mansour.basket.DB.AppDatabase;
import bedo.ball.abdullah_mansour.basket.DB.MatchesEntry;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<MatchesEntry>> mMatchesentry;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        mMatchesentry = database.matchesDAO().loadAllTasks();
    }

    public LiveData<List<MatchesEntry>> getmMatchesentry() {
        return mMatchesentry;
    }
}
