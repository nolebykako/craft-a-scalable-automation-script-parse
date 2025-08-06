import java.util.*;

public class CraftAScalableAutomationScriptParser {

    public static void main(String[] args) {
        // Sample automation script
        String script = "IF temperature > 25 THEN turn_on_fan ELSE turn_off_fan";

        // Tokenize the script
        String[] tokens = script.split("\\s+");

        // Create a syntax tree
        Node root = new Node("ROOT");
        Node current = root;

        for (String token : tokens) {
            if (token.equals("IF")) {
                current = new Node("IF");
                root.addChild(current);
            } else if (token.equals("THEN")) {
                current = new Node("THEN");
                root.addChild(current);
            } else if (token.equals("ELSE")) {
                current = new Node("ELSE");
                root.addChild(current);
            } else {
                current.addChild(new Node(token));
            }
        }

        // Evaluate the script
        evaluateScript(root);
    }

    public static void evaluateScript(Node node) {
        if (node.value.equals("IF")) {
            // Evaluate the condition
            boolean condition = evaluateCondition(node.children.get(0));

            // Evaluate the THEN or ELSE branch
            if (condition) {
                evaluateScript(node.children.get(1));
            } else {
                evaluateScript(node.children.get(2));
            }
        } else if (node.value.equals("THEN") || node.value.equals("ELSE")) {
            // Execute the actions
            for (Node child : node.children) {
                executeAction(child.value);
            }
        }
    }

    public static boolean evaluateCondition(Node node) {
        // Simulate evaluating the condition
        return true; // Replace with actual condition evaluation logic
    }

    public static void executeAction(String action) {
        // Simulate executing the action
        System.out.println("Executing action: " + action); // Replace with actual action execution logic
    }

    public static class Node {
        String value;
        List<Node> children = new ArrayList<>();

        public Node(String value) {
            this.value = value;
        }

        public void addChild(Node node) {
            children.add(node);
        }
    }
}