package ohtu.intjoukkosovellus;

import java.util.HashSet;
import java.util.Set;

public class IntJoukko {

    public Set<Integer> joukko;

    public IntJoukko() {
        joukko = new HashSet<>();
    }

    public IntJoukko(int a) {
        this();
    }

    public IntJoukko(int a, int b) {
        this();
    }

    public boolean lisaa(int luku) {
        if (joukko.contains(luku)) {
            return false;
        }
        joukko.add(luku);
        return true;
    }

    public boolean kuuluu(int luku) {
        return joukko.contains(luku);
    }

    public boolean poista(int luku) {
        if (!joukko.contains(luku)) {
            return false;
        }
        joukko.remove(luku);
        return true;
    }

    public int mahtavuus() {
        return joukko.size();
    }

    @Override
    public String toString() {
        String s = "{";
        boolean eiEka = false;
        for (int luku : joukko) {
            if (eiEka) {
                s += ", ";
            }
            s += luku;
            if (!eiEka) {
                eiEka = true;
            }
        }
        return s + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[joukko.size()];
        int i = 0;
        for (int luku : joukko) {
            taulu[i++] = luku;
        }
        return taulu;
    }


    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int luku : a.joukko) {
            x.lisaa(luku);
        }
        for (int luku : b.joukko) {
            x.lisaa(luku);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int luku : a.joukko) {
            x.lisaa(luku);
        }
        for (int luku : b.joukko) {
            if (!b.kuuluu(luku)) {
                x.poista(luku);
            }
        }
        return x;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int luku : a.joukko) {
            x.lisaa(luku);
        }
        for (int luku : b.joukko) {
            x.poista(luku);
        }
        return x;
    }
}