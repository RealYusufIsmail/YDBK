package listeners

import ch.qos.logback.classic.Logger
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.LoggerFactory

class GeneralEvents : ListenerAdapter() {
    private val logger : Logger = LoggerFactory.getLogger(GeneralEvents::class.java) as Logger

    override fun onReady(event: ReadyEvent) {
        logger.info("Bot is ready!")
    }
}