package StackableTools.asm;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

import java.util.Arrays;

/**
 * Created by A.K. on 14/03/14.
 */
public class StackableToolsModContainer extends DummyModContainer{
    public StackableToolsModContainer() {
        super(new ModMetadata());

        ModMetadata meta = getMetadata();
        meta.modId = "StackableToolsCore";
        meta.name = "StackableToolsCore";
        meta.version = "@VERSION@";
        meta.authorList = Arrays.asList("takanasayo","A.K.");
        meta.description = "Make Tools stackable";
        meta.url = "";
        meta.credits = "";
        this.setEnabledState(true);
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }
}
