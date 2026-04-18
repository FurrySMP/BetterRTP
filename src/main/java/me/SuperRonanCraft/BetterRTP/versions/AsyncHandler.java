package me.SuperRonanCraft.BetterRTP.versions;

import com.tcoded.folialib.impl.ServerImplementation;
import com.tcoded.folialib.wrapper.task.WrappedTask;
import me.SuperRonanCraft.BetterRTP.BetterRTP;
import org.bukkit.entity.Entity;

public class AsyncHandler {

    public static void async(Runnable runnable) {
        getFolia().runAsync(task -> runnable.run());
    }

    public static void sync(Runnable runnable) {
        getFolia().runNextTick(task -> runnable.run());
    }

    public static void syncAtEntity(Entity entity, Runnable runnable) {
        getFolia().runAtEntity(entity, task -> runnable.run());
    }

    public static void syncAtLocation(org.bukkit.Location loc, Runnable runnable) {
        getFolia().runAtLocation(loc, task -> runnable.run());
    }

    public static java.util.concurrent.CompletableFuture<Boolean> teleport(org.bukkit.entity.Entity entity, org.bukkit.Location location) {
        return getFolia().teleportAsync(entity, location);
    }

    public static WrappedTask asyncLater(Runnable runnable, long ticks) {
        return getFolia().runLaterAsync(runnable, ticks);
    }
    public static WrappedTask syncLater(Runnable runnable, long ticks) {
        return getFolia().runLater(runnable, ticks);
    }

    private static ServerImplementation getFolia() {
        return BetterRTP.getInstance().getFoliaHandler().get();
    }
}
