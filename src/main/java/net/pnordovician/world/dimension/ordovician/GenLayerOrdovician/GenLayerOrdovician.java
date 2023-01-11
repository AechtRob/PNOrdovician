package net.pnordovician.world.dimension.ordovician.GenLayerOrdovician;

import net.lepidodendron.LepidodendronConfig;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public class GenLayerOrdovician {

    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        GenLayer biomes = new GenLayerOrdovicianBiomes(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);
        if (!LepidodendronConfig.doShrinkBiomes) {
            biomes = new GenLayerZoom(2001L, biomes);
        }
        //Set some of the normal sea to land, but leave frozen sea for the moment:
        biomes = new GenLayerDiversifyOrdovician1(700L, biomes);
        biomes = new GenLayerZoom(1000L, biomes);
        //Now diversify the land more:
        biomes = new GenLayerDiversifyOrdovician2(700L, biomes);

        biomes = new GenLayerFuzzyZoom(2900L, biomes);
        //Seed the lagoons:
        biomes = new GenLayerOrdovicianLagoon1(1000L, biomes);
        //Add ocean sub-biomes:
        biomes = new GenLayerDiversifyOceanOrdovician(3005L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerOrdovicianDeepOcean(1109L, biomes);
        biomes = new GenLayerOrdovicianShallowOcean(1400L, biomes);

        biomes = new GenLayerOrdovicianLagoon2(1000L, biomes);
        biomes = new GenLayerOrdovicianHilly(777L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);

        biomes = new GenLayerOrdovicianLagoon2(1000L, biomes);

        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerOrdovicianHilly(220L, biomes);

        biomes = new GenLayerOrdovicianBeach(1050L, biomes);
        biomes = new GenLayerZoom(1005L, biomes);

        biomes = new GenLayerOrdovicianLagoon2(1000L, biomes);
        biomes = new GenLayerOrdovicianBeachExtra(2869L, biomes);
        biomes = new GenLayerOrdovicianSnowyBorder(354L, biomes);
        biomes = new GenLayerOrdovicianCraggy(778L, biomes);

        biomes = new GenLayerSmooth(703L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);

        biomes = new GenLayerSmooth(705L, biomes);
        biomes = new GenLayerFuzzyZoom(1001L, biomes);
        biomes = new GenLayerZoom(1006L, biomes);


        //Build and superimpose creeks:
        GenLayer genlayercreek = new GenLayerRiverInit(100L, biomes);
        GenLayer genlayercreek2 = GenLayerZoom.magnify(1000L, genlayercreek, 1);
        GenLayer genlayercreek3 = GenLayerZoom.magnify(1000L, genlayercreek2, 2);
        GenLayer genlayercreek4 = GenLayerZoom.magnify(1000L, genlayercreek3, 2);
        GenLayer genlayercreek5 = GenLayerZoom.magnify(1000L, genlayercreek4, 2);
        GenLayer genlayercreek6 = new GenLayerRiver(1L, genlayercreek5);
        GenLayer genlayercreek7 = new GenLayerSmooth(1000L, genlayercreek6);
        GenLayer genlayercreekfinal = new GenLayerOrdovicianRiverMix(100L, biomes, genlayercreek7);

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayercreekfinal);

        genlayercreekfinal.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        genlayervoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayercreekfinal, genlayervoronoizoom, genlayercreekfinal });
    }

}