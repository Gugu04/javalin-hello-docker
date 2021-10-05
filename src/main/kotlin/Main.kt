import io.javalin.Javalin
import io.javalin.http.Context
import java.time.LocalTime
import java.time.format.DateTimeFormatter


fun main() {
    val app = Javalin.create().start(7000)
    app.routes {
        app.get("/") { ctx -> ctx.result("Hola Javalin") }
        app.get("api/{name}",WelcomeController::get)
    }
}

object WelcomeController {
    fun get(ctx: Context) {
        ctx.result("Bienvenido ${ctx.pathParam("name")} "+
                "son las ${DateTimeFormatter.ofPattern("hh:mm:ss a")
                    .format( LocalTime.now())}")
    }
}