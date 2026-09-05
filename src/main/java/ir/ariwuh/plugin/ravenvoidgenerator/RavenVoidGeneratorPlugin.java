package ir.ariwuh.plugin.ravenvoidgenerator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class RavenVoidGeneratorPlugin extends JavaPlugin {

    @Override
    public @NotNull ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
        return new ChunkGenerator() {

            @Override
            public BiomeProvider getDefaultBiomeProvider(@NotNull WorldInfo worldInfo) {
                return new BiomeProvider() {
                    @Override
                    public @NotNull Biome getBiome(@NotNull WorldInfo worldInfo, int x, int y, int z) {
                        return Biome.PLAINS;
                    }

                    @Override
                    public @NotNull List<Biome> getBiomes(@NotNull WorldInfo worldInfo) {
                        return Collections.singletonList(Biome.PLAINS);
                    }
                };
            }

            @Override
            public Location getFixedSpawnLocation(@NotNull World world, @NotNull Random random) {
                return new Location(world, 0.5, 64.5, 0.5, 0, 0);
            }

            @Override
            public void generateBedrock(@NotNull WorldInfo worldInfo,
                                        @NotNull Random random,
                                        int chunkX, int chunkZ,
                                        @NotNull ChunkGenerator.ChunkData chunkData) {
                final int x = 0, y = 64, z = 0;

                if ((x >= chunkX * 16) && (x < (chunkX + 1) * 16))
                    if ((z >= chunkZ * 16) && (z < (chunkZ + 1) * 16))
                        chunkData.setBlock(x, y, z, Material.BEDROCK);
            }
        };
    }

}