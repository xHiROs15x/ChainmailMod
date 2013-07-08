package net.minecraft.src;

import cpw.*;
import cpw.mods.*;
import cpw.mods.fml.*;
import cpw.mods.fml.client.*;
import cpw.mods.fml.client.modloader.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.asm.*;
import cpw.mods.fml.common.asm.transformers.*;
import cpw.mods.fml.common.discovery.*;
import cpw.mods.fml.common.discovery.asm.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.functions.*;
import cpw.mods.fml.common.modloader.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.common.toposort.*;
import cpw.mods.fml.common.versioning.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.server.*;
import ibxm.*;
import net.*;
import net.minecraft.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.*;
import net.minecraft.client.audio.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.achievement.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.model.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.texturepacks.*;
import net.minecraft.command.*;
import net.minecraft.crash.*;
import net.minecraft.creativetab.*;
import net.minecraft.dispenser.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.packet.*;
import net.minecraft.network.rcon.*;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.*;
import net.minecraft.profiler.*;
import net.minecraft.server.*;
import net.minecraft.server.dedicated.*;
import net.minecraft.server.gui.*;
import net.minecraft.server.integrated.*;
import net.minecraft.server.management.*;
import net.minecraft.src.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.world.demo.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.world.storage.*;
import net.minecraftforge.*;
import net.minecraftforge.classloading.*;
import net.minecraftforge.client.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.event.sound.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.item.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.minecart.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.liquids.*;
import net.minecraftforge.oredict.*;
import net.minecraftforge.transformers.*;
import paulscode.*;
import paulscode.sound.*;
import paulscode.sound.codecs.*;

import java.util.Random;

public class mcreator_tinOre extends BaseMod{

public mcreator_tinOre(){}

public static BlockTinOre block;

public void load(){

ModLoader.registerBlock(block);
ModLoader.addName(block, "Tin Ore");

}
public String getVersion(){
return "1.0";
}


static{

block = (BlockTinOre)(new BlockTinOre(161).setHardness(10.0F)
.setResistance(10.0F)
.setLightValue(0.0F)
.setUnlocalizedName("Tin Ore")
.setLightOpacity(0)
.setStepSound(Block.soundStoneFootstep)
.setCreativeTab(CreativeTabs.tabBlock)
);block.setBlockBounds(0.0F,0.0F,0.0F,1.0F,1.0F,1.0F);
MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0);
}


public void generateSurface(World world, java.util.Random rand, int chunkX, int chunkZ){
for(int i = 0; i < 13; i++){
int randPosX = chunkX + rand.nextInt(16);
int randPosY = rand.nextInt(127)+0;
int randPosZ = chunkZ + rand.nextInt(16);
(new WorldGenMinable(mcreator_tinOre.block.blockID, 16)).generate(world, rand, randPosX, randPosY, randPosZ);
}
}

static class BlockTinOre extends Block
{

int a1 = 0,a2 = 0,a3 = 0,a4 = 0,a5 = 0,a6 = 0;

Icon gor = null, dol = null, st1 = null, st2 = null, st3 = null, st4 = null;

boolean red = false;





protected BlockTinOre(int i)
{
        super(i, Material.iron);

}
public boolean isPoweringTo(IBlockAccess blockAccess, int i, int j, int k, int l){
return red;
}
public Icon getIcon(int i, int par2){

if (i == 0)
return gor;

else if (i == 1)
return dol;

else if (i == 2)
return st1;

else if (i == 3)
return st2;

else if (i == 4)
return st4;

else if (i == 5)
return st3;

else
return gor;

}

public void registerIcons(IconRegister par1IconRegister)
{
this.gor = par1IconRegister.registerIcon("TinOre");
this.dol = par1IconRegister.registerIcon("TinOre");
this.st1 = par1IconRegister.registerIcon("TinOre");
this.st2 = par1IconRegister.registerIcon("TinOre");
this.st3 = par1IconRegister.registerIcon("TinOre");
this.st4 = par1IconRegister.registerIcon("TinOre");
}
public int getRenderType(){
return 0;
}
public int tickRate()
{
    return 10;
}

public int quantityDropped(Random par1Random){
return 1;
}

}
}
