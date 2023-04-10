package cn.Yumcraft

import org.black_ixx.playerpoints.PlayerPoints
import org.black_ixx.playerpoints.PlayerPointsAPI
import org.bukkit.event.player.PlayerFishEvent
import taboolib.common.platform.Plugin
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.console
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigFile
import taboolib.platform.BukkitPlugin


object ExamplePlugin : Plugin() {

    val pointsAPI: PlayerPointsAPI by lazy { PlayerPoints.getInstance().api }

    val plugin by lazy { BukkitPlugin.getInstance() }


    @Config(value = "config.yml", autoReload = true)
    lateinit var config: ConfigFile

    override fun onEnable() {
        runMessage()
    }
    private fun runMessage(){
        console().sendMessage("")
        console().sendMessage("")
        console().sendMessage("§f    ______   _            __       ____              _             __ ")
        console().sendMessage("§f   / ____/  (_)  _____   / /_     / __ \\   ____     (_)  ____     / /_")
        console().sendMessage("§f  / /_     / /  / ___/  / __ \\   / /_/ /  / __ \\   / /  / __ \\   / __/")
        console().sendMessage("§f / __/    / /  (__  )  / / / /  / ____/  / /_/ /  / /  / / / /  / /_  ")
        console().sendMessage("§f/_/      /_/  /____/  /_/ /_/  /_/       \\____/  /_/  /_/ /_/   \\__/  ")
        console().sendMessage("")
        console().sendMessage("         §f${plugin.description.name}  §7by §fYumcraft.cn  §7version: §f${plugin.description.version}")
        console().sendMessage("  §7适用于Bukkit: §f1.19-1.19.2  §7当前: §f${plugin.server.version}")
        console().sendMessage("")
        console().sendMessage("")
    }

    //钓鱼事件
    @SubscribeEvent(priority = EventPriority.LOW, ignoreCancelled = true )
    fun onFishing( e : PlayerFishEvent){
        if(e.state == PlayerFishEvent.State.CAUGHT_FISH){
            if (CoreCode.destiny(setLevel(1))){
                pointsAPI.give(e.player.uniqueId, config.getInt("points"))
                e.player.sendMessage("获取1点券")
            }
        }
    }

    fun setLevel(level:Int): IntArray {
        val destiny= IntArray(level+1)
        for (level in 0..level){
            destiny[level] = level
        }
        return destiny
    }

}
