package org.example;

public interface Visitor {
    String visit(User user);
    String visit(Group group);
    String visit(Asset asset);
}
