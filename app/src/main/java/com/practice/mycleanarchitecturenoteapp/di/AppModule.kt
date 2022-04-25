package com.practice.mycleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.practice.mycleanarchitecturenoteapp.feature.note.data.datasource.NoteDatabase
import com.practice.mycleanarchitecturenoteapp.feature.note.data.repository.NoteRepositoryImpl
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.repository.NoteRepository
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.usecase.AddNote
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.usecase.DeleteNote
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.usecase.GetNotes
import com.practice.mycleanarchitecturenoteapp.feature.note.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application) =
        Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase) = NoteRepositoryImpl(db.noteDao)

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository) =
        NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
}