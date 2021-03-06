package elucent.albedo;

import elucent.albedo.util.ShaderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Albedo.MODID, version = Albedo.VERSION, name = Albedo.NAME, guiFactory = "elucent.albedo.gui.AlbedoGuiFactory", clientSideOnly=true)
public class Albedo
{
    public static final String MODID = "albedo";
    public static final String VERSION = "0.1";
    public static final String NAME = "Albedo";
    public static boolean inited = false;
    
    @SideOnly(Side.CLIENT)
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new ShaderUtil());
        MinecraftForge.EVENT_BUS.register(new EventManager());
		MinecraftForge.EVENT_BUS.register(new ConfigManager());
		ConfigManager.init(event.getSuggestedConfigurationFile());
    }
}
