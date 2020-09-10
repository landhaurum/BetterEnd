package com.dfsek.betterend.world.generators.biomes;

import org.bukkit.Material;
import org.polydev.gaea.biome.BiomeTerrain;
import org.polydev.gaea.math.FastNoise;
import org.polydev.gaea.world.BlockPalette;

public class ShatteredEndGenerator extends BiomeTerrain {
    private final BlockPalette palette;
    private final FastNoise shattered;

    public ShatteredEndGenerator() {
        super();
        shattered = new FastNoise();
        shattered.setNoiseType(FastNoise.NoiseType.SimplexFractal);
        shattered.setFrequency(0.1f);
        shattered.setFractalOctaves(3);
        this.palette = new BlockPalette().add(Material.END_STONE, 1);
    }

    @Override
    public double getNoise(FastNoise gen, int x, int z) {
        if(shattered.getSeed() != gen.getSeed()) shattered.setSeed(gen.getSeed());
        return gen.getSimplexFractal(x, z) + 0.3 * shattered.getSimplexFractal(x, z);
    }

    @Override
    public double getNoise(FastNoise fastNoise, int i, int i1, int i2) {
        return getNoise(fastNoise, i, i1);
    }

    @Override
    public BlockPalette getPalette(int y) {
        return this.palette;
    }
}
