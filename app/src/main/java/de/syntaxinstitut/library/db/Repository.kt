package de.syntaxinstitut.library.db

import android.content.Context
import de.syntaxinstitut.library.data.exampleData.BookExamplesData

class Repository(private val database: BookDatabase) {

    /* -------------------- Objekte -------------------- */

    /**
     * Companion Object, welches innerhalb der Klasse definiert wird und Zugriff auf private Elemente der Klasse hat
     */
    companion object {
        private var repository: Repository? = null

        /**
         * Funktion um eine Instanz des Repositories zu erhalten
         *
         * @param	context		Der Context des aufrufenden ViewModels
         */
        fun getInstance(context: Context): Repository =
            repository ?: buildRepo(
                BookDatabase.getInstance(context.applicationContext)
            ).also {
                repository = it
            }

        /**
         * Lokale Funktion um ein Repository zu erstellen
         *
         * @param shoppingListDatabase    Die Datenbank mit der das Repo verknüpft werden soll
         *
         * @return Ein Repository
         */
        private fun buildRepo(shoppingListDatabase: BookDatabase): Repository =
            Repository(shoppingListDatabase)
    }

    /**
     * Funktion um Beispielwerte und Daten von der API bei leerer Datenbank in diese einzufügen
     */
    fun prepopulateDB() {
        try {
            if (database.library.getCount() == 0) {
                // Beispieleinträge für die Checkliste
                database.library.insertItem(BookExamplesData.book1)
                database.library.insertItem(BookExamplesData.book2)
                database.library.insertItem(BookExamplesData.book3)
                database.library.insertItem(BookExamplesData.book4)
                database.library.insertItem(BookExamplesData.book5)
                database.library.insertItem(BookExamplesData.book6)
                database.library.insertItem(BookExamplesData.book7)
                database.library.insertItem(BookExamplesData.book8)
                database.library.insertItem(BookExamplesData.book9)
            }
        } catch (e: Exception) { }
    }
}