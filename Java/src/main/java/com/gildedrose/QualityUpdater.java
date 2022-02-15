package com.gildedrose;

public abstract class QualityUpdater {
    protected static final int MAXIMUM_QUALITY = 50;
    protected static final int MINIMUM_QUALITY = 0;
    protected static final int SELL_BY_DATE = 0;

    abstract void execute(Item item);

    protected void decreaseQualityIfPossible(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    protected void increaseQualityIfPossible(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    protected void decreaseSellInDate(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
