package StackableTools.asm;

import StackableTools.StackableTools;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.io.File;
import java.util.Map;

/**
 * Created by A.K. on 14/03/14.
 */
@IFMLLoadingPlugin.MCVersion("1.7.2")
public class StackableToolsCorePlugin implements IFMLLoadingPlugin{
    static File location;
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"StackableTools.asm.ItemToolTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "StackableTools.asm.StackableToolsModContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        if (data.containsKey("coremodLocation"))
        {
            location = (File) data.get("coremodLocation");
        }
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
