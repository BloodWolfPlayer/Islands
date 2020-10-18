package me.aleksilassila.islands.utils;

import org.bukkit.Material;

public enum BiomeMaterials {
    OCEAN(Material.WATER_BUCKET),
    PLAINS(Material.GRASS_BLOCK),
    DESERT(Material.SAND),
    MOUNTAINS(Material.STONE),
    FOREST(Material.OAK_WOOD),
    TAIGA(Material.SPRUCE_WOOD),
    SWAMP(Material.BLUE_ORCHID),
    RIVER(Material.WATER_BUCKET),
    NETHER_WASTES(Material.NETHERRACK),
    THE_END(Material.END_STONE),
    FROZEN_OCEAN(Material.ICE),
    FROZEN_RIVER(Material.ICE),
    SNOWY_TUNDRA(Material.SNOW_BLOCK),
    SNOWY_MOUNTAINS(Material.SNOW_BLOCK),
    MUSHROOM_FIELDS(Material.RED_MUSHROOM),
    MUSHROOM_FIELD_SHORE(Material.RED_MUSHROOM),
    BEACH(Material.SAND),
    DESERT_HILLS(Material.SAND),
    WOODED_HILLS(Material.OAK_WOOD),
    TAIGA_HILLS(Material.SPRUCE_WOOD),
    MOUNTAIN_EDGE(Material.STONE),
    JUNGLE(Material.JUNGLE_WOOD),
    JUNGLE_HILLS(Material.JUNGLE_WOOD),
    JUNGLE_EDGE(Material.JUNGLE_WOOD),
    DEEP_OCEAN(Material.WATER_BUCKET),
    STONE_SHORE(Material.STONE),
    SNOWY_BEACH(Material.SAND),
    BIRCH_FOREST(Material.BIRCH_WOOD),
    BIRCH_FOREST_HILLS(Material.BIRCH_WOOD),
    DARK_FOREST(Material.DARK_OAK_WOOD),
    SNOWY_TAIGA(Material.SPRUCE_WOOD),
    SNOWY_TAIGA_HILLS(Material.SPRUCE_WOOD),
    GIANT_TREE_TAIGA(Material.PODZOL),
    GIANT_TREE_TAIGA_HILLS(Material.PODZOL),
    WOODED_MOUNTAINS(Material.OAK_WOOD),
    SAVANNA(Material.ACACIA_WOOD),
    SAVANNA_PLATEAU(Material.ACACIA_WOOD),
    BADLANDS(Material.TERRACOTTA),
    WOODED_BADLANDS_PLATEAU(Material.TERRACOTTA),
    BADLANDS_PLATEAU(Material.TERRACOTTA),
    SMALL_END_ISLANDS(Material.END_STONE),
    END_MIDLANDS(Material.END_STONE),
    END_HIGHLANDS(Material.END_STONE),
    END_BARRENS(Material.END_STONE),
    WARM_OCEAN(Material.WATER_BUCKET),
    LUKEWARM_OCEAN(Material.FIRE_CORAL),
    COLD_OCEAN(Material.WATER_BUCKET),
    DEEP_WARM_OCEAN(Material.WATER_BUCKET),
    DEEP_LUKEWARM_OCEAN(Material.FIRE_CORAL),
    DEEP_COLD_OCEAN(Material.WATER_BUCKET),
    DEEP_FROZEN_OCEAN(Material.WATER_BUCKET),
    THE_VOID(Material.END_PORTAL),
    SUNFLOWER_PLAINS(Material.SUNFLOWER),
    DESERT_LAKES(Material.SAND),
    GRAVELLY_MOUNTAINS(Material.STONE),
    FLOWER_FOREST(Material.ROSE_BUSH),
    TAIGA_MOUNTAINS(Material.SPRUCE_WOOD),
    SWAMP_HILLS(Material.BLUE_ORCHID),
    ICE_SPIKES(Material.ICE),
    MODIFIED_JUNGLE(Material.JUNGLE_WOOD),
    MODIFIED_JUNGLE_EDGE(Material.JUNGLE_WOOD),
    TALL_BIRCH_FOREST(Material.BIRCH_WOOD),
    TALL_BIRCH_HILLS(Material.BIRCH_WOOD),
    DARK_FOREST_HILLS(Material.BIRCH_WOOD),
    SNOWY_TAIGA_MOUNTAINS(Material.SPRUCE_WOOD),
    GIANT_SPRUCE_TAIGA(Material.PODZOL),
    GIANT_SPRUCE_TAIGA_HILLS(Material.PODZOL),
    MODIFIED_GRAVELLY_MOUNTAINS(Material.STONE),
    SHATTERED_SAVANNA(Material.ACACIA_WOOD),
    SHATTERED_SAVANNA_PLATEAU(Material.ACACIA_WOOD),
    ERODED_BADLANDS(Material.TERRACOTTA),
    MODIFIED_WOODED_BADLANDS_PLATEAU(Material.TERRACOTTA),
    MODIFIED_BADLANDS_PLATEAU(Material.TERRACOTTA),
    BAMBOO_JUNGLE(Material.BAMBOO),
    BAMBOO_JUNGLE_HILLS(Material.BAMBOO),
    SOUL_SAND_VALLEY(Material.SOUL_SAND),
    CRIMSON_FOREST(Material.CRIMSON_STEM),
    WARPED_FOREST(Material.WARPED_STEM),
    BASALT_DELTAS(Material.BASALT),
    DEFAULT(null);

    Material material;

    BiomeMaterials(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return this.material != null ? this.material : Material.DIRT;
    }
}