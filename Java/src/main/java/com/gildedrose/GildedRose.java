package com.gildedrose;

import java.util.Map;

class GildedRose {
    Item[] items;

    private final Map<String, QualityUpdater> itemMapper = Map.of(
        "Sulfuras, Hand of Ragnaros", new SulfurasQualityUpdater(),
        "Backstage passes to a TAFKAL80ETC concert", new PassQualityUpdater(),
        "Aged Brie", new AgedBrieQualityUpdater()
    );

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public QualityUpdater getQualityUpdater(String itemName){
        return itemMapper.getOrDefault(itemName, new GenericQualityUpdater());

    }

    public void updateQuality() {
        for (Item item : items) {
            getQualityUpdater(item.name).execute(item);
        }
    }

}
