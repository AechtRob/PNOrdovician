
package net.pnordovician.world.biome.ordovician;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockLavaRock;
import net.lepidodendron.util.EnumBiomeTypeOrdovician;
import net.lepidodendron.world.biome.ordovician.BiomeOrdovician;
import net.lepidodendron.world.gen.WorldGenIceOnSea;
import net.lepidodendron.world.gen.WorldGenSnow;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeOrdovicianHillsFrozen extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:ordovician_hills_frozen")
	public static final BiomeGenCustom biome = null;
	public BiomeOrdovicianHillsFrozen(ElementsLepidodendronMod instance) {
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
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.HILLS);
	}

	static class BiomeGenCustom extends BiomeOrdovician {
		public BiomeGenCustom() {
			super(new BiomeProperties("Ordovician Frozen Jagged Wastes").setRainfall(0.4F).setBaseHeight(2.25F).setHeightVariation(1.4F).setTemperature(-1.8F).setSnowEnabled());
			setRegistryName("lepidodendron:ordovician_hills_frozen");
			topBlock = Blocks.STONE.getStateFromMeta(0);
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

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			return null;
		}
		protected static final WorldGenSnow SNOW_GENERATOR = new WorldGenSnow();
		protected static final WorldGenIceOnSea ICE_GENERATOR = new WorldGenIceOnSea();

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {
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

				i = rand.nextInt(22);

				for (int j = 0; j < i; ++j) {
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					SNOW_GENERATOR.generate(worldIn, rand, blockpos, 0);
				}

				for (int j = 0; j < i; ++j) {
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					//if (worldIn.getBlockState(blockpos.down()).getMaterial() != Material.WATER) {
					ICE_GENERATOR.generate(worldIn, rand, blockpos,0);
					//}
				}

				i = rand.nextInt(96);

				for (int j = 0; j < i; ++j) {
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					SNOW_GENERATOR.generate(worldIn, rand, blockpos, 140);
				}

			}

			super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeOrdovician getBiomeType() {
			return EnumBiomeTypeOrdovician.BarrenLand;
		}

	}
}
