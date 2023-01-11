package net.pnordovician.world.dimension.ordovician.GenLayerOrdovician;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOrdovicianBiomes extends GenLayer {

    public Biome ORDOVICIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore"));
    public int ORDOVICIAN_OCEAN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN);
    public Biome ORDOVICIAN_OCEAN_ICE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore_frozen"));
    public int ORDOVICIAN_OCEAN_ICE_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_ICE);
    
    private final int OrdovicianBiomes[] = new int[] {
            //This dimensiin is a bit different.... first divide into frozen and normal zones:
            ORDOVICIAN_OCEAN_ID,
            ORDOVICIAN_OCEAN_ID,
            ORDOVICIAN_OCEAN_ICE_ID
    };

    public GenLayerOrdovicianBiomes(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        int dest[] = IntCache.getIntCache(width * height);
        for (int dz = 0; dz < height; dz++) {
            for (int dx = 0; dx < width; dx++) {
                initChunkSeed(dx + x, dz + z);
                dest[dx + dz * width] = OrdovicianBiomes[nextInt(OrdovicianBiomes.length)];
            }
        }
        return dest;
    }
}