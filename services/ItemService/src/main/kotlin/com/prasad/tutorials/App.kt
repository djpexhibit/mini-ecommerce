package com.prasad.tutorials

import com.prasad.tutorials.model.Item
import com.prasad.tutorials.service.ItemService
import io.dropwizard.Configuration
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ItemServiceComponent {

    private val service = ItemService()

    @Path("/")
    @GET
    fun getItem(): String {
        return "test Item"
    }

    @Path("/items")
    @GET
    fun getItems(): List<Item> {
        return  service.getAllItems()
    }

    @Path("/")
    @POST
    fun addItem(@NotNull item:Item): String {
        service.addItem(item)
        return "added"
    }
}