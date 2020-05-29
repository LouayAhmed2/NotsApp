package com.example.notesapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AlertDialog
import com.example.notesapp.DataBase.Model.Notes
import com.example.notesapp.DataBase.MyDataBase
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        addnote_btn.setOnClickListener({
            val titletxt=titlenote.text.toString()
            val Decriptiontxt=decriptionnote.text.toString()
            val timetxt=timenote.text.toString()
            val note  = Notes(title =titletxt,description = Decriptiontxt,time = timetxt )

            MyDataBase.getInstance(applicationContext)?.NotesDaos()?.insertNote(note)
            showsuccessmessage()

        })
    }
    fun showsuccessmessage(){
      val bulder=  AlertDialog.Builder(this)
        bulder.setMessage(R.string.notecreatedsuccess)
        bulder.setPositiveButton(R.string.ok, DialogInterface.OnClickListener { dialog, which -> dialog.dismiss()
        finish()})
        bulder.setCancelable(false)
        bulder.show()
    }
}
