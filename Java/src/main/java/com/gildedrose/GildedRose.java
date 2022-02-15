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
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            item.sellIn = item.sellIn - 1;

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                checkBackstage(item);
                continue;
            }


            if (!item.name.equals("Aged Brie")) {
                decreaseQualityIfPossible(item);

            } else {
                if (item.quality < MAXIMUM_QUALITY) {
                    increaseQualityIfPossible(item);

                }
            }


            if (item.sellIn < SELL_BY_DATE) {
                if (!item.name.equals("Aged Brie")) {
                    decreaseQualityIfPossible(item);
                } else {
                    increaseQualityIfPossible(item);

                }
            }

        }
    }

    private void checkBackstage(Item item) {
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
