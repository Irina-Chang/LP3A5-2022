import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    @DisplayName("Aged Brie with 1 day to sell and quality 1 when successful.")
    public void agedBriUpdateTest() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 2, 0)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, items[0].sellIn);
        assertEquals(1, items[0].quality);
        assertEquals("Aged Brie", items[0].name);
    }


    @Test
    @DisplayName("Sulfuras sell days and quality doesn't change when successful.")
    public void sulfurasUpdateTest() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(80, items[0].quality);
        assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);
    }


    @Test
    public void item_Sulfuras_neverChanges() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 100, 100)
        };
                GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(100, items[0].sellIn);
        assertEquals(100, items[0].quality);
        assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);

    }



    @Test
    public void BackStagePassesTest() {
        Item[] items = new Item[]{
        new Item("Backstage passes to a TAFKAL80ETC concert", 20, 2)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(19, items[0].sellIn);
        assertEquals(3, items[0].quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
    }

    @Test
    public void item_BackStagePassesExpires() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);

    }

    }


