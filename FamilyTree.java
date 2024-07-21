package ru.gb.family_tree;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static ru.gb.family_tree.Gender.*;

public class FamilyTree implements Serializable {
    private List<Human> family;
    private int id = -1;

    public FamilyTree(List<Human> family) {
        this.family = family;
    }

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addHuman(Human human) {
        if (!family.contains(human)) {
            family.add(human);
            id ++;
            human.setId(id);

            addChildren(human);
        }
    }

        public void addChildren(Human human) {
        if (human.getParents() != null) {
            for (Human parent : human.getParents()) {
                if (parent != null) {
                    parent.setChildren(human);
                }
            }
        }
    }

    public void setMarried (Human human, Human spouse) {
        if (human.getSpouse() == null && spouse.getSpouse() == null) {
            human.setSpouse(spouse);
            spouse.setSpouse(human);
        }
    }

    public void setDivorsed (Human human, Human spouse) {
        if (human.getSpouse() == spouse && spouse.getSpouse() == human) {
            human.setSpouse(null);
            spouse.setSpouse(null);
        }
    }

    public void showTree () {
        for (Human human : family) {
            System.out.println(human);
        }
    }
}
