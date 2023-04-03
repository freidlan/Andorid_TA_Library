package de.syntaxinstitut.library.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.syntaxinstitut.library.data.dataclasses.BookData

@Dao
interface BookDao {
    /* -------------------- Hinzufüge Funktionen -------------------- */

    /**
     * Methode zum Einfügen eines Elementes in die appartment_table
     *
     * @param ItemData        Das Item das eingefügt werden soll
     */
    @Insert
    fun insertItem(ItemData: BookData)

    /**
     * Methode um sich die Anzahl der Elemente der appartment_table auszugeben
     *
     * @return Anzahl der Datensätze
     */
    @Query("SELECT COUNT(*) FROM book_table")
    fun getCount(): Int
}