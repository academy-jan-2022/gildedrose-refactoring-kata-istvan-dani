package com.gildedrose;

class GildedRose {
    private static final int MAXIMUM_QUALITY = 50;
    public static final int MINIMUM_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }


            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > MINIMUM_QUALITY) {
                    decreaseQualityIfPossible(item);

                }
            } else {
                if (item.quality < MAXIMUM_QUALITY) {
                    increaseQualityIfPossible(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            increaseQualityIfPossible(item);

                        }

                        if (item.sellIn < 6) {
                            increaseQualityIfPossible(item);

                        }
                    }
                }
            }

            item.sellIn = item.sellIn - 1;


            if (item.sellIn < MINIMUM_QUALITY) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            decreaseQualityIfPossible(item);

                        }
                    } else {
                        item.quality = MINIMUM_QUALITY;
                    }
                } else {
                    increaseQualityIfPossible(item);

                }
            }

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
