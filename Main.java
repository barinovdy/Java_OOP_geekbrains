package ru.gb.family_tree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        List<Human> parents = new ArrayList<>();

        Human mother = new Human("Nadezda", Gender.Female, LocalDate.of(1956,11,16), null);
        Human father = new Human("Yakov", Gender.Male, LocalDate.of(1950,9,11), null);

        familyTree.addHuman(mother);
        familyTree.addHuman(father);
        familyTree.setMarried(mother, father);

        parents.clear();
        parents.add(mother);
        parents.add(father);

        Human son = new Human("Dima", Gender.Male, LocalDate.of(1990,04,9), null, parents);
        Human dauther = new Human("Jenia", Gender.Female, LocalDate.of(1992,9,27), null, parents);

        familyTree.addHuman(son);
        familyTree.addHuman(dauther);

        Human grandmother = new Human("Nina", Gender.Female, LocalDate.of(1942,8,12), null);
        Human grandfather = new Human("Egor", Gender.Male, LocalDate.of(1937,7,14), LocalDate.of(2021,5,13));

        familyTree.addHuman(grandmother);
        familyTree.addHuman(grandfather);
        familyTree.setMarried(grandmother, grandfather);

        grandmother.setChildren(mother);
        grandfather.setChildren(mother);
        mother.setParents(grandmother, grandfather);

        parents.clear();
        parents.add(null);
        parents.add(son);

        Human grandson = new Human("Ilia", Gender.Male, LocalDate.of(2017,7,4), null, parents);
        familyTree.addHuman(grandson);

        familyTree.showTree();

        Writer fileWriter = new FileHandler(familyTree);
        fileWriter.saveToFile(familyTree);
        System.out.println("Древо сохранено");



        FamilyTree familyTreeRestored = fileWriter.readFromFile();
        System.out.println("Древо восстановлено");
        familyTreeRestored.showTree();
    }
}
