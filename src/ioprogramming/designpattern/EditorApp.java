package ioprogramming.designpattern;
import java.util.*;

/*
 Memento Pattern
 Save and restore object state
*/

class TextEditor {

    String content;

    void write(String text) {
        content = text;
    }

    EditorSnapshot save() {
        return new EditorSnapshot(content);
    }

    void restore(EditorSnapshot snapshot) {
        content = snapshot.state;
    }

    void show() {
        System.out.println("Content: " + content);
    }
}

class EditorSnapshot {

    String state;

    EditorSnapshot(String s) {
        state = s;
    }
}

class HistoryManager {

    Stack<EditorSnapshot> history = new Stack<>();

    void save(EditorSnapshot m) {
        history.push(m);
    }

    EditorSnapshot undo() {
        return history.pop();
    }
}

public class EditorApp {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        HistoryManager history = new HistoryManager();

        editor.write("Version 1");
        history.save(editor.save());

        editor.write("Version 2");

        editor.restore(history.undo());

        editor.show();
    }
}
