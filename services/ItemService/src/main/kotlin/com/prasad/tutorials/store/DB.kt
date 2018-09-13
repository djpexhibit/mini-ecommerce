package com.prasad.tutorials.store

import com.prasad.tutorials.model.Item

interface DB{
    fun add(item:Item)
    fun getItems(): Map<String,Item>
}