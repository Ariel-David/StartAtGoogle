package LambdasAndStreams.exercise;

import LambdasAndStreams.exercise.Item;
import startAtGoogle.CommonMethods.exercies.Name;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stock {
    public List<Item> itemList;

    public stock() {
        itemList = new ArrayList<>();
    }

    public void GenerateItem() {
        Item it = new Item();
        itemList.add(it);
    }

    public List<Item> GetListOfExpiredItems() {
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        return (itemList.stream().filter(item -> item.expirationDate.isBefore(today)).collect(Collectors.toList()));
    }

    public Item GetItemClosestExpiryDate() {
        List<Item> list = itemList.stream().sorted((o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate())).collect(Collectors.toList());
        return list.get(0);
    }

    public List<Item> GetSortedListOfItemsByName() {
        List<Item> list = itemList.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        return list;
    }

    public Item getItemByName(String name) {
        Optional<Item> it = itemList.stream().filter(item -> item.name.equals(name)).findAny();
        if (it.isPresent()) {
            System.out.println("Item " + name + " found!");
            return it.get();
        } else {
            System.out.println("Item " + name + " not found!");
            return null;
        }
    }

    public List<String> GetListOfNameAccordingToWeight(double weight) {
        List<Item> list1 = itemList.stream().filter(item -> item.weight > weight + 1).collect(Collectors.toList());
        return list1.stream().map(Item::getName).collect(Collectors.toList());
    }

    public HashMap<Type, Integer> GetHashMapAndSum() {
        HashMap<Type, Integer> map = new HashMap<>();
       return null;
    }

    public void printNameList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void printTypeList(HashMap<Type, Integer> hash) {
        System.out.println(hash.entrySet());
    }

    public void printItemList(List<Item> itemList) {
        for (Item it : itemList) {
            it.printItem();
        }
    }
}


