/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft.item;

import java.util.Locale;

public enum MooncakeFillingType {

    /**
     * A place holder for those who failed to make a delicious mooncake.
     */
    INVALID(0, 0F),

    /**
     * Simplified Chinese "莲蓉".
     */
    LOTUS_SEED_PASTE(6, 6.0F),

    /**
     * Simplified Chinese "豆沙".
     */
    SWEET_BEAN_PASTE(2, 4.0F),

    /**
     * Simplified Chinese "枣泥".
     */
    JUJUBE_PASTE(2, 4.0F),

    /**
     * Simplified Chinese "五仁".
     */
    FIVE_NUTS(1, 0.5F),

    /**
     * Simplified Chinese "蛋黄莲蓉".
     */
    LOTUS_SEED_PASTE_WITH_YOLK(10, 10.0F),

    /**
     * Simplified Chinese "双黄莲蓉".
     */
    LOTUS_SEED_PASTE_WITH_DOUBLE_YOLK(15, 15.0F);

    public static final MooncakeFillingType[] VALUES = MooncakeFillingType.values();

    public static MooncakeFillingType getByOrdinal(int ordinal) {
        return ordinal < VALUES.length ? VALUES[ordinal] : INVALID;
    }

    final int hunger;
    final float saturation;
    final String localizationKey;

    MooncakeFillingType(int hunger, float saturation) {
        this.hunger = hunger;
        this.saturation = saturation;
        this.localizationKey = this.name().toLowerCase(Locale.ENGLISH);
    }

    public String getLocalizationKey() {
        return this.localizationKey;
    }
}
