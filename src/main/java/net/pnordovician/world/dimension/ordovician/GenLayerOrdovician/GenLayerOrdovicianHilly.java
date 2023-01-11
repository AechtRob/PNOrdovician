package net.pnordovician.world.dimension.ordovician.GenLayerOrdovician;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOrdovicianHilly extends GenLayer
{
    //Normal:
    public Biome ORDOVICIAN_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_hills"));
    public int ORDOVICIAN_HILLS_ID =  Biome.getIdForBiome(ORDOVICIAN_HILLS);
    public Biome ORDOVICIAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_land"));
    public int ORDOVICIAN_LAND_ID =  Biome.getIdForBiome(ORDOVICIAN_LAND);

    //Frozen:
    public Biome ORDOVICIAN_HILLS_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_hills_frozen"));
    public int ORDOVICIAN_HILLS_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_HILLS_FROZEN);
    public Biome ORDOVICIAN_LAND_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_land_frozen"));
    public int ORDOVICIAN_LAND_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_LAND_FROZEN);


    private final int HillsBiomes[] = new int[] {
            ORDOVICIAN_LAND_ID,
            ORDOVICIAN_LAND_ID,
            ORDOVICIAN_HILLS_ID
    };

    private final int HillsBiomesFrozen[] = new int[] {
            ORDOVICIAN_LAND_FROZEN_ID,
            ORDOVICIAN_LAND_FROZEN_ID,
            ORDOVICIAN_HILLS_FROZEN_ID
    };

    public GenLayerOrdovicianHilly(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        return this.getIntsFloodBasalt(areaX, areaY, areaWidth, areaHeight);
    }

    private int[] getIntsFloodBasalt(int p_151626_1_, int p_151626_2_, int p_151626_3_, int p_151626_4_)
    {
        int i = p_151626_1_ - 1;
        int j = p_151626_2_ - 1;
        int k = 1 + p_151626_3_ + 1;
        int l = 1 + p_151626_4_ + 1;
        int[] aint = this.parent.getInts(i, j, k, l);
        int[] aint1 = IntCache.getIntCache(p_151626_3_ * p_151626_4_);

        for (int i1 = 0; i1 < p_151626_4_; ++i1)
        {
            for (int j1 = 0; j1 < p_151626_3_; ++j1)
            {
                this.initChunkSeed((long)(j1 + p_151626_1_), (long)(i1 + p_151626_2_));
                int k1 = aint[j1 + 1 + (i1 + 1) * k];

                if (k1 == ORDOVICIAN_LAND_ID)
                {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                        (l1 == ORDOVICIAN_LAND_ID)
                        && (i2 == ORDOVICIAN_LAND_ID)
                        && (j2 == ORDOVICIAN_LAND_ID)
                        && (k2 == ORDOVICIAN_LAND_ID)
                    );
                    if (flag)
                    {
                        k1 = HillsBiomes[nextInt(HillsBiomes.length)];
                    }
                }
                else if (k1 == ORDOVICIAN_LAND_FROZEN_ID)
                {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                        (l1 == ORDOVICIAN_LAND_FROZEN_ID)
                        && (i2 == ORDOVICIAN_LAND_FROZEN_ID)
                        && (j2 == ORDOVICIAN_LAND_FROZEN_ID)
                        && (k2 == ORDOVICIAN_LAND_FROZEN_ID)
                    );
                    if (flag)
                    {
                        k1 = HillsBiomesFrozen[nextInt(HillsBiomesFrozen.length)];
                    }
                }

                aint1[j1 + i1 * p_151626_3_] = k1;
            }
        }

        return aint1;
    }
    
}
