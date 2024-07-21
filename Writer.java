package ru.gb.family_tree;

import java.io.IOException;

public interface Writer {
    void saveToFile(FamilyTree familyTree) throws IOException;
    FamilyTree readFromFile() throws IOException, ClassNotFoundException;
}
