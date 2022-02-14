package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldMasterTest {
    private final static String snapshot = "-------- day 0 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 10, 20\n" +
        "+10 Dexterity Vest, 0, 20\n" +
        "+15 Dexterity Vest, 0, 0\n" +
        "Aged Brie, 2, 0\n" +
        "Aged Brie, -1, 0\n" +
        "Elixir of the Mongoose, 5, 7\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
        "Backstage passes to a TAFKAL80ETC concert, 10, 20\n" +
        "Backstage passes to a TAFKAL80ETC concert, 5, 20\n" +
        "Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
        "Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
        "Backstage passes to a TAFKAL80ETC concert, 0, 50\n" +
        "Conjured Mana Cake, 3, 6\n" +
        "\n" +
        "-------- day 1 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 9, 19\n" +
        "+10 Dexterity Vest, -1, 18\n" +
        "+15 Dexterity Vest, -1, 0\n" +
        "Aged Brie, 1, 1\n" +
        "Aged Brie, -2, 2\n" +
        "Elixir of the Mongoose, 4, 6\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
        "Backstage passes to a TAFKAL80ETC concert, 9, 22\n" +
        "Backstage passes to a TAFKAL80ETC concert, 4, 23\n" +
        "Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, -1, 0\n" +
        "Conjured Mana Cake, 2, 5\n" +
        "\n";

    @Test
    void
    should_be_same_as_snapshot() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("+10 Dexterity Vest", 0, 20), //
            new Item("+15 Dexterity Vest", 0, 0), //
            new Item("Aged Brie", 2, 0), //
            new Item("Aged Brie", -1, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)};
        var result = new GildedRose(items);
        int days = 2;

        StringBuilder dayOneResult = new StringBuilder();


        for (int i = 0; i < days; i++) {
            dayOneResult.append("-------- day " + i + " --------\n");
            dayOneResult.append("name, sellIn, quality\n");
            for (Item item : items) {
                dayOneResult.append(item);
                dayOneResult.append("\n");
            }
            dayOneResult.append("\n");
            result.updateQuality();
        }

        assertEquals(snapshot, dayOneResult.toString());
    }
}
