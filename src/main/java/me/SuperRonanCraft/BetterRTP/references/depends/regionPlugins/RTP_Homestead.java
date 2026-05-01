package me.SuperRonanCraft.BetterRTP.references.depends.regionPlugins;

import org.bukkit.Location;
import tfagaming.projects.minecraft.homestead.managers.ChunkManager;

public class RTP_Homestead implements RegionPluginCheck {

    // Homestead (v5.1.0.1)
    // https://github.com/TayebYassine/Homestead
    public boolean check(Location loc) {
        boolean result = true;
        if (REGIONPLUGINS.HOMESTEAD.isEnabled())
            try {
                // If chunk is claimed, then it is NOT a valid teleport location
                result = !ChunkManager.isChunkClaimed(loc.getChunk());
            } catch (Exception e) {
                e.printStackTrace();
            }
        return result;
    }
}
