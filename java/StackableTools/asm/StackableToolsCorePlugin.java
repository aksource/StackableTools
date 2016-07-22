package StackableTools.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.io.File;
import java.util.Map;

/**
 * ClassTransformer登録用クラス
 * Created by A.K. on 14/03/14.
 */
public class StackableToolsCorePlugin implements IFMLLoadingPlugin{
    static File location;
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"StackableTools.asm.ItemToolTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return null;
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
