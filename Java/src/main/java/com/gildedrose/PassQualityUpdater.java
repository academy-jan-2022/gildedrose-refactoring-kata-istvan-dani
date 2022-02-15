package com.gildedrose;

public class PassQualityUpdater extends QualityUpdater {
    @Override
    public void execute(Item item) {
        decreaseSellInDate(item);
        if (item.quality < MAXIMUM_QUALITY) {
            increaseQualityIfPossible(item);
            if (item.sellIn < 11) {
                increaseQualityIfPossible(item);

            }

            if (item.sellIn < 6) {
                increaseQualityIfPossible(item);

            }

        }
        if (item.sellIn < SELL_BY_DATE) {
            item.quality = MINIMUM_QUALITY;
        }
    }
}
