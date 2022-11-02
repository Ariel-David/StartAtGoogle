package BehavioralPatterns;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class exportToJSON implements Visitor {

    Gson g = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String visit(User user) {
        return g.toJson(user);
    }

    @Override
    public String visit(Group group) {
        return g.toJson(group);
    }

    @Override
    public String  visit(Asset asset) {
        return g.toJson(asset);
    }
}
