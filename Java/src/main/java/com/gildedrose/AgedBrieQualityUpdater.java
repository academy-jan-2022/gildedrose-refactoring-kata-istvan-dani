package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {
    @Override
    void execute(Item item) {
        decreaseSellInDate(item);
        increaseQualityIfPossible(item);
        if (item.sellIn < SELL_BY_DATE) {
            increaseQualityIfPossible(item);
        }
    }
}
