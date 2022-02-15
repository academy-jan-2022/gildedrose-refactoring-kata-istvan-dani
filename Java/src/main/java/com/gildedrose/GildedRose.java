package com.gildedrose;

class GildedRose {
    private static final int MAXIMUM_QUALITY = 50;
    public static final int MINIMUM_QUALITY = 0;
    public static final int SELL_BY_DATE = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros" -> {}
                case "Backstage passes to a TAFKAL80ETC concert" -> updatePassQuality(item);
                case "Aged Brie" -> updateBrieQuality(item);
                default -> updateGenericQuality(item);
            }
        }
    }

    private void decreaseSellInDate(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateGenericQuality(Item item) {
        decreaseSellInDate(item);
        decreaseQualityIfPossible(item);
        if (item.sellIn < SELL_BY_DATE) {
            decreaseQualityIfPossible(item);
        }
    }

    private void updateBrieQuality(Item item) {
        decreaseSellInDate(item);
        increaseQualityIfPossible(item);
        if (item.sellIn < SELL_BY_DATE) {
            increaseQualityIfPossible(item);
        }
    }

    private void updatePassQuality(Item item) {
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

    private void decreaseQualityIfPossible(Item item) {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQualityIfPossible(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}
