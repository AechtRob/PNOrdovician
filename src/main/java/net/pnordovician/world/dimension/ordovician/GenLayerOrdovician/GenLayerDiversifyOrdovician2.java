package net.pnordovician.world.dimension.ordovician.GenLayerOrdovician;

import net.lepidodendron.util.EnumBiomeTypeCambrian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnordovician.world.biome.ordovician.BiomeOrdovicianSeaShore;
import net.pnordovician.world.biome.ordovician.BiomeOrdovicianSeaShoreFrozen;

public class GenLayerDiversifyOrdovician2 extends GenLayer {

    //Normal:
    public Biome ORDOVICIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore"));
    public int ORDOVICIAN_OCEAN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN);
    public Biome ORDOVICIAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_land"));
    public int ORDOVICIAN_LAND_ID =  Biome.getIdForBiome(ORDOVICIAN_LAND);
    public Biome ORDOVICIAN_BOG = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_bog"));
    public int ORDOVICIAN_BOG_ID =  Biome.getIdForBiome(ORDOVICIAN_BOG);
    public Biome ORDOVICIAN_LAND_FLAT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_land_flat"));
    public int ORDOVICIAN_LAND_FLAT_ID =  Biome.getIdForBiome(ORDOVICIAN_LAND_FLAT);

    //Frozen:
    public Biome ORDOVICIAN_OCEAN_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore_frozen"));
    public int ORDOVICIAN_OCEAN_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_FROZEN);
    public Biome ORDOVICIAN_LAND_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_land_frozen"));
    public int ORDOVICIAN_LAND_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_LAND_FROZEN);

    private final int OrdovicianBiomes[] = new int[] {
            ORDOVICIAN_OCEAN_ID,
            ORDOVICIAN_OCEAN_ID,
            ORDOVICIAN_OCEAN_ID,
            ORDOVICIAN_LAND_ID,
            ORDOVICIAN_LAND_ID,
            ORDOVICIAN_BOG_ID,
            ORDOVICIAN_LAND_FLAT_ID
    };

    private final int OrdovicianBiomesFrozen[] = new int[] {
            ORDOVICIAN_OCEAN_FROZEN_ID,
            ORDOVICIAN_OCEAN_FROZEN_ID,
            ORDOVICIAN_LAND_FROZEN_ID
    };

    public GenLayerDiversifyOrdovician2(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int input[] = this.parent.getInts(x, z, width, height);
        int output[] = IntCache.getIntCache(width * height);
        EnumBiomeTypeCambrian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeOrdovicianSeaShore.biome)
                        output[i] = OrdovicianBiomes[nextInt(OrdovicianBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeOrdovicianSeaShoreFrozen.biome)
                        output[i] = OrdovicianBiomesFrozen[nextInt(OrdovicianBiomesFrozen.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}