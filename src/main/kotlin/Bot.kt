import ch.qos.logback.classic.Logger
import dev.minn.jda.ktx.jdabuilder.cache
import dev.minn.jda.ktx.jdabuilder.default
import dev.minn.jda.ktx.jdabuilder.intents
import listeners.GeneralEvents
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.cache.CacheFlag
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
    val logger = LoggerFactory.getLogger("net.dv8tion.jda") as Logger
    logger.level = ch.qos.logback.classic.Level.OFF
    //create JDA instance
    val jda = default(BotConfig.getToken(), true) {
        intents += EnumSet.allOf(GatewayIntent::class.java)
        cache += listOf(CacheFlag.ONLINE_STATUS, CacheFlag.VOICE_STATE, CacheFlag.CLIENT_STATUS)
        cache -= listOf(CacheFlag.ACTIVITY, CacheFlag.EMOJI, CacheFlag.MEMBER_OVERRIDES)
        setActivity(Activity.listening("to your commands"))
        build()
    }

    //add event listeners
    jda.addEventListener(GeneralEvents())
}