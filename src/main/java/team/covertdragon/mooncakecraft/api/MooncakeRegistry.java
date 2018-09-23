package team.covertdragon.mooncakecraft.api;

import it.unimi.dsi.fastutil.objects.Object2FloatAVLTreeMap;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2IntAVLTreeMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class MooncakeRegistry {

    public static final MooncakeRegistry INSTANCE = new MooncakeRegistry();

    public static final String FALLBACK_FILLING_TYPE = "unknown";

    private final Map<String, MooncakeFillingLogic> behaviors;
    private final Object2IntMap<String> hungerHealData;
    private final Object2FloatMap<String> saturationData;

    private boolean frozen = false;

    private MooncakeRegistry() {
        behaviors = new HashMap<>();
        hungerHealData = new Object2IntAVLTreeMap<>(); // TODO Do we really want AVL tree at backend?
        hungerHealData.defaultReturnValue(0);
        saturationData = new Object2FloatAVLTreeMap<>(); // TODO Same above?
        saturationData.defaultReturnValue(0F);
        // We reserve this for fallback purpose
        this.registerFilling(FALLBACK_FILLING_TYPE, 0, 0F, MooncakeFillingLogic.Blank.INSTANCE);
    }

    public boolean registerFilling(String uniqueName, int hungerHeal, float saturation, MooncakeFillingLogic logic) {
        if (frozen) {
            return false;
        }
        behaviors.putIfAbsent(uniqueName, logic);
        hungerHealData.put(uniqueName, hungerHeal);
        saturationData.put(uniqueName, saturation);
        return true;
    }

    public Set<String> getAllKnownFillings() {
        return Collections.unmodifiableSet(this.behaviors.keySet());
    }

    public boolean isRegistered(String fillingName) {
        return behaviors.get(fillingName) != null;
    }

    public int getHungerHealFor(String fillingName) {
        return hungerHealData.getInt(fillingName);
    }

    public float getSaturationFor(String fillingName) {
        return saturationData.getFloat(fillingName);
    }

    public MooncakeFillingLogic getBehaviorFor(String fillingName) {
        return behaviors.getOrDefault(fillingName, MooncakeFillingLogic.Blank.INSTANCE);
    }

    public void freezeRegistry() {
        frozen = true;
    }
}
