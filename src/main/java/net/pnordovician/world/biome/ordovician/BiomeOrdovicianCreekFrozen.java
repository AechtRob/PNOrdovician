
package net.pnordovician.world.biome.ordovician;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeOrdovician;
import net.lepidodendron.world.biome.ordovician.BiomeOrdovician;
import net.lepidodendron.world.gen.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeOrdovicianCreekFrozen extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:ordovician_creek_frozen")
	public static final BiomeGenCustom biome = null;
	public BiomeOrdovicianCreekFrozen(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WASTELAND);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DEAD);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SNOWY);
	}

	static class BiomeGenCustom extends BiomeOrdovician {
		public BiomeGenCustom() {
			super(new BiomeProperties("Ordovician Frozen Creek").setRainfall(0.5F).setBaseHeight(-0.525F).setHeightVariation(0.0F).setTemperature(-1.8F).setSnowEnabled());
			setRegistryName("lepidodendron:ordovician_creek_frozen");
			this.topBlock = Blocks.SNOW.getDefaultState();
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenRockPiles ROCK_PILES_GENERATOR = new WorldGenRockPiles();
		protected static final WorldGenSnow SNOW_GENERATOR = new WorldGenSnow();
		protected static final WorldGenIceOnSea ICE_GENERATOR = new WorldGenIceOnSea();
		protected static final WorldGenSingleStaticInWaterUpwards STATIC_GENERATOR = new WorldGenSingleStaticInWaterUpwards();
		protected static final WorldGenSingleStaticInWaterRotational STATIC_ROTATIONAL_GENERATOR = new WorldGenSingleStaticInWaterRotational();
		protected static final WorldGenSingleStaticInWaterSideways STATIC_SIDEWAYS_GENERATOR = new WorldGenSingleStaticInWaterSideways();
		protected static final WorldGenSingleAnemoneSea ANEMONE_GENERATOR = new WorldGenSingleAnemoneSea();
		protected static final WorldGenSingleSponge SPONGE_GENERATOR = new WorldGenSingleSponge();
		protected static final WorldGenSingleSpongeSideways SPONGE_SIDEWAYS_GENERATOR = new WorldGenSingleSpongeSideways();
		protected static final WorldGenSingleBlastoid BLASTOID_GENERATOR = new WorldGenSingleBlastoid();
		protected static final WorldGenSingleBlastoidSideways BLASTOID_SIDEWAYS_GENERATOR = new WorldGenSingleBlastoidSideways();
		protected static final WorldGenSingleFenestella FENESTELLA_GENERATOR = new WorldGenSingleFenestella();
		protected static final WorldGenSingleFenestellaSideways FENESTELLA_SIDEWAYS_GENERATOR = new WorldGenSingleFenestellaSideways();
		protected static final WorldGenSingleRugoseCoral RUGOSA_GENERATOR = new WorldGenSingleRugoseCoral();
		protected static final WorldGenSingleRugoseCoralSideways RUGOSA_SIDEWAYS_GENERATOR = new WorldGenSingleRugoseCoralSideways();
		protected static final WorldGenSingleTabulateCoral TABULATE_GENERATOR = new WorldGenSingleTabulateCoral();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return null;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

	        if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
	        {
	        	int i = rand.nextInt(2);
	            for (int j = 0; j < i; ++j)
	            {
	                int k = rand.nextInt(16) + 8;
	                int l = rand.nextInt(16) + 8;
	                BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
	                ROCK_PILES_GENERATOR.generate(worldIn, rand, blockpos);
	            }
	        }

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ICE)) {
				int i = rand.nextInt(48);

				for (int j = 0; j < i; ++j) {
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					//if (worldIn.getBlockState(blockpos.down()).getMaterial() != Material.WATER) {
					ICE_GENERATOR.generate(worldIn, rand, blockpos,0);
					//}
				}

				i = rand.nextInt(32);

				for (int j = 0; j < i; ++j) {
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					SNOW_GENERATOR.generate(worldIn, rand, blockpos, 0);
				}







				if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
					for (int ii = 0; ii < 17; ++ii)
					{
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getSeaLevel() + 25);
						STATIC_GENERATOR.generate(BlockGreenAlgaeMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 35, 255);
					}

				if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
					for (int ii = 0; ii < 27; ++ii)
					{
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getSeaLevel() + 25);
						STATIC_GENERATOR.generate(BlockGreenCrustedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 35, 255);
					}

				if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
					for (int ii = 0; ii < 27; ++ii)
					{
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getSeaLevel() + 25);
						STATIC_SIDEWAYS_GENERATOR.generate(BlockGreenCrustedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 35, 255);
					}

				if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
					for (int ii = 0; ii < 27; ++ii)
					{
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getSeaLevel() + 25);
						STATIC_GENERATOR.generate(BlockGreenSproutingAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 35, 255);
					}

				if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
					for (int ii = 0; ii < 27; ++ii)
					{
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getSeaLevel() + 25);
						STATIC_GENERATOR.generate(BlockPiledAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 35, 255);
					}

				if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
					for (int ii = 0; ii < 27; ++ii)
					{
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getSeaLevel() + 25);
						STATIC_GENERATOR.generate(BlockStalkedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 35, 255);
					}

			}

	        super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeOrdovician getBiomeType() {
			return EnumBiomeTypeOrdovician.FrozenLand;
		}
	}

}
