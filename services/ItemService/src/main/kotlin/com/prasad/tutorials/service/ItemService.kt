package com.prasad.tutorials.service

import com.prasad.tutorials.model.Item
import com.prasad.tutorials.store.InMemoryDB

class ItemService{

    private val db = InMemoryDB()

    fun getAllItems(): List<Item>{
        return ArrayList<Item>(db.getItems().values)
    }

    fun addItem(item: Item){
        db.add(item)
    }
}