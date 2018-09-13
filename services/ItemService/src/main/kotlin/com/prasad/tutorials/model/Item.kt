package com.prasad.tutorials.model

import javax.validation.constraints.NotNull

//import com.fasterxml.jackson.module.kotlin.*


data class Item(@NotNull val itemName: String = "dd",@NotNull val qty: Int = 2)

//val mapper = jacksonObjectMapper()
//
//val state = mapper.readValue<Item>(json)