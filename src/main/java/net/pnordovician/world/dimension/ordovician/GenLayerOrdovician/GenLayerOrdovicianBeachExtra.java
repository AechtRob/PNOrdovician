package net.pnordovician.world.dimension.ordovician.GenLayerOrdovician;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOrdovicianBeachExtra extends GenLayer
{

    public Biome ORDOVICIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea"));
    public int ORDOVICIAN_OCEAN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN);
    public Biome ORDOVICIAN_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore"));
    public int ORDOVICIAN_OCEAN_SHORE_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_SHORE);

    public Biome ORDOVICIAN_LAGOON_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_lagoon_helper"));
    public int ORDOVICIAN_LAGOON_HELPER_ID =  Biome.getIdForBiome(ORDOVICIAN_LAGOON_HELPER);
    public Biome ORDOVICIAN_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_lagoon"));
    public int ORDOVICIAN_ESTUARY_ID =  Biome.getIdForBiome(ORDOVICIAN_ESTUARY);

    public Biome ORDOVICIAN_ALGAL_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_algal_reef"));
    public int ORDOVICIAN_ALGAL_REEF_ID =  Biome.getIdForBiome(ORDOVICIAN_ALGAL_REEF);
    public Biome ORDOVICIAN_BRYOZOAN_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_bryozoan_reef"));
    public int ORDOVICIAN_BRYOZOAN_REEF_ID =  Biome.getIdForBiome(ORDOVICIAN_BRYOZOAN_REEF);
    public Biome ORDOVICIAN_SPONGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sponge_forest"));
    public int ORDOVICIAN_SPONGE_ID =  Biome.getIdForBiome(ORDOVICIAN_SPONGE);
    public Biome ORDOVICIAN_OCEAN_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_ice"));
    public int ORDOVICIAN_OCEAN_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_FROZEN);
    public Biome ORDOVICIAN_OCEAN_ICEBERGS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_icebergs"));
    public int ORDOVICIAN_OCEAN_ICEBERGS_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_ICEBERGS);
    public Biome ORDOVICIAN_OCEAN_SHORE_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore_frozen"));
    public int ORDOVICIAN_OCEAN_SHORE_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_SHORE_FROZEN);


    public GenLayerOrdovicianBeachExtra(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                //if (k != ORDOVICIAN_BARREN_ID
                //)
                //{
                    if (isOcean(k))
                    {
                        int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                        int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                        int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                        int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                        if (!isLagoon(l1) && !isLagoon(k2) && !isLagoon(j3) && !isLagoon(i4))
                        {
                            aint1[j + i * areaWidth] = k;
                        }
                        else
                        {
                            aint1[j + i * areaWidth] = ORDOVICIAN_LAGOON_HELPER_ID;
                        }
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                //}
                //else
                //{
                //    aint1[j + i * areaWidth] = k;
                //}
            }
        }

        return aint1;
    }

    private boolean isOcean(int biomeID) {
        if (biomeID == ORDOVICIAN_OCEAN_ID || biomeID == ORDOVICIAN_OCEAN_SHORE_ID
                || biomeID == ORDOVICIAN_ALGAL_REEF_ID || biomeID == ORDOVICIAN_BRYOZOAN_REEF_ID || biomeID == ORDOVICIAN_SPONGE_ID
                || biomeID == ORDOVICIAN_OCEAN_FROZEN_ID || biomeID == ORDOVICIAN_OCEAN_SHORE_FROZEN_ID || biomeID == ORDOVICIAN_OCEAN_ICEBERGS_ID) {
            return true;
        }
        return false;
    }

    private boolean isLagoon(int biomeID) {
        if (biomeID == ORDOVICIAN_LAGOON_HELPER_ID || biomeID == ORDOVICIAN_ESTUARY_ID) {
            return true;
        }
        return false;
    }

}
