package tehnut.resourceful.crops.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import tehnut.resourceful.crops.ModInformation;
import tehnut.resourceful.crops.ResourcefulCrops;
import tehnut.resourceful.crops.registry.ItemRegistry;

import java.util.List;
import java.util.Random;

public class BlockROre extends Block {

    public IIcon[] icons = new IIcon[2];
    Random random = new Random();

    public BlockROre() {
        super(Material.rock);

        setBlockName(ModInformation.ID + ".ore");
        setStepSound(soundTypeStone);
        setHardness(4.0F);
        setCreativeTab(ResourcefulCrops.tabResourcefulCrops);
        setHarvestLevel("pickaxe", 3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.icons[0] = iconRegister.registerIcon(ModInformation.ID + ":oreGaianite");
        this.icons[1] = iconRegister.registerIcon(ModInformation.ID + ":oreGaianite_nether");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.icons[meta];
    }

    @SuppressWarnings("unchecked")
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 2; i++)
            list.add(new ItemStack(id, 1, i));
    }

    @Override
    public Item getItemDropped(int int1, Random random, int in2) {
        return ItemRegistry.material;
    }

    @Override
    public int damageDropped(int meta) {
        return 0;
    }

    @Override
    public int quantityDropped(Random random) {

        int drop = random.nextInt(4);

        return drop != 0 ? drop : 1;
    }

    @Override
    public int getExpDrop(IBlockAccess world, int meta, int fortune) {
        return random.nextInt(4);
    }
}
