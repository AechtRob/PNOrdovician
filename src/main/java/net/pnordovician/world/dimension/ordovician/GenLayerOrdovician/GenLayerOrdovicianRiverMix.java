package net.pnordovician.world.dimension.ordovician.GenLayerOrdovician;

import net.lepidodendron.util.EnumBiomeTypeOrdovician;
import net.lepidodendron.world.biome.ordovician.BiomeOrdovician;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOrdovicianRiverMix extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    //Creeks to use:
    public Biome ORDOVICIAN_CREEK_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_creek_frozen"));
    public int ORDOVICIAN_CREEK_FROZEN_ID = Biome.getIdForBiome(ORDOVICIAN_CREEK_FROZEN);
    public Biome ORDOVICIAN_CREEK_COAST_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_creek_coastal"));
    public int ORDOVICIAN_CREEK_COAST_FROZEN_ID = Biome.getIdForBiome(ORDOVICIAN_CREEK_COAST_FROZEN);
    public Biome ORDOVICIAN_CREEK_COAST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_creek_coastal_frozen"));
    public int ORDOVICIAN_CREEK_COAST_ID = Biome.getIdForBiome(ORDOVICIAN_CREEK_COAST);
    public Biome ORDOVICIAN_CREEK_LAGOON = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_lagoon"));
    public int ORDOVICIAN_CREEK_LAGOON_ID =  Biome.getIdForBiome(ORDOVICIAN_CREEK_LAGOON);
    public Biome ORDOVICIAN_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_creek"));
    public int ORDOVICIAN_CREEK_ID =  Biome.getIdForBiome(ORDOVICIAN_CREEK);
    public Biome ORDOVICIAN_CREEK_BOG = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_creek_bog"));
    public int ORDOVICIAN_CREEK_BOG_ID =  Biome.getIdForBiome(ORDOVICIAN_CREEK_BOG);
    public Biome ORDOVICIAN_CREVASSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_ice_trench"));
    public int ORDOVICIAN_CREVASSE_ID =  Biome.getIdForBiome(ORDOVICIAN_CREVASSE);

    //Biomes to exclude for rivers:
    public Biome ORDOVICIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea"));
    public int ORDOVICIAN_OCEAN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN);
    public Biome ORDOVICIAN_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore"));
    public int ORDOVICIAN_OCEAN_SHORE_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_SHORE);
    public Biome ORDOVICIAN_OCEAN_SHORE_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_shore_frozen"));
    public int ORDOVICIAN_OCEAN_SHORE_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_SHORE_FROZEN);
    public Biome ORDOVICIAN_REEF_ALGAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_algal_reef"));
    public int OORDOVICIAN_REEF_ALGAL_ID =  Biome.getIdForBiome(ORDOVICIAN_REEF_ALGAL);
    public Biome ORDOVICIAN_REEF_BRYOZOAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_bryozoan_reef"));
    public int ORDOVICIAN_REEF_BRYOZOAN_ID =  Biome.getIdForBiome(ORDOVICIAN_REEF_BRYOZOAN);
    public Biome ORDOVICIAN_SPONGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sponge_forest"));
    public int ORDOVICIAN_SPONGE_ID =  Biome.getIdForBiome(ORDOVICIAN_SPONGE);

    public Biome ORDOVICIAN_OCEAN_FROZEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_ice"));
    public int ORDOVICIAN_OCEAN_FROZEN_ID =  Biome.getIdForBiome(ORDOVICIAN_OCEAN_FROZEN);
    public Biome ORDOVICIAN_ICEBERGS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:ordovician_sea_icebergs"));
    public int ORDOVICIAN_ICEBERGS_ID =  Biome.getIdForBiome(ORDOVICIAN_ICEBERGS);

    public GenLayerOrdovicianRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {
                //Exclude rivers here:
                if (aint[i] == ORDOVICIAN_OCEAN_ID
                        || aint[i] == ORDOVICIAN_OCEAN_SHORE_ID
                        || aint[i] == ORDOVICIAN_OCEAN_SHORE_FROZEN_ID
                        || aint[i] == OORDOVICIAN_REEF_ALGAL_ID
                        || aint[i] == ORDOVICIAN_REEF_BRYOZOAN_ID
                        || aint[i] == ORDOVICIAN_SPONGE_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    Biome biome = Biome.getBiome(aint[i]);
                    if (biome instanceof BiomeOrdovician) {
                        BiomeOrdovician biomeOrdovician = (BiomeOrdovician) biome;
                        if (biomeOrdovician.getBiomeType() == EnumBiomeTypeOrdovician.BarrenLand) {
                            aint2[i] = ORDOVICIAN_CREEK_ID;
                        }
                        else if (biomeOrdovician.getBiomeType() == EnumBiomeTypeOrdovician.Ocean) {
                            aint2[i] = ORDOVICIAN_CREEK_COAST_ID;
                        }
                        else if (biomeOrdovician.getBiomeType() == EnumBiomeTypeOrdovician.FrozenLand) {
                            aint2[i] = ORDOVICIAN_CREEK_FROZEN_ID;
                        }
                        else if (biomeOrdovician.getBiomeType() == EnumBiomeTypeOrdovician.FrozenOcean) {
                            if (aint[i] == ORDOVICIAN_OCEAN_FROZEN_ID || aint[i] == ORDOVICIAN_ICEBERGS_ID) {
                                aint2[i] = ORDOVICIAN_CREVASSE_ID;
                            }
                            else {
                                aint2[i] = ORDOVICIAN_CREEK_COAST_FROZEN_ID;
                            }
                        }
                        else if (biomeOrdovician.getBiomeType() == EnumBiomeTypeOrdovician.Bog) {
                            aint2[i] = ORDOVICIAN_CREEK_BOG_ID;
                        }
                        else if (biomeOrdovician.getBiomeType() == EnumBiomeTypeOrdovician.Estuary) {
                            aint2[i] = ORDOVICIAN_CREEK_LAGOON_ID;
                        }
                        else {
                            aint2[i] = aint[i];
                        }
                    }
                    else {
                        aint2[i] = aint[i];
                    }
                }
            }
            else
            {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }
}
