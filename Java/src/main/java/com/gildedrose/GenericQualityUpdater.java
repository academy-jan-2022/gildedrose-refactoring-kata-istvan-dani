package com.gildedrose;

public class GenericQualityUpdater extends QualityUpdater {
    @Override
    void execute(Item item) {
        decreaseSellInDate(item);
        decreaseQualityIfPossible(item);
        if (item.sellIn < SELL_BY_DATE) {
            decreaseQualityIfPossible(item);
        }
    }
}
