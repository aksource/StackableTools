package StackableTools.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import org.objectweb.asm.*;

import java.util.HashMap;

/**
 * Created by A.K. on 14/03/14.
 */
public class ItemToolTransformer implements IClassTransformer, Opcodes{
    private static final HashMap<String, String> TARGET_CLASS_NAMES = new HashMap<String, String>();
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (!FMLLaunchHandler.side().isClient() || !TARGET_CLASS_NAMES.containsKey(transformedName)) {
            return basicClass;
        }
        try {
            ClassReader classReader = new ClassReader(basicClass);
            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            classReader.accept(new CustomVisitor(name, transformedName, classWriter), 8);
            basicClass = classWriter.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("failed : ItemToolTransformer loading", e);
        }
        return basicClass;
    }

    class CustomVisitor extends ClassVisitor
    {
        String owner;
        String transformedName;
        public CustomVisitor(String owner ,String transformed, ClassVisitor cv)
        {
            super(Opcodes.ASM4,cv);
            this.owner = owner;
            this.transformedName = transformed;
        }

        @Override
        public void visitEnd() {

            addIsDamageableMethod();
            addIsItemToolMethod();
            super.visitEnd();
        }

        private void addIsDamageableMethod() {
            MethodVisitor mv = this.visitMethod(ACC_PUBLIC, "func_77645_m", "()Z", null, null);//isDamageable
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(158, l0);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            String desc = String.format("L%sn;", TARGET_CLASS_NAMES.get(this.transformedName));
            mv.visitLocalVariable("this", desc, null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

       private void addIsItemToolMethod() {
           MethodVisitor mv = this.visitMethod(ACC_PUBLIC, "func_77616_k", "(Lnet/minecraft/item/ItemStack;)Z", null, null);//isItemTool
           mv.visitCode();
           Label l0 = new Label();
           mv.visitLabel(l0);
           mv.visitLineNumber(170, l0);
           mv.visitVarInsn(ALOAD, 1);
           mv.visitFieldInsn(GETFIELD, "net/minecraft/item/ItemStack", "field_77994_a", "I");//net/minecraft/item/ItemStack.stackSize
           mv.visitInsn(ICONST_1);
           Label l1 = new Label();
           mv.visitJumpInsn(IF_ICMPNE, l1);
           mv.visitInsn(ICONST_1);
           Label l2 = new Label();
           mv.visitJumpInsn(GOTO, l2);
           mv.visitLabel(l1);
           mv.visitInsn(ICONST_0);
           mv.visitLabel(l2);
           mv.visitInsn(IRETURN);
           Label l3 = new Label();
           mv.visitLabel(l3);
           String desc = String.format("L%sn;", TARGET_CLASS_NAMES.get(this.transformedName));
           mv.visitLocalVariable("this", desc, null, l0, l3, 0);
           mv.visitLocalVariable("par1ItemStack", "Lnet/minecraft/item/ItemStack;", null, l0, l3, 1);
           mv.visitMaxs(2, 2);
           mv.visitEnd();
       }
    }
    static {
        TARGET_CLASS_NAMES.put("net.minecraft.item.ItemArmor", "net/minecraft/item/ItemArmor");
        TARGET_CLASS_NAMES.put("net.minecraft.item.ItemBow", "net/minecraft/item/ItemBow");
        TARGET_CLASS_NAMES.put("net.minecraft.item.ItemTool", "net/minecraft/item/ItemTool");
        TARGET_CLASS_NAMES.put("net.minecraft.item.ItemSword", "net/minecraft/item/ItemSword");
    }
}
