package com.example.notesapp.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.DataBase.Model.Notes
import com.example.notesapp.DataBase.daos.NotesDao
@Database(entities = arrayOf(Notes::class),exportSchema = false,version = 1)
abstract  class MyDataBase : RoomDatabase() {
    abstract fun NotesDaos():NotesDao
    companion object{
 private var MyDataBaseInstance:MyDataBase?=null
        fun getInstance(context:Context): MyDataBase? {
            if (MyDataBaseInstance==null){
                MyDataBaseInstance=Room.databaseBuilder(context,MyDataBase::class.java,"NotesDataBase").fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
            return MyDataBaseInstance

               }
    }

}