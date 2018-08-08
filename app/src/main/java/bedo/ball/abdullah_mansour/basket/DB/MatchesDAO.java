package bedo.ball.abdullah_mansour.basket.DB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MatchesDAO {

    @Query("SELECT * FROM matches")
    LiveData<List<MatchesEntry>> loadAllTasks();

    @Insert
    void insertTask(MatchesEntry matchesEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(MatchesEntry matchesEntry);

    @Delete
    void deleteTask(MatchesEntry matchesEntry);

    @Query("SELECT * FROM matches WHERE id = :id")
    LiveData<MatchesEntry> loadTaskById(int id);
}
