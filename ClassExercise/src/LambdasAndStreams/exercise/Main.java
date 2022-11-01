package startAtGoogle.LambdasAndStreams.exercise;

import java.util.List;

public class Main {

    public static <T> void main(String[] args) {
        stock s = new stock();
        for (int i = 0; i < 10; i++) {
            s.GenerateItem();
        }
        System.out.println("The Items:");
        s.printItemList(s.itemList);
        System.out.println("_________________");
        System.out.println("List of expired items: ");
        s.printItemList(s.GetListOfExpiredItems());
        System.out.println("_________________");
        System.out.println("the item with the closest expiry date: ");
        s.GetItemClosestExpiryDate().printItem();
        System.out.println("_________________");
        System.out.println("list of items sorted alphabetically: ");
        s.printItemList(s.GetSortedListOfItemsByName());
        System.out.println("_________________");
        System.out.println("Get one item by name: ");
        s.getItemByName(s.itemList.get(0).name);
        System.out.println("_________________");
        System.out.println(" list of names of items above a " + s.itemList.get(0).weight + " weight: ");
        s.printNameList(s.GetListOfNameAccordingToWeight(s.itemList.get(0).weight));
        System.out.println("_________________");
        System.out.println("sum the items by their type: ");
        s.printTypeList(s.GetHashMapAndSum());
    }
}
