package com.jorbital.jorbichef

import com.apurebase.kgraphql.GraphQL
import com.jorbital.jorbichef.plugins.configureRouting
import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        install(GraphQL) {
            playground = true
            schema {
                schemaValue()
            }
        }
    }.start(wait = true)
}
