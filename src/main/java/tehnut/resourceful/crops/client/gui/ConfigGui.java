package tehnut.resourceful.crops.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.ConfigElement;
import tehnut.resourceful.crops.ConfigHandler;
import tehnut.resourceful.crops.ModInformation;

import java.util.ArrayList;
import java.util.List;

public class ConfigGui extends GuiConfig {

    public ConfigGui(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(parentScreen), ModInformation.ID, false, false, StatCollector.translateToLocal("config.ResourcefulCrops.title"));
    }

    @SuppressWarnings("rawtypes")
    private static List<IConfigElement> getConfigElements(GuiScreen parent) {
        List<IConfigElement> list = new ArrayList<IConfigElement>();

        // adds sections declared in ConfigHandler. toLowerCase() is used because the configuration class automatically does this, so must we.
        list.add(new ConfigElement(ConfigHandler.config.getCategory("Crafting".toLowerCase())));
        list.add(new ConfigElement(ConfigHandler.config.getCategory("Balance".toLowerCase())));
        list.add(new ConfigElement(ConfigHandler.config.getCategory("World".toLowerCase())));
        list.add(new ConfigElement(ConfigHandler.config.getCategory("General".toLowerCase())));

        return list;
    }
}
