package net.pnordovician.world.dimension.ordovician.GenLayerOrdovician;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOrdovicianDeepOcean extends GenLayer
{

    //Normal:
    public Biome ORDOVICIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore"));
    public int ORDOVICIAN_OCEAN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN);
    public Biome ORDOVICIAN_OCEAN_DEEP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea"));
    public int ORDOVICIAN_OCEAN_DEEP_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_DEEP);
    public Biome ORDOVICIAN_ALGAL_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_algal_reef"));
    public int ORDOVICIAN_ALGAL_REEF_ID =  Biome.getIdForBiome(ORDOVICIAN_ALGAL_REEF);
    public Biome ORDOVICIAN_BRYOZOAN_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_bryozoan_reef"));
    public int ORDOVICIAN_BRYOZOAN_REEF_ID =  Biome.getIdForBiome(ORDOVICIAN_BRYOZOAN_REEF);
    public Biome ORDOVICIAN_SPONGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sponge_forest"));
    public int ORDOVICIAN_SPONGE_ID =  Biome.getIdForBiome(ORDOVICIAN_SPONGE);

    //Frozen:
    public Biome ORDOVICIAN_OCEAN_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore_frozen"));
    public int ORDOVICIAN_OCEAN_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_FROZEN);
    public Biome ORDOVICIAN_OCEAN_DEEP_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_ice"));
    public int ORDOVICIAN_OCEAN_DEEP_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_DEEP_FROZEN);
    public Biome ORDOVICIAN_OCEAN_ICEBERGS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_icebergs"));
    public int ORDOVICIAN_OCEAN_ICEBERGS_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_ICEBERGS);

    public GenLayerOrdovicianDeepOcean(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        return this.getIntsOcean(areaX, areaY, areaWidth, areaHeight);
    }

    private int[] getIntsOcean(int p_151626_1_, int p_151626_2_, int p_151626_3_, int p_151626_4_)
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

                if (k1 == ORDOVICIAN_OCEAN_ID)
                {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                        (l1 == ORDOVICIAN_OCEAN_ID || l1 == ORDOVICIAN_OCEAN_DEEP_ID || l1 == ORDOVICIAN_ALGAL_REEF_ID || l1 == ORDOVICIAN_BRYOZOAN_REEF_ID || l1 == ORDOVICIAN_SPONGE_ID)
                        && (i2 == ORDOVICIAN_OCEAN_ID || i2 == ORDOVICIAN_OCEAN_DEEP_ID || i2 == ORDOVICIAN_ALGAL_REEF_ID || i2 == ORDOVICIAN_BRYOZOAN_REEF_ID || i2 == ORDOVICIAN_SPONGE_ID)
                        && (j2 == ORDOVICIAN_OCEAN_ID || j2 == ORDOVICIAN_OCEAN_DEEP_ID || j2 == ORDOVICIAN_ALGAL_REEF_ID || j2 == ORDOVICIAN_BRYOZOAN_REEF_ID || j2 == ORDOVICIAN_SPONGE_ID)
                        && (k2 == ORDOVICIAN_OCEAN_ID || k2 == ORDOVICIAN_OCEAN_DEEP_ID || k2 == ORDOVICIAN_ALGAL_REEF_ID || k2 == ORDOVICIAN_BRYOZOAN_REEF_ID || k2 == ORDOVICIAN_SPONGE_ID)
                    );
                    if (flag)
                    {
                        k1 = ORDOVICIAN_OCEAN_DEEP_ID;
                    }
                }
                else if (k1 == ORDOVICIAN_OCEAN_FROZEN_ID)
                {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                        (l1 == ORDOVICIAN_OCEAN_FROZEN_ID || l1 == ORDOVICIAN_OCEAN_DEEP_FROZEN_ID || l1 == ORDOVICIAN_OCEAN_ICEBERGS_ID)
                        && (i2 == ORDOVICIAN_OCEAN_FROZEN_ID || i2 == ORDOVICIAN_OCEAN_DEEP_FROZEN_ID || i2 == ORDOVICIAN_OCEAN_ICEBERGS_ID)
                        && (j2 == ORDOVICIAN_OCEAN_FROZEN_ID || j2 == ORDOVICIAN_OCEAN_DEEP_FROZEN_ID || j2 == ORDOVICIAN_OCEAN_ICEBERGS_ID)
                        && (k2 == ORDOVICIAN_OCEAN_FROZEN_ID || k2 == ORDOVICIAN_OCEAN_DEEP_FROZEN_ID || k2 == ORDOVICIAN_OCEAN_ICEBERGS_ID)
                    );
                    if (flag)
                    {
                        k1 = ORDOVICIAN_OCEAN_DEEP_FROZEN_ID;
                    }
                }

                aint1[j1 + i1 * p_151626_3_] = k1;
            }
        }

        return aint1;
    }
    
}
