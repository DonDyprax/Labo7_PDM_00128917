package com.example.labo7.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7.database.GithubRepo
import com.example.labo7.database.RoomDB
import com.example.labo7.repository.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application): AndroidViewModel(app) {
    private val repository: GithubRepoRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDao()
        repository = GithubRepoRepository(repoDao)
    }

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()
}