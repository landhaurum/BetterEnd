package com.dfsek.betterend.biomes;

import com.dfsek.betterend.biomes.generators.biomes.*;
import com.dfsek.betterend.biomes.generators.border.AetherHighlandsBorderGenerator;
import com.dfsek.betterend.biomes.generators.border.VoidAetherBorderGenerator;
import com.dfsek.betterend.biomes.generators.border.VoidAetherHighlandsBorderGenerator;
import com.dfsek.betterend.biomes.generators.border.VoidEndBorderGenerator;

/**
 * Representation of BetterEnd custom biomes.
 * 
 * @author dfsek
 * @since 3.6.2
 */
public enum Biome {
	END(new EndGenerator()),
	SHATTERED_END(new ShatteredEndGenerator()),
	SHATTERED_FOREST(new ShatteredEndGenerator()),
	AETHER(new AetherGenerator()),
	AETHER_HIGHLANDS(new AetherHighlandsGenerator()),
	AETHER_FOREST(new AetherGenerator()),
	AETHER_HIGHLANDS_FOREST(new AetherHighlandsGenerator()),
	VOID(new VoidGenerator()),
	VOID_END_BORDER(new VoidEndBorderGenerator()),
	VOID_AETHER_BORDER(new VoidAetherBorderGenerator()),
	VOID_AETHER_HIGHLANDS_BORDER(new VoidAetherHighlandsBorderGenerator()),
	AETHER_HIGHLANDS_BORDER(new AetherHighlandsBorderGenerator()),
	STARFIELD(new VoidGenerator());

	private final BiomeTerrain generator;

	Biome(BiomeTerrain g) {
		this.generator = g;
	}

	/**
	 * Checks whether or not the Biome is a variant of the Aether.
	 * 
	 * @author dfsek
	 * @since 3.6.2
	 * @return Whether or not the Biome is an Aether variant.
	 */
	public boolean isAether() {
		return(this.equals(Biome.AETHER)
				|| this.equals(Biome.AETHER_FOREST)
				|| this.equals(Biome.AETHER_HIGHLANDS)
				|| this.equals(Biome.AETHER_HIGHLANDS_FOREST)
				|| this.equals(Biome.VOID_AETHER_BORDER)
				|| this.equals(Biome.VOID_AETHER_HIGHLANDS_BORDER)
				|| this.equals(Biome.AETHER_HIGHLANDS_BORDER));
	}

	/**
	 * Checks whether or not the Biome is a variant of the Highlands.
	 * 
	 * @author dfsek
	 * @since 3.6.2
	 * @return Whether or not the Biome is a Highlands variant.
	 */
	public boolean isHighlands() {
		return(this.equals(Biome.AETHER_HIGHLANDS) || this.equals(Biome.AETHER_HIGHLANDS_FOREST));
	}

	/**
	 * Checks whether or not the Biome is a variant of the Void.
	 * 
	 * @author dfsek
	 * @since 3.6.2
	 * @return Whether or not the Biome is a Void variant.
	 */
	public boolean isVoid() {
		return(this.equals(Biome.VOID) || this.equals(Biome.STARFIELD));
	}

	/**
	 * Checks whether or not the Biome is a variant of the Shattered End.
	 * 
	 * @author dfsek
	 * @since 3.6.2
	 * @return Whether or not the Biome is a Shattered End variant.
	 */
	public boolean isShattered() {
		return(this.equals(Biome.SHATTERED_END) || this.equals(Biome.SHATTERED_FOREST));
	}

	/**
	 * Gets a Biome from a String containing the Biome ID.
	 * 
	 * @author dfsek
	 * @since 3.6.2
	 * @param biome
	 *          - The Biome ID
	 * @return The Biome matching the ID.
	 */
	public static Biome fromString(String biome) {
		switch(biome.toUpperCase()) {
			case "END":
				return Biome.END;
			case "SHATTERED_END":
				return Biome.SHATTERED_END;
			case "SHATTERED_FOREST":
				return Biome.SHATTERED_FOREST;
			case "AETHER":
				return Biome.AETHER;
			case "AETHER_HIGHLANDS":
				return Biome.AETHER_HIGHLANDS;
			case "AETHER_FOREST":
				return Biome.AETHER_FOREST;
			case "AETHER_HIGHLANDS_FOREST":
				return Biome.AETHER_HIGHLANDS_FOREST;
			case "VOID":
				return Biome.VOID;
			case "STARFIELD":
				return Biome.STARFIELD;
			default:
				throw new IllegalArgumentException("Invalid biome name \"" + biome + "\"");
		}
	}

	/**
	 * Gets the generator object
	 * @return BiomeTerrain - the terrain gen object.
	 */
	public BiomeTerrain getGenerator() {
		return this.generator;
	}
}
