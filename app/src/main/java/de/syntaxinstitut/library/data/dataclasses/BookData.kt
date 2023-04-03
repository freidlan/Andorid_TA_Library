package de.syntaxinstitut.library.data.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")

data class BookData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var author: String,
    var verlag: String,
    var jahr: Int
)