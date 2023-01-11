package net.pnordovician.world.dimension.ordovician.GenLayerOrdovician;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOrdovicianSnowyBorder extends GenLayer
{

    public Biome ORDOVICIAN_SNOWY_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_land_frozen"));
    public int ORDOVICIAN_SNOWY_LAND_ID =  Biome.getIdForBiome(ORDOVICIAN_SNOWY_LAND);
    public Biome ORDOVICIAN_FLAT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_land_flat"));
    public int ORDOVICIAN_FLAT_ID =  Biome.getIdForBiome(ORDOVICIAN_FLAT);
    public Biome ORDOVICIAN_BARREN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_hills"));
    public int ORDOVICIAN_BARREN_ID =  Biome.getIdForBiome(ORDOVICIAN_BARREN);


    public GenLayerOrdovicianSnowyBorder(long seed, GenLayer genLayer)
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

                if (isFrozen(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((!isFrozen(l1) && !isExemptforFrozen(l1))
                        || (!isFrozen(k2) && !isExemptforFrozen(k2))
                        || (!isFrozen(j3) && !isExemptforFrozen(j3))
                        || (!isFrozen(i4) && !isExemptforFrozen(i4))
                    )
                    {
                        aint1[j + i * areaWidth] = ORDOVICIAN_BARREN_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isFrozen(int biomeID) {
        if (biomeID == ORDOVICIAN_SNOWY_LAND_ID) {
            return true;
        }
        return false;
    }

    private boolean isExemptforFrozen(int biomeID) {
        if (biomeID != ORDOVICIAN_FLAT_ID) {
            return true;
        }
        return false;
    }

}
