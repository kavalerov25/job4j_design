package ru.job4j.ood.isp.menu;

import java.util.*;

public class SimpleMenu implements Menu {

    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        var rsl = false;
        if (findItem(childName).isEmpty()) {
            var menuItem = new SimpleMenuItem(childName, actionDelegate);
            if (Objects.equals(Menu.ROOT, parentName)) {
                rsl = rootElements.add(menuItem);
            } else {
                Optional<ItemInfo> itemInfo = findItem(parentName);
                if (itemInfo.isPresent()) {
                    rsl = itemInfo.get().menuItem.getChildren().add(menuItem);
                }
            }
        }
        return rsl;
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        Optional<MenuItemInfo> rsl = Optional.empty();
        if (findItem(itemName).isPresent()) {
            rsl = Optional.of(new MenuItemInfo(findItem(itemName).get().menuItem,
                    findItem(itemName).get().number));
        }
        return rsl;
    }


    @Override
    public Iterator<MenuItemInfo> iterator() {
        return new Iterator<MenuItemInfo>() {

            DFSIterator dfsIterator = new DFSIterator();

            @Override
            public boolean hasNext() {
                return dfsIterator.hasNext();
            }

            @Override
            public MenuItemInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ItemInfo itemInfo = dfsIterator.next();
                return new MenuItemInfo(itemInfo.menuItem, itemInfo.number);
            }
        };
    }

    private Optional<ItemInfo> findItem(String name) {
        DFSIterator iterator = new DFSIterator();
        Optional<ItemInfo> result = Optional.empty();
        while (iterator.hasNext()) {
            ItemInfo info = iterator.next();
            String currentName = info.menuItem.getName();
            if (Objects.equals(currentName, name)) {
                result = Optional.of(info);
                break;
            }
        }
        return result;
    }


    private static class SimpleMenuItem implements MenuItem {

        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious();) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
            }
            return new ItemInfo(current, lastNumber);
        }

    }

    private class ItemInfo {

        MenuItem menuItem;
        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }

}