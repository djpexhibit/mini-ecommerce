package com.prasad.tutorials.store

import com.prasad.tutorials.model.Item

class InMemoryDB:DB{

    private val itemMap:HashMap<String,Item> = HashMap<String,Item>()

    override fun add(item: Item) {
        itemMap.put(item.itemName,item)
    }

    override fun getItems(): Map<String,Item> {
//        itemMap.put("test",Item("test", Integer(2)))
//        println(itemMap)
        return itemMap
    }
}