package com.example.a07.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.a07.entity.SportEntity;

import java.util.List;

@Dao
public interface SportDao {

    @Insert
    void insert(SportEntity... quesEntity);


    // query All Questionaires(Default:   table name = entity name)
    @Query("SELECT * FROM SportEntity")
    List<SportEntity> queryAll();


    // clear the "QuestionaireEntity" table
    @Query("DELETE FROM SportEntity")
    void deleteAll();

}
