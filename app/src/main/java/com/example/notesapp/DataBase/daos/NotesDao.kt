package com.example.notesapp.DataBase.daos

import androidx.room.*
import com.example.notesapp.DataBase.Model.Notes

@Dao
interface NotesDao {
    @Insert
    fun insertNote(note:Notes)
    @Query("select * from Notes")
    fun getAllNotes():List<Notes>
    @Delete
    fun deleteNote(note: Notes)
    @Update
    fun updateNote(note: Notes)
    @Query("delete from Notes  Where id=:id")
    fun deleteNoteById(id:Int)

@Query("select * from Notes Where description like :word")
    fun searchNotesbydescrtption(word:String):List<Notes>
}