package StackableTools.asm;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import cpw.mods.fml.common.asm.transformers.deobf.FMLRemappingAdapter;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by A.K. on 14/03/14.
 */
public class ItemToolTransformer implements IClassTransformer, Opcodes{
    private static final Set<String> TARGET_CLASS_NAMES = new HashSet<String>();
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (!FMLLaunchHandler.side().isClient() || !TARGET_CLASS_NAMES.contains(transformedName)) {
            return basicClass;
        }
        try {
            System.out.println(name);
            System.out.println(transformedName);
            return extendItemTool(name, transformedName, basicClass);
        } catch (Exception e) {
            throw new RuntimeException("failed : ItemToolTransformer loading", e);
        }
    }

    private byte[] extendItemTool(String name, String transformedName, byte[] bytes) {
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept(classNode, 0);
        MethodNode newMethodNode1 = addIsItemToolMethod(name, transformedName);
        MethodNode newMethodNode2 = addIsDamageableMethod();
        classNode.methods.add(newMethodNode1);
        classNode.methods.add(newMethodNode2);
        ClassWriter cw = new ClassWriter((ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS));
        classNode.accept(cw);
        bytes = cw.toByteArray();
        System.out.println("check");
        return bytes;
    }

    private MethodNode addIsItemToolMethod(String owner, String transformed) {
        MethodNode methodNode = new MethodNode(0x1, "isItemTool", "(Lnet/minecraft/item/ItemStack;)Z", null, null);
        InsnList insnList = new InsnList();
        insnList.add(new VarInsnNode(ALOAD, 1));
        insnList.add(new FieldInsnNode(GETFIELD, transformed,"net/minecraft/item/ItemTool.maxStackSize","I"));
        insnList.add(new VarInsnNode(SIPUSH, 1));
        LabelNode labelNode1 = new LabelNode(new Label());
        LabelNode labelNode2 = new LabelNode(new Label());
        insnList.add(new JumpInsnNode(IFEQ, labelNode1));
        insnList.add(new InsnNode(ICONST_0));
        insnList.add(new JumpInsnNode(GOTO, labelNode2));
        insnList.add(labelNode1);
        insnList.add(new InsnNode(ICONST_1));
        insnList.add(labelNode2);
        insnList.add(new InsnNode(IRETURN));
        methodNode.instructions.add(insnList);
        return methodNode;
    }

    private MethodNode addIsDamageableMethod() {
        MethodNode methodNode = new MethodNode(0x1, "isDamageable", "()Z", null, null);
        InsnList insnList = new InsnList();
        insnList.add(new InsnNode(ICONST_1));
        insnList.add(new InsnNode(IRETURN));
        methodNode.instructions.add(insnList);
        return methodNode;
    }
    static {
        TARGET_CLASS_NAMES.add("net.minecraft.item.ItemArmor");
        TARGET_CLASS_NAMES.add("net.minecraft.item.ItemAxe");
        TARGET_CLASS_NAMES.add("net.minecraft.item.ItemBow");
        TARGET_CLASS_NAMES.add("net.minecraft.item.ItemPickaxe");
        TARGET_CLASS_NAMES.add("net.minecraft.item.ItemSpade");
        TARGET_CLASS_NAMES.add("net.minecraft.item.ItemSword");
    }
}
