package com.example.labo7.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class GithubRepo(

    //Sirve para poder utilizar un alias para el nombre de las columnas
    //@ColumnInfo(name = "s_name")
  val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}