package me.SuperRonanCraft.BetterRTP.player.events;

import me.SuperRonanCraft.BetterRTP.player.rtp.RTPSetupInformation;
import me.SuperRonanCraft.BetterRTP.player.rtp.RTP_TYPE;
import me.SuperRonanCraft.BetterRTP.references.helpers.HelperRTP;
import me.SuperRonanCraft.BetterRTP.references.rtpinfo.worlds.WorldPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.SuperRonanCraft.BetterRTP.BetterRTP;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death {

    static void deathEvent(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (BetterRTP.getInstance().getCooldowns().isResetOnDeath()) {
            BetterRTP.getInstance().getCooldowns().removeCooldowns(p);
        }
    }

    static void respawnEvent(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        WorldPlayer worldPlayer = HelperRTP.getPlayerWorld(new RTPSetupInformation(
                p.getWorld(),
                p, p, false
        ));
        if (worldPlayer.getRTPOnDeath()) {
            HelperRTP.tp(p, p, p.getWorld(), null, RTP_TYPE.FORCED, true, true);
        }
    }
}
