package net.pnordovician.world.dimension.ordovician.GenLayerOrdovician;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOrdovicianLagoon1 extends GenLayer
{

    public Biome ORDOVICIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea"));
    public int ORDOVICIAN_OCEAN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN);
    public Biome ORDOVICIAN_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore"));
    public int ORDOVICIAN_OCEAN_SHORE_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_SHORE);
    public Biome ORDOVICIAN_OCEAN_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_ice"));
    public int ORDOVICIAN_OCEAN_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_FROZEN);
    public Biome ORDOVICIAN_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_lagoon"));
    public int ORDOVICIAN_ESTUARY_ID =  Biome.getIdForBiome(ORDOVICIAN_ESTUARY);
    public Biome ORDOVICIAN_OCEAN_SHORE_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore_frozen"));
    public int ORDOVICIAN_OCEAN_SHORE_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_SHORE_FROZEN);
    public Biome ORDOVICIAN_OCEAN_ICEBERGS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_icebergs"));
    public int ORDOVICIAN_OCEAN_ICEBERGS_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_ICEBERGS);
    public Biome ORDOVICIAN_LAND_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_land_frozen"));
    public int ORDOVICIAN_LAND_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_LAND_FROZEN);
    public Biome ORDOVICIAN_HILLS_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_hills_frozen"));
    public int ORDOVICIAN_HILLS_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_HILLS_FROZEN);

    public GenLayerOrdovicianLagoon1(long seed, GenLayer genLayer)
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

                //if (k != ORDOVICIAN_HILLS_ID
                //        && k != ORDOVICIAN_ICE_EDGE_ID
                //        && k != ORDOVICIAN_ICE_ID
                //        && k != ORDOVICIAN_ICE_SPIKES_ID
                //        && k != ORDOVICIAN_HILLS_ID
                //        && k != ORDOVICIAN_HILLS_EDGE_ID
                //        && k != ORDOVICIAN_HILLS_CENTRE_ID
                //)
                {
                    if (!isOcean(k) && (!isFrozen(k)))
                    {
                        int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                        int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                        int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                        int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                        if (!isOcean(l1) && !isOcean(k2) && !isOcean(j3) && !isOcean(i4))
                        {
                            aint1[j + i * areaWidth] = k;
                        }
                        else
                        {
                            if (nextInt(3) == 0) {
                                aint1[j + i * areaWidth] = ORDOVICIAN_ESTUARY_ID;
                            }
                            else {
                                aint1[j + i * areaWidth] = k;
                            }
                        }
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
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
                || biomeID == ORDOVICIAN_OCEAN_FROZEN_ID || biomeID == ORDOVICIAN_OCEAN_SHORE_FROZEN_ID
                || biomeID == ORDOVICIAN_OCEAN_ICEBERGS_ID) {
            return true;
        }
        return false;
    }

    private boolean isFrozen(int biomeID) {
        if (biomeID == ORDOVICIAN_OCEAN_FROZEN_ID || biomeID == ORDOVICIAN_OCEAN_SHORE_FROZEN_ID
                || biomeID == ORDOVICIAN_LAND_FROZEN_ID || biomeID == ORDOVICIAN_HILLS_FROZEN_ID
                || biomeID == ORDOVICIAN_OCEAN_ICEBERGS_ID
        ) {
            return true;
        }
        return false;
    }


}
