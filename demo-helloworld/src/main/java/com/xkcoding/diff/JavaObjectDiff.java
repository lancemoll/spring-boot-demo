package com.xkcoding.diff;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.node.Visit;
import de.danielbechler.diff.path.NodePath;

import java.util.Collections;
import java.util.Map;

public class JavaObjectDiff  {

    public static void main(String[] args) {

        Map<String, String> working = Collections.singletonMap("item", "foo");
        Map<String, String> base = Collections.singletonMap("item", "bar");
        DiffNode diff = ObjectDifferBuilder.buildDefault().compare(working, base);

        System.out.println(diff.hasChanges());
        System.out.println(diff.childCount() == 1);
        NodePath itemPath = NodePath.startBuilding().mapKey("item").build();
        System.out.println(diff.getChild(itemPath).getState() == DiffNode.State.CHANGED);

        /**
         * method1 Traversal
         */
        diff.visit(new DiffNode.Visitor() {
            @Override
            public void node(DiffNode node, Visit visit) {
                System.out.println(node.getPath() + " => " + node.getState());
            }
        });

        /**
         * method2 Reading Values
         */
        diff.visit(new DiffNode.Visitor() {
            @Override
            public void node(DiffNode node, Visit visit) {
                final Object baseValue = node.canonicalGet(base);
                final Object workingValue = node.canonicalGet(working);
                final String message = node.getPath() + " changed from " +
                    baseValue + " to " + workingValue;
                System.out.println(message);
            }
        });
    }
}
