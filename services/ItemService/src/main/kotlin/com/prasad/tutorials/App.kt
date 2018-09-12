package com.prasad.tutorials

import io.dropwizard.Configuration
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import javax.ws.rs.*

fun main(args: Array<String>) {
    ItemServiceApp().run(*args)
}

class ItemServiceConfig(val name: String = "unknown") : Configuration()

class ItemServiceApp : Application<ItemServiceConfig>() {
    override fun run(configuration: ItemServiceConfig, environment: Environment) {
        println("Running ${configuration.name}!")
        val itemServiceComponent = ItemServiceComponent()
        environment.jersey().register(itemServiceComponent)
    }
}

@Path("/")
class ItemServiceComponent {
    @Path("/")
    @GET
    fun getItem(): String {
        return "test Item"
    }

    @Path("/items")
    @GET
    fun getItems(): List<String> {
        return  ArrayList<String>()
    }

    @Path("/")
    @POST
    fun addItem(@QueryParam("itemName") itemName: String, @QueryParam("qty") qty: Integer): String {
        return "Added"
    }
}