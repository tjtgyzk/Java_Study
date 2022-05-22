package LeetCode.SwardOffer.I;

public class Offer20 {
    public boolean isNumber(String s) {
        return s.matches(" *(((\\+|-)?((\\d+?\\.\\d*)|(\\.\\d+)))|((\\+|-)?\\d+))((e|E)((\\+|-)?\\d+))? *");
    }
}
