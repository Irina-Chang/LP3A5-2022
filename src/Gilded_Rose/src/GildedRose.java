public class GildedRose {

    final private static int MAX_QUALITY = 50;
    final private static int MIN_QUALITY = 0;
    final private static int SELL_IN_END = 0;
    final private static int DEFAUTL_QUALITY_CHANGE_IN_VALUE = 1;
    final private static int DEFAUTL_SELL_IN_DECREMENT_VALUE = 1;
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";
    Item[] items;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            switch (item.name) {
                case AGED_BRIE:
                    updateAgedBrieQuality(i, item.sellIn, item.quality, 2);
                    sellInDecrement(i, item.sellIn);
                    break;
                case BACKSTAGE_PASSES:
                    updateBackstagePassesQuality(i, item.sellIn, item.quality);
                    sellInDecrement(i, item.sellIn);
                    break;
                case SULFURAS:
                    break;
                    case CONJURED:
                    updateConjuredManaCakeQuality(i, item.sellIn, item.quality, 2);
                    sellInDecrement(i, item.sellIn);
                    break;
                default:
                    updateQualityDefault(i, item.sellIn, item.quality, 1);
                    sellInDecrement(i, item.sellIn);
                    break;
            }
        }
    }

    private void updateAgedBrieQuality(int i, int sellIn, int quality, int qualityChangeTax){
        if(isSellInLessOrEqualToMinimum(sellIn)){
            this.items[i].quality = quality + qualityChangeTax * DEFAUTL_QUALITY_CHANGE_IN_VALUE;
        }
        else{
            this.items[i].quality = quality + DEFAUTL_QUALITY_CHANGE_IN_VALUE;
        }
        if (this.items[i].quality > MAX_QUALITY) {
            this.items[i].quality = MAX_QUALITY;
        }


    }

    private void updateQualityDefault(int i, int sellIn, int quality, int qualityChangeTax) {
        if (isSellInLessOrEqualToMinimum(sellIn) && quality > MIN_QUALITY) {
            this.items[i].quality = quality - qualityChangeTax * 2 * DEFAUTL_QUALITY_CHANGE_IN_VALUE;
        } else if (!(isSellInLessOrEqualToMinimum(sellIn)) && quality > MIN_QUALITY) {
            this.items[i].quality = quality - qualityChangeTax * DEFAUTL_QUALITY_CHANGE_IN_VALUE;
        }
        if (this.items[i].quality < MIN_QUALITY) {
            this.items[i].quality = MIN_QUALITY;
        }
    }

    private void updateBackstagePassesQuality(int i, int sellIn, int quality) {
        if (isQualityLessThanMaximum(quality)) {
            if (sellIn > 10) {
                this.items[i].quality = quality + 1;
            } else if (5 < sellIn && sellIn < 11) {
                this.items[i].quality = quality + 2;
                if (!isQualityLessThanMaximum(this.items[i].quality)) {
                    this.items[i].quality = MAX_QUALITY;
                }
            } else if (-1 < sellIn && sellIn < 6) {
                this.items[i].quality = quality + 3;
                if (!isQualityLessThanMaximum(this.items[i].quality)) {
                    this.items[i].quality = MAX_QUALITY;
                }
            } else if (isSellInLessOrEqualToMinimum(sellIn)) {
                this.items[i].quality = MIN_QUALITY;
            }
        } else if (!isQualityLessThanMaximum(quality) && isSellInLessOrEqualToMinimum(sellIn)) {
            this.items[i].quality = MIN_QUALITY;
        }
    }

    private void updateConjuredManaCakeQuality(int i, int sellIn, int quality, int qualityChangeTax) {
        updateQualityDefault(i, sellIn, quality, qualityChangeTax);
    }

    private static boolean isSellInLessOrEqualToMinimum(int sellIn) {
        return (sellIn <= SELL_IN_END);
    }

    private static boolean isQualityLessThanMaximum(int quality) {
        return (quality < MAX_QUALITY);
    }

    private void sellInDecrement(int i, int sellIn){
        this.items[i].sellIn = sellIn - DEFAUTL_SELL_IN_DECREMENT_VALUE;
    }
}
