package me.aleksilassila.islands.commands.subcommands;

import me.aleksilassila.islands.GUIs.CreateGUI;
import me.aleksilassila.islands.IslandLayout;
import me.aleksilassila.islands.Islands;
import me.aleksilassila.islands.commands.IslandManagmentCommands;
import me.aleksilassila.islands.commands.Subcommand;
import me.aleksilassila.islands.utils.Messages;
import me.aleksilassila.islands.utils.Permissions;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecreateSubcommand extends Subcommand {
    private final Islands plugin;
    private final IslandLayout layout;

    private final IslandManagmentCommands.Utils utils = new IslandManagmentCommands.Utils();

    public RecreateSubcommand(Islands plugin) {
        this.plugin = plugin;
        this.layout = plugin.layout;
    }

    @Override
    public void onCommand(Player player, String[] args, boolean confirmed) {
        HashMap<Biome, List<Location>> availableLocations = plugin.islandGeneration.biomes.availableLocations;
        String islandId;
        Biome targetBiome;

        int islandSize = args.length == 2 ? plugin.parseIslandSize(args[1]) : plugin.parseIslandSize("");

        String permissionRequired = plugin.getCreatePermission(islandSize);

        if (!player.hasPermission(permissionRequired)) {
            player.sendMessage(Messages.get("error.NO_PERMISSION"));
            return;
        }

        if (islandSize < plugin.getSmallestIslandSize() || islandSize + 4 >= layout.islandSpacing) {
            player.sendMessage(Messages.get("error.INVALID_ISLAND_SIZE"));
            return;
        }

        if (!player.getWorld().equals(plugin.islandsWorld)) {
            player.sendMessage(Messages.get("error.WRONG_WORLD"));
            return;
        }

        if (args.length < 1) {
            new CreateGUI(plugin, player);
            return;
        }

        if (!hasFunds(player, islandSize)) {
            player.sendMessage(Messages.get("error.INSUFFICIENT_FUNDS"));
            return;
        }

        islandId = layout.getIslandId(player.getLocation().getBlockX(), player.getLocation().getBlockZ());

        if (islandId == null) {
            player.sendMessage(Messages.get("error.NOT_ON_ISLAND"));
            return;
        } else if (!layout.getUUID(islandId).equals(player.getUniqueId().toString())
                && !player.hasPermission(Permissions.bypass.recreate)) {
            player.sendMessage(Messages.get("error.UNAUTHORIZED"));
            return;
        }

        targetBiome = utils.getTargetBiome(args[0]);

        if (targetBiome == null) {
            player.sendMessage(Messages.get("error.NO_BIOME_FOUND"));
            return;
        }

        if (!plugin.islandGeneration.biomes.availableLocations.containsKey(targetBiome)) {
            player.sendMessage(Messages.get("error.NO_LOCATIONS_FOR_BIOME"));
            return;
        }

        if (!confirmed) {
            player.sendMessage(Messages.get("info.CONFIRM"));
            return;
        }

        try {
            boolean success = plugin.recreateIsland(islandId, targetBiome, islandSize, player);

            if (!success) {
                player.sendMessage(Messages.get("error.ONGOING_QUEUE_EVENT"));
                return;
            }

            pay(player, islandSize);

            player.sendTitle(Messages.get("success.ISLAND_GEN_TITLE"), Messages.get("success.ISLAND_GEN_SUBTITLE"), 10, 20 * 7, 10);
        } catch (IllegalArgumentException e) {
            player.sendMessage(Messages.get("error.NO_LOCATIONS_FOR_BIOME"));
        }
    }

    private boolean hasFunds(Player player, int islandSize) {
        if (plugin.econ == null) return true;

        double cost = plugin.islandCosts.getOrDefault(islandSize, 0.0);
        cost += plugin.getConfig().getDouble("economy.recreateCost");

        return plugin.econ.has(player, cost);
    }

    private void pay(Player player, int islandSize) {
        if (plugin.econ == null) return;

        double cost = plugin.islandCosts.getOrDefault(islandSize, 0.0);
        cost += plugin.getConfig().getDouble("economy.recreateCost");

        plugin.econ.withdrawPlayer(player, cost);
        player.sendMessage(Messages.get("success.ISLAND_PURCHASED", cost));
    }

    @Override
    public List<String> onTabComplete(Player player, String[] args) {
        List<String> availableArgs = new ArrayList<>();

        if (args.length == 1) {
            HashMap<Biome, List<Location>> availableLocations = plugin.islandGeneration.biomes.availableLocations;

            for (Biome biome : availableLocations.keySet()) {
                availableArgs.add(biome.name());
            }

        } else if (args.length == 2) {
            availableArgs.addAll(plugin.definedIslandSizes.keySet());
        }

        return availableArgs;
    }

    @Override
    public String getName() {
        return "recreate";
    }

    @Override
    public String help() {
        return "Recreate island";
    }

    @Override
    public String getPermission() {
        return Permissions.command.recreate;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
