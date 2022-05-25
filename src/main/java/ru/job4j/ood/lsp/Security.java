package ru.job4j.ood.lsp;

public class Security {
    /**
     * Пример нарушения принципа LSP - когда в подклассе происходит постусловие
     */
    private String name;

    public Security(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Security security = new SecurityClub("Kirill");
        security.cinema(15);
    }

    public void cinema(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Этот фильм для взрослых!");
        }
        System.out.println("Можете проходить!");
    }

    static class SecurityClub extends Security {

        public SecurityClub(String name) {
            super(name);
        }

        @Override
        public void cinema(int age) {
            System.out.println("Можете проходить!");
        }
    }
}