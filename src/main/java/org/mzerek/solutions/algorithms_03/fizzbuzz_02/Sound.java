package main.java.org.mzerek.solutions.algorithms_03.fizzbuzz_02;

public class Sound {

    private final int trigger;
    private final String sound;
    private final Sound next;

    public Sound(int trigger, String sound, Sound next) {
        this.trigger = trigger;
        this.sound = sound;
        this.next = next;
    }

    public Sound(int trigger, String sound) {
        this(trigger, sound, null);
    }

    public String generate(int n) {
        StringBuilder sb = new StringBuilder();
        generate(sb, n);
        return sb.length() == 0 ? String.valueOf(n) : sb.toString();
    }

    public void generate(StringBuilder sb, int n) {
        if (n % trigger == 0) {
            sb.append(sound);
        }
        if (next != null) {
            next.generate(sb, n);
        }
    }
}
