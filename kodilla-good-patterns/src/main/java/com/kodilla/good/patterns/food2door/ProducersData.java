package com.kodilla.good.patterns.food2door;

import java.util.*;

public class ProducersData {

    private Set<Producer> producersSet = new HashSet<>();

    public void addProducer(Producer producer) {
        int sizeBeforeAdd = producersSet.size();
        if (producer != null) {
            producersSet.add(producer);
        }
        if (producersSet.size() == sizeBeforeAdd) {
            System.out.println("Probably you've tried add the same producer");
        }
    }

    public Set<Producer> getProducersSet() {
        return producersSet;
    }
}
