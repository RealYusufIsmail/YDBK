import io.github.yusufsdiscordbot.config.Config

class BotConfig {
    //equivalent of public static in java
    companion object {
        fun getToken() : String = Config.getString("TOKEN")
    }
}