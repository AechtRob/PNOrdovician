
package net.pnordovician.world.biome.ordovician;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockCoral;
import net.lepidodendron.block.BlockStromatoporoideaReef;
import net.lepidodendron.util.EnumBiomeTypeOrdovician;
import net.lepidodendron.world.biome.ordovician.BiomeOrdovician;
import net.lepidodendron.world.gen.*;
import net.minecraft.block.material.Material;
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
public class BiomeOrdovicianSeaIcebergs extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:ordovician_sea_icebergs")
	public static final BiomeGenCustom biome = null;
	public BiomeOrdovicianSeaIcebergs(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WATER);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SNOWY);
	}

	static class BiomeGenCustom extends BiomeOrdovician {
		public BiomeGenCustom() {
			super(new BiomeProperties("Ordovician Icebergs").setRainfall(0.5F).setBaseHeight(-1.15F).setHeightVariation(0.05F).setTemperature(-1.8F).setSnowEnabled());
			setRegistryName("lepidodendron:ordovician_sea_icebergs");
			topBlock = Blocks.GRAVEL.getDefaultState();
			fillerBlock = Blocks.GRAVEL.getDefaultState();
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 2;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}
		
		protected static final WorldGenArchaeopterisTree ARCHAEOPTERIS_TREE = new WorldGenArchaeopterisTree(false);
		protected static final WorldGenReef REEF_GENERATOR = new WorldGenReef();
		protected static final WorldGenIceOnSea ICE_GENERATOR = new WorldGenIceOnSea();
		protected static final WorldGenSnow SNOW_GENERATOR = new WorldGenSnow();
		protected static final WorldGenIcebergs ICEBERG_GENERATOR = new WorldGenIcebergs();
		protected static final WorldGenAddSomethingToTopSolidBlock LITTER = new WorldGenAddSomethingToTopSolidBlock();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return ARCHAEOPTERIS_TREE;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ICE)) {
				{
					int i = rand.nextInt(24);

					for (int j = 0; j < i; ++j) {
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(16) + 8;
						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
						SNOW_GENERATOR.generate(worldIn, rand, blockpos, 0);
					}
					//}

					//{
					i = rand.nextInt(32);

					for (int j = 0; j < i; ++j) {
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(16) + 8;
						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
						ICE_GENERATOR.generate(worldIn, rand, blockpos,0);
					}

					i = rand.nextInt(8);

					for (int j = 0; j < i; ++j) {
						BlockPos blockpos = worldIn.getHeight(pos);
						ICEBERG_GENERATOR.generate(worldIn, rand, blockpos, true);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 2; ++i)
				{
					int radius = 2;
					int j;
					int k;
					if (radius < 10) {
						j = 16 + (int)Math.floor(rand.nextInt(16 - radius - 6)/2) - (int)Math.floor(rand.nextInt(16 - radius - 6)/2);
						k = 16 + (int)Math.floor(rand.nextInt(16 - radius - 6)/2) - (int)Math.floor(rand.nextInt(16 - radius - 6)/2);
					}
					else {
						radius = 10;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR.generate(worldIn, rand, pos1, radius, BlockStromatoporoideaReef.block.getDefaultState());
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS)) {

				for (int i = 0; i < 56; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 37, 40, Blocks.COBBLESTONE.getDefaultState(), -1);
				}

				for (int i = 0; i < 156; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 37, 40, Blocks.PACKED_ICE.getStateFromMeta(1), -1);
				}

				for (int i = 0; i < 256; ++i) {
					LITTER.generate(worldIn, rand, pos.add(16, 0, 16), 37, 40, Blocks.PACKED_ICE.getStateFromMeta(5), 0);
				}


			}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeOrdovician getBiomeType() {
			return EnumBiomeTypeOrdovician.FrozenOcean;
		}
	}

}
